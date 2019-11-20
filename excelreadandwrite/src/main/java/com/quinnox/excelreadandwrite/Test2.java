package com.quinnox.excelreadandwrite;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test2 {
	
	private static String[] columns = {"Assets-Names", "Corresponding Assets-Path"};
	
	/*static XSSFWorkbook workbook=null;
	static XSSFSheet denmarkSheet =null;
	static XSSFSheet norwaySheet =null;
	static XSSFSheet swedenSheet =null;
	static XSSFSheet finlandSheet =null;
	
	static{
		workbook = new XSSFWorkbook();
		denmarkSheet =workbook.createSheet("Denmark");
		norwaySheet =workbook.createSheet("Norway");
		swedenSheet =workbook.createSheet("Sweden");
		finlandSheet =workbook.createSheet("Finland");

	}
*/
	
	
/*	static XSSFWorkbook workbook = new XSSFWorkbook();
	public static void writeToExcel(List<String> assetsPaths, String sheetName) throws IOException {
		
		int rowNum=1;
		//Row row=null;
		//Cell cell=null;
		for(String assetsPath : assetsPaths){
			int cellNum=0;
			
				XSSFSheet sheet =workbook.getSheet(sheetName);
				if(sheet==null)
					sheet =workbook.createSheet(sheetName);
				String assetName=(assetsPath.substring(assetsPath.lastIndexOf("/")+1));
				
				Row row=sheet.getRow(0);
				if(row==null){
					row=sheet.createRow(0);
					for(int i = 0; i < columns.length; i++) {
			            Cell cell = row.createCell(i);
			            cell.setCellValue(columns[i]);
			        }
				}

				
				row = sheet.createRow(rowNum++);
				Cell cell = row.createCell(cellNum);
					 	cell.setCellValue(assetName);
					 	row.createCell(++cellNum).setCellValue(assetsPath);

		}		
		
		//Sheet[] sheets = {denmarkSheet, norwaySheet, swedenSheet, finlandSheet};
		//List<Sheet> listOfSheets = Arrays.asList(sheets);
		
		OutputStream fileOut = new FileOutputStream("E:\\DamAsset\\RequiredAssetList2.xlsx");
		workbook.write(fileOut);
		fileOut.close();
		
	}*/
	
	
	
	static XSSFWorkbook workbook = new XSSFWorkbook();
	static XSSFSheet sheet=null;
	public static void writeToExcel(List<String> assetsPaths, List<String> assetWithNames, String sheetName) throws IOException {
		//Row row=null;
		//Cell cell=null;
		
		Map<Integer,Object[]> data = new LinkedHashMap<Integer,Object[]>();
	    int count=1;
	    for (int i=0; i<assetWithNames.size(); i++) {
	      data.put(count++,new Object[]{assetWithNames.get(i), assetsPaths.get(i)});
	    }
			
				sheet =workbook.getSheet(sheetName);
				if(sheet==null)
					sheet =workbook.createSheet(sheetName);
				
				int rowNum=1;
				Row row=sheet.getRow(0);
				if(row==null){
					row=sheet.createRow(0);
					for(int i = 0; i < columns.length; i++) {
			            Cell cell = row.createCell(i);
			            cell.setCellValue(columns[i]);
			        }
				}
				
				Set<Integer> keys=data.keySet();
				for(Integer key:keys){
					row=sheet.createRow(rowNum++);
					
					Object[] objectArray=data.get(key);
					int cellNum=0;
		            for (Object obj : objectArray)
		            {
		               Cell cell = row.createCell(cellNum++);
		               if(obj instanceof String)
		                    cell.setCellValue((String)obj);
		            }				
				}
				
		//writeToMap(assetsPaths.iterator().next(), assetWithNames.iterator().next());
		OutputStream fileOut = new FileOutputStream("E:\\DamAsset\\RequiredAssetList3.xlsx");
		workbook.write(fileOut);
		fileOut.close();

		//Sheet[] sheets = {denmarkSheet, norwaySheet, swedenSheet, finlandSheet};
		//List<Sheet> listOfSheets = Arrays.asList(sheets);	
	}
	
	
/*	static XSSFWorkbook workbook = new XSSFWorkbook();
	public static void writeToExcel(List<String> assetsPaths) throws IOException {
						

			
			XSSFSheet denmarkSheet =workbook.createSheet("Denmark");
			XSSFSheet norwaySheet =workbook.createSheet("Norway");
			XSSFSheet swedenSheet =workbook.createSheet("Sweden");
			XSSFSheet finlandSheet =workbook.createSheet("Finland");
		
		XSSFSheet denmarkSheet =workbook.getSheet("Denmark");
		if(denmarkSheet==null)
			denmarkSheet =workbook.createSheet("Denmark");
		
		XSSFSheet norwaySheet =workbook.getSheet("Norway");
			if(norwaySheet==null)
				norwaySheet =workbook.createSheet("Norway");
			
		XSSFSheet swedenSheet =workbook.getSheet("Sweden");
			if(swedenSheet==null)
				swedenSheet =workbook.createSheet("Sweden");

		XSSFSheet finlandSheet =workbook.getSheet("Finland");
			if(finlandSheet==null)
				finlandSheet =workbook.createSheet("Finland");	
			
			int rowNum=1;
			//Row row=null;
			//Cell cell=null;
			for(String assetsPath : assetsPaths){
				int cellNum=0;
				if(assetsPath.contains("denmark")){
					//denmarkSheet =workbook.getSheet("Denmark");
					//if(denmarkSheet==null)
						//denmarkSheet =workbook.createSheet("Denmark");
					String assetName=(assetsPath.substring(assetsPath.lastIndexOf("/")+1));
					
					Row row=denmarkSheet.getRow(0);
					if(row==null){
						row=denmarkSheet.createRow(0);
						for(int i = 0; i < columns.length; i++) {
				            Cell cell = row.createCell(i);
				            cell.setCellValue(columns[i]);
				        }
					}
					
					row = denmarkSheet.createRow(rowNum++);
					Cell cell = row.createCell(cellNum);
						 	cell.setCellValue(assetName);
						 	row.createCell(++cellNum).setCellValue(assetsPath);
					
				}
				else if(assetsPath.contains("norway")){
					//norwaySheet =workbook.getSheet("Norway");
					//(norwaySheet==null)
					//norwaySheet =workbook.createSheet("Norway");
					String assetName=(assetsPath.substring(assetsPath.lastIndexOf("/")+1));
					
					Row row=norwaySheet.getRow(0);
					if(row==null){
						row=norwaySheet.createRow(0);
						for(int i = 0; i < columns.length; i++) {
				            Cell cell = row.createCell(i);
				            cell.setCellValue(columns[i]);
				        }
					}
					
					row = norwaySheet.createRow(rowNum++);
					Cell cell = row.createCell(cellNum);
						 	cell.setCellValue(assetName);
						 	row.createCell(++cellNum).setCellValue(assetsPath);
					
				}
				else if(assetsPath.contains("sweden")){
					String assetName=(assetsPath.substring(assetsPath.lastIndexOf("/")+1));
					
					Row row=swedenSheet.getRow(0);
					if(row==null){
						row=swedenSheet.createRow(0);
						for(int i = 0; i < columns.length; i++) {
				            Cell cell = row.createCell(i);
				            cell.setCellValue(columns[i]);
				        }
					}
					
					row = swedenSheet.createRow(rowNum++);
					Cell cell = row.createCell(cellNum);
						 	cell.setCellValue(assetName);
						 	row.createCell(++cellNum).setCellValue(assetsPath);
				}
				else if(assetsPath.contains("finland")){
					String assetName=(assetsPath.substring(assetsPath.lastIndexOf("/")+1));
					
					Row row=finlandSheet.getRow(0);
					if(row==null){
						row=finlandSheet.createRow(0);
						for(int i = 0; i < columns.length; i++) {
				            Cell cell = row.createCell(i);
				            cell.setCellValue(columns[i]);
				        }
					}
					
					row = finlandSheet.createRow(rowNum++);
					Cell cell = row.createCell(cellNum);
						 	cell.setCellValue(assetName);
						 	row.createCell(++cellNum).setCellValue(assetsPath);
				}

			}		
			
			//Sheet[] sheets = {denmarkSheet, norwaySheet, swedenSheet, finlandSheet};
			//List<Sheet> listOfSheets = Arrays.asList(sheets);
			
			OutputStream fileOut = new FileOutputStream("E:\\DamAsset\\RequiredAssetList.xlsx");
			workbook.write(fileOut);
			fileOut.close();
		
	}		
*/
}
