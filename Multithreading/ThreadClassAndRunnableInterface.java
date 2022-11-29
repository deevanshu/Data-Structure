package com.java.Multithreading;

class Hi extends Thread{

	@Override
	public void run() {

		for(int i=0;i<5;i++) {
			System.out.println("Hi");
		}
	}
}

class Hello extends Thread{

	@Override
	public void run() {

		for(int i=0;i<5;i++) {
			System.out.println("Hello");
		}
	}
}

class HiI implements Runnable{

	@Override
	public void run() {

		for(int i=0;i<5;i++) {
			System.out.println("Hi");
		}
	}
}

class HelloI implements Runnable{

	@Override
	public void run() {

		for(int i=0;i<5;i++) {
			System.out.println("Hello");
		}
	}
}

public class ThreadClassAndRunnableInterface {

	public static void main(String args[]) {

		Hi h = new Hi();
		Hello he = new Hello();

		h.start();
		he.start();
		
		HiI hI = new HiI();
		HelloI heI = new HelloI();
		
		Thread t1 = new Thread(hI);
		Thread t2 = new Thread(heI);
		
		t1.start();
		t2.start();

	}
}
