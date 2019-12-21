package com.quinnox.datecoding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DaysBetweenTwoDates {
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		
		while(true){
			Scanner scanner=null;
			System.out.println("Enter the first Date : ");
			scanner=new Scanner(System.in);
			String dateInString1=scanner.nextLine();
			
			System.out.println("Enter the Second Date : ");
			scanner=new Scanner(System.in);
			String dateInString2=scanner.nextLine();
			
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("EEEE, dd/MM/yyyy");
			Date date1 = null,date2=null;
			
			try {
				date1=simpleDateFormat.parse(dateInString1);
				date2=simpleDateFormat.parse(dateInString2);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			int numberOfDays=(int)((date1.getTime()-date2.getTime())/(1000*60*60*24));
			System.out.println("The diff. b/w date "+simpleDateFormat2.format(date1)+" and date "
			+simpleDateFormat2.format(date2)+" is "+Math.abs(numberOfDays)+" days");
			
			System.out.println("If you want to test some other dates press Y otherwise press N");
			String value=scanner.nextLine();
			if(value.equalsIgnoreCase("n")){
				break;
			}
		}
		

/*		 SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		 String dateBeforeString = "31 10 2019";
		 String dateAfterString = "31 10 2017";

		 try {
		       Date dateBefore = myFormat.parse(dateBeforeString);
		       Date dateAfter = myFormat.parse(dateAfterString);
		       long difference = dateAfter.getTime() - dateBefore.getTime();
		       float daysBetween = (difference / (1000*60*60*24));
	                You can also convert the milliseconds to days using this method
	                * float daysBetween = 
	                *         TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS)
	                
		       System.out.println("Number of Days between dates: "+Math.abs((int)daysBetween));
		 } catch (Exception e) {
		       e.printStackTrace();
		 }*/
		
	}
}
