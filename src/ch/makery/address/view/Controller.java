package ch.makery.address.view;

import java.io.IOException;
import java.sql.SQLException;

import application.Main;
import application.ViewController;
import ch.makery.address.DAO.UtilisateurDAO;
import ch.makery.address.model.Utilisateur;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller extends Application {
	
  	@FXML
    private TextField name;
    @FXML
    private TextField tel;
    
    @FXML
    private Text label;

	public TextField getName() {
			return name;
		}

		public void setName(TextField name) {
			this.name = name;
		}

		public TextField getTel() {
			return tel;
		}

		public void setTel(TextField tel) {
			this.tel = tel;
		}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}
	
	public void test() throws SQLException, IOException{
		UtilisateurDAO dao = new UtilisateurDAO();
		Utilisateur user = dao.login(this.name.getText(), this.tel.getText());
		if(user != null){
			if(user.getId_role() == 1){
				Main vc = new Main();
				vc.setScene("Accueil.fxml");
			}
			this.label.setText("Success");
		}
		else{
			this.label.setText("Faillure");
		}
		
		
		
	}

	public Text getLabel() {
		return label;
	}

	public void setLabel(Text label) {
		this.label = label;
	}

}
