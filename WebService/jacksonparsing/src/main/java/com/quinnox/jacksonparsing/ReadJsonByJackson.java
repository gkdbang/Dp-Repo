package com.quinnox.jacksonparsing;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class ReadJsonByJackson {

	public static void main(String[] args) {
		
		// Reading Json data by Jackson api
		
		ObjectMapper mapper=new ObjectMapper();
		File file=new File("C:\\Gaurav\\jsonExample.json");
		try {
			JsonNode rootNode=mapper.readTree(file);
			// Read firstName
			JsonNode firstName=rootNode.path("firstName");
			System.out.println(firstName.getTextValue());
			
			// Read firstName
			JsonNode age=rootNode.path("age");
			System.out.println(age.getIntValue());
			
			/*JsonNode address=rootNode.path("address");
			JsonNode streetAddress=address.path("streetAddress");
			System.out.println("========"+streetAddress.asText());*/
			
			// Read inner json element address
			JsonNode address=rootNode.path("address");
			Iterator<JsonNode> iterator=address.iterator();
			while(iterator.hasNext()){
				JsonNode add=iterator.next();
				System.out.println(add.asText());
			}
			
			// Read inner Json array phoneNumbers
			List<JsonNode> phoneNumbers=rootNode.findValues("phoneNumbers");
			Iterator<JsonNode> iterator2=phoneNumbers.iterator();
			while (iterator2.hasNext()) {
				JsonNode phone =  iterator2.next();
				Iterator<JsonNode> iterator3=phone.iterator();
				while (iterator3.hasNext()) {
					JsonNode ph = iterator3.next();
					Iterator<JsonNode> iterator4=ph.iterator();
					while (iterator4.hasNext()) {
						JsonNode phnum = iterator4.next();
						System.out.println(phnum.asText());
						
					}
				}
			}
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
