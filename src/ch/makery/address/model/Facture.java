package ch.makery.address.model;

public class Facture {
	private int id_facture;
	
	private double montant;
	
	private String moyen_payement;
	
	private int id_client;

	public int getId_facture() {
		return id_facture;
	}

	public void setId_facture(int id_facture) {
		this.id_facture = id_facture;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getMoyen_payement() {
		return moyen_payement;
	}

	public void setMoyen_payement(String moyen_payement) {
		this.moyen_payement = moyen_payement;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
}
