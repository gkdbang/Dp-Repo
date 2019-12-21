package com.sgs.general;

class P{
	public void parentMethod(){
		System.out.println("From Parent method");
	}
}
class C extends P{
	public void chidMethod(){
		System.out.println("From Child Method");
	}
}
public class ParentAndChild {

	public static void main(String[] args) {
		
		// Create Parent class object
		P p = new P();
		p.parentMethod();
		// p.childMethod();  // Through Parent reference we cant't call child specific method CE:
		
		// Create Child class object
		C c = new C();
		c.parentMethod();
		c.chidMethod();
		
		P p1 = new C();
		p1.parentMethod();
		//p1.childMethod();   // Compiler is responsible of reference checking so CE:
							// Compiler will just check child method is available inside Parent class or not.
	}

}
