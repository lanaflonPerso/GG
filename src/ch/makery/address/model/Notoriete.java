package ch.makery.address.model;

public class Notoriete {
	private int idNotoriete;
	private String nom;
	private int note;
	
	public Notoriete() {
		super();
	}
	public Notoriete(int idNotoriete, String nom, int note) {
		super();
		this.idNotoriete = idNotoriete;
		this.nom = nom;
		this.note = note;
	}
	public int getIdNotoriete() {
		return idNotoriete;
	}
	public void setIdNotoriete(int idNotoriete) {
		this.idNotoriete = idNotoriete;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}

}
