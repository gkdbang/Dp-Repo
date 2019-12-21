package com.sgs.simple;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
	
	public static void main(String[] args){
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(101, "Nagarjuna");
		map.put(102, "Cheeranjivi");
		map.put(103, "Venktesh");
		map.put(104, "NTR");
		
		System.out.println(map);  // Printing map object
		
		Set<Integer> set = map.keySet(); // If we want only Key object then we have to call keySet() method on map object
		System.out.println("Only Key : "+set); // printing only key object
		
		// If we want only value object then we have to call Values() method on map object
		Collection<String> collection = map.values(); 
		System.out.println("Only value : "+collection);  // Printing only value object
		
		// If we want entry of map object then we have to call entrySet() method on map object
		Set<Map.Entry<Integer,String>> set2 = map.entrySet();
		System.out.println(set2); // We are printing entry here
		Iterator<Map.Entry<Integer,String>> itr= set2.iterator();
		while (itr.hasNext()) {
			Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>)itr.next();
			System.out.println(entry);  // Here also we are printing entry but one by one
			System.out.println("Key : "+entry.getKey() +".........."+"Value : "+entry.getValue());
		}
		
	}
}
