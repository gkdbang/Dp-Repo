package com.gaurav.ecom.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address_table")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="address_id")
	private Long id;
	@Column(name="customer_address_houseNo")
	private String houseNo;
	@Column(name="customer_address_city")
	private String city;
	@Column(name="customer_address_state")
	private String state;
	@Column(name="customer_address_zipcode",unique=true)
	private Long zipcode;
	
	// No argu constructor
	public Address(){}
	
	public Address(Long id, String houseNo, String city, String state, Long zipcode) {
		super();
		this.id = id;
		this.houseNo = houseNo;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", houseNo=" + houseNo + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + "]";
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getZipcode() {
		return zipcode;
	}
	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}
}
