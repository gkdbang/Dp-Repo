package com.sgs.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateFromCharacterArray {
		
	public static void main(String[] args) {
		
		// Remove duplicate character from this  Character[] array    
		Character[] ch = {'g','a','u','r','a','v','k','u','m','a','r'};
		
		// change this char array to List type
		List list = Arrays.asList(ch);
		System.out.println("List element that contains duplicate : "+list);
		
		// Now convert this list to set type that will not allow duplicate
		Set set = new LinkedHashSet(list);
		System.out.println("After Removal of duplicate : "+set);
		
		// Through anathor logic
		LinkedHashSet lhs = new LinkedHashSet();
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			Character chr = (Character)itr.next();
			lhs.add(chr);
		}
		System.out.println("From Anathor logic : "+lhs);
		
		// Again convert this set into array so first convert set into list
		ArrayList al = new ArrayList(lhs);
		// Then convert list to array type
		Object[] obj = al.toArray();   // we can also write lhs.toArray();
		System.out.println("Printing Array element :");
		for (Object word : obj) {
			System.out.println(word);
		}
	}
	
}
