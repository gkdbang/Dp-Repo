package com.sgs.simple;

public class Employee {                   

	
		private String name;
		private int id;
		private String dept;             
		private Address address;     	/*If you want to represent any object as a string, toString() method comes into existence.*/
                                        /*The toString() method returns the string representation of the object.*/
		public Employee() {             /*If we are not overriding toString method we will get className@hashCode.*/
			                            /*we can override toString() method in our class to print proper output*/
		}                                	/*If you print any object, java compiler internally invokes the toString() method on the object.*/  
											/*So overriding the toString() method, returns the desired output.*/ 
		public String getName() { 
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getDept() {
			return dept;
		}

		public void setDept(String dept) {
			this.dept = dept;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

	}


