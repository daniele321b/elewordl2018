package it.unisa.data;

import java.sql.Date;
import java.sql.SQLException;

public class Main1 {
	public static void main(String[] args) {
//		CartaDiCreditoBean ccb= new CartaDiCreditoBean();
//		
//		Scanner in=new Scanner(System.in);
//		
//		System.out.println("Inserisci Numero Carta");
//		long numeroCarta=in.nextInt();
//		System.out.println("Inserisci CVC");
//		int cvc=in.nextInt();
//		in.nextLine();
//		System.out.println("Inserisci Intestatario");
//		String intestatario=in.nextLine();
//		System.out.println("Inserisci Data Scadenza");
//		String utilDate=in.nextLine();
//		Date dataScadenza= Date.valueOf(utilDate);
//		
//		ccb.setnCarta(numeroCarta);
//		ccb.setCvc(cvc);
//		ccb.setIntestatario(intestatario);
//		ccb.setDataScadenza(dataScadenza);
//		System.out.println(ccb.getnCarta()+" "+ccb.getCvc()+" "+ccb.getIntestatario()+" "+ccb.getDataScadenza());
//		
//		CartaDiCreditoDAO ccDAO=new CartaDiCreditoDAO();
//		try {
//			ccDAO.doSave(ccb);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Errone nella classe DAO"+e.getMessage());
//		}finally {
//			in.close();
//		}
		//creazione Utente con id 1001
		UtenteBean uBean = new UtenteBean();
		uBean.setNome("Giuseppe");
		uBean.setCognome("Bianchi");
		uBean.setMail("giubi@libero.it");
		uBean.setPassword("giubia");
		uBean.setTipo("user");
		uBean.setPaese("Italia");
		uBean.setProvincia("RO");
		uBean.setCitta("ValMonotne"); 
		uBean.setVia("viaDelleCarcioffole");
		uBean.setCap("01223");
		uBean.setCivico(6);
		uBean.setNumerCarta("231423434");;
		
		//creazione carta di credito
		CartaDiCreditoBean cdcBean  = new CartaDiCreditoBean();
		cdcBean.setnCarta("231423434");
		
		//creazione Ordine
//		Date dataOrdine = new Date(2017-02-03);
//		Date dataSpedizione = new Date(2017-05-02);
//		OrdineBean oBean = new OrdineBean();
//		oBean.setIdOrdine(13);
//		oBean.setDataOrdine(dataOrdine);
//		oBean.setDataConsegna(dataSpedizione);
//		oBean.setStato("spedito");
//		oBean.setUtenteEmail("giubia@libero.it");
		
		//Ordine di inserimento -> Carta > Utente > Ordine
		
		CartaDiCreditoDAOInterface cdcDAO = new CartaDiCreditoDAO();
		UtenteDAOInterface uDAO = new UtenteDAO();
//		OrdineDAOInterface oDAO = new OrdineDAO();
		ProdottiDAOInterface prodottiDAOInterface = new ProdottiDAO();
		
		try {
			System.out.println("Carta di credito");
//			cdcDAO.doSave(cdcBean);
//			Thread.sleep(1000);
			System.out.println("Utente");
//			uDAO.doSave(uBean);
//			Thread.sleep(1000);
			System.out.println("prodotto");
			prodottiDAOInterface.doDelete(3);
//			oDAO.doSave(oBean);
//			Thread.sleep(1000);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erroe sql ex "+e.getMessage());
		} 
//		catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Erroe sleep ex "+e.getMessage());
//		}
		
	} 
}
