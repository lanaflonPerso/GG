package ch.makery.address.view;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mysql.fabric.xmlrpc.base.Array;

import ch.makery.address.Main;
import ch.makery.address.DAO.ClientDAO;
import ch.makery.address.DAO.ReserverDAO;
import ch.makery.address.model.Client;
import ch.makery.address.model.Reservation_Client;
import ch.makery.address.model.Reserver;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class GestionReservationController extends Application implements Initializable{

	@FXML
	private Button b1;

	@FXML
	private Button b2;

	@FXML
	private Button b3;

	@FXML
	private Button BD;

	@FXML
	private Button supp;

	@FXML
	private Button find;

	 @FXML
	 private TableView<Reservation_Client> tab;

	 @FXML
	 private TableView<Client> tab2;

	 @FXML
	 private TableColumn<Reservation_Client, Date> c1;
	 @FXML
	 private TableColumn<Reservation_Client, Date> c2;
	 @FXML
	 private TableColumn<Reservation_Client, Integer> c3;
	 @FXML
	 private TableColumn<Reservation_Client, String> c4;
	 @FXML
	 private TableColumn<Reservation_Client, String> c5;

	 @FXML
	 private DatePicker date1;

	 @FXML
	 private DatePicker date2;


	public void actionBD(){
		Main vc = new Main();
		vc.setScene("ListeOverview.fxml");
	}

	public void actionB1(){
		Main vc = new Main();
		vc.setScene("GestionReservation.fxml");
	}

	public void actionB2(){
		Main vc = new Main();
		vc.setScene("AccueilHebergement.fxml");
	}

	public void actionB3(){
		Main vc = new Main();
		vc.setScene("Notoriete.fxml");
	}



	public void find(){
		this.tab.getItems().removeAll(tab.getItems());
		ReserverDAO res = new ReserverDAO();
		ClientDAO cd = new ClientDAO();
		ArrayList<Reserver> listRes = res.getReserverByDate(this.date1.getValue().toString(), this.date2.getValue().toString());
		if (listRes != null){
			for(Reserver r : listRes){
				System.out.println(r.getDate_debut());
				Client c = cd.getClientById(r.getId_client());
				Reservation_Client rc = new Reservation_Client();
				rc.setDate_debut(r.getDate_debut());
				rc.setDate_fin(r.getDate_fin());
				rc.setId_chambre(r.getId_chambre());
				rc.setNom_client(c.getNom_client());
				rc.setPrenom_client(c.getPrenom_client());
				tab.getItems().add(rc);
			}
		}
	}

	public void supp(){
		Reservation_Client cpt = tab.getSelectionModel().getSelectedItem();
		ReserverDAO rd = new ReserverDAO();
		rd.suuppReserverByDate(cpt.getDate_debut().toString(), cpt.getDate_fin().toString());
		find();
	}

	public void select(){
		Reservation_Client cpt = tab.getSelectionModel().getSelectedItem();
	    if( cpt !=null ){
	        supp.setDisable(false);
	    }
	    else{
	        supp.setDisable(true);
	    }
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.supp.setDisable(true);
		c1.setCellValueFactory(new PropertyValueFactory<Reservation_Client,Date>("date_debut"));
		c2.setCellValueFactory(new PropertyValueFactory<Reservation_Client,Date>("date_fin"));
		c3.setCellValueFactory(new PropertyValueFactory<Reservation_Client,Integer>("id_chambre"));
		c4.setCellValueFactory(new PropertyValueFactory<Reservation_Client,String>("nom_client"));
		c5.setCellValueFactory(new PropertyValueFactory<Reservation_Client,String>("prenom_client"));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

	}

}
