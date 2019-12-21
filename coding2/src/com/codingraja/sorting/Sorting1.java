package com.codingraja.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Sorting1 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		@SuppressWarnings("rawtypes")
		ArrayList al = new ArrayList();  // Without Generic
		al.add("CCC");
		al.add("111");
		al.add("AAA");
		al.add("BBB");
		al.add("ccc");
		al.add("bbb");
		al.add("aaa");
		al.add("333");
		al.add("222");
		
		System.out.println("Before sorting------");
		System.out.println(al);
		
		System.out.println("Before sorting one by one-------");
		@SuppressWarnings("rawtypes")
		Iterator itr = al.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		  }
		
		System.out.println("After sorting------");
		Collections.sort(al);
		System.out.println(al);
		
		System.out.println("After sorting one by one-------");
		itr = al.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		  }
		System.out.println("================================================");	
		
		@SuppressWarnings("rawtypes")
		ArrayList al2 = new ArrayList();  // Without Generic
		al2.add(88);
		al2.add(7);
        al2.add(101);
        al2.add(0);
        al2.add(3);
        al2.add(222);
        
        System.out.println("Before sorting-------------");
        System.out.println(al2);
        
        System.out.println("After sorting--------------");
        Collections.sort(al2);
        System.out.println(al2);
	}

}
