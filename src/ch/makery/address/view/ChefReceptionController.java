package ch.makery.address.view;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ChefReceptionController extends Application implements Initializable{
	
	@FXML
	private Button b1;
	
	@FXML
	private Button b2;
	
	
	
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
	@Override
	public void start(Stage primaryStage) throws Exception {
		
	}
}