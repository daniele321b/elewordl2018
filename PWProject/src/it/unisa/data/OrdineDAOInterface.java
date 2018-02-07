package it.unisa.data;

import java.sql.SQLException;
import java.util.Collection;

public interface OrdineDAOInterface {
	
	public void doSave(OrdineBean ordine) throws SQLException;
	
	public OrdineBean doRetrieveByKey(int idOrdine) throws SQLException;
	
	public boolean doDelete(int idOrdine) throws SQLException;
	
	public Collection<OrdineBean> doRetrieveAll(String order) throws SQLException;
	
	public boolean doUpdate (OrdineBean ordine) throws SQLException;
}
