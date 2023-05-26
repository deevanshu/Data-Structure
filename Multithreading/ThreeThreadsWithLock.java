package com.java.Multithreading;

public class ThreeThreadsWithLock {

	public static void main(String[] args) {

		PrintSequenceRunnable runnable1=new PrintSequenceRunnable(1);
		PrintSequenceRunnable runnable2=new PrintSequenceRunnable(2);
		PrintSequenceRunnable runnable3=new PrintSequenceRunnable(0);

		Thread t1=new Thread(runnable1,"T1");
		Thread t2=new Thread(runnable2,"T2");
		Thread t3=new Thread(runnable3,"T3");

		t1.start();
		t2.start();
		t3.start();   
	}
}

class PrintSequenceRunnable implements Runnable{

	public int PRINT_NUMBERS_UPTO=74;
	static int  number=1;
	int remainder;
	static Object lock=new Object();

	PrintSequenceRunnable(int remainder)
	{
		this.remainder=remainder;
	}

	@Override
	public void run() {
		while (number < PRINT_NUMBERS_UPTO) {
			synchronized (lock) {
				while (number % 3 != remainder) { // wait for numbers other than remainder , for 3 threads rem  val will always be 1 , 2 , 0
					try {
						lock.wait();  // Causes the current thread to wait until it is awakened, typically by being notified or interrupted. 
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " "+number);	
				
				
//				if(remainder==1) {
//					System.out.println(Thread.currentThread().getName() + " Welcome ");	
//				}
//				else if(remainder==2) {
//					System.out.println(Thread.currentThread().getName() + "  To");	
//
//				}
//				else {
//					System.out.println(Thread.currentThread().getName() + " Freechrge");	
//
//				}
				number++;
				lock.notifyAll();
			}
		}
	}
}