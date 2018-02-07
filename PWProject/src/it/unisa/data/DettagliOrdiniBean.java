package it.unisa.data;

public class DettagliOrdiniBean {
	
	public int getIdDettagliOrdini() {
		return idDettagliOrdini;
	}
	public void setIdDettagliOrdini(int idDettagliOrdini) {
		this.idDettagliOrdini = idDettagliOrdini;
	}
	public int getOrdineIdOrdine() {
		return ordineIdOrdine;
	}
	public void setOrdineIdOrdine(int ordineIdOrdine) {
		this.ordineIdOrdine = ordineIdOrdine;
	}
	public int getOrdineUtenteIdUente() {
		return OrdineUtenteIdUente;
	}
	public void setOrdineUtenteIdUente(int ordineUtenteIdUente) {
		OrdineUtenteIdUente = ordineUtenteIdUente;
	}
	public int getProdottiCodiceModello() {
		return prodottiCodiceModello;
	}
	public void setProdottiCodiceModello(int prodottiCodiceModello) {
		this.prodottiCodiceModello = prodottiCodiceModello;
	}
	public String getProdottiCategoriaNome() {
		return prodottiCategoriaNome;
	}
	public void setProdottiCategoriaNome(String prodottiCategoriaNome) {
		this.prodottiCategoriaNome = prodottiCategoriaNome;
	}
	public int getProdottiMagazinoId() {
		return prodottiMagazinoId;
	}
	public void setProdottiMagazinoId(int prodottiMagazinoId) {
		this.prodottiMagazinoId = prodottiMagazinoId;
	}
	

	private int idDettagliOrdini;
	private int ordineIdOrdine;
	private int OrdineUtenteIdUente;
	private int prodottiCodiceModello;
	private String prodottiCategoriaNome;
	private int prodottiMagazinoId;
}
