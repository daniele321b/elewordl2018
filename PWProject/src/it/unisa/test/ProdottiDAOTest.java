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

import it.unisa.data.ProdottiBean;
import it.unisa.data.ProdottiDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class ProdottiDAOTest {

	@Mock
	ProdottiBean prodotti;
	
	ProdottiDAO prodottiDao;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		prodottiDao = new ProdottiDAO();
		
		when(prodotti.getCodiceModello()).thenReturn(codiceModello);
		when(prodotti.getNome()).thenReturn(nome);
		when(prodotti.getProduttore()).thenReturn(produttore);
		when(prodotti.getColore()).thenReturn(colore);
		when(prodotti.getPrezzo()).thenReturn(prezzo);
		when(prodotti.getPrezzoScontato()).thenReturn(prezzoScontato);
		when(prodotti.getPeso()).thenReturn(peso);
		when(prodotti.getAltezza()).thenReturn(altezza);
		when(prodotti.getProfondita()).thenReturn(profondita);
		when(prodotti.getLarghezza()).thenReturn(larghezza);
		when(prodotti.getDescrizione()).thenReturn(descrizione);
		when(prodotti.getImmagine()).thenReturn(immagine);
		when(prodotti.getGiacenza()).thenReturn(giacenza);
		when(prodotti.getCategoriaNome()).thenReturn(categoriaNome);
		when(prodotti.getMagazzinoId()).thenReturn(magazzinoId);
		
	}
	
	@Test
	public void AdoSaveTest() throws SQLException {
		new ProdottiDAO().doSave(prodotti);
	}
	
	@Test
	public void BdoRetrieveByKeyTest() throws SQLException {
		assertTrue(prodottiDao.doRetrieveByKey(codiceModello).getCodiceModello()==(prodotti.getCodiceModello()));
		assertTrue(prodottiDao.doRetrieveByKey(codiceModello).getNome().equals(prodotti.getNome()));
		assertTrue(prodottiDao.doRetrieveByKey(codiceModello).getProduttore().equals(prodotti.getProduttore()));
		assertTrue(prodottiDao.doRetrieveByKey(codiceModello).getColore().equals(prodotti.getColore()));
		assertTrue(prodottiDao.doRetrieveByKey(codiceModello).getPrezzo()==(prodotti.getPrezzo()));
		assertTrue(prodottiDao.doRetrieveByKey(codiceModello).getPrezzoScontato()==(prodotti.getPrezzoScontato()));
		assertTrue(prodottiDao.doRetrieveByKey(codiceModello).getPeso()==(prodotti.getPeso()));
		assertTrue(prodottiDao.doRetrieveByKey(codiceModello).getAltezza()==(prodotti.getAltezza()));
		assertTrue(prodottiDao.doRetrieveByKey(codiceModello).getProfondita()==(prodotti.getProfondita()));
		assertTrue(prodottiDao.doRetrieveByKey(codiceModello).getLarghezza()==(prodotti.getLarghezza()));
		assertTrue(prodottiDao.doRetrieveByKey(codiceModello).getDescrizione().equals(prodotti.getDescrizione()));
		assertTrue(prodottiDao.doRetrieveByKey(codiceModello).getImmagine().equals(prodotti.getImmagine()));
		assertTrue(prodottiDao.doRetrieveByKey(codiceModello).getGiacenza()==(prodotti.getGiacenza()));
		assertTrue(prodottiDao.doRetrieveByKey(codiceModello).getCategoriaNome().equals(prodotti.getCategoriaNome()));
		assertTrue(prodottiDao.doRetrieveByKey(codiceModello).getMagazzinoId()==(prodotti.getMagazzinoId()));
	}
	
	@Test
	public void doRetrieveAll() throws SQLException {
		
		for(ProdottiBean prodottiBean : prodottiDao.doRetrieveAll("")) {
			if (prodottiBean.getCodiceModello() == codiceModello) {
				assertTrue(prodottiBean.getCodiceModello()==(prodotti.getCodiceModello()));
				assertTrue(prodottiBean.getNome().equals(prodotti.getNome()));
				assertTrue(prodottiBean.getProduttore().equals(prodotti.getProduttore()));
				assertTrue(prodottiBean.getColore().equals(prodotti.getColore()));
				assertTrue(prodottiBean.getPrezzo()==(prodotti.getPrezzo()));
				assertTrue(prodottiBean.getPrezzoScontato()==(prodotti.getPrezzoScontato()));
				assertTrue(prodottiBean.getPeso()==(prodotti.getPeso()));
				assertTrue(prodottiBean.getAltezza()==(prodotti.getAltezza()));
				assertTrue(prodottiBean.getProfondita()==(prodotti.getProfondita()));
				assertTrue(prodottiBean.getLarghezza()==(prodotti.getLarghezza()));
				assertTrue(prodottiBean.getDescrizione().equals(prodotti.getDescrizione()));
				assertTrue(prodottiBean.getImmagine().equals(prodotti.getImmagine()));
				assertTrue(prodottiBean.getGiacenza()==(prodotti.getGiacenza()));
				assertTrue(prodottiBean.getCategoriaNome().equals(prodotti.getCategoriaNome()));
				assertTrue(prodottiBean.getMagazzinoId()==(prodotti.getMagazzinoId()));
			}
			
		}
	}
	
	@Test
	public void DdoUpdateTest() throws SQLException {
		new ProdottiDAO().doUpdate(prodotti);
	}
	
	@Test
	public void EdoDeleteTest() throws SQLException {
		assertTrue(new ProdottiDAO().doDelete(codiceModello));
	}

	
	final int codiceModello = 1;
	final String nome = "Test";
	final String produttore = "Test";
	final String colore = "Test";
	final float prezzo = 1F;
	final float prezzoScontato = 1F;
	final double peso = 1D;
	final int altezza = 1;
	final int profondita = 1;
	final int larghezza = 1;
	final String descrizione = "This is a test";
	final String immagine = "Test.png";
	final int giacenza = 1;
	final String categoriaNome = "Scope";
	final int magazzinoId = 1;
}
