package it.unisa.data;

import java.sql.SQLException;

public class Main2 {
	public static void main(String[] args) {
		
		String mailParameter = "gio@vanni.it";
		String password = "alee";
		
		UtenteBean uBean = null;
		UtenteDAOInterface uDao = new UtenteDAO();
		
		try {
			uBean = uDao.doRetrieveByKey(mailParameter);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+" \n so retrive ERROR \n"+e.getSQLState());
		}
		
		if (uBean == null) {
			System.out.println(" Bean nullo");
		}else if (uBean.getMail()==null) {
			System.out.println(" Bean vuoto");
		}else {
			if (!uBean.getPassword().equals(password)) {
			System.out.println(" Password errara");
			}else {
			System.out.println("Tutto apposto");
			System.out.println(uBean.getMail()+uBean.getNome()+uBean.getCognome());
			}
		}
	}
}
