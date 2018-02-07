package it.unisa.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.unisa.data.ProdottiBean;
import it.unisa.data.ProdottiDAO;
import it.unisa.data.ProdottiDAOInterface;

/**
 * Servlet implementation class InsertIteamAdmin
 */
@WebServlet("/InsertIteamAdmin")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB
public class InsertIteamAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "images";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertIteamAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String err = "";
		ProdottiBean prodotto = new ProdottiBean();
		
		ProdottiDAOInterface nProdotti = new ProdottiDAO();
		int codiceM;
		
		try {
			codiceM = nProdotti.doRetrieveAll("").size();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			codiceM = new Random().nextInt(100)*999;
		}
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
		
		
		String savePath = request.getServletContext().getRealPath("")+File.separator+SAVE_DIR;
		
		
		File fileSaveDir = new File(savePath);
		
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		
		
		String fileName="";
		for (Part part : request.getParts()) {
			fileName=extractFileName(part);
			
			if (fileName!=null && !fileName.equals("")) {
				fileName=new File(fileName).getName();
				
				part.write(savePath+File.separator+fileName);
//				request.setAttribute("filename", fileName);
			}
		}
		
		
		
		prodotto.setImmagine(fileName);
		
		ProdottiDAOInterface prodottiDAO = new ProdottiDAO();
		
		try {
			prodottiDAO.doSave(prodotto);
			err="Prodotto inserito correttamente";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		err = "errore nel database";
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/inserisci.jsp?errore"+err);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
		return "";
	}
}
