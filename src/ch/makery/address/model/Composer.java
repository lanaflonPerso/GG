package ch.makery.address.model;

public class Composer {
	private int id_menu;
	
	private double montant;
	
	private int id_plat;
	
	private double montant_prix;

	public int getId_menu() {
		return id_menu;
	}

	public void setId_menu(int id_menu) {
		this.id_menu = id_menu;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public int getId_plat() {
		return id_plat;
	}

	public void setId_plat(int id_plat) {
		this.id_plat = id_plat;
	}

	public double getMontant_prix() {
		return montant_prix;
	}

	public void setMontant_prix(double montant_prix) {
		this.montant_prix = montant_prix;
	}
}
