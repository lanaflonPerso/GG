package ch.makery.address.model;

public class Chambre {
	private int id_chambre;
	
	private int numero_chambre;
	
	private int nb_lits;
	
	private int id_etage;

	public int getId_chambre() {
		return id_chambre;
	}

	public void setId_chambre(int id_chambre) {
		this.id_chambre = id_chambre;
	}

	public int getNumero_chambre() {
		return numero_chambre;
	}

	public void setNumero_chambre(int numero_chambre) {
		this.numero_chambre = numero_chambre;
	}

	public int getNb_lits() {
		return nb_lits;
	}

	public void setNb_lits(int nb_lits) {
		this.nb_lits = nb_lits;
	}

	public int getId_etage() {
		return id_etage;
	}

	public void setId_etage(int id_etage) {
		this.id_etage = id_etage;
	}

}
