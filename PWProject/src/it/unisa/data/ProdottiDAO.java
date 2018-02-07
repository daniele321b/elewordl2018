package it.unisa.data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;


public class ProdottiDAO implements ProdottiDAOInterface{

	private static final String TABLE_NAME = "prodotti";
	
	public ProdottiDAO(){
	}

	public synchronized void doSave(ProdottiBean prodotto) 
			throws SQLException {
		final String insertSQL = "INSERT INTO " + ProdottiDAO.TABLE_NAME
				+ " ( CodiceModello, Nome, Produttore, Colore, Prezzo, PrezzoScontato, Peso, Altezza, Profondita, Larghezza, Descrizione, Immagine, Giacenza, Categoria_Nome, Magazzino_ID ) "
				+ "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, prodotto.getCodiceModello());
			preparedStatement.setString(2, prodotto.getNome());
			preparedStatement.setString(3, prodotto.getProduttore());
			preparedStatement.setString(4, prodotto.getColore());
			preparedStatement.setFloat(5, prodotto.getPrezzo());
			preparedStatement.setFloat(6, prodotto.getPrezzoScontato());
			preparedStatement.setDouble(7, prodotto.getPeso());
			preparedStatement.setInt(8, prodotto.getAltezza());
			preparedStatement.setInt(9, prodotto.getProfondita());
			preparedStatement.setInt(10, prodotto.getLarghezza());
			preparedStatement.setString(11, prodotto.getDescrizione());
			preparedStatement.setString(12, prodotto.getImmagine());
			preparedStatement.setInt(13, prodotto.getGiacenza());
			preparedStatement.setString(14, prodotto.getCategoriaNome());
			preparedStatement.setInt(15, prodotto.getMagazzinoId());

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

	public synchronized ProdottiBean doRetrieveByKey(int codiceModello) 
			throws SQLException {
		final String selectSQL = "SELECT * FROM " + ProdottiDAO.TABLE_NAME + " WHERE CodiceModello = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ProdottiBean prodottiBean = new ProdottiBean();

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, codiceModello);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				prodottiBean.setCodiceModello(rs.getInt("CodiceModello"));
				prodottiBean.setNome(rs.getString("Nome"));
				prodottiBean.setProduttore(rs.getString("Produttore"));
				prodottiBean.setColore(rs.getString("Colore"));
				prodottiBean.setPrezzo(rs.getFloat("Prezzo"));
				prodottiBean.setPrezzoScontato(rs.getFloat("PrezzoScontato"));
				prodottiBean.setPeso(rs.getDouble("Peso"));
				prodottiBean.setAltezza(rs.getInt("Altezza"));
				prodottiBean.setProfondita(rs.getInt("Profondita"));
				prodottiBean.setLarghezza(rs.getInt("Larghezza"));
				prodottiBean.setDescrizione(rs.getString("Descrizione"));
				prodottiBean.setImmagine(rs.getString("Immagine"));
				prodottiBean.setGiacenza(rs.getInt("Giacenza"));
				prodottiBean.setCategoriaNome(rs.getString("Categoria_Nome"));
				prodottiBean.setMagazzinoId(rs.getInt("Magazzino_ID"));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return prodottiBean;
	}

	public synchronized boolean doDelete(int codiceModello) 
			throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ProdottiDAO.TABLE_NAME + " WHERE CodiceModello = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
//			System.out.println("ProdottiDAO.doDelete()"+connection.toString());
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, codiceModello);

			result = preparedStatement.executeUpdate();
			connection.commit();
			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return (result != 0);
	}
	
	
	public synchronized Collection<ProdottiBean> doRetrieveAll(String order) 
			throws SQLException {
		String selectSQL = "SELECT * FROM " + ProdottiDAO.TABLE_NAME;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//LinkedList è una struttura dati che implementa l'interfaccia Collection
		Collection<ProdottiBean> cdcList = new LinkedList<ProdottiBean>();

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProdottiBean prodottiBean = new ProdottiBean();
				prodottiBean.setCodiceModello(rs.getInt("CodiceModello"));
				prodottiBean.setNome(rs.getString("Nome"));
				prodottiBean.setProduttore(rs.getString("Produttore"));
				prodottiBean.setColore(rs.getString("Colore"));
				prodottiBean.setPrezzo(rs.getFloat("Prezzo"));
				prodottiBean.setPrezzoScontato(rs.getFloat("PrezzoScontato"));
				prodottiBean.setPeso(rs.getDouble("Peso"));
				prodottiBean.setAltezza(rs.getInt("Altezza"));
				prodottiBean.setProfondita(rs.getInt("Profondita"));
				prodottiBean.setLarghezza(rs.getInt("Larghezza"));
				prodottiBean.setDescrizione(rs.getString("Descrizione"));
				prodottiBean.setImmagine(rs.getString("Immagine"));
				prodottiBean.setGiacenza(rs.getInt("Giacenza"));
				prodottiBean.setCategoriaNome(rs.getString("Categoria_Nome"));
				prodottiBean.setMagazzinoId(rs.getInt("Magazzino_ID"));
				cdcList.add(prodottiBean);
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
	 * @param prodotto
	 * @throws SQLException
	 */
	public synchronized void doUpdate (ProdottiBean prodotto) 
			throws SQLException{
		final String updateSQL = "UPDATE "+ProdottiDAO.TABLE_NAME + 
				" SET  Nome = ?, Produttore = ?, Colore = ?, Prezzo = ?, PrezzoScontato = ?,"
				+ " Peso = ?, Altezza = ?, Profondita = ?, Larghezza = ?, Descrizione = ?, Immagine = ?, "
				+ "Giacenza = ?, Categoria_Nome = ?, Magazzino_ID  = ?"
				+ " WHERE CodiceModello = ?";
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, prodotto.getNome());
			preparedStatement.setString(2, prodotto.getProduttore());
			preparedStatement.setString(3, prodotto.getColore());
			preparedStatement.setFloat(4, prodotto.getPrezzo());
			preparedStatement.setFloat(5, prodotto.getPrezzoScontato());
			preparedStatement.setDouble(6, prodotto.getPeso());
			preparedStatement.setInt(7, prodotto.getAltezza());
			preparedStatement.setInt(8, prodotto.getProfondita());
			preparedStatement.setInt(9, prodotto.getLarghezza());
			preparedStatement.setString(10, prodotto.getDescrizione());
			preparedStatement.setString(11, prodotto.getImmagine());
			preparedStatement.setInt(12, prodotto.getGiacenza());
			preparedStatement.setString(13, prodotto.getCategoriaNome());
			preparedStatement.setInt(14, prodotto.getMagazzinoId());
			preparedStatement.setInt(15, prodotto.getCodiceModello());

			preparedStatement.executeUpdate();
			// Applica tutti i cambiamenti dall'ultimo commit e rilascia
			// il blocco del BD
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
}
