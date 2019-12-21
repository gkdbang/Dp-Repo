package com.sgs.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class RemoveDuplicateFromArryList {

	public static void main(String[] args) {
		
		// Creating ArrayList object
		ArrayList al = new ArrayList();
		// Add some element to al
		al.add(10);
		al.add(20);
		al.add(10);
		al.add(30);
		al.add(10);
		al.add(30);
		al.add(50);
		al.add(50);
		
		System.out.println(al);
		
		// Now want to remove duplicate so just convert al to equivalent set
		LinkedHashSet lhs = new LinkedHashSet(al);
		System.out.println("After removing duplicate=====================");
		System.out.println(lhs);
		
		
		// we have one more logic
		LinkedHashSet lhs2 = new LinkedHashSet();
		Iterator itr = al.iterator();
		while(itr.hasNext()){
			int value = (Integer)itr.next();
			lhs2.add(value);	
		}
		System.out.println("From different logic : ");
		System.out.println(lhs2);
	}

}
