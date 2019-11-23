package com.quinnox.jsonparsing;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReadExample {

	public static void main(String[] args) throws IOException, ParseException {
		
		// Reading Json data by json.simple
		// Now we will parse the Json file with the help of JsonParser, JsonArray, JsonObject
		File file=new File("C:\\Gaurav\\jsonExample.json");
		FileReader fileReader=new FileReader(file);
		
		JSONParser jsonParser=new JSONParser();
		Object obj=jsonParser.parse(fileReader);
		JSONObject jsonObject=(JSONObject) obj;
		
		String firstName=(String)jsonObject.get("firstName");
		String lastName=(String)jsonObject.get("lastName");
		System.out.println(firstName);
		System.out.println(lastName);
		
		Long age=(Long)jsonObject.get("age");
		System.out.println(age);
		
		// Getting Inner json element Address
		Map<Object,Object> addressMap = (Map<Object,Object>)jsonObject.get("address");
		Set<Entry<Object, Object>> set=addressMap.entrySet();
		Iterator<Entry<Object, Object>> iterator=set.iterator();
		while (iterator.hasNext()) {
			Entry<Object, Object> entry=iterator.next();
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
		// Getting Inner json array phoneNumbers
		JSONArray phoneNumberList=(JSONArray) jsonObject.get("phoneNumbers");
		Iterator<Object> iterator2=phoneNumberList.iterator();
		while(iterator2.hasNext()){
			Map<Object,Object> map=(Map<Object, Object>) iterator2.next();
			Iterator<Entry<Object, Object>> iterator3=map.entrySet().iterator();
			while(iterator3.hasNext()){
				Entry<Object, Object> entry=iterator3.next();
				System.out.println(entry.getKey()+":"+entry.getValue());
			}
		}
	}
}
