package it.unisa.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;


public class CategoriaDAO implements CategoriaDAOInterface{
	private static final String TABLE_NAME = "categoria";
	
	public CategoriaDAO() {
	}
	
	/**
	 * salva i dati dell'oggetto corrente nel database
	 * @param categoria carta di credito da salvare
	 * @throws SQLException
	 */
	public synchronized void doSave(CategoriaBean categoria) 
			throws SQLException {
		final String insertSQL = "INSERT INTO " + CategoriaDAO.TABLE_NAME + 
				" (Nome) VALUES (?)";

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, categoria.getNome());


			// Applica tutti i cambiamenti dall'ultimo commit e rilascia
			// il blocco del BD
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
	
	public synchronized CategoriaBean doRetrieveByKey(String name)
			throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		CategoriaBean bean = new CategoriaBean();

		String selectSQL = "SELECT * FROM " + CategoriaDAO.TABLE_NAME + " WHERE Nome = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, name);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setNome(rs.getString("Nome"));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return bean;
	}
	
	/**
	 * cancella dal database i dati dell'oggetto corrente
	 * @param numeroCarta chiave appartenente all'oggetto da eliminare
	 * @return il risultato di executeUpdate()
	 * @throws SQLException
	 */
	public synchronized boolean doDelete(String nomeCategoria) 
			throws SQLException {
		final String deleteSQL = "DELETE FROM " + CategoriaDAO.TABLE_NAME + " WHERE Nome = ?";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rs=0;
		
		try {
			connection=DriverManagerConnectionPool.getConnection();
			preparedStatement=connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, nomeCategoria);
			
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
	public synchronized Collection<CategoriaBean> doRetrieveAll(String order) 
			throws SQLException {
		String selectSQL = "SELECT * FROM " + CategoriaDAO.TABLE_NAME;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//LinkedList è una struttura dati che implementa l'interfaccia Collection
		Collection<CategoriaBean> cdcList = new LinkedList<CategoriaBean>();
		
		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				CategoriaBean cBean = new CategoriaBean();
				
				cBean.setNome(rs.getString("Nome"));
				cdcList.add(cBean);
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
	
//	public synchronized void doUpdate (CategoriaBean categoria) 
//			throws SQLException{
//		
//		final String updateSQL = "UPDATE "+DettagliOrdiniDAO.TABLE_NAME + 
//				" SET Nome = ? VALUES (?)";
//		
//	}
}
