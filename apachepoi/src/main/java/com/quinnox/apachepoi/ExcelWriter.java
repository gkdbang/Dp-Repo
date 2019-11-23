package com.quinnox.apachepoi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	
	// Columns names
	private static String[] columns = {"Name", "Email", "Date Of Birth", "Salary"};
	
	private static List<Employee> employees = new ArrayList<>();
	
	
	// Initializing employees data to insert into the excel file
	static{
		
		Calendar dateOfBirth = Calendar.getInstance();
		
		dateOfBirth.set(1992, 8, 10);
		employees.add(new Employee("Rajeev Singh", "rajeev@example.com", 
                dateOfBirth.getTime(), 1200000.0));
		
	    dateOfBirth.set(1965, 10, 15);
	    employees.add(new Employee("Thomas cook", "thomas@example.com", 
	             dateOfBirth.getTime(), 1500000.0));

	    dateOfBirth.set(1987, 4, 18);
	    employees.add(new Employee("Steve Maiden", "steve@example.com", 
	             dateOfBirth.getTime(), 1800000.0));
	    
	}
	
	
	public static void main(String[] args) throws IOException {
		
		// Create blank Workbook object
		// new HSSFWorkbook() for generating `.xls` file and new XSSFWorkbook() for .xlsx
		Workbook workbook = new XSSFWorkbook();  
		
        /* CreationHelper helps us create instances of various things like DataFormat, 
        Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
		CreationHelper createHelper = workbook.getCreationHelper();
     
		// Create a sheet
		Sheet sheet = workbook.createSheet("Employee");
		
		// create a font for styling header cells
		Font headerFont =workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short)14);
		headerFont.setColor(IndexedColors.RED.getIndex());
		
		// Create a cellStyle with font 
		CellStyle headerCellStyle=workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		
		// Create a row 
		Row headerRow = sheet.createRow(0);
		
		// create cell
		for(int i=0; i<columns.length; i++){
				Cell cell=headerRow.createCell(i);
				cell.setCellValue(columns[i]);
				cell.setCellStyle(headerCellStyle);
		}
		
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
		
		//  Create Other rows and cells with employees data
		int rowNum=(sheet.getLastRowNum()+1);
		for(Employee employee : employees){
			int cellNum = 0;
			Row row=sheet.createRow(rowNum++);
			row.createCell(cellNum++).setCellValue(employee.getName());
			row.createCell(cellNum++).setCellValue(employee.getEmail());
			
			Cell dateOfBirthCell=row.createCell(cellNum++);
			dateOfBirthCell.setCellValue(employee.getDateOfBirth());
			dateOfBirthCell.setCellStyle(dateCellStyle);
			
			row.createCell(cellNum).setCellValue(employee.getSalary());
			
			// Resize all columns to fit the content size
	        for(int i = 0; i < columns.length; i++) {
	            sheet.autoSizeColumn(i);
	        }
				
		}
		
        // Write the output to the file
		
        OutputStream outputStream=new 
					FileOutputStream("C:\\Users\\gauravd\\Downloads\\poi-generated-file.xlsx");
			workbook.write(outputStream);
			
			outputStream.close();
			workbook.close();
			System.out.println("Writer Completed");
			
	}

}
