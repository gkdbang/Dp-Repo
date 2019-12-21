package com.sgs.collection;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class RemoveDuplicateFromString2 {
		
		public static void main(String[] args) {
			
			String str = "Ravi is a, good! boy. But Ravi is a nasty fellow.";
			// Getting list and set object
			List<String> list = new ArrayList<String>();
			Set<String> set = new LinkedHashSet<String>();
			//Tokenize the String
			StringTokenizer st = new StringTokenizer(str, " ,, ,! ,. ");
			while(st.hasMoreTokens()){
				//System.out.println(st.nextToken());
				list.add(st.nextToken());
			}
			System.out.println("With Duplicate : "+list);
			set.addAll(list);
			list.clear();
			list.addAll(set);
			System.out.println("Without Duplicate : "+list);
		}	
}
