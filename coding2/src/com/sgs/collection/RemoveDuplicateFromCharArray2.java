package com.sgs.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateFromCharArray2 {

	public static void main(String[] args) {
		
		// Remove duplicate character from this primitive char[] array    
		char[] ch = {'g','a','u','r','a','v','k','u','m','a','r'};
		System.out.println("Primitive Array with duplicate : "+Arrays.toString(ch));
		
		// Convert char[] into list
		List<Character> list = new ArrayList<Character>();
		for(char c:ch){
			list.add(c);
		}
		System.out.println("With Duplicate : "+list);
		
		// Want to remove Duplicate
		LinkedHashSet<Character> lhs = new LinkedHashSet<Character>();
		for(Iterator<Character> itr = list.iterator(); itr.hasNext();){
			Character character = itr.next();
			lhs.add(character);
		}
		System.out.println("Without Duplicate : "+lhs);
		// Now convert Set type to Array type
		Object[] obj = lhs.toArray();
		System.out.println("Array without duplicate : "+Arrays.toString(obj));
	}

}
