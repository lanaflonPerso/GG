package ch.makery.address.model;

import javafx.scene.control.Button;

/**
 *
 * @author maxim
 */
public class Reservation_Table {
    private int numTable;
    
    private String nbPlaces;
    
    private String nbCouvert;
    
    private String client;
    
    private Button action;

    public Reservation_Table(int numTable, String nbPlaces, String nbCouvert, String client, Button action) {
        this.numTable = numTable;
        this.nbPlaces = nbPlaces;
        this.nbCouvert = nbCouvert;
        this.client = client;
        this.action = action;
    }

    public int getNumTable() {
        return numTable;
    }

    public void setNumTable(int numTable) {
        this.numTable = numTable;
    }

    public String getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(String nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public String getNbCouvert() {
        return nbCouvert;
    }

    public void setNbCouvert(String nbCouvert) {
        this.nbCouvert = nbCouvert;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Button getAction() {
        return action;
    }

    public void setAction(Button action) {
        this.action = action;
    }
}
