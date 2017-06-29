package ch.makery.address;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainAppController extends Application {
    
    @FXML
    private TextField name;
    @FXML
    private TextField tel;

    @Override
    public void start(Stage primaryStage) {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainAppController.class.getResource("view/ListeOverview.fxml"));
        try {
			AnchorPane personOverview = (AnchorPane) loader.load();
			 Scene scene = new Scene(personOverview);
	            primaryStage.setScene(scene);
	            primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
    
}