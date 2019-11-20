package com.quinnox.model;

public class User {
	
	private String name;
    private String age;
    private long phone;
    
    public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String age, long phone) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", phone=" + phone + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
    
	
}
