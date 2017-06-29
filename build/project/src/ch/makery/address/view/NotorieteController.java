package ch.makery.address.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import application.Main;
import ch.makery.address.DAO.NotorieteDAO;
import ch.makery.address.DAO.ServiceEmployeDAO;
import ch.makery.address.model.Notoriete;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class NotorieteController extends Application implements Initializable{

	@FXML
	private Button b1;

	@FXML
	private Button b2;

	@FXML
	private Button b3;

	@FXML
	private LineChart<String, Number> graph;

	@FXML
	private Button BD;


	public void actionBD(){
		Main vc = new Main();
		vc.setScene("ListeOverview.fxml");
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

	public Button getB3() {
		return b3;
	}

	public void setB3(Button b3) {
		this.b3 = b3;
	}

	public LineChart<String, Number> getGraph() {
		return graph;
	}

	public void setGraph(LineChart<String, Number> graph) {
		this.graph = graph;
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




	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initialize(URL arg0, ResourceBundle arg1) {
	        NotorieteDAO sr = new NotorieteDAO();
	        ArrayList<Notoriete> list =sr.getNotoriete();
			CategoryAxis xAxis = new CategoryAxis();
	        NumberAxis yAxis = new NumberAxis();
	        BarChart<String,Number> bc =
	            new BarChart<>(xAxis,yAxis);
	        XYChart.Series series1 = new XYChart.Series();
			for (Notoriete not : list)
			{
				series1.getData().add(new XYChart.Data(not.getNom(),not.getNote()));
			}
			bc.getData().add(series1);
			this.graph.getData().addAll(series1);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

	}

}
