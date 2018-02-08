package it.unisa.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CarrelloDAOTest.class, 
				CartaDiCreditoDAOTest.class, 
				CategoriaDAOTest.class, 
				OrdineDAOTest.class,
				ProdottiDAOTest.class, 
				UtenteDAOTest.class })
public class DAOTestSuite {

}
