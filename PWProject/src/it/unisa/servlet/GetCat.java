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

import org.json.*;

import it.unisa.data.CategoriaBean;
import it.unisa.data.CategoriaDAO;
import it.unisa.data.CategoriaDAOInterface;

/**
 * Servlet implementation class GetCat
 */
@WebServlet("/GetCat")
public class GetCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Collection<CategoriaBean> categoriaList = null;
		CategoriaDAOInterface categoriaDAO = new CategoriaDAO();
		
		try {
			categoriaList = (List<CategoriaBean>) categoriaDAO.doRetrieveAll("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		response.setContentType("text/plain");
		response.getWriter().write(createJSONObject(categoriaList).toString());
		
	}
	
	
	
	private JSONObject createJSONObject(Collection<CategoriaBean> categorie){
		JSONArray ja = new JSONArray();
		JSONObject mainObj = new JSONObject();
		
		for(CategoriaBean categoria : categorie){
			JSONObject jo = new JSONObject();
			jo.put("categoria", categoria.getNome());
			ja.put(jo);
		}

		
		mainObj.put("cat", ja);
		
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
