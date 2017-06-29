package ch.makery.address.view;

import ch.makery.address.Main;
import ch.makery.address.DAO.ChambreDAO;
import ch.makery.address.DAO.OffreDAO;
import ch.makery.address.model.Chambre;
import ch.makery.address.model.Offre;
import ch.makery.address.model.Reserver;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author maxime
 */
public class CentraleReservationController extends Application implements Initializable{
    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

	@FXML
	private Button BD;


	public void actionBD(){
		Main vc = new Main();
		vc.setScene("ListeOverview.fxml");
	}

    public void actionB1(){
	Main vc = new Main();
	vc.setScene("CentaleReservation.fxml");
    }

    public void actionB2(){
	Main vc = new Main();
	vc.setScene("AccueilHebergement.fxml");
    }

    public void actionB3(){
	Main vc = new Main();
	vc.setScene("Notoriete.fxml");
    }

    @SuppressWarnings("unused")
	@Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        OffreDAO sro = new OffreDAO();
        ChambreDAO src = new ChambreDAO();
        ReserverDAO srr = new ReserverDAO();
        Date aujourd = new Date();

        int numChambre = 0;
        int nbLits = 0;
        String lienUrl ="";
        String nomClient = " - ";
        String dateDebut = " - ";
        Boolean estReserve = false;
        Chambre chambre = null;
        ArrayList<Offre> tabOffre = sro.getAllCentrale();

        for(Offre offre : tabOffre){
            chambre = src.getChambreById(offre.getId_chambre());
            numChambre = chambre.getNumero_chambre();
            nbLits = chambre.getNb_lits();
            lienUrl = offre.getLien_url();
            ArrayList<Reserver> tabReserver = srr.getReserverByChambre(chambre.getId_chambre());
            nomClient = " - ";
            dateDebut = " - ";
            estReserve = false;
            for(Reserver reserver : tabReserver){
                if(reserver.getDate_fin().compareTo(aujourd) > 0){ /* Chambre réservé où la reservation n'est pas terminée */
                    dateDebut = reserver.getDate_debut().toString();
                    estReserve = true;
                }
            }
            /* On complete la vue avec les données récuperer ci-dessus */

        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
