package it.unisa.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.data.UtenteBean;
import it.unisa.data.UtenteDAO;
import it.unisa.data.UtenteDAOInterface;

/**
 * Servlet implementation class PswLost
 */
@WebServlet("/PswLost")
public class PswLost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PswLost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recupero il bean della sessione <---- verificare se è nullo quando arriva dalla jsp
//		UtenteBean utenteSession  = (UtenteBean) request.getSession().getAttribute("utente");
		
		//Stringa di errore
		String error="";
		
		// ottengo i parametri inseriti nel form di login
		String mailParameter = request.getParameter("email");
		String newPswParameter = request.getParameter("password");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		
		//Bean utente 
		UtenteBean utenteBean = null;
		
		//Oggetto DAO
		UtenteDAOInterface utenteDAO = new UtenteDAO();
		
		try {
			utenteBean = utenteDAO.doRetrieveByKey(mailParameter);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore nel database "+e.getMessage());
			error += " Errore nel database "+e.getMessage();
		}
		
		if(utenteBean == null){
			
			error += " errore nel database ";
		}else if (utenteBean.getMail() == null) {
			error += " non sei ancora iscritto, compila i campi che trovi in questa pagina per iniziare subito ad acquistare";
		}else if (!utenteBean.getNome().equals(nome) ||!utenteBean.getCognome().equals(cognome)) {
			error += " credenziali errate";
		}else {
			//i dati iseriti nel form sono corretti
			utenteBean.setPassword(newPswParameter);
			
			// il bean di sessione ha tutti i dati dell'utente
		}
		
		
		
		//Salvo il nuovo utente nel DB
		try {
			utenteDAO.doUpdate(utenteBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore nel salvataggio "+e.getMessage());
			error += " Errore nel salvataggio "+e.getMessage();
		}
		
		
		// se non ci sono stati errori -> forward alla home del sito
				//se ci sono stati errori -> forward alla pagina di login/registrazione del sito
		
		
		if (error.length() == 0) {
			// non ci sono stati errori
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/account.jsp?errore="+"Password reimpostata correttamente");
			dispatcher.forward(request, response);
		} else {
			// ci sono stati errori durante il login
			// l'errore è accodato all'url come query  
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/passwordlost.jsp?errore="+error);
			dispatcher.forward(request, response);
		}
		
	}

}
