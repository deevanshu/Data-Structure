package com.java.Multithreading;


class HiLE extends Thread{

	@Override
	public void run() {

		for(int i=0;i<5;i++) {
			System.out.println("HiLE");
		}
	}
}

class HelloLE extends Thread{

	@Override
	public void run() {

		for(int i=0;i<5;i++) {
			System.out.println("HelloLE");
		}
	}
}

//class HiILE implements Runnable{
//
//	@Override
//	public void run() {
//
//		for(int i=0;i<5;i++) {
//			System.out.println("HiLE");
//		}
//	}
//}
//
//class HelloILE implements Runnable{
//
//	@Override
//	public void run() {
//
//		for(int i=0;i<5;i++) {
//			System.out.println("HelloLE");
//		}
//	}
//}

public class UsingLambdaExpression {

	public static void main(String args[]) throws InterruptedException {

		HiLE h = new HiLE();
		HelloLE he = new HelloLE();

		h.start();
		he.start();
		
		
//		
//		HiILE hI = new HiILE();
//		HelloILE heI = new HelloILE();
		
//		Thread t1 = new Thread(new HiILE());
//		Thread t2 = new Thread(new HelloILE()); 
		
		
//		Thread t1 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//
//				for(int i=0;i<5;i++) {
//					System.out.println("HiLE");
//				}
//			}
//		});
//		Thread t2 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//
//				for(int i=0;i<5;i++) {
//					System.out.println("HelloLE");
//				}
//			}
//			
//		});
		
		Thread t1 = new Thread(  () -> {

				for(int i=0;i<5;i++) {
					System.out.println("HiLE");
				}
			} );
		
		
		Thread t2 = new Thread( () ->{

				for(int i=0;i<5;i++) {
					System.out.println("HelloLE");
				}
			}
			
		);
		
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		t2.start();
		System.out.println(t1.isAlive());
		System.out.println(t2.isAlive());
		
		t1.join();   
		t2.join();
		
		System.out.println(t1.isAlive());
		System.out.println(t2.isAlive());
		System.out.println("Bye");

	}
}
