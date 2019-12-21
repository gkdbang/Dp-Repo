//Program to find Transpose of Matrix

package com.codingraja.array;

import java.util.Scanner;

 class TransposeMatrix {

	public static void main(String[] args) {
		
		 
	      Scanner in = new Scanner(System.in);
	      System.out.print("Enter the number of rows: ");
	       int rows = in.nextInt();
	       
	       System.out.print("Enter the number of columns: ");
	       int columns = in.nextInt();
	 
	      int matrix[][] = new int[rows][columns];
	 
	      System.out.println("Enter the elements of matrix");
	 
	      for ( int i = 0 ; i < rows ; i++ )
	         for (int j = 0 ; j < columns ; j++ )
	            matrix[i][j] = in.nextInt();
	 
	      int transpose[][] = new int[rows][columns];
	 
	      for (int i = 0 ; i < rows ; i++ )
	      {
	         for (int j = 0 ; j < columns ; j++ )               
	            transpose[j][i] = matrix[i][j];
	      }
	 
	      System.out.println("Transpose of entered matrix:-");
	 
	      for (int i = 0 ; i < rows ; i++ )
	      {
	         for (int j = 0 ; j < columns ; j++ )
	               System.out.print(transpose[i][j]+"\t");
	 
	         System.out.print("\n");
	      }
		

	}

}
