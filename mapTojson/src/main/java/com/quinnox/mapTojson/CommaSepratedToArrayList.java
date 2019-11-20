package com.quinnox.mapTojson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CommaSepratedToArrayList {

	public static void main(String[] args) {
		
		try {
			String fromLineSecond=null;
			BufferedReader bufferedReader=new BufferedReader(new FileReader(new File("E:\\Csv\\book.txt")));
			String firstLine=bufferedReader.readLine();
			System.out.println(firstLine+"\n");
			while((fromLineSecond=bufferedReader.readLine())!=null){
				System.out.println("Raw CSV Data: "+fromLineSecond);
				System.out.println("Converted ArrayList CSV Data : " + csvToArrayList(fromLineSecond) + "\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressWarnings("null")
	private static ArrayList<String> csvToArrayList(String fromLineSecond) {
		
		ArrayList<String> list=new ArrayList<>();
		if(fromLineSecond!=null){
			String[] splitedData=fromLineSecond.split(",");
			for(String str:splitedData){
				if( !(str==null) || !(str.length()==0) ){
					list.add(str);
				}
			}
		}
		return list;
	}
	
}
