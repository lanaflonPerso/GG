package ch.makery.address.model;

import java.sql.Date;

public class Demander {
	private Date date_demande;
	
	private int id_plat;
	
	private double montant;
	
	private int id_client;

	public Date getDate_demande() {
		return date_demande;
	}

	public void setDate_demande(Date date_demande) {
		this.date_demande = date_demande;
	}

	public int getId_plat() {
		return id_plat;
	}

	public void setId_plat(int id_plat) {
		this.id_plat = id_plat;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
}
