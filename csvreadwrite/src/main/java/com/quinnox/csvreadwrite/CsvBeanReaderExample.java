package com.quinnox.csvreadwrite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class CsvBeanReaderExample {
	

	static void readCSVFile(String csvFileName) {
        
		ICsvBeanReader beanReader=null;
		
		//Super CSV provides some classes called cell processors that automate data type conversions and 
		//enforce constraints when mapping values in the CSV file with JavaBean’s properties.
		
		CellProcessor[] processors = new CellProcessor[] {
		        new NotNull(), // ISBN
		        new NotNull(), // title
		        new NotNull(), // author
		        new NotNull(), // publisher
		        new ParseDate("MM/dd/yyyy"), // published date
		        new ParseDouble() // price
		};
		
		try {
			beanReader = new CsvBeanReader(new FileReader(csvFileName),
			        CsvPreference.STANDARD_PREFERENCE);

			String[] header = beanReader.getHeader(true);
			Book bookBean = null;

			while ((bookBean = beanReader.read(Book.class, header, processors)) != null) {
				System.out.printf("%s %-30s %-30s %-20s %tD $%.2f",
	                    bookBean.getIsbn(), bookBean.getTitle(),
	                    bookBean.getAuthor(), bookBean.getPublisher(),
	                    bookBean.getPublished(), bookBean.getPrice());
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(beanReader!=null){
				try {
					beanReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
    }
 
    public static void main(String[] args) {
        String csvFileName = "E:/Csv/Book.csv";
        readCSVFile(csvFileName);
    }

}
