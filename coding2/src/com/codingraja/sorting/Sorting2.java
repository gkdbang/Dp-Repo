package com.codingraja.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

@SuppressWarnings("rawtypes")
class Student implements Comparable{
	
	  public String studentname;
	  public int rollno;
	  public int studentage;
	  
	  public Student(String  studentname, int rollno, int studentage){
		    this.studentname = studentname;
		    this.rollno = rollno;
		    this.studentage = studentage;
	  }
	  
	  public String toString(){
		   return "studentname = " + studentname  +  ",  rollno = " 
				   + rollno +  ",  studentage = "  + studentage;
	  }
	  
	  public int compareTo(Object obj){   //obj1.compareTo(obj2)
		  	// It will sort in ascending order of student age
		    Student s = (Student) obj;
		    int studentage2 = s.studentage;
		    
		    int studentage1 = this.studentage;
		    
		    if(studentage1<studentage2)
		    	return -1;
		    else if(studentage1>studentage)
		    	return +1;
		    else
		    	return 0;		    	
	    }
  }

public class Sorting2 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		 Student s1 = new Student("gaurav",10,28);
		 Student s2 = new Student("saurav",11,22); 
		 Student s3 = new Student("amit",12,20);
		 
		 ArrayList al = new ArrayList();
		 al.add(s1);
		 al.add(s2);
		 al.add(s3);
		 
		 // This sort method meant for natural order 
		 Collections.sort(al);  // it will call compareTo() method
		 System.out.println("Sorting based on Student age : "+al);
		 
		 System.out.println("Sorting based on Student age one by one output : ");
		 for(Object obj:al){
			 System.out.println(obj);
		 }
		 
		 System.out.println("===================================================================");
		 
		 // This sort method meant for custom sorting
		 Collections.sort(al,new MyComparator());  // it will call compare() method
		 
		 System.out.println("Sorting based on Student name : "+al);
		 
		 System.out.println("Sorting based on Student name one by one output : ");	
		 
		 Iterator itr = al.iterator();
		 while(itr.hasNext()){
			   System.out.println(itr.next());
		 }
     }
}

@SuppressWarnings("rawtypes")
class MyComparator implements Comparator{
	
	    public int compare(Object obj1, Object obj2){
	    // It will sort in Alphabetical order of student name	
	    	   Student st1 = (Student) obj1;
	    	   Student st2 = (Student) obj2;
	    	   
	    	   String s1 = st1.studentname;
	    	   String s2 = st2.studentname;
	    	     
	    	   return s1.compareTo(s2);
	        }
    }

