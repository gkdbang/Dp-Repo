package com.quinnox.jsonToMap;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.quinnox.model.User;

public class JsonToMap {

	public static void main(String[] args) {
		
		String json = "{\n" +
                "    \"name\": \"Garima\",\n" +
                "    \"age\": \"28\",\n" +
                "    \"phone\": 9832734651}";
		
		User user=new Gson().fromJson(json, User.class);
		//System.out.println(user);
		
		ObjectMapper objectMapper=new ObjectMapper();
		User[] user2=null;
		//List<User> user2=null;
		try {
			 user2=objectMapper.readValue(new File("C:\\Users\\gauravd\\Desktop\\User.txt"), User[].class);
			 //user2=Arrays.asList(objectMapper.readValue(new File("C:\\Users\\gauravd\\Desktop\\User.txt"), User[].class));
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Arrays.toString(user2));
		//System.out.println(user2);
	}

}
