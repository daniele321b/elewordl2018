package it.unisa.test;

import java.beans.IntrospectionException;

import org.junit.Test;

import it.unisa.data.OrdineBean;
import junit.framework.TestCase;
import net.codebox.javabeantester.JavaBeanTester;

public class OrdineBeanTest extends TestCase {

	@Test
	public void test() throws IntrospectionException {
		JavaBeanTester.test(OrdineBean.class,"dataConsegna","dataOrdine");
	}

}
