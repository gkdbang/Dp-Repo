package com.sgs.simple;

public class Address {
	
	private String houseNo;
	private String city;
	private int pincode;
	
	public Address() {
		
	}
	
	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", city=" + city + ", pincode="
				+ pincode + "]";
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
