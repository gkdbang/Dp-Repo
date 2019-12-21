package com.sgs.interview.logical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortMapByValue {

	public static void main(String[] args) {
		
		Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("java", 20);
        map.put("C++", 45);
        map.put("DBMS", 2);
        map.put("Unix", 67);
        map.put("MAC", 26);
        map.put("Algorithm", 93);
        
        Set<Entry<String, Integer>> set=map.entrySet();
        List<Entry<String,Integer>> list=new ArrayList<Entry<String,Integer>>(set);
        Collections.sort(list, new ValueComparator());
        System.out.println("Sorting based on value : "+list);
        
        System.out.println("Sorting based on value one by one output : ");
        for(Entry<String,Integer> entry:list){
        	System.out.println(entry);
        	System.out.println("Key="+entry.getKey()+"......."+"Value="+entry.getValue());
        }
	}
}
class ValueComparator implements Comparator<Entry<String,Integer>>{
	
		public int compare(Entry<String,Integer> entry1,Entry<String,Integer> entry2){
			return -(entry1.getValue()).compareTo(entry2.getValue());
		}
}
