package com.quinnox.mapTojson;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.simple.JSONValue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MapToJsonObject {

	public static void main(String[] args) {
		
		Map<String, String> crunchifyMap = new HashMap<String, String>();
		crunchifyMap.put("Google", "San Jose");
		crunchifyMap.put("Facebook", "Mountain View");
		crunchifyMap.put("Crunchify", "NYC");
		crunchifyMap.put("Twitter", "SFO");
		crunchifyMap.put("Microsoft", "Seattle");
		
		// By google Gson
		GsonBuilder gsonMapBuilder=new GsonBuilder();
		Gson gsonObject=gsonMapBuilder.create();
		
		String jsonObject=gsonObject.toJson(crunchifyMap);
		System.out.println("Method 1 by Gson : "+jsonObject);
		
		Gson prettyGson=new GsonBuilder().setPrettyPrinting().create();
		String prettyjson=prettyGson.toJson(crunchifyMap);
		System.out.println(prettyjson);
		
		// 2nd way by org.json
		JSONObject crunchifyObject = new JSONObject(crunchifyMap);
		System.out.println("Method-2: Using new JSONObject : "+crunchifyObject+"\n");
		
		// 3rd way by Jackson
		try {
			String objectMapper=new ObjectMapper().writeValueAsString(crunchifyMap);
			System.out.println("Method-3: Using ObjectMapper().writeValueAsString() : "+ objectMapper+"\n");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		// 4th way 
		String jsonValue=JSONValue.toJSONString(crunchifyMap);
		System.out.println("Method-4: Using JSONValue.toJSONString() : "+jsonValue);
	}

}
