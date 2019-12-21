package com.codingraja.array;

import java.util.Scanner;

public class ArrayBinarySearch {

	public static void main(String[] args) {
		
		int num, item, flag=0;
		
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of elements in the array:");
        num = s.nextInt();
        int array[] = new int[num];
        
        System.out.println("Enter elements of array:");
        for(int i = 0; i<array.length; i++){
            array[i] = s.nextInt();
        }
        
        System.out.println("Enter Item for Searching :");
        item = s.nextInt();
        
        // Logic For Searching
        int startIndex=0;
        int endIndex=(array.length)-1;
        int mid=0;;
        while(startIndex <= endIndex){
        	mid = (startIndex+endIndex)/2;
        	if(item==array[mid]){
        		System.out.println("Item found at index : "+mid);
        		flag++;
        		break;
        	}
        	else if(item>array[mid]){
        		startIndex=mid+1;
        	}
        	else{
        		endIndex=mid-1;
        	}
        }
        if(flag==0)
        	System.out.println("Item is not found in Array");
        s.close();
	}

}
