package it.unisa.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.data.ProdottiDAO;
import it.unisa.data.ProdottiDAOInterface;

/**
 * Servlet implementation class EiminaIteamAdmin
 */
@WebServlet("/EiminaIteamAdmin")
public class EiminaIteamAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EiminaIteamAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int codice = Integer.parseInt(request.getParameter("codiceModello"));
		String err ="";
		
		ProdottiDAOInterface pDAO = new ProdottiDAO();
		
		try {
			pDAO.doDelete(codice);
			err = "Prodotto eliminato con successo";
			System.out.println("EiminaIteamAdmin.doGet()"+err);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			err = "problemi nel database "+e.getMessage()+e.getErrorCode();
			System.out.println("EiminaIteamAdmin.doGet()"+err);
		}
		
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cancella.jsp?errore"+err);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
