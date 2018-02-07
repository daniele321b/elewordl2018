package it.unisa.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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
 * Servlet implementation class Offerte
 */
@WebServlet("/Offerte")
public class Offerte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Offerte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		List<ProdottiBean> prodotti = null;
		List<ProdottiBean> prodottiRequest = new LinkedList<>();
		
		
		
		ProdottiDAOInterface prodottiDAO =  new ProdottiDAO();
		
		try {
			prodotti = (LinkedList<ProdottiBean>) prodottiDAO.doRetrieveAll("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Eccezione "+e.getMessage());
		}
		
		
		
		for (int i = 0; i < prodotti.size(); i++) {
			if ((prodotti.get(i).getPrezzoScontato()) > 0){
				prodottiRequest.add(prodotti.get(i));
			}
		}
		
		prodotti.removeAll(prodotti);
		
		
//		request.getSession().setAttribute("prodotti", prodottiBeans);
		request.setAttribute("prodotti", prodottiRequest);
		
		
		
		
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/offerte.jsp");
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
