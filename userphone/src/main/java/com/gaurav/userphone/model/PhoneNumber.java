package com.gaurav.userphone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phone_numbers_table")
public class PhoneNumber {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="phone_id")
	private Long phoneId;
	
	@Column(name = "phone_number_type")
	private String phoneType;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	public PhoneNumber() {
		// TODO Auto-generated constructor stub
	}

	public PhoneNumber(Long phoneId, String phoneType, String phoneNumber) {
		super();
		this.phoneId = phoneId;
		this.phoneType = phoneType;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "PhoneNumber [phoneId=" + phoneId + ", phoneType=" + phoneType + ", phoneNumber=" + phoneNumber + "]";
	}

	public Long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(Long phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
