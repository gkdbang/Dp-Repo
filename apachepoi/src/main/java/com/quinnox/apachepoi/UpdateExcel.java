package com.quinnox.apachepoi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UpdateExcel {
	
	public static void main(String[] args) {
		
		try {
			 // Obtain a workbook from the excel file
			Workbook workbook=WorkbookFactory.create(new FileInputStream
					(new File("C:\\Users\\gauravd\\Downloads\\poi-generated-file.xlsx")));
			
			// Get Sheet at index 0
			Sheet sheet=workbook.getSheetAt(0);
			int rowNum=1;
			int cellNum=3;
			Cell cell=null;
			int totalRows=sheet.getLastRowNum();
			// Want to update all employee salary
			for(int i=rowNum; i<=totalRows;i++){
				cell=sheet.getRow(i).getCell(cellNum);
				cell.setCellValue(20000.0);
			}
			
			FileOutputStream fileOutputStream=new FileOutputStream(
								new File("C:\\Users\\gauravd\\Downloads\\poi-generated-file.xlsx"));
			workbook.write(fileOutputStream);
			fileOutputStream.close();
			workbook.close();
			System.out.println("Update Completed");
			
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
