package ch.makery.address.view;

import application.Main;
import ch.makery.address.DAO.ClientDAO;
import ch.makery.address.DAO.MangerDAO;
import ch.makery.address.DAO.Table_restaurantDAO;
import ch.makery.address.model.Manger;
import ch.makery.address.model.Reservation_Table;
import ch.makery.address.model.Table_restaurant;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    
    @FXML
    private TableView<Reservation_Table> tableView;
    @FXML
    private TableColumn<Reservation_Table, Integer> c1;
    @FXML
    private TableColumn<Reservation_Table, String> c2;
    @FXML
    private TableColumn<Reservation_Table, String> c3;
    @FXML
    private TableColumn<Reservation_Table, String> c4;
    @FXML
    private TableColumn<Reservation_Table, Button> c5;
    
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
        c1.setCellValueFactory(new PropertyValueFactory<Reservation_Table, Integer>("numTable"));
        c2.setCellValueFactory(new PropertyValueFactory<Reservation_Table, String>("nbPlaces"));
        c3.setCellValueFactory(new PropertyValueFactory<Reservation_Table, String>("nbCouvert"));
        c4.setCellValueFactory(new PropertyValueFactory<Reservation_Table, String>("client"));
        c5.setCellValueFactory(new PropertyValueFactory<Reservation_Table, Button>("action"));
        
        Table_restaurantDAO srt = new Table_restaurantDAO();
        MangerDAO srm = new MangerDAO();
        ClientDAO src = new ClientDAO();
        
        Manger manger;
        String nbCouvert;
        String nomClient;
        
        for(Table_restaurant table : srt.getAll()){
            manger = srm.getMangerByTable(table.getId_table());
            if (manger != null){
                nbCouvert = manger.getNb_couverts() + " couverts";
                nomClient = src.getClientById(manger.getId_client()).getNom_client();
            }else{
                nbCouvert = " - ";
                nomClient = " - ";
            }
            Button but = new Button("Modifier");
            but.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("Modifier");
                }
            });
            Reservation_Table rt = new Reservation_Table(table.getNumero_table(), table.getNb_place() + " places", nbCouvert, nomClient, but);
            
            
        }
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
