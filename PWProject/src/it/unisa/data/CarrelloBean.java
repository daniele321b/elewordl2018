package it.unisa.data;

/**
 * 
 * @author Unknow
 *
 */
public class CarrelloBean {
	
	public String getUtenteEmail() {
		return utenteEmail;
	}
	public void setUtenteEmail(String utenteEmail) {
		this.utenteEmail = utenteEmail;
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
	private String utenteEmail;
	private int prodottiCodiceModello;
	private String prodottiCategoriaNome;
	private int prodottiMagazinoId;
}
