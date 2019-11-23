package com.quinnox.apachepoi3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiReader {

	public static void main(String[] args) {
		
		try {
			FileInputStream fileInputStream=new FileInputStream(
								new File("C:\\Users\\gauravd\\Downloads\\POI-Studentgenerated.xlsx"));
			
			// Create Workbook instance holding reference to .xlsx file 
			XSSFWorkbook xssfWorkbook=new XSSFWorkbook(fileInputStream);
			
			XSSFSheet xxSheet=null;
			
			// Get the numberOfSheets
			int totalNoOfSheet=xssfWorkbook.getNumberOfSheets();
			// Now get sheet one by one 
			for(int i=0;i<totalNoOfSheet;i++){
				xxSheet=xssfWorkbook.getSheetAt(i);
				// once we got the sheet iterator it to get the row
				Iterator<Row> rowIterator=xxSheet.rowIterator();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					// Now for each row we will get all cell through cellIterator
					Iterator<Cell> cellIterator=row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						// Check the cell type and format accordingly 
						switch(cell.getCellTypeEnum()){
							case NUMERIC:
								System.out.println(cell.getNumericCellValue());
								break;
							case STRING:
								System.out.println(cell.getStringCellValue());
								break;
						}
					}
					System.out.println();
				}
			}
			
			fileInputStream.close();
			xssfWorkbook.close();
			System.out.println("Completed");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}
