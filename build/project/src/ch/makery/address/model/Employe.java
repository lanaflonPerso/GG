package ch.makery.address.model;

public class Employe {
 private int id_employe;
 
 private String nom;
 
 private String prenom;
 
 private int id_metier;

public int getId_employe() {
	return id_employe;
}

public void setId_employe(int id_employe) {
	this.id_employe = id_employe;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public int getId_metier() {
	return id_metier;
}

public void setId_metier(int id_metier) {
	this.id_metier = id_metier;
}
}
