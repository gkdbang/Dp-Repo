package com.sgs.simple;

public class TestString {

	public static void main(String[] args) {
		
		String userId = "EFUSER1001";
		String temp = userId.substring(6);
		
		System.out.println(temp); 
		
		int id = Integer.parseInt(temp);
		
		         id+=1;
		     
		        
			System.out.println(id);
			System.out.println("EFUSER"+id);
		

	}

}
