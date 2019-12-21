//Program to find Multiplication of two Matrix

package com.codingraja.array;

import java.util.Scanner;

 class MultiplyTwoMatrix {

	public static void main(String[] args) {
		
		   Scanner s = new Scanner(System.in);
	       System.out.print("Enter the number of rows: ");
	       int rows = s.nextInt();
	       
	       System.out.print("Enter the number of columns: ");
	       int columns = s.nextInt();
	       
	       int[][] matrix1 = new int[rows][columns];
	       int[][] matrix2 = new int[rows][columns];
	       
	       System.out.println("Enter the element first matrix");
	       for (int i = 0; i < rows; i++) {
	           for (int j = 0; j < columns; j++) {
	        	   matrix1[i][j] = s.nextInt();               //elements of first matrix.
	           }
	       }
	       
	       System.out.println("Enter the element second matrix");
	       for (int i = 0; i < rows; i++) {
	           for (int j = 0; j < columns; j++) {
	               matrix2[i][j] = s.nextInt();                //elements of second matrix.
	           }
	       }
	       
	       
	       int[][] matrix3 = new int[rows][columns];
	       
	       
	       for (int i = 0; i < rows; i++) {
	           for (int j = 0; j < columns; j++) {
	        	   matrix3[i][j]=0;
	               for(int k=0; k<3; k++)
	               {
	                   matrix3[i][j]= matrix3[i][j]+matrix1[i][k]*matrix2[k][j];
	               }
	           }
	       }
	       System.out.println("The sum of the two matrices is");
	       for (int i = 0; i < rows; i++) {
	           for (int j = 0; j < columns; j++) {
	               System.out.print(matrix3[i][j] + " ");
	           }
	           System.out.println();
	       }
		

	}

}
