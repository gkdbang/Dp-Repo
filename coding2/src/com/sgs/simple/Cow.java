package com.sgs.simple;

public class Cow {
	
		public void run(){
			System.out.println("Cow is running");
		}
}

class CowBoy extends Cow{
	
	public void run(){
		System.out.println("CowBoy is running");
	}
	
	public static void main(String[] args){
		
		Cow c = new Cow();
		//Cow c = new CowBoy();
		c.run();
	}
	
}
