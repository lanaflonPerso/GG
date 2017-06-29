package ch.makery.address;

import java.io.File;
import java.io.IOException;
import java.net.URL;

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
        /*stage = primaryStage;
         stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("view/ListeOverview.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("../View/DashboardDirector.fxml"));
         // Show the scene containing the root layout.
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();*/
    }

    /*
     * argument
     *     lien = nomDuFichier.fxml dans package View
     *     del = est ce un retour à la fenetre precedente
     * Changement de scene
     */
    public void setScene(String lien){
    	MainAppController mac = new MainAppController();
    	mac.setScene(lien);
        /*try {
        	String path = System.getProperty("java.class.path");
        	String[] p = path.split(System.getProperty("path.separator"));
        	String url = new File(p[0]+"\\ch\\makery\\address\\view\\ListeOverview.fxml").toURI().toURL().toString();
        	Parent root = FXMLLoader.load(getClass().getResource(url));
            //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/ListeOverview.fxml"));
            
             // Show the scene containing the root layout.
            Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Changement de scene impossible");
        }*/

    }

}
