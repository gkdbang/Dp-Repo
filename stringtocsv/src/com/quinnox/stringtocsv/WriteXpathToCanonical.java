package com.quinnox.stringtocsv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteXpathToCanonical {
		

	public static void writeXpathToCanonical(List<String> csvAsList) {
		
		String fileName="C:\\Gaurav2\\Order Canonical Template_SourceToCanonical.xlsx";
		
		try {
			InputStream inputStream = new FileInputStream(fileName); 
			Workbook workbook = WorkbookFactory.create(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
		    
		    int rownum=5;
		    Cell cell=null;
	
		    for(String value:csvAsList){
		    	String temp=value;
		    	cell = sheet.getRow(rownum++).getCell(1);
		    	cell.setCellValue(temp);
		    }
		    
		       FileOutputStream fileOut = new FileOutputStream(fileName); 
		       workbook.write(fileOut);
		       fileOut.close();
		    
			System.out.println("Completed");
			
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
}
