package it.unisa.test;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GestioneAutenticazioneTest {
	
	private String baseURL;
	private WebDriver driver;
	private static final Logger LOGGER = Logger.getLogger(
	        GestioneAutenticazioneTest.class.getSimpleName());
	private static final String ACCOUNT_PAGE = "account.jsp";
	private static final String LOGIN_RESPONSE_PAGE = "Login";
	private static final String PASS_LOST_PAGE = "passwordlost.jsp";
	private static final String NEW_PASS_RESPONSE_PAGE = "PswLost";
	
	
	//Ripartire da qui (testing fail registrazione)--->
//	private static final String 
	

	@Before
	public void setUp() throws Exception {
		baseURL = "http://localhost:8080/PWProject/";
		System.setProperty("webdriver.chrome.driver","/Users/hubblex/git/elewordl2018/PWProject/WebContent/WEB-INF/lib/chromedriver");
		driver = new ChromeDriver();
		driver.get(baseURL+ACCOUNT_PAGE);
	    LOGGER.info("connecting to " + driver.getCurrentUrl());
	}
	
	@After
	public void tearDown() throws Exception {
	    driver.quit();
	}

	@Test
	public void LoginFailTest() {
		driver.findElement(By.id("loginMail")).sendKeys("a@.it");
	    driver.findElement(By.id("loginPassword")).sendKeys("");     
	    driver.findElement(By.name("login")).click();

	    assertTrue(driver.getCurrentUrl().contains(baseURL+ACCOUNT_PAGE));
	}

	@Test
	public void LoginSuccessTest() {
		driver.findElement(By.id("loginMail")).sendKeys("admin@admin.it");
	    driver.findElement(By.id("loginPassword")).sendKeys("admin");     
	    driver.findElement(By.name("login")).submit();
	    
	    assertTrue(driver.getCurrentUrl().contains(baseURL+LOGIN_RESPONSE_PAGE));
	}
	
	@Test
	public void ReimpostaPasswordFailTest() {
		driver.findElement(By.className("forgot")).click();
		driver.findElement(By.name("nome")).sendKeys("A");
		driver.findElement(By.name("cognome")).sendKeys("A");
		driver.findElement(By.name("email")).sendKeys("@.it");
		driver.findElement(By.name("nome")).sendKeys("A");
		driver.findElement(By.name("password")).sendKeys("");
		driver.findElement(By.name("repassword")).sendKeys("");
		driver.findElement(By.name("reg-submit")).submit();
		

		
		assertTrue(driver.getCurrentUrl().contains(baseURL+PASS_LOST_PAGE));
	}
	
	@Test
	public void ReimpostaPasswordSuccessTest() {
		driver.findElement(By.className("forgot")).click();
		driver.findElement(By.name("nome")).sendKeys("admin");
		driver.findElement(By.name("cognome")).sendKeys("admin");
		driver.findElement(By.name("email")).sendKeys("admin@admin.it");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("repassword")).sendKeys("admin");
		driver.findElement(By.name("reg-submit")).submit();
		

		LOGGER.info("#SUCCESS#"+driver.getCurrentUrl());
		assertTrue(driver.getCurrentUrl().contains(baseURL+NEW_PASS_RESPONSE_PAGE));
	}
	
	@Test
	public void RegistratiFailTest() {
		driver.findElement(By.name("nome")).sendKeys("A");
		driver.findElement(By.name("cognome")).sendKeys("A");
		driver.findElement(By.name("email")).sendKeys("@.it");
		driver.findElement(By.name("password")).sendKeys("");
		driver.findElement(By.name("repassword")).sendKeys("");
		driver.findElement(By.name("carta")).sendKeys("1111");
		driver.findElement(By.name("reg-submit")).submit();
		
		
		LOGGER.info("#FAIL#"+driver.getCurrentUrl());
		assertTrue(driver.getCurrentUrl().contains(baseURL+PASS_LOST_PAGE));
	}
}
