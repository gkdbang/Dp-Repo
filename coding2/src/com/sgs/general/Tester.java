package com.sgs.general;

class Parent{ }

class ChildClass extends Parent {  }

public class Tester {

     public static void main (String args[ ]) {
   
      Parent p = new Parent ( );
	  
	  //Parent p = new ChildClass();
      
      /*this is a downcast since the Parent class
        object, "p" is being cast to a ChildClass type,
        and ChildClass derives from the Parent class */
      
      ChildClass c = (ChildClass) p; 

     }
}
