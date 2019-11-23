package com.quinnox.javaapijsonparsing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class ReadJsonByJsonReader {

	public static void main(String[] args) {
		
		// Reading Json data by using Java api
		
		// Representing file
		File inputJsonFile=new File("C:\\Gaurav\\jsonExample.json");
		try {
			// Reading file
			Reader reader=new FileReader(inputJsonFile);
			
			// Creating Json Reader from Json
			JsonReader jsonReader=Json.createReader(reader);
			
			// Get the JsonObject Structure from jsonReader
			JsonObject empObject=jsonReader.readObject();
			jsonReader.close();
		
			// Now read the JSON String data
			System.out.println(empObject.getString("firstName"));
			// Now read the JSON Int data
			System.out.println(empObject.getInt("age"));
			
			// Read Inner json element address
			JsonObject addObj=empObject.getJsonObject("address");
			System.out.println(addObj.getString("city"));
			System.out.println(addObj.getInt("postalCode"));
			
			// Read Inner json array phoneNumbers
			JsonArray phNumArray=empObject.getJsonArray("phoneNumbers");
			for (JsonValue jsonValue : phNumArray) {
				System.out.println(jsonValue.toString());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
