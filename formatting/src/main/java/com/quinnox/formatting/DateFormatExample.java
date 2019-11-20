package com.quinnox.formatting;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatExample {

	public static void main(String[] args) {
		
		//convert date to dd-MMMM-yy format e.g. "14-September-11"
		Date dateNow=new Date();
		SimpleDateFormat ddMMMMyyFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date_to_string = ddMMMMyyFormat.format(dateNow);
		System.out.println("date into yyyy-MM-dd format: " + date_to_string);
		
		// This code parse a String to a Date object with the date pattern â€œdd/MM/yyyyâ€�
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = "25/03/1991";
		try {
			Date parsedDate=df.parse(strDate);
			System.out.println("The parsed date is: " + parsedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// This code format a Date object into a String in the pattern â€œdd/MM/yyyyâ€�
		String pattren="dd/MM/yyyy";
		DateFormat dateFormat=new SimpleDateFormat(pattren);
		Date newDate=new Date();
		System.out.println(newDate);
		System.out.println(dateFormat.format(newDate));
		
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		System.out.println(dateFormat2.format(newDate));
	}

}
