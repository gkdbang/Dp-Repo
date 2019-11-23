package com.quinnox.apachepoi3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiWrite {

	public static void main(String[] args) throws IOException {
		
		// Blank workbook
		XSSFWorkbook xssfWorkbook=new XSSFWorkbook();
		
		// Creating a blank sheet
		XSSFSheet xssfSheet=xssfWorkbook.createSheet("Student Details");
		
		Map<String,Object[]> studentData=new TreeMap<String,Object[]>();
		studentData.put("1", new Object[]{"ID", "NAME","LASTNAME"});
		studentData.put("2", new Object[]{1,"Rahul","Kumar"});
		studentData.put("3", new Object[]{2,"Pawan","Yadav"});
		studentData.put("4", new Object[]{3,"Ramesh","Singh"});
		studentData.put("5", new Object[]{4,"Ram","Kapoor"});
		
		// now write this data to excel
		int rowNum=0;
		Set<String> keys=studentData.keySet();
		for (String key : keys) {
				Object[] studentArray=studentData.get(key);
				XSSFRow xxRow = xssfSheet.createRow(rowNum++);
				int cellNum=0;
					for (Object object : studentArray) {
							Cell xssfCell =xxRow.createCell(cellNum++);
							if(object instanceof String){
								xssfCell.setCellValue((String)object);
							}
							if(object instanceof Integer){
								xssfCell.setCellValue((Integer)object);
							}
						
						}
			}
		
		OutputStream outputStream = new FileOutputStream("C:\\Users\\gauravd\\Downloads\\POI-Studentgenerated.xlsx");
		xssfWorkbook.write(outputStream);
		outputStream.close();
		xssfWorkbook.close();
		System.out.println("Completed");
	}

}
