package it.unisa.data;

import java.sql.SQLException;
import java.util.Collection;

public interface CartaDiCreditoDAOInterface {
	public void doSave(CartaDiCreditoBean data) throws SQLException;

	public boolean doDelete(String code) throws SQLException;

	public CartaDiCreditoBean doRetrieveByKey(String code) throws SQLException;
	
	public Collection<CartaDiCreditoBean> doRetrieveAll(String order) throws SQLException;
	
	public boolean doUpdate (CartaDiCreditoBean cdc) throws SQLException;
}
