package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;


@SuppressWarnings("unused")
public class ViewController extends Application{

    static Stage stage = null;

    public ViewController(){

    }

    public void first(){
        launch();
    }

@Override
    public void start(Stage primaryStage) throws Exception {
         stage = primaryStage;
         stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("../View/PageLogin.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("../View/DashboardDirector.fxml"));
         // Show the scene containing the root layout.
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }

    /*
     * argument
     *     lien = nomDuFichier.fxml dans package Vi
     *     del = est ce un retour à la fenetre precedente
     * Changement de scene
     */
    public void setScene(String lien){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/ch/makery/address/view/"+lien));
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