package it.unisa.data;

import java.sql.Date;

/**
 * Classe Bean Carta di credito
 * @author hubblex
 *
 */
public class CartaDiCreditoBean {

	
	public String getnCarta() {
		return nCarta;
	}
	public void setnCarta(String nCarta) {
		this.nCarta = nCarta;
	}
	public int getCvc() {
		return cvc;
	}
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
	public String getIntestatario() {
		return intestatario;
	}
	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}
	public Date getDataScadenza() {
		return dataScadenza;
	}
	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	
	private String nCarta;
	private int cvc;
	private String intestatario;
	private Date dataScadenza;
}
