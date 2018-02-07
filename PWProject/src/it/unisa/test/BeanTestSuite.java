package it.unisa.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CarrelloBeanTest.class,
	CartaDiCreditoBeanTest.class, 
	CategoriaBeanTest.class, 
	DettagliOrdineBeanTest.class,
	OrdineBeanTest.class, 
	ProdottiBeanTest.class, 
	UtenteBeanTest.class })
public class BeanTestSuite {

}
