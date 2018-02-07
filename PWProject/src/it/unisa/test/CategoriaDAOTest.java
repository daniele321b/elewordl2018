package it.unisa.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.LinkedList;

import it.unisa.data.CategoriaBean;
import it.unisa.data.CategoriaDAO;


import org.mockito.runners.MockitoJUnitRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class CategoriaDAOTest {
	
	@Mock
	CategoriaBean categoria;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		when(categoria.getNome()).thenReturn(nome);
	}

	@Test
	public void AdoSaveTest() throws SQLException {
		new CategoriaDAO().doSave(categoria);
	}
	
	@Test
	public void BdoRetrieveByKeyTest() throws SQLException {
		assertTrue(new CategoriaDAO().doRetrieveByKey(nome).getNome().equals(categoria.getNome()));
	}
	
	@Test
	public void doRetrieveAll() throws SQLException {
		LinkedList<CategoriaBean> cList = (LinkedList<CategoriaBean>) 
				new CategoriaDAO().doRetrieveAll(""); 
	
		for (CategoriaBean categoriaBean : cList) 
			if (categoriaBean.getNome().equals(nome))
				assertTrue(categoriaBean.getNome().equals(categoria.getNome()));
	}
	
	@Test
	public void DdoDeleteTest() throws SQLException {
		assertTrue(new CategoriaDAO().doDelete(nome));
	}
	
	final String nome = "Test";
}
