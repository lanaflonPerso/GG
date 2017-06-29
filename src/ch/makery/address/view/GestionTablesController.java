package ch.makery.address.view;

import application.Main;
import ch.makery.address.DAO.ClientDAO;
import ch.makery.address.DAO.MangerDAO;
import ch.makery.address.DAO.Table_restaurantDAO;
import ch.makery.address.model.Manger;
import ch.makery.address.model.Table_restaurant;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author maxim
 */
public class GestionTablesController extends Application implements Initializable{
    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;
    
    @FXML
    private Button b4;
    
    @FXML
    private Button BD;
    
    public void actionBD(){
        Main vc = new Main();
	vc.setScene("ListeOverview.fxml");
    }
    
    public void actionB1(){
	Main vc = new Main();
	vc.setScene("GestionTables.fxml");
    }

    public void actionB2(){
	Main vc = new Main();
	vc.setScene(".fxml");
    }

    public void actionB3(){
	Main vc = new Main();
	vc.setScene(".fxml");
    }
    
    public void actionB4(){
	Main vc = new Main();
	vc.setScene(".fxml");
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Table_restaurantDAO srt = new Table_restaurantDAO();
        MangerDAO srm = new MangerDAO();
        ClientDAO src = new ClientDAO();
        
        int numTable;
        int nbPlaces;
        Manger manger;
        boolean estReserve;
        int nbCouvert;
        String nomClient;
        
        for(Table_restaurant table : srt.getAll()){
            numTable = table.getNumero_table();
            nbPlaces = table.getNb_place();
            manger = srm.getMangerByTable(table.getId_table());
            estReserve = false;
            if (manger != null){
                nbCouvert = manger.getNb_couverts();
                estReserve = true;
                nomClient = src.getClientById(manger.getId_client()).getNom_client();
            }
            
            
        }
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
