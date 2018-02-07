package it.unisa.test;

import java.beans.IntrospectionException;
import org.junit.Test;


import it.unisa.data.UtenteBean;
import net.codebox.javabeantester.JavaBeanTester;
public class UtenteBeanTest {
	@Test
	public void test() throws IntrospectionException {
		JavaBeanTester.test(UtenteBean.class);
	}

}
