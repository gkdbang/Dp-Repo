package com.quinnox.jsonparsing;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonWriteExample {
		
		@SuppressWarnings("unchecked")
		public static void main(String[] args) throws FileNotFoundException {
			
			// Creating Json data by json.simple
			
			// Creating JsonObject to have map view
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("firstName", "john");
			jsonObject.put("lastName", "Smith");
			jsonObject.put("age", 25);
			
			LinkedHashMap<Object,Object> linkedHashMap = new LinkedHashMap<Object,Object>();
			linkedHashMap.put("streetAddress","21 2nd Street");
			linkedHashMap.put("city", "New York");
			linkedHashMap.put("state","NY");
			linkedHashMap.put("postalCode", 10021);
			
			jsonObject.put("address", linkedHashMap);
			
			// Creating JsonArray to have List view
			JSONArray jsonArray=new JSONArray();
			
			linkedHashMap=new LinkedHashMap<Object,Object>();
			linkedHashMap.put("type","home");
			linkedHashMap.put("number","212 555-1234");
			
			// Adding map to list
			jsonArray.add(linkedHashMap);
			
			linkedHashMap=new LinkedHashMap<Object,Object>();
			linkedHashMap.put("type","fax");
			linkedHashMap.put("number","646 555-4567");
			
			jsonArray.add(linkedHashMap);
			
			// finally adding phone number array to map
			jsonObject.put("phoneNumbers", jsonArray);
			
			// Now writing this Json to file
			PrintWriter pw = new PrintWriter("C:\\Gaurav\\jsonExample.json");
			pw.write(jsonObject.toJSONString());
			
			pw.flush();
			pw.close();
			
		}
}
