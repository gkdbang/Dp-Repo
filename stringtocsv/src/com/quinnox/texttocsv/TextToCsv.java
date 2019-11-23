package com.quinnox.texttocsv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TextToCsv {

	public static void main(String[] args) throws IOException {
		
		  File file = new File("C:\\Gaurav\\xpath.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		  String data;
		  List<String> list = new ArrayList<String>();
		  String[] csvAsArray=null;
		  
		  while ((data = br.readLine()) != null){
			    csvAsArray=data.split("\n");
			    for (String string : csvAsArray) {
			    	list.add(string);
				}		    
		  }
		  
		  PrintWriter writer = new PrintWriter(file);
		  writer.print("");
		  writer.close();

		  TextToCsvUtil.writeXpathToCanonical(list);
		  br.close();

	}

}
