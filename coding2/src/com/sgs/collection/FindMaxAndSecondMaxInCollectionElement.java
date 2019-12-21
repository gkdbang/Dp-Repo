package com.sgs.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindMaxAndSecondMaxInCollectionElement {

	public static void main(String[] args) {
		
		int num=0;
		int max,sMax;
		List<Integer> ls = new ArrayList<Integer>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements in collection : ");
		num = sc.nextInt();
		
		System.out.println("Enter Collection Elements : ");
		for(int i=0;i<num;i++){
			ls.add(sc.nextInt());
		}
		
		max=ls.get(0);
		sMax=ls.get(1);
		
		// Logic
		for(int i=1; i<ls.size();i++){
			if(max<ls.get(i)){
				sMax=max;
				max=ls.get(i);
			}
			else if(sMax<ls.get(i)){
				sMax=ls.get(i);
			}
		}
		System.out.println("Max element in collection : "+max);
		System.out.println("SecondMax element in collection : "+sMax);
		sc.close();
	}

}
