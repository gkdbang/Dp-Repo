package com.quinnox.apachepoi2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CountSheetAndName {
		
		static final String fileName ="C:\\Users\\gauravd\\Downloads\\Shift Plan Jan'19.xlsx";
		
		public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException {
			
			// Creating a Workbook from an Excel file (.xls or .xlsx)
			Workbook workbook=WorkbookFactory.create(new FileInputStream(fileName));
			
			 // Retrieving the number of sheets in the Workbook
			int noOfSheets=workbook.getNumberOfSheets();
	        System.out.println("Workbook has " + noOfSheets + " Sheets\n");
	        
	        // Iterating all the sheet which are present in workbook
	        
	        Iterator<Sheet> sheetIterator=workbook.sheetIterator();
	        System.out.println("Retrieving Sheets using Iterator : "+"\n");
	        // Retriev sheet using iterator
	        while (sheetIterator.hasNext()) {
				Sheet sheet =  sheetIterator.next();
				System.out.println(sheet.getSheetName() +"\n");
			}
	        
	        // 2.Or else we can use for each loop
	        for (Sheet sheet : workbook) {
				System.out.println(sheet.getSheetName()+"\n");
			}
	        
	        // By iterating total no of sheets
	        for(int i=0;i<noOfSheets;i++){
	        	Sheet sheet=workbook.getSheetAt(i);
	        	System.out.println(sheet.getSheetName()+"\n");
	        }

	}

}
