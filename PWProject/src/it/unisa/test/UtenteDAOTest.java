package it.unisa.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import it.unisa.data.UtenteBean;
import it.unisa.data.UtenteDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class UtenteDAOTest {

	@Mock
	UtenteBean utente;
	
	private UtenteDAO utenteDao;
	
	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
		
		utenteDao = new UtenteDAO();
		
		when(utente.getMail()).thenReturn(mail);
		when(utente.getNome()).thenReturn(nome);
		when(utente.getCognome()).thenReturn(cognome);
		when(utente.getPassword()).thenReturn(password);
		when(utente.getTipo()).thenReturn(tipo);
		when(utente.getPaese()).thenReturn(paese);
		when(utente.getProvincia()).thenReturn(provincia);
		when(utente.getCitta()).thenReturn(citta);
		when(utente.getVia()).thenReturn(via);
		when(utente.getCap()).thenReturn(cap);
		when(utente.getCivico()).thenReturn(civico);
		when(utente.getNumerCarta()).thenReturn(numerCarta);
	}

	@Test
	public void AdoSaveTest() throws SQLException {
		new UtenteDAO().doSave(utente);
	}
	
	@Test
	public void BdoRetrieveByKeyTest() throws SQLException {
		assertTrue(utenteDao.doRetrieveByKey(mail).getMail().equals(utente.getMail()));
		assertTrue(utenteDao.doRetrieveByKey(mail).getNome().equals(utente.getNome()));
		assertTrue(utenteDao.doRetrieveByKey(mail).getCognome().equals(utente.getCognome()));
		assertTrue(utenteDao.doRetrieveByKey(mail).getPassword().equals(utente.getPassword()));
		assertTrue(utenteDao.doRetrieveByKey(mail).getTipo().equals(utente.getTipo()));
		assertTrue(utenteDao.doRetrieveByKey(mail).getPaese().equals(utente.getPaese()));
		assertTrue(utenteDao.doRetrieveByKey(mail).getProvincia().equals(utente.getProvincia()));
		assertTrue(utenteDao.doRetrieveByKey(mail).getCitta().equals(utente.getCitta()));
		assertTrue(utenteDao.doRetrieveByKey(mail).getVia().equals(utente.getVia()));
		assertTrue(utenteDao.doRetrieveByKey(mail).getVia().equals(utente.getVia()));
		assertTrue(utenteDao.doRetrieveByKey(mail).getCap().equals(utente.getCap()));
		assertTrue(utenteDao.doRetrieveByKey(mail).getCivico()==utente.getCivico());
		assertTrue(utenteDao.doRetrieveByKey(mail).getNumerCarta().equals(utente.getNumerCarta()));
	}
	
	@Test
	public void doRetrieveAll() throws SQLException {
		
		for(UtenteBean utenteBean : utenteDao.doRetrieveAll("")) {
			if (utenteBean.getMail().equals(mail)) {
				assertTrue(utenteBean.getMail().equals(utente.getMail()));
				assertTrue(utenteBean.getNome().equals(utente.getNome()));
				assertTrue(utenteBean.getCognome().equals(utente.getCognome()));
				assertTrue(utenteBean.getPassword().equals(utente.getPassword()));
				assertTrue(utenteBean.getTipo().equals(utente.getTipo()));
				assertTrue(utenteBean.getPaese().equals(utente.getPaese()));
				assertTrue(utenteBean.getProvincia().equals(utente.getProvincia()));
				assertTrue(utenteBean.getCitta().equals(utente.getCitta()));
				assertTrue(utenteBean.getVia().equals(utente.getVia()));
				assertTrue(utenteBean.getVia().equals(utente.getVia()));
				assertTrue(utenteBean.getCap().equals(utente.getCap()));
				assertTrue(utenteBean.getCivico()==utente.getCivico());
				assertTrue(utenteBean.getNumerCarta().equals(utente.getNumerCarta()));
			}
		}
	}
	
	@Test
	public void DdoDeleteTest() throws SQLException {
		new UtenteDAO().doDelete(mail);
	}

	final String nome = "Test";
	final String cognome = "Test";
	final String mail = "test@test.it";
	final String password = "test";
	final String tipo = "admin";
	final String paese = "Test";
	final String provincia = "TE";
	final String citta = "Test";
	final String via = "Test";
	final String cap = "81010";
	final int civico = 1;
	final String numerCarta = "1234123412341234";
}
