package ch.makery.address.model;

/**
 *
 * @author maxim
 */
public class Agence_voyage {
    private int id_agence_voyage;
    
    private String nom_agence_voyage;
    
    private String lien_url;

    public int getId_agence_voyage() {
        return id_agence_voyage;
    }

    public void setId_agence_voyage(int id_agence_voyage) {
        this.id_agence_voyage = id_agence_voyage;
    }

    public String getNom_agence_voyage() {
        return nom_agence_voyage;
    }

    public void setNom_agence_voyage(String nom_agence_voyage) {
        this.nom_agence_voyage = nom_agence_voyage;
    }

    public String getLien_url() {
        return lien_url;
    }

    public void setLien_url(String lien_url) {
        this.lien_url = lien_url;
    }
}
