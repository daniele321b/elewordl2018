package it.unisa.data;

import java.sql.SQLException;
import java.util.Collection;

public interface CategoriaDAOInterface {
	public void doSave(CategoriaBean categoria)throws SQLException;
	
	public boolean doDelete(String nomeCategoria)throws SQLException;
	
	public CategoriaBean doRetrieveByKey(String name)throws SQLException;
	
	public Collection<CategoriaBean> doRetrieveAll(String order)throws SQLException;
}
