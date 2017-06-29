package ch.makery.address.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import ch.makery.address.Main;
import ch.makery.address.DAO.ServiceDAO;
import ch.makery.address.DAO.ServiceEmployeDAO;
import ch.makery.address.model.Service;
import ch.makery.address.model.Service_employe;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.fxml.Initializable;

@SuppressWarnings("unused")
public class EmployeParServiceController extends Application implements Initializable{

	@FXML
	private Button b1;

	@FXML
	private Button b2;

	@FXML
	private Button b3;

	@FXML
	private Button b4;

	@FXML
	private Button b5;

	@FXML
	private Button b6;


	@FXML
	private Button BD;


	public void actionBD(){
		Main vc = new Main();
		vc.setScene("ListeOverview.fxml");
	}


	@FXML
	private BarChart<String, Number> graph;


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

	public Button getB4() {
		return b4;
	}

	public void setB4(Button b4) {
		this.b4 = b4;
	}

	public Button getB5() {
		return b5;
	}

	public void setB5(Button b5) {
		this.b5 = b5;
	}

	public Button getB6() {
		return b6;
	}

	public void setB6(Button b6) {
		this.b6 = b6;
	}

	public BarChart<String, Number> getGraph() {
		return graph;
	}

	public void setGraph(BarChart<String, Number> graph) {
		this.graph = graph;
	}

	public void actionB1(){
		Main vc = new Main();
		System.out.println("test b1");
		vc.setScene("TauxJournalierRemplissageHotel.fxml");
	}

	public void actionB2(){
		Main vc = new Main();
		vc.setScene("MoyenneTauxFrequentation.fxml");
	}

	public void actionB3(){
		Main vc = new Main();
		vc.setScene("NombrePetitDejeuner.fxml");
	}

	public void actionB4(){
		Main vc = new Main();
		vc.setScene("PanierMoyen.fxml");
	}

	public void actionB5(){
		Main vc = new Main();
		vc.setScene("DepenseParService.fxml");
	}

	public void actionB6(){
		Main vc = new Main();
		vc.setScene("EmployeParService.fxml");
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	        ServiceEmployeDAO sr = new ServiceEmployeDAO();
	        HashMap<String,Integer> list =sr.getNombreEmpService();
			CategoryAxis xAxis = new CategoryAxis();
	        NumberAxis yAxis = new NumberAxis();
	        BarChart<String,Number> bc =
	            new BarChart<>(xAxis,yAxis);
	        XYChart.Series series1 = new XYChart.Series();
			for (String serv : list.keySet())
			{
				series1.getData().add(new XYChart.Data(serv,list.get(serv)));
			}
			bc.getData().add(series1);
			this.graph.getData().addAll(series1);
	}

	public void visualisation(){

	}
	@Override
	public void start(Stage primaryStage) throws Exception {

	}
}