package com.quinnox.patterncoding;

public class Pattern58 {

	public static void main(String[] args) {
		
		int size=4;
		for(int i=size;i>=1;i--){
			for(int j=i;j<=size;j++){
				System.out.print((char)((j-1)+65));
			}
			System.out.println();
		}
		for(int i=1;i<=(size-1);i++){
			for(int j=i;j<=(size-1);j++){
				System.out.print((char)((j)+65));
			}
			System.out.println();
		}

	}

}
