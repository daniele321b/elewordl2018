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
 * Servlet implementation class LoginAmministratore
 */
@WebServlet("/LoginAmministratore")
public class LoginAmministratore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAmministratore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		
		String error="";
	
		
		UtenteBean utenteBean = null;
		
		UtenteDAOInterface utenteDAO = new UtenteDAO();
		
		try {
			utenteBean = utenteDAO.doRetrieveByKey(mail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			error += " Errore nel database "+e.getMessage();
		}
		
		if(utenteBean == null){
			error += " Errore nel database ";
		}else if (utenteBean.getMail() == null) {
			error += " non sei ancora iscritto";
		}else if (!utenteBean.getTipo().equals("admin")) {
			error += " ATTENZIONE non sei amministratore";
		}else {
			if (!utenteBean.getPassword().equals(password)) {
				error += " password errata";
			}
		}
		
		request.getSession().setAttribute("admin", utenteBean);
		
		if (error.length() == 0) {
			// non ci sono stati errori
			request.getSession().setAttribute("admin", utenteBean);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index2.jsp");
			dispatcher.forward(request, response);
		} else {
			// ci sono stati errori durante il login
			// l'errore è accodato all'url come query  
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp?errore="+error);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
