package ch.makery.address.view;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import ch.makery.address.DAO.ChambreDAO;
import ch.makery.address.DAO.ClientDAO;
import ch.makery.address.DAO.ReserverDAO;
import ch.makery.address.model.Chambre;
import ch.makery.address.model.Client;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlanningReservationController extends Application implements Initializable{

	@FXML
	private Button b1;

	@FXML
	private Button b2;

	@FXML
	private DatePicker date_entre;

	@FXML
	private DatePicker date_fin;

	@FXML
	private TextField typeC;

	@FXML
	private TextField nom;

	@FXML
	private TextField prenom;

	@FXML
	private Label info;

	@FXML
	private Button BD;


	public void actionBD(){
		Main vc = new Main();
		vc.setScene("ListeOverview.fxml");
	}

	public DatePicker getDate_entre() {
		return date_entre;
	}

	public void setDate_entre(DatePicker date_entre) {
		this.date_entre = date_entre;
	}

	public DatePicker getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(DatePicker date_fin) {
		this.date_fin = date_fin;
	}

	public TextField getTypeC() {
		return typeC;
	}

	public void setTypeC(TextField typeC) {
		this.typeC = typeC;
	}

	public TextField getNom() {
		return nom;
	}

	public void setNom(TextField nom) {
		this.nom = nom;
	}

	public TextField getPrenom() {
		return prenom;
	}

	public void setPrenom(TextField prenom) {
		this.prenom = prenom;
	}

	public Label getInfo() {
		return info;
	}

	public void setInfo(Label info) {
		this.info = info;
	}

	public Button getB1() {
		return b1;
	}

	public void setB1(Button b1) {
		this.b1 = b1;
	}

	public Button getB2() {
		return b2;
	}

	public void setB2(Button b2) {
		this.b2 = b2;
	}



	public void actionB1(){
		Main vc = new Main();
		vc.setScene("EncaisserClients.fxml");
	}

	public void actionB2(){
		Main vc = new Main();
		vc.setScene("PlanningReservation.fxml");
	}




	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public void enregistrer(){
		ClientDAO cd = new ClientDAO();
		Client c = cd.getClientByNomPrenom(this.nom.getText(), this.prenom.getText());

		if (c == null){
			c = new Client();
			c.setEmail_client("");
			c.setNom_client(this.nom.getText());
			c.setNum_tel_client(0);
			c.setPrenom_client(this.prenom.getText());
			c.setId_client(cd.getMaxId());
			cd.insertClient(c);
		}
		ChambreDAO ch = new ChambreDAO();
		Chambre cha = ch.getChambreById(Integer.parseInt(this.typeC.getText()));

		if(cha == null){
			this.info.setText("Pas de chambre pour Numéro");
			return;
		}
		ReserverDAO r = new ReserverDAO();
		r.insertReserverByClient(c.getId_client(), cha.getId_chambre(),
				this.date_entre.getValue().toString(), this.date_fin.getValue().toString());
		this.info.setText("Réservation enregistrer");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

	}

}
