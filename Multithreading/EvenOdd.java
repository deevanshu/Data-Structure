package com.java.Multithreading;
class Q1{

	int i ;
	boolean valueSet=false;

	public synchronized void putEven(int i) {
		//	synchronized(this) {
		while(valueSet) {

			try {
				wait() ;
			} 
			catch(Exception e) {

				System.out.println(e);
			}  
		}
		this.i=i;
		valueSet = true;
		System.out.println(i +" Even");
		notify();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//	}
	}
	public synchronized void putOdd(int i) {

		while(!valueSet) {

			try {wait () ;} catch(Exception e) {}
		}

		this.i = i;
		System.out.println(i +" Odd ");
		valueSet = false;
		notify();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class producer1 implements Runnable{

	Q1 q;
	public producer1(Q1 q) {

		this.q = q;
		Thread t1 = new Thread(this , "producer1Even");
		t1.start();
	}
	@Override
	public void run() {
		int i=0;

		while(true) { 

			q.putEven(i);
			i = i+2;
		}
	}
}
class consumer1 implements Runnable{

	Q1 q;
	public consumer1(Q1 q) {

		this.q = q;
		Thread t1 = new Thread(this , "consumer1Odd");
		t1.start();
	}
	public void run() {

		int i=1;

		while(true) { 

			q.putOdd(i);
			i=i+2;
		}
	}
}
public class EvenOdd {

	public static void main(String args[]) {

		Q1 q = new Q1();
		new producer1(q);
		new consumer1(q);

	}
}