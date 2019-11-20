package com.quinnox.mapTojson;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONObject;

public class MapToJson {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Map<String, String> crunchifyMap = new HashMap<String, String>();
		crunchifyMap.put("Google", "San Jose");
		crunchifyMap.put("Facebook", "Mountain View");
		crunchifyMap.put("Crunchify", "NYC");
		crunchifyMap.put("Twitter", "SFO");
		crunchifyMap.put("Microsoft", "Seattle");
		
		
		JSONObject jsonMap=new JSONObject();
		for(Iterator<Entry<String, String>> itr=crunchifyMap.entrySet().iterator();itr.hasNext();){
			Entry<String, String> entry=itr.next();
			jsonMap.put(entry.getKey(), entry.getValue());
		}
		
		System.out.println(jsonMap);
		
	}

}
