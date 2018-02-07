package it.unisa.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import it.unisa.data.ProdottiBean;
import it.unisa.data.ProdottiDAO;
import it.unisa.data.ProdottiDAOInterface;

/**
 * Servlet implementation class GetCod
 */
@WebServlet("/GetCod")
public class GetCod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCod() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Collection<ProdottiBean> prodottiList = null;
		ProdottiDAOInterface prodottiDAO = new ProdottiDAO();
		
		try {
			prodottiList = (List<ProdottiBean>) prodottiDAO.doRetrieveAll("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		response.setContentType("text/plain");
		response.getWriter().write(createJSONObject(prodottiList).toString());
		
	}
	
	
	
	private JSONObject createJSONObject(Collection<ProdottiBean> prodList){
		JSONArray ja = new JSONArray();
		JSONObject mainObj = new JSONObject();
		
		for(ProdottiBean prodotto : prodList){
			JSONObject jo = new JSONObject();
			jo.put("codice", prodotto.getCodiceModello());
			ja.put(jo);
		}

		
		mainObj.put("codici", ja);
		
//		System.out.println("Array"+mainObj.toString());
		
		return mainObj;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
