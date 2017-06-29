package ch.makery.address.model;

public class Equipement {
	private int id_equipement;
	
	private String nom_equipement;
	
	private int id_type;

	public int getId_equipement() {
		return id_equipement;
	}

	public void setId_equipement(int id_equipement) {
		this.id_equipement = id_equipement;
	}

	public String getNom_equipement() {
		return nom_equipement;
	}

	public void setNom_equipement(String nom_equipement) {
		this.nom_equipement = nom_equipement;
	}

	public int getId_type() {
		return id_type;
	}

	public void setId_type(int id_type) {
		this.id_type = id_type;
	}
}
