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
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<ProdottiBean> cart = (LinkedList<ProdottiBean>) request.getSession().getAttribute("cart");
		
//		int codiceModello = Integer.parseInt(request.getParameter("codiceM"));
		int codiceModello=0 ;
			codiceModello = Integer.parseInt(request.getParameter("codiceM"));
		
		ProdottiBean prodotto = null;
		
		ProdottiDAOInterface prodottiDAO = new ProdottiDAO();
		
		try {
			prodotto = prodottiDAO.doRetrieveByKey(codiceModello);
			prodotto.setGiacenza(prodotto.getGiacenza()-1);
			prodottiDAO.doUpdate(prodotto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Sql ex "+e.getMessage());
		}
		
		cart.add(prodotto);
		
//		for (ProdottiBean prodottiBean : cart) {
//			System.out.println(prodottiBean.getCodiceModello());
//		}
		
		
		request.getSession().setAttribute("cart", cart);

		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
		
//		response.sendRedirect("/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
