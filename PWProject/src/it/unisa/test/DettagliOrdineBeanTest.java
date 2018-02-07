package it.unisa.test;

import java.beans.IntrospectionException;

import org.junit.Test;

import it.unisa.data.DettagliOrdiniBean;
import junit.framework.TestCase;
import net.codebox.javabeantester.JavaBeanTester;

public class DettagliOrdineBeanTest extends TestCase {

	@Test
	public void test() throws IntrospectionException {
		JavaBeanTester.test(DettagliOrdiniBean.class);
	}

}
