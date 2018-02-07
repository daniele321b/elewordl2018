package it.unisa.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import it.unisa.data.ProdottiBean;
import it.unisa.data.ProdottiDAO;
import it.unisa.data.ProdottiDAOInterface;

/**
 * Servlet implementation class FillAdmin
 */
@WebServlet("/FillAdmin")
public class FillAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FillAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int codice = Integer.parseInt(request.getParameter("codice"));
	
		
		ProdottiBean prodotto = null;
		
		ProdottiDAOInterface pDAO = new ProdottiDAO();
		
		try {
			prodotto = pDAO.doRetrieveByKey(codice);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERRORE");
		}
		
		JSONObject obj = new JSONObject();
		
		obj.put("nome",prodotto.getNome());
		obj.put("produttore", prodotto.getProduttore());
		obj.put("colore", prodotto.getColore());
		obj.put("prezzo", prodotto.getPrezzo());
		obj.put("prezzoS", prodotto.getPrezzoScontato());
		obj.put("peso", prodotto.getPeso());
		obj.put("altezza", prodotto.getAltezza());
		obj.put("profondita", prodotto.getProfondita());
		obj.put("larghezza", prodotto.getLarghezza());
		obj.put("descrizione", prodotto.getDescrizione());
		obj.put("giacenza", prodotto.getGiacenza());
		obj.put("categoria", prodotto.getCategoriaNome());
		obj.put("img", prodotto.getImmagine());
		
		response.setContentType("text/plain");
		response.getWriter().write(obj.toString());
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
