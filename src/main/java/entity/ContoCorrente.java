package entity;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
@Entity
public class ContoCorrente {
	private String dataCreazione=LocalDate.now().toString();
	private String iban;
	private double saldo;
	private String intestatario;
	
	private ArrayList<Movimento> movimenti= new ArrayList<>();
	
	 public String getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(String dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getIntestatario() {
		return intestatario;
	}
	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}
	public ArrayList<Movimento> getMovimenti() {
		return movimenti;
	}
	public void setMovimenti(ArrayList<Movimento> movimenti) {
		this.movimenti = movimenti;
	}
	 
	 
}
