package com.java.Multithreading;

import java.util.ArrayList;
import java.util.List;

class Q{

	int i ;
	boolean valueSet=false;

	public void put(int i) {

		synchronized(this) {

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
			System.out.println(i +"put ");
			notify();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void get() {

		while(!valueSet) {

			try {wait () ;} catch(Exception e) {}
		}

		System.out.println(i +"get ");
		valueSet = false;
		notify();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class producer implements Runnable{

	Q q;
	public producer(Q q) {

		this.q = q;
		Thread t1 = new Thread(this , "producer");
		t1.start();
	}
	@Override
	public void run() {
		int i=0;

		while(true) { 

			q.put(i++);
		}
	}
}
class consumer implements Runnable{

	Q q;
	public consumer(Q q) {

		this.q = q;
		Thread t1 = new Thread(this , "consumer");
		t1.start();
	}
	public void run() {

		while(true) {

			q.get();
		}
	}
}
public class InterThreadCommunication {
	static List<Integer>list = new ArrayList<>();

	public static void main(String args[]) {

		Q q = new Q();
		new producer(q);
		new consumer(q);

	}
}
