package com.quinnox.excelreadandwrite;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel2 {
	
	private static final String FILE_NAME="E:\\Migration\\MigrationExcel.xlsx";
	
	public static void main(String[] args) throws IOException {
		
		Workbook workbook = new XSSFWorkbook(FILE_NAME);
		Sheet sheet=workbook.getSheetAt(0);
		int num = sheet.getPhysicalNumberOfRows();
		System.out.println("physical Number of row :"+num);
		for (int i = 1; i <= num; i++) {
			Row column = sheet.getRow(i);
			if (column==null || column.getCell(0) == null) {
				continue;
			}

			if(column.getCell(0)!=null){
				String path = column.getCell(0).getStringCellValue()
						.replaceAll(" ", "-").replaceAll("[^A-Za-z0-9._/è-]+", "").replaceAll("è", "e")
						.toLowerCase();
				System.out.println(path);
			}
			else{
				System.out.println("No Path : ");
			}
						
			
           if(column.getCell(1)!=null){
        	   String sourceId = column.getCell(1).getStringCellValue();
        	   System.out.println(sourceId);
           }else{
        	  System.out.println("No Source Id");
           }
  
           if(column.getCell(2)!=null){
	        	 String url = column.getCell(2).getStringCellValue();
	        	 System.out.println(url);
	         }else{
	        	 System.out.println("No Url : ");
	         }
          
           if(column.getCell(3)!=null){
	        	 String title = column.getCell(3).getStringCellValue();
	        	 System.out.println(title);
	         }else{
	        	 System.out.println("No Title : ");
	         }
           
           if(column.getCell(4)!=null){
	        	 String description = column.getCell(4).getStringCellValue();
	        	 System.out.println(description);
	         }else{
	        	 System.out.println("No description : ");
	         }
           if(column.getCell(5)!=null){
        	   String webAssetType=column.getCell(5).getStringCellValue();
        	   System.out.println(webAssetType);
	         }else{
	        	 System.out.println("No WebAssetType ");
	         }
           
           if(column.getCell(6)!=null){
        	   		/*if(column.getCell(6).getCellType()==Cell.CELL_TYPE_NUMERIC){
        	   			String orderNumber=Double.toString(column.getCell(6).getNumericCellValue()).substring(0, 6);
        	   			System.out.println("If Part ============: "+orderNumber);
        	   		}
        	   		else{
        	   			String orderNumber=column.getCell(6).getStringCellValue();
            	   		System.out.println("Else Part =======: "+orderNumber);       
        	   		}*/
        	   		/*RichTextString orderNumber=column.getCell(6).getRichStringCellValue();
   	   				System.out.println(orderNumber);*/
        	   
        	   		DataFormatter formatter = new DataFormatter();
        	   		String orderNumber=formatter.formatCellValue(column.getCell(6));
        	   		System.out.println(orderNumber);
        	   								
                 }else{
               	  System.out.println("No Order Number : ");
            }
					
           if(column.getCell(7)!=null){
        		String languageVersion=column.getCell(7).getStringCellValue();
        		System.out.println(languageVersion);
	         }else{
	        	 System.out.println("No Language : ");
	         }

           if(column.getCell(8)!=null){
        	   String keywords=column.getCell(8).getStringCellValue();
        	   System.out.println(keywords);
	         }else{
	        	 System.out.println("No Keywords : ");
	         }	
           
           if(column.getCell(9)!=null){
        	   String country=column.getCell(9).getStringCellValue();
        	   System.out.println(country);
	         }else{
	        	 System.out.println("No Country Name : ");
	         }
           
           if(column.getCell(10)!=null){
        	   String brands=column.getCell(10).getStringCellValue();
        	   System.out.println(brands);
	         }else{
	        	 System.out.println("No Brand : ");
	         }		
           if(column.getCell(11)!=null){
        	   if(DateUtil.isCellDateFormatted(column.getCell(11))){
        		   //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        		   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        		   String creationDate=dateFormat.format(column.getCell(11).getDateCellValue());
            	   System.out.println(creationDate);
        	   }
        	   
	         }else{
	        	 System.out.println("No Creation Date : ");
	         }
           if(column.getCell(12)!=null){
        	   String assetType=column.getCell(12).getStringCellValue();
        	   System.out.println(assetType);
	         }else{
	        	 System.out.println("No Asset Type : ");
	         }

           if(column.getCell(13)!=null){
        	   if(DateUtil.isCellDateFormatted(column.getCell(13))){
        		   //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        		   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        		   String futureReviewDate=dateFormat.format(column.getCell(13).getDateCellValue());
        		   System.out.println(futureReviewDate);
        	   }
	         }else{
	        	 System.out.println("No Date : ");
	         }
           
           if(column.getCell(14)!=null){
        	   String intendedAudience=column.getCell(14).getStringCellValue();
        	   System.out.println(intendedAudience);
           }
           else{
        	   System.out.println("No Intended Audience : ");
           }
           
           if(column.getCell(15)!=null){
        	   //String downloadable=column.getCell(15).getStringCellValue();
        	   DataFormatter dataFormatter = new DataFormatter();
               String downloadable = dataFormatter.formatCellValue(column.getCell(15));
        	   System.out.println(downloadable);
           }
           else{
        	   System.out.println("No Downloadable : ");
           }
		   System.out.println("Row Number: "+i);
		   System.out.println("=========================================================================================");
		}
		
		workbook.close();
		
	}
			

}
