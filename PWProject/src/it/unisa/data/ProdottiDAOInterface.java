package it.unisa.data;

import java.sql.SQLException;
import java.util.Collection;

public interface ProdottiDAOInterface {

	public void doSave(ProdottiBean prodotto)throws SQLException;
	
	public ProdottiBean doRetrieveByKey(int codiceModello)throws SQLException;
	
	public boolean doDelete(int codiceModello)throws SQLException;
	
	public Collection<ProdottiBean> doRetrieveAll(String order)throws SQLException;
	
	public void doUpdate (ProdottiBean prodotto) throws SQLException;
}
