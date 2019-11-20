package com.quinnox.excelreadandwrite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {
	
	private static final String FILE_NAME="E:\\DamAsset\\AssetsList.xlsx";
	
	public static void main(String[] args) throws IOException {
		
		Workbook workbook = new XSSFWorkbook(FILE_NAME);
		int noOfSheet=workbook.getNumberOfSheets();
		//System.out.println(noOfSheet);
		//int count=0;
		//int rowCount=0;
		//int subAssetsCount=0;
		int withoutSubAssetCount=0;
		List<String> assets = new ArrayList<String>();
		List<String> assetsWithoutSubAssets = new ArrayList<String>();
		List<String> assetWithNames=new ArrayList<String>();
		
		for(int i=0;i<noOfSheet;i++){
			Sheet sheet=workbook.getSheetAt(i);
			Iterator<Row> rowIterator=sheet.rowIterator();
			Cell cell=null;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				//count++;
				//rowCount=sheet.getLastRowNum();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					cell = cellIterator.next();
					String cellValue = cell.getStringCellValue();
					assets.add(cellValue);	
				}
								
			}
			for(int j=0; j<assets.size(); j++) {
				String asset=assets.get(j);
				int index=asset.indexOf("subassets");
				
				if(index==-1){
					//System.out.println(index);
					//int rowIndex=cell.getRowIndex();
					//System.out.println(rowIndex);
					//sheet.createRow(rowIndex+1).createCell(0).setCellValue("Gaurav");
					//sheet.removeRow(sheet.getRow(rowIndex));
					assetsWithoutSubAssets.add(asset);
				}
				else{
					//System.out.println(index);
					//withoutSubAssetCount++;
					//assetsWithoutSubAssets.add(asset);
				}
				
			}
			//System.out.println(assets.size()+"============================");
			//System.out.println(assetsWithoutSubAssets.size()+"===================================================================");
			assets.clear();
			
			for(String assetsWithoutSubAsset : assetsWithoutSubAssets){
				System.out.println("assetsWithoutSubAsset : "+assetsWithoutSubAsset);
				assetWithNames.add(assetsWithoutSubAsset.substring(assetsWithoutSubAsset.lastIndexOf("/")+1));
			}
			String sheetName=null;
			for(String path : assetsWithoutSubAssets){
					if(path.contains("denmark")){
						sheetName="Denmark";
						break;
					}	
					else if(path.contains("norway")){
						sheetName="Norway";
						break;
					}
						
					else if(path.contains("sweden")){
						sheetName="Sweden";
						break;
					}
						
					else if(path.contains("finland")){
						sheetName="Finland";
						break;
					}
					
			}

			Test2.writeToExcel(assetsWithoutSubAssets,assetWithNames,sheetName);
			//Test2.writeToExcel(assetsWithoutSubAssets,sheetName);
			//Test2.writeToExcel(assetsWithoutSubAssets);
			assetsWithoutSubAssets.clear();
			System.out.println("=====================================End of the Sheet==============================================================");
			
			//System.out.println(assetsWithoutSubAssets.size()+"=====================================================");
			/*for(String assetsWithoutSubAsset : assetsWithoutSubAssets){
				System.out.println("assetsWithoutSubAsset : "+assetsWithoutSubAsset);
				assetWithNames.add(assetsWithoutSubAsset.substring(assetsWithoutSubAsset.lastIndexOf("/")+1));
			}*/
			/*for(String assetWithName:assetWithNames){
				System.out.println("assetWithName : "+assetWithName);
			}*/
			assetWithNames.clear();
			//System.out.println(assetWithNames.size());
			//System.out.println("=================================================================================");
			//System.out.println("No Of Row : "+count);
			//System.out.println("No Of Row : "+rowCount);
			//System.out.println(withoutSubAssetCount);
		}
		workbook.close();
	}

}
