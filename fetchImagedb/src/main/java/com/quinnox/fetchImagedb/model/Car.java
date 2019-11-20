package com.quinnox.fetchImagedb.model;

public class Car {
	
	private String carTitle;
	private String base64Image;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String carTitle, String base64Image) {
		this.carTitle = carTitle;
		this.base64Image = base64Image;
	}

	public String getCarTitle() {
		return carTitle;
	}

	public void setCarTitle(String carTitle) {
		this.carTitle = carTitle;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	
	
}
