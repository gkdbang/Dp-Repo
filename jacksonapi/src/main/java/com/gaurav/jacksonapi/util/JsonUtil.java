package com.gaurav.jacksonapi.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaurav.jacksonapi.domain.Product;

public class JsonUtil {

	public static String convertJavaToJson(Product product) {
		String json="{}";
		// Create object of ObjectMapper class
		ObjectMapper objectMapper=new ObjectMapper();
		try{json=objectMapper.writeValueAsString(product);}
		catch(JsonProcessingException e){e.printStackTrace();}
		return json;
	}

	public static Product convertJsonToJava(String jsonProduct, Class<Product> targetClass) {
		
		Product response=null;
		ObjectMapper objectMapper=new ObjectMapper();
		try{
			response=objectMapper.readValue(jsonProduct, targetClass);
		}
		catch(JsonMappingException e){
			e.printStackTrace();
		}
		catch(JsonParseException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return response;
	}
}
