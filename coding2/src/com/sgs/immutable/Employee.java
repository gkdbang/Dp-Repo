package com.sgs.immutable;

final class Employee {
	
	private int id;
	
	public Employee(int id) {
		this.id = id;
	}
	
	public Employee modify(int id){
		if(this.id == id){
			return this;
		}
		return new Employee(id);
	}
}
