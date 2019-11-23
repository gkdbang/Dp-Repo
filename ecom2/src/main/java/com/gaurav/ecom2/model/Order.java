package com.gaurav.ecom2.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="order_table")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id")
	private Long id;
	@Column(name="item_name")
	private String itemName;
	@Column(name="model_number")
	private String modelNo;
	@Column(name="brand_name")
	private String brand;
	@Column(name="price")
	private Double price;
	
	// one-to-many Bidirectional one to many side as owner
	//@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id",insertable=false, updatable=false)
	@JsonBackReference
	private Customer customer;
	
	public Order(){}
	
	
	public Order(Long id,String itemName, String modelNo, String brand, Double price) {
		super();
		this.id=id;
		this.itemName = itemName;
		this.modelNo = modelNo;
		this.brand = brand;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", itemName=" + itemName + ", modelNo=" + modelNo + ", brand=" + brand + ", price="
				+ price + ", customer=" + customer + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getModelNo() {
		return modelNo;
	}


	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
		
	
}
