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
 * Servlet implementation class ModificaAmministratore
 */
@WebServlet("/ModificaIteamAdmin")
public class ModificaIteamAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaIteamAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int codiceM = Integer.parseInt(request.getParameter("codiceModello"));
		String err = "";
		ProdottiBean prodotto = new ProdottiBean();

		ProdottiDAOInterface prodottiDAO = new ProdottiDAO();
		
		prodotto.setCodiceModello(codiceM);
		prodotto.setNome(request.getParameter("nome"));
		prodotto.setProduttore(request.getParameter("produttore"));
		prodotto.setColore(request.getParameter("colore"));
		prodotto.setPrezzo(Integer.parseInt(request.getParameter("prezzo")));
		prodotto.setPrezzoScontato(Integer.parseInt(request.getParameter("prezzoScont")));
		prodotto.setPeso(Integer.parseInt(request.getParameter("peso")));
		prodotto.setAltezza(Integer.parseInt(request.getParameter("altezza")));
		prodotto.setProfondita(Integer.parseInt(request.getParameter("profondita")));
		prodotto.setLarghezza(Integer.parseInt(request.getParameter("larghezza")));
		prodotto.setDescrizione(request.getParameter("descrizione"));
		prodotto.setGiacenza(Integer.parseInt(request.getParameter("giacenza")));
		prodotto.setCategoriaNome(request.getParameter("categoria"));
		prodotto.setMagazzinoId(1);
		
		
		
		try {
			prodotto.setImmagine(prodottiDAO.doRetrieveByKey(codiceM).getImmagine());
			prodottiDAO.doUpdate(prodotto);
			err="Prodotto inserito correttamente";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		err = "errore nel database"+e.getMessage();
		}
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/modifica.jsp?errore"+err);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
