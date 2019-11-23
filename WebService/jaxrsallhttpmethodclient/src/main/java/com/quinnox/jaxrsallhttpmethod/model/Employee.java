package com.quinnox.jaxrsallhttpmethod.model;

public class Employee {
		
		private Integer id;
		private String name;
		
		public Employee() {
			// TODO Auto-generated constructor stub
		}

		public Employee(Integer id, String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + "]";
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
}
