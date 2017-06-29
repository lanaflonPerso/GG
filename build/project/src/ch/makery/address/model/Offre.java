package ch.makery.address.model;

/**
 *
 * @author maxim
 */
public class Offre {
    private int id_offre;
    
    private int id_chambre;
    
    private int id_agence_voyage;
    
    private int id_centrale_reservation;
    
    private String lien_url;
    
    private String desc_offre;
    
    private int nb_visites;

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public int getId_chambre() {
        return id_chambre;
    }

    public void setId_chambre(int id_chambre) {
        this.id_chambre = id_chambre;
    }

    public int getId_agence_voyage() {
        return id_agence_voyage;
    }

    public void setId_agence_voyage(int id_agence_voyage) {
        this.id_agence_voyage = id_agence_voyage;
    }

    public int getId_centrale_reservation() {
        return id_centrale_reservation;
    }

    public void setId_centrale_reservation(int id_centrale_reservation) {
        this.id_centrale_reservation = id_centrale_reservation;
    }

    public String getLien_url() {
        return lien_url;
    }

    public void setLien_url(String lien_url) {
        this.lien_url = lien_url;
    }

    public String getDesc_offre() {
        return desc_offre;
    }

    public void setDesc_offre(String desc_offre) {
        this.desc_offre = desc_offre;
    }

    public int getNb_visites() {
        return nb_visites;
    }

    public void setNb_visites(int nb_visites) {
        this.nb_visites = nb_visites;
    }
}
