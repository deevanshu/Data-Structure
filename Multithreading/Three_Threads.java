package com.java.Multithreading;

public class Three_Threads {

	public static void main(String[] args) {

		Thread t1 = new Thread(new NumbersGenerator(1), "THREAD-1");
		Thread t2 = new Thread(new NumbersGenerator(2), "THREAD-2");
		Thread t3 = new Thread(new NumbersGenerator(0), "THREAD-3");

		t1.start();
		t2.start();
		t3.start();
	}
}


class NumbersGenerator implements Runnable{

	private static final int NUMBER_OF_THREADS = 3;
	private static final int TOTAL_NUMBERS_IN_SEQ = 74;
	private int currNumber = 1;
    int remainder ;
        
	public NumbersGenerator(int remainder)
	{
		this.remainder=remainder;
	}

	public void run() {
		synchronized (this) {
			while(currNumber < TOTAL_NUMBERS_IN_SEQ-1) {
				while (currNumber % NUMBER_OF_THREADS != remainder) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				System.out.println(Thread.currentThread().getName() + " : " + currNumber);
				currNumber++;
				notifyAll();
			}
		}
	}
}