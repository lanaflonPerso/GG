package ch.makery.address.model;


import javafx.beans.property.StringProperty;

public class Text {
	private StringProperty message;

	

	public Text(StringProperty message) {
		super();
		this.message = message;
	}



	public StringProperty getMessage() {
		return message;
	}



	public void setMessage(StringProperty message) {
		this.message = message;
	}



	public Text() {
		super();
	}
	

}
