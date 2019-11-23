package com.quinnox.apachepoi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class AppendInExistingExcel {
	
	private static List<Employee> employees = new ArrayList<>();
	
	
	// Initializing employees data to insert into the excel file
	static{
		
		Calendar dateOfBirth = Calendar.getInstance();
		
		dateOfBirth.set(1999, 8, 105);
		employees.add(new Employee("Virat", "Virat@example.com", 
                dateOfBirth.getTime(), 12555.0));
		
	    dateOfBirth.set(2001, 12, 22);
	    employees.add(new Employee("Lokesh", "Lokesh@example.com", 
	             dateOfBirth.getTime(), 16444.0));

	    dateOfBirth.set(1972, 4, 5);
	    employees.add(new Employee("Ankur", "Ankur@example.com", 
	             dateOfBirth.getTime(), 40000.0));
	    
	}

	public static void main(String[] args) {
		
		try {
			 // Obtain a workbook from the excel file
			Workbook workbook=WorkbookFactory.create(new FileInputStream
					(new File("C:\\Users\\gauravd\\Downloads\\poi-generated-file.xlsx")));
			
			  /* CreationHelper helps us create instances of various things like DataFormat, 
	        Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
			CreationHelper createHelper = workbook.getCreationHelper();
			
			// Get Sheet at index 0
			Sheet sheet=workbook.getSheetAt(0);
			
			CellStyle dateCellStyle = workbook.createCellStyle();
			dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
			
			int rowNum=(sheet.getLastRowNum()+1);
			
					for(Employee employee:employees){	
						int cellNum = 0;
						Row row=sheet.createRow(rowNum++);
						row.createCell(cellNum++).setCellValue(employee.getName());
						row.createCell(cellNum++).setCellValue(employee.getEmail());
						
						Cell dateOfBirthCell=row.createCell(cellNum++);
						dateOfBirthCell.setCellValue(employee.getDateOfBirth());
						dateOfBirthCell.setCellStyle(dateCellStyle);
						
						row.createCell(cellNum).setCellValue(employee.getSalary());					

					}
			
			FileOutputStream fileOutputStream=new FileOutputStream(
								new File("C:\\Users\\gauravd\\Downloads\\poi-generated-file.xlsx"));
			workbook.write(fileOutputStream);
			fileOutputStream.close();
			workbook.close();
			System.out.println("Append Completed");
			
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
