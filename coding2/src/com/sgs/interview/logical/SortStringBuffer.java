package com.sgs.interview.logical;

import java.util.Comparator;
import java.util.TreeSet;

public class SortStringBuffer {

	public static void main(String[] args) {
		
		/* Add StringBuffer object to TreeSet StringBuffer is not Comparable so always go for 
	  	  Comparator for any type of Sorting.*/
		
		TreeSet<StringBuffer> ts=new TreeSet<StringBuffer>(new BufferCompaarator());
		ts.add(new StringBuffer("A"));
		ts.add(new StringBuffer("Z"));
		ts.add(new StringBuffer("K"));
		ts.add(new StringBuffer("L"));
		System.out.println("After Sorting StringBuffer Object : "+ts);
	}
}
class BufferCompaarator implements Comparator<StringBuffer>{

	@Override
	public int compare(StringBuffer sb1, StringBuffer sb2) {
		
		return -(sb1.toString()).compareTo(sb2.toString());
	}
	
}