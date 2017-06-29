package ch.makery.address.model;

import java.sql.Date;

public class Reservation_Client {
	private Date date_debut;
	
	private Date date_fin;
	
	private int id_chambre;
	
	private String nom_client;
	
	public Reservation_Client() {
		super();
	}

	public Reservation_Client(Date date_debut, Date date_fin, int id_chambre, String nom_client, String prenom_client) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.id_chambre = id_chambre;
		this.nom_client = nom_client;
		this.prenom_client = prenom_client;
	}

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

	public int getId_chambre() {
		return id_chambre;
	}

	public void setId_chambre(int id_chambre) {
		this.id_chambre = id_chambre;
	}

	public String getNom_client() {
		return nom_client;
	}

	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}

	public String getPrenom_client() {
		return prenom_client;
	}

	public void setPrenom_client(String prenom_client) {
		this.prenom_client = prenom_client;
	}

	private String prenom_client;
}
