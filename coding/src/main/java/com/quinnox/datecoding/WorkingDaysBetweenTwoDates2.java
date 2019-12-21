package com.quinnox.datecoding;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WorkingDaysBetweenTwoDates2 {
	
	// First Day will be excluded
	public static void main(String[] args) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    Date date1 = df.parse("10/11/2019");
	    Date date2 = df.parse("2/12/2019");
	    Calendar cal1 = Calendar.getInstance();
	    Calendar cal2 = Calendar.getInstance();
	    cal1.setTime(date1);
	    cal2.setTime(date2);
	    
	    if (cal1.equals(cal2)) {
	        System.out.println("Dates Are equals : "+0);
	    }
	    
	    if(cal1.after(cal2)){
	    	System.out.println("First date is greater");
	    	cal1.setTime(date2);
	    	cal2.setTime(date1);
	    }
	    
	    int numberOfDays = 0;
	    int weekEnds=0;
	    while (cal1.before(cal2)) {
	    	cal1.add(Calendar.DAY_OF_MONTH,1);
	        if ((Calendar.SATURDAY != cal1.get(Calendar.DAY_OF_WEEK))
	           &&(Calendar.SUNDAY != cal1.get(Calendar.DAY_OF_WEEK))) {
	            numberOfDays++;
	        }
	        else{
	        	weekEnds++;
	        }
	    }
	    System.out.println("No of working days : "+numberOfDays);
	    System.out.println("No of weekEnds : "+weekEnds);
	}
}
