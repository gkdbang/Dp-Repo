package com.sgs.customExcep;

import java.util.Scanner;


class ElegibleException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	ElegibleException(String str){
		
		super(str);
	}
}

class NotElegibleException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	NotElegibleException(String str){
		
		super(str);
	}
}

public class CustomUnCheckedException{
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Age : ");
		int age = sc.nextInt();
		sc.close();
		
		if(age>=18 && 200>=age){
			throw new ElegibleException("You are Elegible to cast your Vote");
		}
		else{
			throw new NotElegibleException("You are not Elegible to cast your Vote");
		}
		
	}
		
}
