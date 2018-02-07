package it.unisa.test;

import java.beans.IntrospectionException;

import org.junit.Test;

import it.unisa.data.CartaDiCreditoBean;
import junit.framework.TestCase;
import net.codebox.javabeantester.JavaBeanTester;

public class CartaDiCreditoBeanTest extends TestCase {

	@Test
	public void test() throws IntrospectionException {
		JavaBeanTester.test(CartaDiCreditoBean.class,"dataScadenza");
	}

}
