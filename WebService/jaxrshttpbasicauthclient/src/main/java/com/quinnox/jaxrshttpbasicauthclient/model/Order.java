package com.quinnox.jaxrshttpbasicauthclient.model;

public class Order {
	
		private String customerName;
		private String address;
		private String amount;
		
		public Order() {
			super();
		}

		public Order(String customerName, String address, String amount) {
			super();
			this.customerName = customerName;
			this.address = address;
			this.amount = amount;
		}

		@Override
		public String toString() {
			return "Order [customerName=" + customerName + ", address=" + address + ", amount=" + amount + "]";
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}
		
}
