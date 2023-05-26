package com.java.Multithreading;

public class Three_Threads {

	public static void main(String[] args) {
		
		 NumbersGenerator n1 =new NumbersGenerator(1);
		 
		Thread t1 = new Thread(n1, "1");
		Thread t2 = new Thread(n1, "2");
		Thread t3 = new Thread(n1, "0");

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
			while(currNumber < TOTAL_NUMBERS_IN_SEQ-1) {
				synchronized (this) {
				while (currNumber%NUMBER_OF_THREADS != Integer.parseInt(Thread.currentThread().getName())) {
					try {
						wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				System.out.println("Thread "+Thread.currentThread().getName() + " : " + currNumber);
				currNumber++;
				notifyAll();
			}
		}
	}
}