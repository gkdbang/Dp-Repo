package com.usermanagementwithjdbc.model;

public class User {
	
		private int id;
		private String userName;
		private String password;
		private String email;
		private String country;
		private String userRole;
		
		public User() {
			// TODO Auto-generated constructor stub
		}

		public User(int id, String userName, String email, String country, String userRole,String password) {
			this.id = id;
			this.userName = userName;
			this.email = email;
			this.country = country;
			this.userRole= userRole;
			this.password=password;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
					+ ", country=" + country + ", userRole=" + userRole + "]";
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getUserRole() {
			return userRole;
		}

		public void setUserRole(String userRole) {
			this.userRole = userRole;
		}
		
}
