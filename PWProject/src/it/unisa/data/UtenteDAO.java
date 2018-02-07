package it.unisa.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;



public class UtenteDAO implements UtenteDAOInterface{
	private static final String TABLE_NAME = "utente";
	
	public UtenteDAO() {
	}
	/**
	 * salva i dati dell'oggetto corrente nel database
	 * @param utente carta di credito da salvare
	 * @throws SQLException
	 */
	public synchronized void doSave(UtenteBean utente) 
			throws SQLException {
		final String insertSQL = "INSERT INTO " + UtenteDAO.TABLE_NAME
				+ " ( Email, Nome, Cognome, Password, Tipo, Paese, Provincia, Citta, Via, Cap, Civico, CarteDiCredito_Ncarta) "
				+ "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, utente.getMail());
			preparedStatement.setString(2, utente.getNome());
			preparedStatement.setString(3, utente.getCognome());
			preparedStatement.setString(4, utente.getPassword());
			preparedStatement.setString(5, utente.getTipo());
			preparedStatement.setString(6, utente.getPaese());
			preparedStatement.setString(7, utente.getProvincia());
			preparedStatement.setString(8, utente.getCitta());
			preparedStatement.setString(9, utente.getVia());
			preparedStatement.setString(10, utente.getCap());
			preparedStatement.setInt(11, utente.getCivico());
			preparedStatement.setString(12, utente.getNumerCarta());

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
	 * restituisce uno ggetto istanza di CartaDiCreditoBean i cui dati sono letti dal database
	 * @param ID chiave da ricercare
	 * @return l'oggetto con la chiave desiderata
	 * @throws SQLException
	 */
	public synchronized UtenteBean doRetrieveByKey(String ID) 
			throws SQLException {
		final String selectSQL = "SELECT * FROM " + UtenteDAO.TABLE_NAME + " WHERE Email = ?";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		UtenteBean uBean = new UtenteBean();
		
		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, ID);
			ResultSet rs=preparedStatement.executeQuery();
			
			while (rs.next()) {
				uBean.setMail(rs.getString("Email"));
				uBean.setNome(rs.getString("Nome"));
				uBean.setCognome(rs.getString("Cognome"));
				uBean.setPassword(rs.getString("Password"));
				uBean.setTipo(rs.getString("Tipo"));
				uBean.setPaese(rs.getString("Paese"));
				uBean.setProvincia(rs.getString("Provincia"));
				uBean.setCitta(rs.getString("Citta"));
				uBean.setVia(rs.getString("Via"));
				uBean.setCap(rs.getString("Cap"));
				uBean.setCivico(rs.getInt("Civico"));
				uBean.setNumerCarta(rs.getString("CarteDiCredito_Ncarta"));
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
		
		return uBean;
	}
	
	/**
	 * cancella dal database i dati dell'oggetto corrente
	 * @param ID chiave appartenente all'oggetto da eliminare
	 * @return il risultato di executeUpdate()
	 * @throws SQLException
	 */
	public synchronized boolean doDelete(String ID) 
			throws SQLException {
		final String deleteSQL = "DELETE FROM " + UtenteDAO.TABLE_NAME + " WHERE Email = ?";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rs=0;
		
		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, ID);
			
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
	public synchronized Collection<UtenteBean> doRetrieveAll(String order) 
			throws SQLException {
		String selectSQL = "SELECT * FROM " + UtenteDAO.TABLE_NAME;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//LinkedList è una struttura dati che implementa l'interfaccia Collection
		Collection<UtenteBean> cdcList = new LinkedList<UtenteBean>();

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				UtenteBean uBean = new UtenteBean();
				uBean.setMail(rs.getString("Email"));
				uBean.setNome(rs.getString("Nome"));
				uBean.setCognome(rs.getString("Cognome"));
				uBean.setPassword(rs.getString("Password"));
				uBean.setTipo(rs.getString("Tipo"));
				uBean.setPaese(rs.getString("Paese"));
				uBean.setProvincia(rs.getString("Provincia"));
				uBean.setCitta(rs.getString("Citta"));
				uBean.setVia(rs.getString("Via"));
				uBean.setCap(rs.getString("Cap"));
				uBean.setCivico(rs.getInt("Civico"));
				uBean.setNumerCarta(rs.getString("CarteDiCredito_Ncarta"));
				cdcList.add(uBean);
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
	 * @param utente
	 * @throws SQLException
	 */
	public synchronized boolean doUpdate (UtenteBean utente) 
			throws SQLException{
		
		final String updateSQL = "UPDATE "+UtenteDAO.TABLE_NAME+" SET Nome = ?, Cognome = ?, Password = ?,"
				+ " Tipo = ?, Paese = ?, Provincia = ?, Citta = ?, Via = ?, Cap = ?, Civico = ?, CarteDiCredito_Ncarta = ?"
				+ " WHERE Email = ?";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;	
		int rs=0;
		
		try {
			
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, utente.getNome());
			preparedStatement.setString(2, utente.getCognome());
			preparedStatement.setString(3, utente.getPassword());
			preparedStatement.setString(4, utente.getTipo());
			preparedStatement.setString(5, utente.getPaese());
			preparedStatement.setString(6, utente.getProvincia());
			preparedStatement.setString(7, utente.getCitta());
			preparedStatement.setString(8, utente.getVia());
			preparedStatement.setString(9, utente.getCap());
			preparedStatement.setInt(10, utente.getCivico());
			preparedStatement.setString(11, utente.getNumerCarta());
			preparedStatement.setString(12, utente.getMail());

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
