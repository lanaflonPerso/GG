package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Stage stage = new Stage();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ch/makery/address/view/ListeOverview.fxml"));

		    AnchorPane mainScreen = (AnchorPane) loader.load();
		    Scene scene = new Scene(mainScreen);
		    stage.setScene(scene);
		    stage.setTitle("Password Manager");
		    stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
