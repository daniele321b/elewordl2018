package it.unisa.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

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
 * Servlet implementation class RemoveFromCart
 */
@WebServlet("/RemoveFromCart")
public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int elemento = Integer.parseInt(request.getParameter("el"));
		LinkedList<ProdottiBean> cart = (LinkedList<ProdottiBean>) request.getSession().getAttribute("cart");
		ProdottiDAOInterface prodottiDAO = new ProdottiDAO();
		ProdottiBean prodotto = null;
		
		//new
		if (cart != null) {
			
			prodotto = cart.get(elemento);
			try {
				prodotto.setGiacenza(prodotto.getGiacenza()+1);
				prodottiDAO.doUpdate(prodotto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			cart.remove(elemento);
			
			
		}
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/checkout.jsp");
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
