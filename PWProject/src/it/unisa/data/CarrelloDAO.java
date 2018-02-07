package it.unisa.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class CarrelloDAO implements CarrelloDAOInterface{

	private static final String TABLE_NAME = "carrello";
	
	public synchronized void doSave(CarrelloBean carrello) 
			throws SQLException {
		final String insertSQL = "INSERT INTO "+CarrelloDAO.TABLE_NAME + 
				"( utente_Email, prodotti_CodiceModello, prodotti_Categoria_Nome, prodotti_Magazzino_ID)"
				+ "VALUES (?, ?, ?, ?)";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, carrello.getUtenteEmail());
			preparedStatement.setInt(2, carrello.getProdottiCodiceModello());
			preparedStatement.setString(3, carrello.getProdottiCategoriaNome());
			preparedStatement.setInt(4, carrello.getProdottiMagazinoId());
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
	
	public boolean doDelete(String utenteEmail, int prodottoCodiceModello) 
			throws SQLException {
		final String deleteSQL = "DELETE FROM " + CarrelloDAO.TABLE_NAME + " WHERE utente_Email = ? and prodotti_CodiceModello = ?";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rs=0;
		
		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, utenteEmail);
			preparedStatement.setInt(2, prodottoCodiceModello);
			
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
	
	/*
	 * (non-Javadoc)
	 * @see it.unisa.data.CarrelloDAOInterface#doRetrieveByKey(java.lang.String)
	 * il metodo ritorna una collezione di oggetti di tipo CarrelloBean perchè non ha chiavi primarie ma solo 
	 * chiave esterne e quindi ci saranno più elementi con la stessa utenteMail
	 */
	public synchronized Collection<CarrelloBean> doRetrieveByKey(String utenteEmail) 
			throws SQLException {
		final String selectSQL = "SELECT * FROM " + CarrelloDAO.TABLE_NAME + " WHERE utente_Email = ?";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<CarrelloBean> carrelloList  = new  LinkedList<>();
		
		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement =connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, utenteEmail);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				CarrelloBean carrelloBean = new CarrelloBean();
				carrelloBean.setUtenteEmail(rs.getString("utente_Email"));
				carrelloBean.setProdottiCodiceModello(rs.getInt("prodotti_CodiceModello"));
				carrelloBean.setProdottiCategoriaNome(rs.getString("prodotti_Categoria_Nome"));
				carrelloBean.setProdottiMagazinoId(rs.getInt("prodotti_Magazzino_ID"));
				carrelloList.add(carrelloBean);
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
		
		return carrelloList;
	}
	
	public synchronized Collection<CarrelloBean> doRetrieveAll(String order) throws SQLException {
		String selectSQL = "SELECT * FROM " + CarrelloDAO.TABLE_NAME;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//LinkedList Ã¨ una struttura dati che implementa l'interfaccia Collection
		Collection<CarrelloBean> carrelloList = new LinkedList<>();

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				CarrelloBean carrelloBean = new CarrelloBean();
				
				carrelloBean.setUtenteEmail(rs.getString("utente_Email"));
				carrelloBean.setProdottiCodiceModello(rs.getInt("prodotti_CodiceModello"));
				carrelloBean.setProdottiCategoriaNome(rs.getString("prodotti_Categoria_Nome"));
				carrelloBean.setProdottiMagazinoId(rs.getInt("prodotti_Magazzino_ID"));
				carrelloList.add(carrelloBean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return carrelloList;
	}
}
