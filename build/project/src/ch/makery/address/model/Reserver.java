package ch.makery.address.model;

import java.sql.Date;

public class Reserver {
	private Date date_debut;
	
	private Date date_fin;
	
	private boolean est_paye;
	
	private String nom_agence_voyage;
	
	private String moyen_de_reservation;
	
	private int id_client;
	
	private int id_chambre;

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public boolean isEst_paye() {
		return est_paye;
	}

	public void setEst_paye(boolean est_paye) {
		this.est_paye = est_paye;
	}

	public String getNom_agence_voyage() {
		return nom_agence_voyage;
	}

	public void setNom_agence_voyage(String nom_agence_voyage) {
		this.nom_agence_voyage = nom_agence_voyage;
	}

	public String getMoyen_de_reservation() {
		return moyen_de_reservation;
	}

	public void setMoyen_de_reservation(String moyen_de_reservation) {
		this.moyen_de_reservation = moyen_de_reservation;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public int getId_chambre() {
		return id_chambre;
	}

	public void setId_chambre(int id_chambre) {
		this.id_chambre = id_chambre;
	}
	
	
}
