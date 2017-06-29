package ch.makery.address.view;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import ch.makery.address.Main;
import ch.makery.address.DAO.ReserverDAO;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class TauxReservationController extends Application implements Initializable{

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
	private Button validate;

	@FXML
	private BarChart<String, Number> graph;

	@FXML
	private DatePicker date1;

	@FXML
	private DatePicker date2;

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

	public Button getValidate() {
		return validate;
	}

	public void setValidate(Button validate) {
		this.validate = validate;
	}

	public BarChart<String, Number> getGraph() {
		return graph;
	}

	public void setGraph(BarChart<String, Number> graph) {
		this.graph = graph;
	}


	public DatePicker getDate1() {
		return date1;
	}

	public void setDate1(DatePicker date1) {
		this.date1 = date1;
	}

	public DatePicker getDate2() {
		return date2;
	}

	public void setDate2(DatePicker date2) {
		this.date2 = date2;
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


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void tauxFrequantation(){
		this.graph.getData().clear();
		LocalDate localDate =  getDate1().getValue();
		Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		Date date_debut  = Date.from(instant);

		localDate =  getDate2().getValue();
		instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		Date date_fin  = Date.from(instant);


		if((date_fin.getTime()-date_debut.getTime()) / (60*1000*60*24) %60 <= 6
				&& date_fin.getTime()-date_debut.getTime() / (60*1000*60*24) %60 >=0){

			CategoryAxis xAxis = new CategoryAxis();
	        NumberAxis yAxis = new NumberAxis();
	        BarChart<String,Number> bc =
	            new BarChart<>(xAxis,yAxis);

			int i = 0;
			int moyenne = 0;
			for (LocalDate date =  getDate1().getValue(); date.isBefore(getDate2().getValue().plusDays(1)); date = date.plusDays(1))
			{

				ReserverDAO rs = new ReserverDAO();
				System.out.println(date.toString());
				moyenne = moyenne + rs.getReserverByDate(date.toString());
				i++;


			}
			System.out.println();

			float result = (float)moyenne/i;

	        XYChart.Series series1 = new XYChart.Series();
	        series1.getData().add(new XYChart.Data(date_debut.toString() +" / "+date_fin.toString(), result));
	        bc.getData().add(series1);
	        this.graph.getYAxis();
			this.graph.getData().addAll(bc.getData());




		}


	}

}
