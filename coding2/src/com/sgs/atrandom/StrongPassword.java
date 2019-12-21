package com.sgs.atrandom;

import java.util.Scanner;

public class StrongPassword {
		
    	public static void main(String[] args) {
    		
        String password;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Password : ");
        password = sc.next();

        int digit = 0;
        int upperCase = 0;
        int lowerCase = 0;
        int specialCharacter = 0;

        if (password.length() >= 8) {
            for (int i = 0; i<password.length(); i++) {
                	char x = password.charAt(i);
	                if (Character.isLowerCase(x)) {
	                	lowerCase=lowerCase+1;
	                }
	                if (Character.isUpperCase(x)) {
						upperCase+=1;
					}
	                if (Character.isDigit(x)) {
	                	digit+=1;
	                }
	                if (password.matches("(?=.*[~!@#$%^&*()_-]).*")) {
						specialCharacter=specialCharacter+1;
					}
            }
	            if (upperCase>=1 && lowerCase>=1 && digit>=1 && specialCharacter>=1) {
	                	System.out.println("Strong password");
	            } 
	            else {
	                	System.out.println("Weak password please enter at least 1 upperCase Character"
	                			+ " 1 lowerCase Character and 1 digit and 1 special Character ");
	            }
        } 
        else {
            	System.out.println("Your password must contain at least 8 character");
        }
        sc.close();        
        
    }
}
