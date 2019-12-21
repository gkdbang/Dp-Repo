package com.sgs.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class RemoveAndWriteDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    ArrayList<String> list = new ArrayList<String>();
	    HashSet<String> unique = new LinkedHashSet<String>();
	    HashSet<String> dup = new LinkedHashSet<String>();
	    boolean b = false;
	    list.add("Hello");
	    list.add("Hello");
	    list.add("how");
	    list.add("are");
	    list.add("u");
	    list.add("u");

	    for(Iterator<String> iterator= list.iterator();iterator.hasNext();)
	    {
	        String value = (String)iterator.next();
	        System.out.println(value);
	        
	        if(b==unique.add(value))
	            dup.add(value);
	        else
	            unique.add(value);
	    }
	    System.out.println("===============================");
	    System.out.println(unique);
	    System.out.println("===============================");
	    System.out.println(dup);

	}

}
