package com.codingraja.sorting;
	
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
	
@SuppressWarnings("rawtypes")
class Employee implements Comparable{
		
		 int empid;
		 String empname;
		 
		 Employee(int empid, String empname){
			    this.empid= empid;
			    this.empname= empname;
		 }
		 public String toString(){
			 return "empid=" + empid  + ", empname=" + empname;
		 }
		
		 public int compareTo(Object  obj){ 
		 //obj1.compareTo(obj2) 
		/*Which element we are trying to insert that is obj1.
		 which is already inserted that is obj2.*/
		// It will sort in ascending order of Employee id	 
			  Employee e = (Employee)obj;
			  int empid2 = e.empid;
			  
			  int empid1 = this.empid;
			  
			  if(empid1<empid2)
			     return -1;
			  else if(empid1>empid2)
				  return +1;
			  else
				  return 0;
		 }
}
	
public class Sorting4{
	
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public static void main(String[] args){
			
			Employee e1 = new Employee(100,"gaurav");
			Employee e2 = new Employee(200, "venkat");
			Employee e3 = new Employee(50,"saurav");
			Employee e4 = new Employee(300,"bassappa");
			
	        // Default TreeSet constructor always meant for natural sorting
			TreeSet t1 = new TreeSet();
			t1.add(new Employee(100,"gaurav"));
			t1.add(new Employee(200,"venkat"));
			t1.add(new Employee(50,"saurav"));
			t1.add(new Employee(300,"bassappa"));
			
			System.out.println("Ascending order of Employee id : "+t1);
			
			System.out.println("Ascending order of Employee id one by one output : ");
			Iterator itr1 = t1.iterator();
		    while(itr1.hasNext()){
		    	Object obj = itr1.next();
		        System.out.println(obj);
		    }
		    System.out.println("=================================================================");
		    // Parameterized TreeSet constructor always meant for custom sorting
		    TreeSet t2 = new TreeSet(new MyComparator2());
			t2.add(e1);
			t2.add(e2);
			t2.add(e3);
			t2.add(e4);
			System.out.println("Alphabetical order of Employee name : "+t2);
			
			System.out.println("Alphabetical order of Employee name one by one output : ");
			Iterator itr2 = t2.iterator();
			while(itr2.hasNext()){
			    Object obj = itr2.next();
			    System.out.println(obj);
			}
			System.out.println("=================================================================");        
			TreeSet t3 = new TreeSet(new MyComparator3());
			t3.add(e1);
			t3.add(e2);
			t3.add(e3);
			t3.add(e4);
			System.out.println("Descending order of Employee id : "+t3);
			
			System.out.println("Descending order of Employee id one by one output : ");
			Iterator itr3 = t3.iterator();
			while(itr3.hasNext()){
				Object obj = itr3.next();
				System.out.println(obj);
			}
		}
}

@SuppressWarnings("rawtypes")
class  MyComparator2 implements Comparator{
	
	     public int compare(Object obj1, Object obj2){
	    	// It will sort in Alphabetical order of Employee name
	    	   Employee E1 = (Employee) obj1;
	    	   Employee E2 = (Employee) obj2;
	    	   
	    	   String s1 = E1.empname;
	    	   String s2 = E2.empname;
	    	   
	    	   return s1.compareTo(s2);
	     }
}
	
@SuppressWarnings("rawtypes")
class  MyComparator3 implements Comparator{
	
	 public int compare(Object obj1, Object obj2){
	 // It will sort in descending order of Employee id 
	  	   Employee E1 = (Employee) obj1;
	  	   Employee E2 = (Employee) obj2;
	  	   
	  	   int empid1 = E1.empid;
	  	   int empid2 = E2.empid;
	  	   if(empid1<empid2)
		     return +1;
	  	   else if(empid1>empid2)
			  return -1;
	  	   else
			  return 0;   
	     }
}
	
