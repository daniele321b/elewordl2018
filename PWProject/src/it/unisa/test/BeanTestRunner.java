package it.unisa.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class BeanTestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(BeanTestSuite.class);
		
		for (Failure fail : result.getFailures()) {
			System.out.println(fail.toString());
		}
		
		System.out.println("Test was successful ? "+result.wasSuccessful());
	}

}
