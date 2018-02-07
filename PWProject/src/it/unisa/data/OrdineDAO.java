package it.unisa.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;


public class OrdineDAO implements OrdineDAOInterface{
	
	private static final String TABLE_NAME = "ordine";
	
	public OrdineDAO() {
	}
	
	
	/**
	 * salva i dati dell'oggetto corrente nel database
	 * @param ordine ordine da salvare
	 * @throws SQLException
	 */
	public synchronized void doSave(OrdineBean ordine) 
			throws SQLException{
		
		final String insertSQL = "INSERT INTO " + OrdineDAO.TABLE_NAME
				+ " (IdOrdine, DataOrdine, DataConsegna, Stato, Utente_Email) VALUES (?, ?, ?, ?, ?)";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, ordine.getIdOrdine());
			preparedStatement.setDate(2, ordine.getDataOrdine());
			preparedStatement.setDate(3, ordine.getDataConsegna());
			preparedStatement.setString(4, ordine.getStato());
			preparedStatement.setString(5, ordine.getUtenteEmail());
			
			//Applica tutti i cambiamenti dall'ultimo commit e rilascia 
			//il blocco del BD
			preparedStatement.executeUpdate();
			connection.commit();
		} finally {
			// TODO: handle finally clause
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
	 * @param idOrdine
	 * @return l'oggetto OrdineBean con la chiave desiderata
	 * @throws SQLException
	 */
	public synchronized OrdineBean doRetrieveByKey(int idOrdine) 
			throws SQLException {
		
		final String selectSQL = "SELECT * FROM " + OrdineDAO.TABLE_NAME + " WHERE IdOrdine = ?";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		OrdineBean oBean = new OrdineBean();
		
		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setLong(1, idOrdine);
			
			ResultSet rs=preparedStatement.executeQuery();
			
			while (rs.next()) {
				oBean.setIdOrdine(rs.getInt("IdOrdine"));
				oBean.setDataOrdine(rs.getDate("DataOrdine"));
				oBean.setDataConsegna(rs.getDate("DataConsegna"));
				oBean.setStato(rs.getString("Stato"));
				oBean.setUtenteEmail(rs.getString("Utente_Email"));
			}
		} finally {
			// TODO: handle finally clause
			try {
				if (preparedStatement!=null) 
					preparedStatement.close();
			} finally {
				// TODO: Rilascio della connessione
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return oBean;
	}
	
	/**
	 * cancella dal database i dati dell'oggetto corrente
	 * @param idOrdine chiave appartenente all'oggetto da eliminare
	 * @return il risultato di executeUpdate()
	 * @throws SQLException
	 */
	public synchronized boolean doDelete(int idOrdine) 
			throws SQLException {
			final String deleteSQL = " DELETE FROM " + OrdineDAO.TABLE_NAME + " WHERE IdOrdine = ?";
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			int rs=0;
			
			try {
				connection=DriverManagerConnectionPool.getConnection();
				preparedStatement=connection.prepareStatement(deleteSQL);
				preparedStatement.setLong(1, idOrdine);
				
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
	
	
	public synchronized Collection<OrdineBean> doRetrieveAll(String order) 
			throws SQLException {
		
		String selectSQL = "SELECT * FROM " + OrdineDAO.TABLE_NAME;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<OrdineBean> oList = new LinkedList<OrdineBean>();
		
		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}
		
		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			
			ResultSet rs=preparedStatement.executeQuery();
			
			while (rs.next()) {
				OrdineBean oBean = new OrdineBean();
				oBean.setIdOrdine(rs.getInt("IdOrdine"));
				oBean.setDataOrdine(rs.getDate("DataOrdine"));
				oBean.setDataConsegna(rs.getDate("DataConsegna"));
				oBean.setStato(rs.getString("Stato"));
				oBean.setUtenteEmail(rs.getString("Utente_Email"));
				oList.add(oBean);
			}
		} finally {
			// TODO: handle finally clause
			try {
				if (preparedStatement!=null) 
					preparedStatement.close();
			} finally {
				// TODO: Rilascio della connessione
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return oList;
	}
	
	
	public synchronized boolean doUpdate (OrdineBean ordine) 
			throws SQLException{
		
		final String updateSQL = "UPDATE "+OrdineDAO.TABLE_NAME +
				 " SET DataOrdine = ?, DataConsegna = ?, Stato ?, Utente_Email = ?"
				 + " WHERE IdOrdine = ?";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;	
		int rs = 0;
		
		try {
			
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setDate(1, ordine.getDataOrdine());
			preparedStatement.setDate(2, ordine.getDataConsegna());
			preparedStatement.setString(3, ordine.getStato());
			preparedStatement.setString(4, ordine.getUtenteEmail());
			preparedStatement.setInt(5, ordine.getIdOrdine());
			
			rs=preparedStatement.executeUpdate();
			//Applica tutti i cambiamenti dall'ultimo commit e rilascia 
			//il blocco del BD
			connection.commit();
		} finally {
			// TODO: handle finally clause
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
