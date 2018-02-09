package it.unisa.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import it.unisa.data.CartaDiCreditoBean;
import it.unisa.data.CartaDiCreditoDAO;
import it.unisa.data.CartaDiCreditoDAOInterface;
import it.unisa.data.UtenteBean;
import it.unisa.data.UtenteDAO;
import it.unisa.data.UtenteDAOInterface;

/**
 * Servlet implementation class AddInfoUtente
 */
@WebServlet("/AddInfoUtente")
public class AddInfoUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInfoUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//creare carta di credito se non esiste 
		
		
		String mail;
		mail = request.getParameter("mail");
		if (mail == null) {
			UtenteBean u = (UtenteBean) request.getSession().getAttribute("utente");
			mail = u.getMail();
			System.out.println("Email "+mail);
		}
		
		UtenteBean uSession = null;
		UtenteDAOInterface utenteDAO = new UtenteDAO();
		String err="";
		
		try {
			uSession = utenteDAO.doRetrieveByKey(mail);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			err = "Qualcosa è andato storto !";
		}
		
		
			uSession.setPaese(request.getParameter("paese"));
			uSession.setProvincia(request.getParameter("provincia"));
			uSession.setCitta(request.getParameter("citta"));
			uSession.setVia(request.getParameter("via"));
			uSession.setCap(request.getParameter("cap"));
			uSession.setCivico(Integer.parseInt(request.getParameter("civico")));
			
			
			try {
				utenteDAO.doUpdate(uSession);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				err = "Qualcosa è andato storto"+e.getMessage();
			}
		
		if (err.length() == 0) {
			// non ci sono stati errori
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		} else {
			// ci sono stati errori durante il login
			// l'errore è accodato all'url come query  
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/informazioni.jsp?errore=" + err);
			dispatcher.forward(request, response);
		}
	}

	
}
