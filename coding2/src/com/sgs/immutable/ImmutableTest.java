package com.sgs.immutable;

public class ImmutableTest {

	public static void main(String[] args) {
		
		Employee emp1 = new Employee(101);
		Employee emp2 = emp1.modify(101);
		Employee emp3 = emp1.modify(102);
		
		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println(emp3);
		
		System.out.println(emp1==emp2);
		System.out.println(emp1==emp3);
		System.out.println(emp2==emp3);
		
	}

}
