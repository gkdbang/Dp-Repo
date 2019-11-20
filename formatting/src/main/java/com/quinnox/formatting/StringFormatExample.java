package com.quinnox.formatting;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class StringFormatExample {

	public static void main(String[] args) {
		
		String formattedString = String.format("Order with OrdId : %d and Amount: %d is missing", 40021, 3000);
		System.out.println(formattedString);
		
		System.out.printf("Order with OrdId : %d and Amount: %d is missing \n", 40021, 3000);
		
		String str=String.format("Hello %s", "Raj");
		System.out.println(str);
		
		System.out.printf("Hello %s \n", "Raj");
		
		System.out.printf("Number %.2f \n", 3.0);
		
		str=String.format("Today is %tD", new Date());
		System.out.println(str);
		
		Date today=new Date();
		System.out.printf("Date in dd/mm/yy format : %td/%tm/%ty \n", today,today,today);
		
		System.out.println(String.format("Date in dd/mm/yyyy format : %td/%tm/%tY", today,today,today));
		
		System.out.printf("Today is %tB %te, %tY %n", today,today,today);
		
		// add leading zero. should be 8 digit with zero leading
		System.out.printf("Amount : %08d %n" , 221);
		
		System.out.printf("positive number : +%d %n", 1534632142);
        System.out.printf("negative number : -%d %n", 989899);
        
        System.out.format("%f %n", Math.E);
        
        System.out.format("%.3f %n", Math.E);
        
      //Total 8 character in width and 3 digit after decimal point
        System.out.printf("%8.3f %n", Math.E);
        
        //adding comma into long numbers
        System.out.printf("Total %,d messages processed today %n", 10000000);
        
        System.out.println("===================================================");
        
        String title = "Effective Java";
        float price = 33.953f;
        System.out.format("%s is a great book. It is sold at %.2f USD today.%n", title, price);
        
        
        //the flag ‘-‘ to left-justify the Strings with the width of 30 characters (%-30s):
        List<String> listBook = Arrays.asList(
                "Head First Java",
                "Effective Java",
                "The Passionate Programmer",
                "Head First Design Patterns"
            );
         
        for (String book : listBook) {
            System.out.format("%-30s - In Stock%n", book);
        }
        System.out.println();
        
        System.out.println(String.format("Now is %tT %n", new Date()));
        System.out.println(String.format("Now is %tF %n", new Date()));
        System.out.println(String.format("Now is %tD %n", new Date()));
        
        // If we specify the width without the flag, the output is right-justified within the specified width
        System.out.format("%20s %s %n", "Full Name: ", "John");
        System.out.format("%20s %s %n", "E-mail Address: ", "john@gmail.com");
        System.out.format("%20s %s %n", "City: ", "New York");
        System.out.format("%20s %s %n", "Country: ", "United States");
        
        
	}

}
