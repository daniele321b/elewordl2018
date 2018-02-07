package it.unisa.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.LinkedList;

import it.unisa.data.CarrelloBean;
import it.unisa.data.CarrelloDAO;
import it.unisa.data.DriverManagerConnectionPool;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarrelloDAOTest {

	@Mock
	CarrelloBean firstCart;
	@Mock
	CarrelloBean secondCart;
	@Mock
	DriverManagerConnectionPool dm;
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		

		when(firstCart.getUtenteEmail()).thenReturn("mario@consalvo.it");
		when(firstCart.getProdottiCategoriaNome()).thenReturn("scope");
		when(firstCart.getProdottiCodiceModello()).thenReturn(19);
		when(firstCart.getProdottiMagazinoId()).thenReturn(1);
		
		when(secondCart.getUtenteEmail()).thenReturn("mario@mario.it");
		when(secondCart.getProdottiCategoriaNome()).thenReturn("Caffe");
		when(secondCart.getProdottiCodiceModello()).thenReturn(101);
		when(secondCart.getProdottiMagazinoId()).thenReturn(1);
	}

	@Test
	public void AdoSaveTest() throws SQLException {
		
		new CarrelloDAO().doSave(firstCart);
		new CarrelloDAO().doSave(secondCart);
	}
	
	@Test
	public void BdoRetrieveByKeyTest() throws SQLException{
		LinkedList<CarrelloBean> list = (LinkedList<CarrelloBean>) new CarrelloDAO().doRetrieveByKey("mario@consalvo.it");
		
		for (CarrelloBean carrelloBean : list) {
			assertTrue(carrelloBean.getUtenteEmail().equals(firstCart.getUtenteEmail()));
		}
	}
	
	@Test
	public void CdoRetrieveAll() throws SQLException {
		LinkedList<CarrelloBean> list = (LinkedList<CarrelloBean>) new CarrelloDAO().doRetrieveAll("");
		
		for (CarrelloBean carrelloBean : list) {
			
			if (carrelloBean.getUtenteEmail().equals("mario@consalvo.it"))
				assertTrue(carrelloBean.getUtenteEmail().equals(firstCart.getUtenteEmail()));
			else if (carrelloBean.getUtenteEmail().equals("mario@mario.it")) 
				assertTrue(carrelloBean.getUtenteEmail().equals(secondCart.getUtenteEmail()));
			
		}
	}
	
	@Test
	public void DdoDeleteTest() throws SQLException{
		assertTrue( new CarrelloDAO().doDelete("mario@consalvo.it", 19));
		assertTrue( new CarrelloDAO().doDelete("mario@mario.it", 101));
	}

}
