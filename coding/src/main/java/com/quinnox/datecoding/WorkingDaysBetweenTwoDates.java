package com.quinnox.datecoding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WorkingDaysBetweenTwoDates {

	public static void main(String[] args) {
		String date1="10/11/2019";
		String date2="2/12/2019";
		
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
		try {
			int noOfWorkingDays=calculateWeekDaysBetweenTwoDays(simpleDateFormat.parse(date1), 
					simpleDateFormat.parse(date2));
			System.out.println("No of Working Days : "+noOfWorkingDays);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	// First Day has been included in this program 
	public static int calculateWeekDaysBetweenTwoDays(Date startDate, Date endDate) {
		
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("EEEE");
		Calendar cal=Calendar.getInstance();cal.setTime(startDate);
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		String nameOfTheDay=simpleDateFormat.format(startDate);
		System.out.println(nameOfTheDay);
		
	    Calendar startCal = Calendar.getInstance();
	    startCal.setTime(startDate);        

	    Calendar endCal = Calendar.getInstance();
	    endCal.setTime(endDate);

	    int workDays = 0;
	    int sutSun=0;
	    //Return 0 if start and end are the same
	    if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
	    	System.out.println("Dates Are equals : "+0);
	        return 0;
	    }

	    if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
	    	System.out.println("First date is greater");
	        startCal.setTime(endDate);
	        endCal.setTime(startDate);
	    }

	    do {
	       //excluding start date
	        startCal.add(Calendar.DAY_OF_MONTH, 1);
	        if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && 
	        		startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
	            ++workDays;
	        }
	        else{
	        	sutSun++;
	        }
	    } while (startCal.getTimeInMillis() < endCal.getTimeInMillis());
	    
	    if(cal.get(Calendar.DAY_OF_WEEK)==1 || cal.get(Calendar.DAY_OF_WEEK)==7){
	    	sutSun++;
	    }
	    else{
	    	workDays++;
	    }
	    
	    System.out.println("Saturday & Sunday : "+(sutSun));
	    return workDays;
	}
	
}
