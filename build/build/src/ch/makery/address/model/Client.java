package ch.makery.address.model;

public class Client {
	private int id_client;
	
	private String nom_client;
	
	private String prenom_client;
	
	private int num_tel_client;
	
	private String email_client;

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
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

	public int getNum_tel_client() {
		return num_tel_client;
	}

	public void setNum_tel_client(int num_tel_client) {
		this.num_tel_client = num_tel_client;
	}

	public String getEmail_client() {
		return email_client;
	}

	public void setEmail_client(String email_client) {
		this.email_client = email_client;
	}
}
