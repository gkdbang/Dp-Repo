package com.sgs.interview.logical;

public class UniqueFromTwoArray {

	public static void main(String[] args) {
		
		Integer[] fArray=new Integer[]{1,2,3,4,5};
		Integer[] sArray=new Integer[]{1,2,3,6,7};
		
		// Logic 
		for(int i=0;i<fArray.length;i++){
			for(int j=0;j<sArray.length;j++){
				if(fArray[i]==sArray[j]){
					fArray[i]=null;
					sArray[j]=null;
				}
			}
		}
		
		int size =(fArray.length+sArray.length);
		Integer[] finalArray=new Integer[size];
		
		// Storing first array inside final array
		int m=0;
		for(int i=0;i<fArray.length;i++){
			if(fArray[i]!=null){
				finalArray[m]=fArray[i];
				m++;
			}
		}
		
		//Storing second array inside final array
		int n=fArray.length;
		for(int i=0;i<sArray.length;i++){
			if(sArray[i]!=null){
				finalArray[n]=sArray[i];
				n++;
			}
		}
		
		// Print that final array
		System.out.println("Final Array is : ");
		for(int i=0;i<finalArray.length;i++){
			if(finalArray[i]!=null)
			System.out.print(finalArray[i]+" ");
		}
	}
}
