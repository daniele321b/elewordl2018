package it.unisa.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.data.CarrelloBean;
import it.unisa.data.CarrelloDAO;
import it.unisa.data.CarrelloDAOInterface;
import it.unisa.data.UtenteBean;
import it.unisa.data.UtenteDAO;
import it.unisa.data.UtenteDAOInterface;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
/**
 * 
 * @author mario
 *
 *	La servlet realizza il login di un utente
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recupero il bean della sessione <---- verificare se è nullo quando arriva dalla jsp
		UtenteBean utenteSession  = (UtenteBean) request.getSession().getAttribute("utente");
		
		// ottengo i parametri inseriti nel form di login
		String emailParameter = request.getParameter("email");
		String passwordParameter = request.getParameter("password");
		
		//Regex email
		final String mailFormat = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
		//Regex password
		final String passFormat = "^(\\s|\\t)+.$";
		
		
		// stringa per l'errore
		String error = "";
		
		// dichiaro un bean per il DB
		UtenteBean utenteBean = null;
		
		// oggetto DAO
		UtenteDAOInterface utenteDAO = new UtenteDAO();

		//new 
//		CarrelloDAOInterface carrelloDAO = new CarrelloDAO();
//		Collection<CarrelloBean> carrelloList= new LinkedList<>();
		//
		
		
		
		if (emailParameter.matches(mailFormat)&&(!passwordParameter.matches(passFormat))) {
			
			// chiamata a doRetrieveByKey di UteteDAO
			// doRetrieveByKey può restituire:
			// - un'oggetto vuoto -> l'utente con mail=emailParameter non esiste
			// - l'oggetto con mail=emailParameter
			try {
				utenteBean = utenteDAO.doRetrieveByKey(emailParameter);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				error +=" Ci dispiace ma qualcosa è andato storto ";
			}
			//ERR -> cambiare chive da ID a EMAIL && try/catch
			
			/**
			 *  verifica se l'utente con email = emailParameter
			 *  
			 *  Se l'utente esiste e la psw è corretta si completa il bean di tutti i dati dell'utente
			 *  e si effettua una forward alla home
			 *  
			 *  Se l'utente non esiste o la psw non è corretta si effettua una forward con 
			 *  l'errore relativo
			 */
	//		if (utenteDb==null) 
	//			//l'utente non esiste
	//			error += "Non sei ancora iscritto, compila i campi che trovi in questa pagina per iniziare subito ad acquistare";
	//		else{
	//			if(!utenteDb.getPassword().equals(passwordParameter))
	//				error += "Password errata";
	//			else {
	//				//i dati iseriti nel form sono corretti
	//				utenteSession.setMail(utenteDb.getMail());
	//				utenteSession.setNome(utenteDb.getNome());
	//				utenteSession.setCognome(utenteDb.getCognome());
	//				utenteSession.setPassword(utenteDb.getPassword());
	//				utenteSession.setTipo(utenteDb.getTipo());
	//				utenteSession.setPaese(utenteDb.getPaese());
	//				utenteSession.setProvincia(utenteDb.getProvincia());
	//				utenteSession.setCitta(utenteDb.getCitta());
	//				utenteSession.setVia(utenteDb.getVia());
	//				utenteSession.setCap(utenteDb.getCap());
	//				utenteSession.setCivico(utenteDb.getCivico());
	//				utenteSession.setNumerCarta(utenteDb.getNumerCarta());
	//				// il bean di sessione ha tutti i dati dell'utente
	//				}
	//			}
			
			if(utenteBean == null){
				System.out.println("Problemi al DB");
			}else if (utenteBean.getMail() == null) {
				error += "Non sei ancora iscritto, compila i campi che trovi in questa pagina per iniziare subito ad acquistare";
			}else {
				if (!utenteBean.getPassword().equals(passwordParameter)) {
					error += "Password errata";
				}else {
					//i dati iseriti nel form sono corretti
					utenteSession.setMail(utenteBean.getMail());
					utenteSession.setNome(utenteBean.getNome());
					utenteSession.setCognome(utenteBean.getCognome());
					utenteSession.setPassword(utenteBean.getPassword());
					utenteSession.setTipo(utenteBean.getTipo());
					utenteSession.setPaese(utenteBean.getPaese());
					utenteSession.setProvincia(utenteBean.getProvincia());
					utenteSession.setCitta(utenteBean.getCitta());
					utenteSession.setVia(utenteBean.getVia());
					utenteSession.setCap(utenteBean.getCap());
					utenteSession.setCivico(utenteBean.getCivico());
					utenteSession.setNumerCarta(utenteBean.getNumerCarta());
					// il bean di sessione ha tutti i dati dell'utente
				}
			}
			
	//		//new 
	//		if (error.length() != 0) {
	//			Collection<CarrelloBean>
	//		}
	//		
	//		
		}else {
			error += "I dati inseriti non sono corretti";
		}
		
		// se non ci sono stati errori -> forward alla home del sito
		//se ci sono stati errori -> forward alla pagina di login/registrazione del sito
		if (error.length() == 0) {
			// non ci sono stati errori
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		} else {
			// ci sono stati errori durante il login
			// l'errore è accodato all'url come query  
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/account.jsp?errore="+error);
			dispatcher.forward(request, response);
		}
	}

}
