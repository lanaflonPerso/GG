package ch.makery.address.model;

public class Menu {
	private int id_menu;
	
	private String nom_menu;
	
	private double montant;

	public int getId_menu() {
		return id_menu;
	}

	public void setId_menu(int id_menu) {
		this.id_menu = id_menu;
	}

	public String getNom_menu() {
		return nom_menu;
	}

	public void setNom_menu(String nom_menu) {
		this.nom_menu = nom_menu;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
	
}
