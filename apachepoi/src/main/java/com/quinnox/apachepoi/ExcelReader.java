package com.quinnox.apachepoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	
	static final String fileName ="C:\\Users\\gauravd\\Downloads\\poi-generated-file.xlsx";
	
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException {
		
		// Creating a Workbook from an Excel file (.xls or .xlsx)
		Workbook workbook=WorkbookFactory.create(new FileInputStream(fileName));
		
		 // Retrieving the number of sheets in the Workbook
		int noOfSheets=workbook.getNumberOfSheets();
        System.out.println("Workbook has " + noOfSheets + " Sheets\n");
        
        // Iterating all the sheet which are present in workbook
        
        Iterator<Sheet> sheetIterator=workbook.sheetIterator();
        System.out.println("Retrieving Sheets using Iterator : ");
        // Retriev sheet using iterator
        while (sheetIterator.hasNext()) {
			Sheet sheet =  sheetIterator.next();
			System.out.println(sheet.getSheetName());
		}
        
        // 2.Or else we can use for each loop
        for (Sheet sheet : workbook) {
			System.out.println(sheet.getSheetName());
		}
        
        // By iterating total no of sheets
        for(int i=0;i<noOfSheets;i++){
        	Sheet sheet=workbook.getSheetAt(i);
        	System.out.println(sheet.getSheetName());
        }
        
        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);
        
     // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();
        
     // Now we have sheet so we can get row by iterating through rowIterator()
        System.out.println("\nIterating Rows and Columns using Iterator\n");
        
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
			Row row =  rowIterator.next();
			// Now we have row so we can get column by iterating through columnIterator()
			Iterator<Cell> cellIterator=row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell =  cellIterator.next();
					String cellValueAsString = dataFormatter.formatCellValue(cell);
					System.out.println(cellValueAsString);
				}
				System.out.println();
		}
        
        System.out.println("\n\nIterating Rows and Columns using for-each \n");
        for (Row row : sheet) {
			for (Cell cell : row) {
				String cellValueAsString = dataFormatter.formatCellValue(cell);
				System.out.println(cellValueAsString);
			}
			System.out.println();
		}
        
        System.out.println("Reading Completed");
        
	}

}
