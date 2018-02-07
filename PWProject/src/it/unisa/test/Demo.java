/**
 * Questa classe è un test per il test della servlet Login.java
 */
package it.unisa.test;

import static org.junit.Assert.*;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import it.unisa.data.UtenteBean;
import it.unisa.servlet.Login;

import static org.mockito.Mockito.when;

import java.io.IOException;

import static org.mockito.Mockito.verify;

import junit.framework.TestCase;

public class Demo extends TestCase{
	
	@Mock
	HttpServletRequest request;
	@Mock
	HttpServletResponse response;;
	@Mock
	RequestDispatcher dispatcher;
	@Mock
	ServletContext sc;
	@Mock
	UtenteBean ub;
	@Mock
	HttpSession session;
	
	// metodo da eseguire prima dell’esecuzione di un test case
	@Before
	protected void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test() throws ServletException, IOException {
		 when(request.getParameter("email")).thenReturn("admin@admin.it");
		 when(request.getParameter("password")).thenReturn("admin");
		 when(request.getSession()).thenReturn(session);
		 when(session.getAttribute("utente")).thenReturn(ub);
//		 when(sc.getRequestDispatcher("/index.jsp")).thenReturn(dispatcher);
		 when(request.getServletContext()).thenReturn(sc);

		 Login servletTest = new Login();
		 try {

			 servletTest.doPost(request, response);
		} catch (ServletException e) {
			System.out.println("Error "+e.getMessage());
			e.printStackTrace();
		}
		 
//		 when(servletTest.getServletContext()).thenReturn(sc);
		 
		 verify(request).getParameter("email");
		 verify(request).getParameter("password");
		 
		 //controllo che il metodo forward sia stato eseguito
		 verify(dispatcher).forward(request, response);
		 
		 System.out.println(dispatcher);
	}

}
