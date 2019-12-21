package com.codingraja.sorting;

import java.util.Comparator;
import java.util.TreeMap;

public class Sorting7 {
	
	public static void main(String[] args) {
			
			TreeMap<String, Integer> tm=new TreeMap<String, Integer>(new KeyComparator2());
			tm.put("VVV", 10);
			tm.put("AAA", 40);
			tm.put("ZZZ", 30);
			tm.put("LLL", 20);
			System.out.println(tm);
	}
}
class KeyComparator2 implements Comparator<Object>{
		
		public int compare(Object obj1, Object obj2){
			String str1=(String)obj1;
			String str2=obj2.toString();
			return str2.compareTo(str1);
			//return -str2.compareTo(str1);
		}
}
