package it.unisa.data;

import java.sql.SQLException;
import java.util.Collection;

public interface UtenteDAOInterface {

	public void doSave(UtenteBean utente)throws SQLException;
	
	public UtenteBean doRetrieveByKey(String ID)throws SQLException;
	
	public boolean doDelete(String ID)throws SQLException;
	
	public Collection<UtenteBean> doRetrieveAll(String order)throws SQLException;
	
	 public boolean doUpdate (UtenteBean utente) throws SQLException;
}
