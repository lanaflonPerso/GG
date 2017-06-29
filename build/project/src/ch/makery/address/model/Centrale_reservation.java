package ch.makery.address.model;

/**
 *
 * @author maxim
 */
public class Centrale_reservation {
    private int id_centrale_reservation;
    
    private String nom_centrale_reservation;
    
    private String lien_url;

    public int getId_centrale_reservation() {
        return id_centrale_reservation;
    }

    public void setId_centrale_reservation(int id_centrale_reservation) {
        this.id_centrale_reservation = id_centrale_reservation;
    }

    public String getNom_centrale_reservation() {
        return nom_centrale_reservation;
    }

    public void setNom_centrale_reservation(String nom_centrale_reservation) {
        this.nom_centrale_reservation = nom_centrale_reservation;
    }

    public String getLien_url() {
        return lien_url;
    }

    public void setLien_url(String lien_url) {
        this.lien_url = lien_url;
    }
}
