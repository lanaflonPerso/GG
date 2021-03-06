package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


@SuppressWarnings("unused")
public class Main extends Application {
	static Stage stage = null;

    public void first(){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
         stage = primaryStage;
         stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("../ch/makery/address/view/ListeOverview.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("../View/DashboardDirector.fxml"));
         // Show the scene containing the root layout.
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }

    /*
     * argument
     *     lien = nomDuFichier.fxml dans package View
     *     del = est ce un retour � la fenetre precedente
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
