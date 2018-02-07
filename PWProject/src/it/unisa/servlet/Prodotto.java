package it.unisa.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.data.ProdottiBean;
import it.unisa.data.ProdottiDAO;
import it.unisa.data.ProdottiDAOInterface;

/**
 * Servlet implementation class Prodotto
 */
@WebServlet("/Prodotto")
public class Prodotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prodotto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int codiceModello = Integer.parseInt(request.getParameter("codiceM"));
		
		
//		ProdottiBean prodotto = (ProdottiBean)request.getAttribute("prodotto");
		ProdottiBean prodotto = null;
		ProdottiDAOInterface prodottiDAO  = new ProdottiDAO();
		
		try {
			prodotto = prodottiDAO.doRetrieveByKey(codiceModello);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Sql ex "+e.getMessage());
		}
		
		request.setAttribute("prodotto", prodotto);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/single.jsp");
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
