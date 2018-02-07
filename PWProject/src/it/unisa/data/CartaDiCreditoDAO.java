package it.unisa.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;


public class CartaDiCreditoDAO implements CartaDiCreditoDAOInterface{
	private static final String TABLE_NAME = "carteDiCredito";
	
	public CartaDiCreditoDAO() {
	}

	/**
	 * salva i dati dell'oggetto corrente nel database
	 * @param cartaDiCredito carta di credito da salvare
	 * @throws SQLException
	 */
	public synchronized void doSave(CartaDiCreditoBean cartaDiCredito) 
			throws SQLException {
		final String insertSQL = "INSERT INTO " + CartaDiCreditoDAO.TABLE_NAME
				+ " (Ncarta, CVC, Intestatario, DataScadenza) VALUES (?, ?, ?, ?)";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;	
		

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, cartaDiCredito.getnCarta());
			preparedStatement.setInt(2, cartaDiCredito.getCvc());
			preparedStatement.setString(3, cartaDiCredito.getIntestatario());
			preparedStatement.setDate(4, cartaDiCredito.getDataScadenza());

			//Applica tutti i cambiamenti dall'ultimo commit e rilascia 
			//il blocco del BD
			preparedStatement.executeUpdate();
			connection.commit();
			
			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally { 
					DriverManagerConnectionPool.releaseConnection(connection);
					}
			}
	}
	
	/**
	 * legge dati dal database
	 * @param numeroCarta chiave da ricercare
	 * @return l'oggetto con la chiave desiderata
	 * @throws SQLException
	 */
	public synchronized CartaDiCreditoBean doRetrieveByKey(String numeroCarta) 
			throws SQLException {
		final String selectSQL = "SELECT * FROM " + CartaDiCreditoDAO.TABLE_NAME + " WHERE Ncarta = ?";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		CartaDiCreditoBean cdcBean = new CartaDiCreditoBean();
		
		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, numeroCarta);
			
			ResultSet rs=preparedStatement.executeQuery();
			
			while (rs.next()) {
				cdcBean.setnCarta(rs.getString("Ncarta"));
				cdcBean.setCvc(rs.getInt("CVC"));
				cdcBean.setIntestatario(rs.getString("Intestatario"));
				cdcBean.setDataScadenza(rs.getDate("DataScadenza"));
			}
		}finally{
			// TODO: handle exception
			try {
				if (preparedStatement!=null) 
					preparedStatement.close();
			} finally {
				// TODO: Rilascio della connessione
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return cdcBean;
	}
	
	/**
	 * cancella dal database i dati dell'oggetto corrente
	 * @param numeroCarta chiave appartenente all'oggetto da eliminare
	 * @return il risultato di executeUpdate()
	 * @throws SQLException
	 */
	public synchronized boolean doDelete(String numeroCarta) 
			throws SQLException {
		final String deleteSQL = "DELETE FROM " + CartaDiCreditoDAO.TABLE_NAME + " WHERE Ncarta = ?";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rs=0;
		
		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, numeroCarta);
			
			rs=preparedStatement.executeUpdate();
			connection.commit();
		}finally{
			// TODO: handle exception
			try {
				if (preparedStatement!=null) 
					preparedStatement.close();
			} finally {
				// TODO: Rilascio della connessione
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		
		return (rs != 0);
	}
	
	/**
	 * restituisce tutta la collezione di oggetti istanza della classe MyData
	 * @param order possibile ordine per i dati
	 * @return una collezioni di tutte le CartaDiCreditoBean
	 * @throws SQLException
	 */
	public synchronized Collection<CartaDiCreditoBean> doRetrieveAll(String order) 
			throws SQLException {
		String selectSQL = "SELECT * FROM " + CartaDiCreditoDAO.TABLE_NAME;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//LinkedList è una struttura dati che implementa l'interfaccia Collection
		Collection<CartaDiCreditoBean> cdcList = new LinkedList<CartaDiCreditoBean>();

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				CartaDiCreditoBean cdcBean = new CartaDiCreditoBean();
				
				cdcBean.setnCarta(rs.getString("Ncarta"));
				cdcBean.setCvc(rs.getInt("CVC"));
				cdcBean.setIntestatario(rs.getString("Intestatario"));
				cdcBean.setDataScadenza(rs.getDate("DataScadenza"));
				cdcList.add(cdcBean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return cdcList;
	}
	
	/**
	 * aggiorna i dati dell'oggetto passato nei database
	 * @param cdc
	 * @throws SQLException
	 */
	public synchronized boolean doUpdate (CartaDiCreditoBean cdc) 
			throws SQLException{
		
		final String updateSQL = "UPDATE "+CartaDiCreditoDAO.TABLE_NAME + 
				" SET CVC = ?, Intestatario = ?, DataScadenza = ?"
				+ " WHERE  Ncarta = ?";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setInt(1, cdc.getCvc());
			preparedStatement.setString(2, cdc.getIntestatario());
			preparedStatement.setDate(3, cdc.getDataScadenza());
			preparedStatement.setString(4, cdc.getnCarta());

			rs = preparedStatement.executeUpdate();

			connection.commit();
			
			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally { 
					DriverManagerConnectionPool.releaseConnection(connection);
					}		
				
			}
		return (rs != 0);
	}
}
