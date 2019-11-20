package com.quinnox.csvreadwrite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.supercsv.cellprocessor.FmtDate;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

public class CsvBeanWriterExample {
	
	
	 static void writeCsvFile(String csvFileName, List<Book> bookList) {
		 
		 ICsvBeanWriter beanWriter=null;
		 
		 //Super CSV provides some built-in classes called cell processors that convert Java data types to
		 //Strings (when writing to CSV file) and vice-versa (when reading from CSV file)
		 CellProcessor[] processors = new CellProcessor[] {
			        new NotNull(), // ISBN
			        new NotNull(), // title
			        new NotNull(), // author
			        new NotNull(), // publisher
			        new FmtDate("MM/dd/yyyy"), // published date
			        new ParseDouble() // price
			};
		 
		  try {
			beanWriter=new CsvBeanWriter(new FileWriter(new File(csvFileName)), CsvPreference.STANDARD_PREFERENCE);
			  String[] header = {"isbn", "title", "author", "publisher", "published", "price"};
			  beanWriter.writeHeader(header);
			  for(Book book:bookList){
				  beanWriter.write(book, header, processors);
			  }
			  System.out.println("Compleated");
		} catch (IOException e) {
			System.err.println("Error writing the CSV file: " + e);
			e.printStackTrace();
		} finally{
			if(beanWriter!=null){
				try {
					beanWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		 
	 }
	
	public static void main(String[] args) {
		
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM/dd/yyyy");
		
		Book book1 = null;
		Book book2 = null;
		Book book3 = null;
		Book book4 = null;
		try {
			book1 = new Book("0321356683", "Effective Java", "Joshua Bloch",
			        "Addision-Wesley",simpleDateFormat.parse("05/08/2008"),38.00);
			book2 = new Book("0321356683", "Head First Java", "Kathy Sierra & Bert Bates",
			        "O'Reilly Media", simpleDateFormat.parse("02/09/2005"), 30.00);
			book3 = new Book("0131872486", "Thinking in Java", "Bruce Eckel",
			        "Prentice Hall", simpleDateFormat.parse("02/26/06"), 45.00);
			book4 = new Book("0596527756", "Java Generics and Collections", "Naftalin & Philip Wadler",
			        "O'Reilly Media", simpleDateFormat.parse("10/24/2006"), 27.00);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        List<Book> bookList=Arrays.asList(book1,book2,book3,book4);
		
		String csvFileName = "E:/Csv/Book.csv";
		writeCsvFile(csvFileName,bookList);

	}

}
