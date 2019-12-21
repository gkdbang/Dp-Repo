package com.sgs.atrandom;

import java.util.Scanner;

public class StrongPassword2 {
		
		public static void main(String[] args) {
			
			String password;
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter Password : ");
			password = sc.next();
			
			if (isStrong(password)) {
				System.out.println("Strong password");
			} 
			else {
				System.out.println("Weak password please enter at least 1 upperCase Character"
            			+ " 1 lowerCase Character and 1 digit and 1 special Character ");	
			}
			sc.close();
		}
		private static boolean isStrong(String password){
		    return password.matches("(?=.*[A-Z].*)(?=.*[~!@#$%^&*()_-])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8,}$");

		  }
}
