package it.unisa.data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class DettagliOrdiniDAO implements DettagliOdriniDAOInterface{
	
	private static final String TABLE_NAME = "dettagliordini";
	
	public DettagliOrdiniDAO() {
	}
	
	/**
	 * salva i dati dell'oggetto corrente nel database
	 * @param dettagliOrdiniBean carta di credito da salvare
	 * @throws SQLException
	 */
	public synchronized void doSave(DettagliOrdiniBean dettagliOrdiniBean) 
			throws SQLException{
		final String insertSQL = "INSERT INTO "+DettagliOrdiniDAO.TABLE_NAME + 
		"( IdDettagliOrdini, Ordine_IdOrdine, Ordine_Utente_IdUtente, Prodotti_CodiceModello,"
		+ " Prodotti_Categoria_Nome, Prodotti_Magazzino_ID) VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, dettagliOrdiniBean.getIdDettagliOrdini());
			preparedStatement.setInt(2, dettagliOrdiniBean.getOrdineIdOrdine());
			preparedStatement.setInt(3, dettagliOrdiniBean.getOrdineUtenteIdUente());
			preparedStatement.setInt(4, dettagliOrdiniBean.getProdottiCodiceModello());
			preparedStatement.setString(5, dettagliOrdiniBean.getProdottiCategoriaNome());
			preparedStatement.setInt(6, dettagliOrdiniBean.getProdottiMagazinoId());

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
	
	public synchronized DettagliOrdiniBean doRetrieveByKey(int idDettagliOrdine) 
			throws SQLException{
		final String selectSQL = "SELECT * FROM " + DettagliOrdiniDAO.TABLE_NAME + "WHERE IdDettagliOrdini = ?";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		DettagliOrdiniBean dettagliBean = new DettagliOrdiniBean();
		
		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement =connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idDettagliOrdine);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				dettagliBean.setIdDettagliOrdini(rs.getInt("IdDettagliOrdini"));
				dettagliBean.setOrdineIdOrdine(rs.getInt("Ordine_IdOrdine"));
				dettagliBean.setOrdineUtenteIdUente(rs.getInt("Ordine_Utente_IdUtente"));
				dettagliBean.setProdottiCodiceModello(rs.getInt("Prodotti_CodiceModello"));
				dettagliBean.setProdottiCategoriaNome(rs.getString("Prodotti_Categoria_Nome"));
				dettagliBean.setProdottiMagazinoId(rs.getInt("Prodotti_Magazzino_ID"));
			}
		} finally {
			try {
				if (preparedStatement!=null) 
					preparedStatement.close();
			} finally {
				// TODO: Rilascio della connessione
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return dettagliBean;
	}
	
	public synchronized boolean doDelete(int idDettagliOrdine) 
			throws SQLException {
		final String deleteSQL = "DELETE FROM " + DettagliOrdiniDAO.TABLE_NAME + "WHERE IdDettagliOrdini = ?";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rs=0;
		
		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(deleteSQL);
			preparedStatement.setLong(1, idDettagliOrdine);
			
			rs=preparedStatement.executeUpdate();
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
	
	public synchronized Collection<DettagliOrdiniBean> doRetrieveAll(String order) 
			throws SQLException {
		String selectSQL = "SELECT * FROM " + DettagliOrdiniDAO.TABLE_NAME;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//LinkedList è una struttura dati che implementa l'interfaccia Collection
		Collection<DettagliOrdiniBean> dettagliList = new LinkedList<DettagliOrdiniBean>();

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				DettagliOrdiniBean dettagliBean = new DettagliOrdiniBean();
				
				dettagliBean.setIdDettagliOrdini(rs.getInt("IdDettagliOrdini"));
				dettagliBean.setOrdineIdOrdine(rs.getInt("Ordine_IdOrdine"));
				dettagliBean.setOrdineUtenteIdUente(rs.getInt("Ordine_Utente_IdUtente"));
				dettagliBean.setProdottiCodiceModello(rs.getInt("Prodotti_CodiceModello"));
				dettagliBean.setProdottiCategoriaNome(rs.getString("Prodotti_Categoria_Nome"));
				dettagliBean.setProdottiMagazinoId(rs.getInt("Prodotti_Magazzino_ID"));
				dettagliList.add(dettagliBean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return dettagliList;
	}
	
	/**
	 * aggiorna i dati dell'oggetto passato nei database
	 * @param dOrdini
	 * @throws SQLException
	 */
	public synchronized boolean doUpdate (DettagliOrdiniBean dOrdini) 
			throws SQLException{
		final String updateSQL = "UPDATE "+DettagliOrdiniDAO.TABLE_NAME + 
				" SET Ordine_IdOrdine = ?, Ordine_Utente_IdUtente = ?, Prodotti_CodiceModello = ?,"
				+ " Prodotti_Categoria_Nome = ?, Prodotti_Magazzino_ID = ? WHERE IdDettagliOrdini = ?";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setInt(1, dOrdini.getOrdineIdOrdine());
			preparedStatement.setInt(2, dOrdini.getOrdineUtenteIdUente());
			preparedStatement.setInt(3, dOrdini.getProdottiCodiceModello());
			preparedStatement.setString(4, dOrdini.getProdottiCategoriaNome());
			preparedStatement.setInt(5, dOrdini.getProdottiMagazinoId());
			preparedStatement.setInt(6, dOrdini.getIdDettagliOrdini());
			
			rs=preparedStatement.executeUpdate();
			
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
