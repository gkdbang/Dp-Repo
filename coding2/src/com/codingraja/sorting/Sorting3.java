package com.codingraja.sorting;

import java.util.Iterator;
import java.util.TreeSet;

public class Sorting3 {

	public static void main(String[] args) {
		
		// TreeSet default constructor meant for natural sorting 
		TreeSet<Integer> ts = new TreeSet<Integer>();   // With Generic
        ts.add(10);
        ts.add(0);
        ts.add(15);
        ts.add(20);
        ts.add(20);
        System.out.println("After Sorting Integer element : "+ts);
        
        System.out.println("Printing one by one : ");
        Iterator<Integer> itr = ts.iterator();
        while(itr.hasNext()){
        	int i = itr.next();
        	System.out.println(i);
        }
        
        System.out.println("====================================================");
        
        // Default constructor 
        TreeSet<String> ts2 = new TreeSet<String>();   // With Generic
        ts2.add("sumit");
        ts2.add("amit");
        ts2.add("ram");
        ts2.add("aman");
        ts2.add("vikas");
        System.out.println("After Sorting String element : "+ts2);
        
        System.out.println("Printing one by one : ");
        Iterator<String> itr2 = ts2.iterator();
        while(itr2.hasNext()){
        	String str = itr2.next();
        	System.out.println(str);
        }
    }
}
