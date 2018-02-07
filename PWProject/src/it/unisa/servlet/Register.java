package it.unisa.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.data.CartaDiCreditoBean;
import it.unisa.data.CartaDiCreditoDAO;
import it.unisa.data.CartaDiCreditoDAOInterface;
import it.unisa.data.UtenteBean;
import it.unisa.data.UtenteDAO;
import it.unisa.data.UtenteDAOInterface;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
/**
 * 
 * @author mario
 *
 *         la servlet regidstra un nuovo utente
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// prelevo i parametri inseriti dall'utente
		String nomeUtente = request.getParameter("nome");
		String cognomeUtente = request.getParameter("cognome");
		String mailUtente = request.getParameter("email");
		String passwordUtente = request.getParameter("password");
		String cartaDiCredito = request.getParameter("carta");
		CartaDiCreditoDAOInterface cartaDAO = new CartaDiCreditoDAO();
		// si assume che l'utente registrato come amministratore deve avere una mail che
		// abbia un dominio eleworld.it
		String tipo, error = "";
		
		//Regex   
		final String mailFormat = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
		final String allLetterFormat = "^[A-Za-z]+$";
		final String cartaFormat = "^[0-9]{16}$";
		final String passFormat = "^(\\s|\\t)+.$";
		
		
		if (nomeUtente.matches(allLetterFormat) && cognomeUtente.matches(allLetterFormat)
				&& mailUtente.matches(mailFormat) && !passwordUtente.matches(passFormat) && cartaDiCredito.matches(cartaFormat)) {
			String[] dominio = mailUtente.split("@");
			UtenteBean utenteRegistrato = new UtenteBean();
			UtenteDAOInterface utenteDAO = new UtenteDAO();
	
			if (dominio[1].equals("eleworld.it"))
				tipo = "admin";
			else
				tipo = "user";
	
			utenteRegistrato.setMail(mailUtente);
			utenteRegistrato.setNome(nomeUtente);
			utenteRegistrato.setCognome(cognomeUtente);
			utenteRegistrato.setPassword(passwordUtente);
			utenteRegistrato.setTipo(tipo);
			
			// ERR -> CARTA DI CREDITO NON AGGIUNTA AL MOMENTO DELLA REGISTRAZIONE ->
			// IMPOSSIBILE AGGIUNGERE L'UTENTE AL DB
		
			try {
				if (cartaDAO.doRetrieveByKey(cartaDiCredito).getnCarta()==null) {
					createCarta(cartaDiCredito, cartaDAO);
				}
				utenteRegistrato.setNumerCarta(cartaDiCredito);
				utenteDAO.doSave(utenteRegistrato);
				error = "Utente registrato con successo";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				error = "Ci dispiace ma qualcosa è andato storto ";
				System.out.println(e.getMessage());
			}
		}else {
			error += "I dati inseriti non sono corretti";
		}

		if (error.equals("Utente registrato con successo")) {
			// non ci sono stati errori
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/informazioni.jsp?errore=" + error+"&email="+mailUtente);
			dispatcher.forward(request, response);
		} else {
			// ci sono stati errori durante il login
			// l'errore è accodato all'url come query  
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/account.jsp?errore=" + error);
			dispatcher.forward(request, response);
		}

	}
	
	private void createCarta(String codice, CartaDiCreditoDAOInterface cDAO){
		CartaDiCreditoBean cBean = new CartaDiCreditoBean();
		cBean.setnCarta(codice);
		try {
			cDAO.doSave(cBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Register.createCarta()"+"do Save"+e.getMessage());
		}
	}
	
	private boolean isNotEmpty(String string) {
		
		return string.length() > 0 ?  true :  false;
	}
}
