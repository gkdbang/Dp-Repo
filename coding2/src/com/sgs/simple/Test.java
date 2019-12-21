package com.sgs.simple;

public class Test {

	public static void main(String[] args) {
		
		Address address = new Address();
		address.setHouseNo("H101");
		address.setCity("BLR");
		address.setPincode(123456);
		
		Employee employee = new Employee();
		employee.setName("gaurav");
		employee.setId(1001);
		employee.setDept("devlopment");
		employee.setAddress(address);
		
		/*-------------------------------------------------------------------------------------*/
		
		System.out.println("Employee Name : " + employee.getName());
		System.out.println("Employee ID : " + employee.getId());
		System.out.println("Employee Dept : " + employee.getDept());
		System.out.println("Employee Address : " + employee.getAddress());	
		
		/*--------------------------------------------------------------------------------------*/
		
		/*System.out.println("Employee Address : ");
		System.out.println("House No." + address.getHouseNo());
		System.out.println("City" + address.getCity());
		System.out.println("PinCode" + address.getPincode());*/
		
	}

}
