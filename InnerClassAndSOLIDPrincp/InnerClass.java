package com.java.InnerClassAndSOLIDPrincp;

class Outer_Demo {
	   int num;
	   
	   // inner class
	   private class Inner_Demo {
	      public void print() {
	         System.out.println("This is an inner class");
	      }
	   }
	   
	   void display_Inner() {
	      Inner_Demo inner = new Inner_Demo();
	      inner.print();
	   }
	}
	   
	public class InnerClass {

	   public static void main(String args[]) {
	      // Instantiating the outer class 
	      Outer_Demo outer = new Outer_Demo();
	      
	      // Accessing the display_Inner() method.
	      outer.display_Inner();
	   }
	}
	
	// youtube