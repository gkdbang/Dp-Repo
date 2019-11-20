package com.quinnox.mapTojson;

import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONObject;

public class JsonToMap {

	public static void main(String[] args) {
		
		String json="{\"phonetype\":\"N95\",\"cat\":\"WP\"}";
		jsonToMap(json);
	}

	private static void jsonToMap(String json) {
		
		HashMap<String, Object> hashMap=new HashMap<>();
		
		// 1st way by  org.json
		JSONObject jsonObject=new JSONObject(json);
		Iterator<String> keys=jsonObject.keys();
		while (keys.hasNext()) {
			String key = keys.next();
			hashMap.put(key, jsonObject.get(key));
		}
		System.out.println("Json : "+json);
		System.out.println("Map : "+hashMap);
	
	}

}
