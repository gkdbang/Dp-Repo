package com.codingraja.sorting;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Sorting5 {

	public static void main(String[] args) {
		// TreeMap always sort based on key
		// TreeMap no argu-constructor meant for natural Sorting
		TreeMap<Integer,String> tm=new TreeMap<Integer, String>(); 
		tm.put(101, "Oracle");
		tm.put(100, "JAVA");
		tm.put(103, "C#");
		tm.put(102, "C++");
		System.out.println("Sorting in ascending order of key : "+tm);
		
		System.out.println("Sorting in ascending order of key one by one output : ");
		Set<Map.Entry<Integer,String>> set=tm.entrySet();
		Iterator<Map.Entry<Integer, String>> itr = set.iterator();
		while(itr.hasNext()){
			Map.Entry<Integer, String> entry = itr.next();
			System.out.println(entry);
			System.out.println("key="+entry.getKey()+"........"+" value="+entry.getValue());
		}
	}
}
