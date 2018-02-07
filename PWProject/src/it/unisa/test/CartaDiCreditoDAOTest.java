package it.unisa.test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import it.unisa.data.CartaDiCreditoBean;
import it.unisa.data.CartaDiCreditoDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CartaDiCreditoDAOTest{

	@Mock
	CartaDiCreditoBean cdc;
	@Mock
	CartaDiCreditoBean cdcReturn;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		when(cdc.getnCarta()).thenReturn(nCarta);
		when(cdc.getCvc()).thenReturn(cvc);
		when(cdc.getIntestatario()).thenReturn(intestatario);
		when(cdc.getDataScadenza()).thenReturn(scadenza);
	}

	@Test
	public void AdoSaveTest() throws SQLException {
		new CartaDiCreditoDAO().doSave(cdc);
	}
	
	@Test
	public void BdoRetrieveByKeyTest() throws SQLException{
		cdcReturn = new CartaDiCreditoDAO().doRetrieveByKey(nCarta);
		assertTrue(cdcReturn.getnCarta().equals(cdc.getnCarta()));
		assertTrue(cdcReturn.getCvc() == cdc.getCvc());
		assertTrue(cdcReturn.getIntestatario().equals(cdc.getIntestatario()));
		assertTrue(cdcReturn.getDataScadenza().equals(cdc.getDataScadenza()));
	}
	
	@Test
	public void CdoRetrieveAll() throws SQLException {
		LinkedList<CartaDiCreditoBean> cdcList = (LinkedList<CartaDiCreditoBean>) 
				new CartaDiCreditoDAO().doRetrieveAll("");
		
		for (CartaDiCreditoBean cartaDiCreditoBean : cdcList) {
			if(cartaDiCreditoBean.getnCarta().equals(nCarta)) {
				assertTrue(cartaDiCreditoBean.getnCarta().equals(cdc.getnCarta()));
				assertTrue(cartaDiCreditoBean.getCvc() == cdc.getCvc());
				assertTrue(cartaDiCreditoBean.getIntestatario().equals(cdc.getIntestatario()));
				assertTrue(cartaDiCreditoBean.getDataScadenza().equals(cdc.getDataScadenza()));
			}
		}
	}
	
	@Test
	public void DdoDeleteTest() throws SQLException{
		assertTrue(new CartaDiCreditoDAO().doDelete(nCarta));
	}
	
	final String nCarta = "1234567891234567";
	final int cvc = 686;
	final String intestatario = "Mario Rossi";
	final Date scadenza = Date.valueOf("1985-10-26");
}
