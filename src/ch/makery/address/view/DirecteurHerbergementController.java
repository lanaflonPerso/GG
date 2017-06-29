package ch.makery.address.view;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.fxml.Initializable;

public class DirecteurHerbergementController extends Application implements Initializable{

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




	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

	}

}
