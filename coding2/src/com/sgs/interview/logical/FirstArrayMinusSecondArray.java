package com.sgs.interview.logical;

public class FirstArrayMinusSecondArray {

	public static void main(String[] args) {
			
			Integer[] fArray=new Integer[]{1,2,3,4,5,6,7,8,1,2,3};
			Integer[] sArray=new Integer[]{1,2,3};
			int count=0;
			// Logic 
			for(int j=0;j<sArray.length;j++){
				for(int i=0;i<fArray.length;i++){
					if(sArray[j]==fArray[i]){
						fArray[i]=null;
						count++;
					}
				}
			}
			int size =fArray.length-count;
			Integer[] finalArray=new Integer[size];
			int k=0;
			for(int i=0;i<fArray.length;i++){
				if(fArray[i]!=null){
					finalArray[k]=fArray[i];
					k++;
				}
			}
			// Print that final array
			System.out.println("Final Array is : ");
			for(int i:finalArray){
				System.out.print(i+" ");
			}
	}
}
