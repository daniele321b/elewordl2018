package it.unisa.data;

import java.sql.SQLException;
import java.util.Collection;

public interface DettagliOdriniDAOInterface {
	
	public void doSave(DettagliOrdiniBean dettagliOrdiniBean)throws SQLException;
	
	public DettagliOrdiniBean doRetrieveByKey(int idDettagliOrdine)throws SQLException;
	
	public boolean doDelete(int idDettagliOrdine)throws SQLException ;
	
	public Collection<DettagliOrdiniBean> doRetrieveAll(String order)throws SQLException;
	
	public boolean doUpdate (DettagliOrdiniBean dOrdini) throws SQLException;
}
