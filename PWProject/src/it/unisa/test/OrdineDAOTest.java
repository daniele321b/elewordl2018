package it.unisa.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import it.unisa.data.OrdineBean;
import it.unisa.data.OrdineDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class OrdineDAOTest {

	@Mock
	OrdineBean ordine;
	
	@Mock
	OrdineBean ordineReturn;
	
	private OrdineDAO ordineDao;
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		ordineDao = new OrdineDAO();
		
		when(ordine.getIdOrdine()).thenReturn(id);
		when(ordine.getDataOrdine()).thenReturn(dataOrdine);
		when(ordine.getDataConsegna()).thenReturn(dataOrdine);
		when(ordine.getStato()).thenReturn(stato);
		when(ordine.getUtenteEmail()).thenReturn(utenteEmail);
		
	}

	@Test
	public void AdoSaveTest() throws SQLException {
		new OrdineDAO().doSave(ordine);
	}
	
	@Test
	public void BdoRetrieveByKeyTest() throws SQLException {
		when(ordineReturn.getIdOrdine()).thenReturn(ordineDao.doRetrieveByKey(id).getIdOrdine());
		when(ordineReturn.getDataOrdine()).thenReturn(ordineDao.doRetrieveByKey(id).getDataOrdine());
		when(ordineReturn.getDataConsegna()).thenReturn(ordineDao.doRetrieveByKey(id).getDataConsegna());
		when(ordineReturn.getStato()).thenReturn(ordineDao.doRetrieveByKey(id).getStato());
		when(ordineReturn.getUtenteEmail()).thenReturn(ordineDao.doRetrieveByKey(id).getUtenteEmail());
		
		
		assertTrue(ordineReturn.getIdOrdine() == ordine.getIdOrdine());
		assertTrue(ordineReturn.getDataOrdine().equals(ordine.getDataOrdine()));
		assertTrue(ordineReturn.getDataConsegna().equals(ordine.getDataOrdine()));
		assertTrue(ordineReturn.getStato().equals(ordine.getStato()));
		assertTrue(ordineReturn.getUtenteEmail().equals(ordine.getUtenteEmail()));
		
//		assertTrue(ordineDao.doRetrieveByKey(id).getIdOrdine() == ordine.getIdOrdine());
//		assertTrue(ordineDao.doRetrieveByKey(id).getDataOrdine().equals(ordine.getDataOrdine()));
//		assertTrue(ordineDao.doRetrieveByKey(id).getDataConsegna().equals(ordine.getDataOrdine()));
//		assertTrue(ordineDao.doRetrieveByKey(id).getStato().equals(ordine.getStato()));
//		assertTrue(ordineDao.doRetrieveByKey(id).getUtenteEmail().equals(ordine.getUtenteEmail()));
	}
	
	@Test
	public void doRetrieveAll() throws SQLException {
		LinkedList<OrdineBean> oList = (LinkedList<OrdineBean>)
				ordineDao.doRetrieveAll("");
		for (OrdineBean ordineBean : oList) {
			if (ordineBean.getIdOrdine() == id) {
				assertTrue(ordineBean.getIdOrdine() == ordine.getIdOrdine());
				assertTrue(ordineBean.getDataOrdine().equals(ordine.getDataOrdine()));
				assertTrue(ordineBean.getDataConsegna().equals(ordine.getDataOrdine()));
				assertTrue(ordineBean.getStato().equals(ordine.getStato()));
				assertTrue(ordineBean.getUtenteEmail().equals(ordine.getUtenteEmail()));
			}
		}
	}
	
	@Test
	public void DdoDeleteTest() throws SQLException {
		assertTrue(ordineDao.doDelete(id));
	}
	
	
	final int id = 111;
	final Date  dataOrdine = Date.valueOf("1986-10-26");
	final Date dataConsegna = Date.valueOf("1896-10-26");
	final String stato = "testing";
	final String utenteEmail = "admin@admin.it";
}
