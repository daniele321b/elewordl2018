package it.unisa.data;

import java.sql.SQLException;
import java.util.Collection;

public interface CarrelloDAOInterface {
	public void doSave(CarrelloBean carrello) throws SQLException;
	
	public boolean doDelete(String utenteEmail, int prodottoCodiceModello) throws SQLException;
	
	public Collection<CarrelloBean> doRetrieveByKey(String utenteEmail) throws SQLException;
	
	public Collection<CarrelloBean> doRetrieveAll(String order) throws SQLException;
}
