package it.unisa.data;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Logger;

public class MainTestCarrello {
	
	static Logger logger = Logger.getLogger("global");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create 3 different Cart 
		logger.info("# creating cart");
		CarrelloBean cartUno = new CarrelloBean();
		CarrelloBean cartDue = new CarrelloBean();
		CarrelloBean cartTre = new CarrelloBean();
		logger.info("# cart create");
		
		//set properties for all cart
//		logger.info("# first cart filling");
//		cartUno.setUtenteEmail("mario@consalvo.it");
//		cartUno.setProdottiCodiceModello(19);
//		cartUno.setProdottiCategoriaNome("Scope");
//		cartUno.setProdottiMagazinoId(1);
		
		logger.info("# second cart filling");
		cartDue.setUtenteEmail("mario@mario.it");
		cartDue.setProdottiCodiceModello(101);
		cartDue.setProdottiCategoriaNome("Caffe");
		cartDue.setProdottiMagazinoId(1);
		
		logger.info("# third cart filling");
		cartTre.setUtenteEmail("mario@mario.it");
		cartTre.setProdottiCodiceModello(102);
		cartTre.setProdottiCategoriaNome("Cottura");
		cartTre.setProdottiMagazinoId(1);
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			logger.warning("Sleeping error"+e1.getMessage());
//		}
		
		//creating a DAO cart which is used to do the operation on DB
		CarrelloDAOInterface carrelloDAO = new CarrelloDAO();
		
		//store cats into DB with doSave method
		try {
			logger.info("#1toSave");
			//carrelloDAO.doSave(cartUno);
			logger.info("#2toSave");
			carrelloDAO.doSave(cartDue);
			logger.info("#3toSave");
			carrelloDAO.doSave(cartTre);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			logger.info("error has occurred on saving carts ");
			logger.warning(e2.getMessage());
			System.exit(404);
		}
		
		logger.info("Carts stored success ! ");
		
		
		//retrieve by key 
		Collection<CarrelloBean> carrelloListKey = new LinkedList<>();
		String key = "mario@mario.it";
		
		
		try {
			logger.info("retrieving by key "+key+" ");
			carrelloListKey = carrelloDAO.doRetrieveByKey(key);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.info("error has occurred on retrieving the cart by key");
			logger.warning(e.getMessage());
			System.exit(404);
		}
		
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			logger.warning("Sleeping error"+e1.getMessage());
//		}
		
		logger.info("Printing retrieveByKey "+key+" resul");
		System.out.println("Cart of "+key);
		for (CarrelloBean carrelloBean : carrelloListKey) {
			System.out.println(carrelloBean.getUtenteEmail()+" "+carrelloBean.getProdottiCodiceModello()+" "+
		carrelloBean.getProdottiCategoriaNome()+" "+carrelloBean.getProdottiMagazinoId());
		}
		
		logger.info("Retrieve all cart");
		Collection<CarrelloBean> carrelloListAll = new LinkedList<>();
		try {
			logger.info("retrieving all ");
			carrelloListAll = carrelloDAO.doRetrieveAll("utente_Email");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.info("error has occurred on retrieving all the cart");
			logger.warning(e.getMessage());
		}
		
		logger.info("Printing retrieveAll");
		System.out.println("All Cart ");
		for (CarrelloBean carrelloBean : carrelloListAll) {
			System.out.println(carrelloBean.getUtenteEmail()+" "+carrelloBean.getProdottiCodiceModello()+" "+
		carrelloBean.getProdottiCategoriaNome()+" "+carrelloBean.getProdottiMagazinoId());
		}
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			logger.warning("Sleeping error"+e1.getMessage());
//		}
		
		logger.info("deleting all data");
		for (CarrelloBean carrelloBean : carrelloListAll) {
			try {
				logger.info("deleting "+carrelloBean.getUtenteEmail()+" "+carrelloBean.getProdottiCodiceModello());
				carrelloDAO.doDelete(carrelloBean.getUtenteEmail(), carrelloBean.getProdottiCodiceModello());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.info("error has occurred on deleting");
				logger.warning(e.getMessage());
			}
		}
	}

}
