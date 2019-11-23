package com.quinnox.javaapijsonparsing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

public class CreateJsonByJsonBuilder {
		
	public static void main(String[] args) throws IOException {
		
		// Creating Json object by Java api using Object Model
		JsonObjectBuilder jsonObjectBuilder=Json.createObjectBuilder();
		jsonObjectBuilder.add("emp_name", "Nataraj");
		jsonObjectBuilder.add("emp_id", 1001);
		jsonObjectBuilder.add("emp_salary", 20000);
		
		// creating one JsonObject inside an existing object
		JsonObjectBuilder jsonObjectBuilder2=Json.createObjectBuilder();
		jsonObjectBuilder2.add("streetAddress","MG Road");
		jsonObjectBuilder2.add("city","Bangalore");
		jsonObjectBuilder2.add("zip",560001);
		
		// Adding jsonObjectBuilder2 to main jsonObjectBuilder 
		jsonObjectBuilder.add("address", jsonObjectBuilder2);
		
		// creating one JsonArray inside an existing object
		JsonArrayBuilder jsonArrayBuilder=Json.createArrayBuilder();
		
		JsonObjectBuilder jsonObjectBuilder3=Json.createObjectBuilder();
		jsonObjectBuilder3.add("type","home");
		jsonObjectBuilder3.add("number","212 555-1234");
		JsonObjectBuilder jsonObjectBuilder4=Json.createObjectBuilder();
		jsonObjectBuilder4.add("type","fax");
		jsonObjectBuilder4.add("number","646 555-4567");
		
		// Add this jsonObjectBuilder3 to jsonArrayBuilder
		jsonArrayBuilder.add(jsonObjectBuilder3);
		jsonArrayBuilder.add(jsonObjectBuilder4);
		
		JsonArray jsonArray=jsonArrayBuilder.build();
		
		// Adding jsonArray to main jsonObjectBuilder 
		jsonObjectBuilder.add("phoneNumbers", jsonArray);
		
		JsonObject empObj=jsonObjectBuilder.build();
		
		// Writing to a String Writer, if we want we can write it to file as well.
/*		StringWriter stringWriter=new StringWriter();
		JsonWriter jsonWriter=Json.createWriter(stringWriter);
		jsonWriter.writeObject(empObj);
		jsonWriter.close();
		System.out.println(stringWriter);*/
		
		File file=new File("C:\\Gaurav\\jsonData.json");
		FileWriter fileWriter=new FileWriter(file);
		JsonWriter jsonWriter=Json.createWriter(fileWriter);
		jsonWriter.writeObject(empObj);
		jsonWriter.close();
	}
			
}
