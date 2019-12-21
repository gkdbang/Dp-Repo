package com.sgs.interview.logical;

import java.util.Comparator;
import java.util.TreeSet;

// Sort Heterogeneous object based on their length
public class SortHeterogeneous {

	public static void main(String[] args) {
		
		// If we want to sort Heterogeneous Objects then we have only one choice Comparator
		// Add String and StringBuffer object to TreeSet
		TreeSet<Object> ts=new TreeSet<Object>(new HeterogeneousComparator());
		ts.add("A");
		ts.add(new StringBuffer("ABC"));
		ts.add(new StringBuffer("AA"));
		ts.add("XX");
		ts.add("ABCD");
		ts.add("A");
		System.out.println("Sorting based on their lenth : "+ts);
	}
}
class HeterogeneousComparator implements Comparator<Object>{

	@Override
	public int compare(Object obj1, Object obj2) {
		
		String str1=obj1.toString();
		String str2=obj2.toString();
		int l1=str1.length();
		int l2=str2.length();
		
		if(l1<l2)
			return -1;
		else if(l1>l2)
			return +1;
		else
			return str1.compareTo(str2);
	}	
}