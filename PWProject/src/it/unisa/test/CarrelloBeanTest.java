package it.unisa.test;

import java.beans.IntrospectionException;

import org.junit.Test;

import it.unisa.data.CarrelloBean;
import junit.framework.TestCase;
import net.codebox.javabeantester.JavaBeanTester;

public class CarrelloBeanTest extends TestCase {

	@Test
	public void test() throws IntrospectionException {
		JavaBeanTester.test(CarrelloBean.class);
	}

}
