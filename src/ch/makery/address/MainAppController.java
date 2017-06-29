package ch.makery.address;


import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainAppController extends Application {
	static Stage stage = null;

    public void first(){
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
         stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("view/ListeOverview.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("../View/DashboardDirector.fxml"));
         // Show the scene containing the root layout.
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void setScene(String lien){
    	
        try {
        	Parent root = FXMLLoader.load(getClass().getResource("view/"+lien));
            //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/ListeOverview.fxml"));
            
             // Show the scene containing the root layout.
            Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Changement de scene impossible");
        }

    }
    
    
    
    
}