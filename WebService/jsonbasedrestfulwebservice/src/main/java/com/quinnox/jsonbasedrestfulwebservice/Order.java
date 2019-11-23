package com.quinnox.jsonbasedrestfulwebservice;

import org.codehaus.jackson.annotate.JsonProperty;

public class Order {
		
		@JsonProperty("order-Id")
		private int orderId;
		
		@JsonProperty
		private String customer;
		
		private String address;
		
		@JsonProperty("bill-amount")
		private double amount;

		public Order() {
			super();
		}

		public Order(int orderId, String customer, String address, double amount) {
			super();
			this.orderId = orderId;
			this.customer = customer;
			this.address = address;
			this.amount = amount;
		}

		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public String getCustomer() {
			return customer;
		}

		public void setCustomer(String customer) {
			this.customer = customer;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}
		
}
