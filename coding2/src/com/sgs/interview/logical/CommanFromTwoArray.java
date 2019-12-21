package com.sgs.interview.logical;

public class CommanFromTwoArray {

	public static void main(String[] args) {
		
		Integer[] fArray=new Integer[]{1,2,3,4,5,6};
		Integer[] sArray=new Integer[]{1,2,3};
		int count=0;
		
		Integer[] finalArray=new Integer[fArray.length];
		// Logic 
		for(int j=0;j<sArray.length;j++){
			for(int i=0;i<fArray.length;i++){
				if(sArray[j]==fArray[i]){
					finalArray[i]=fArray[i];
					count++;
				}
			}
		}
		// Print that final array
		System.out.println("Final Array is : ");
		for(int i=0;i<finalArray.length-count;i++){
			System.out.print(finalArray[i]+" ");
		}
	}
}
