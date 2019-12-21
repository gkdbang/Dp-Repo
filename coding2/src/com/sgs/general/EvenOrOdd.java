package com.sgs.general;

import java.util.Scanner;

public class EvenOrOdd {
	
	public static void main(String []args )    {
		 
	    int number;
	    Scanner in= new Scanner(System.in);
	    
	    while(true){
	    	
	    	System.out.println("Enter a number to check even or odd : ");
		    number=in.nextInt();
		    
		    if((number & 1)==0){
		    	System.out.println(+number +" :  is Even number");
		    }
		    else{
		    	System.out.println(+number+" : is Odd Number");
		    }
		    
		    System.out.println("If you want check some other number write YES if no then write NO : ");
		    
		    String option = in.next();
			
			if(option.equalsIgnoreCase("NO")){
				break;
			}
	    }
	    	in.close();
	}
}
