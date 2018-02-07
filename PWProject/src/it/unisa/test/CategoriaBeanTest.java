package it.unisa.test;

import java.beans.IntrospectionException;

import org.junit.Test;

import junit.framework.TestCase;
import net.codebox.javabeantester.JavaBeanTester;

public class CategoriaBeanTest extends TestCase {

	@Test
	public void test() throws IntrospectionException {
		JavaBeanTester.test(CategoriaBeanTest.class);
	}

}
