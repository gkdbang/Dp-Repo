package com.sgs.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindMinAndSecondMinInCollectionElement {

	public static void main(String[] args) {
		
		int num=0;
		int min,sMin;
		List<Integer> ls = new ArrayList<Integer>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements in collection : ");
		num = sc.nextInt();
		
		System.out.println("Enter Collection Elements : ");
		for(int i=0;i<num;i++){
			ls.add(sc.nextInt());
		}
		
		min=ls.get(0);
		sMin=ls.get(1);
		
		// Logic
		for(int i=1; i<ls.size();i++){
			if(min>ls.get(i)){
				sMin=min;
				min=ls.get(i);
			}
			else if(sMin>ls.get(i)){
				sMin=ls.get(i);
			}
		}
		System.out.println("min element in collection : "+min);
		System.out.println("SecondMin element in collection : "+sMin);
		sc.close();

	}

}
