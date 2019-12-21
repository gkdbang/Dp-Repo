package com.codingraja.sorting;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Sorting6 {

	public static void main(String[] args) {
		
		// TreeMap Parameterized constructor meant for custom Sorting
		TreeMap<Integer,String> tm=new TreeMap<Integer,String>(new KeyComparator()); 
		tm.put(101, "Oracle");
		tm.put(100, "JAVA");
		tm.put(103, "C#");
		tm.put(102, "C++");
		System.out.println("Sorting in descending order of key : "+tm);
		
		System.out.println("Sorting in descending order of key one by one output : ");
		Set<Entry<Integer, String>> set=tm.entrySet();
		Iterator<Entry<Integer,String>> itr=set.iterator();
		while(itr.hasNext()){
			Entry<Integer,String> entry=itr.next();
			System.out.println(entry);
			System.out.println("key="+entry.getKey()+"........"+" value="+entry.getValue());
		}
	}
}
class KeyComparator implements Comparator<Object>{
	
	public int compare(Object obj1,Object obj2){
		 // As we know TreeMap always sort based on key
		// And key is type of Integer so type cast from object to integer 
		int key1=(Integer)obj1;
		int key2=(Integer)obj2;
		
		// Now write the logic for descending order
		if(key1<key2)
			return +1;
		else if(key1>key2)
			return -1;
		else
			return 0;
	}
}
