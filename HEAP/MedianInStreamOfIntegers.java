package com.datastructure.HEAP;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianInStreamOfIntegers {

	public static void main(String args[]) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		Scanner sc  = new Scanner(System.in);

		for(int i=0 ; i<4 ; i++) {

			System.out.println("Enter "+ (i+1)+" Number :");
			int num = sc.nextInt();
			insertNum(num , minHeap , maxHeap);
			System.out.println("Median Is : "+findMedian(minHeap , maxHeap));
		}
	}
	
	private static int findMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {

		if(minHeap.size() == maxHeap.size()) {

			return ( minHeap.peek() + maxHeap.peek() ) / 2;
		}

		
		return maxHeap.peek();
	}
	
	private static void insertNum(int num, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {

		if(maxHeap.size() == 0 || maxHeap.peek() >= num) {

			maxHeap.add(num);
		}
		else {
			minHeap.add(num);
		}

		if(maxHeap.size() > minHeap.size() + 1 ) {

			minHeap.add(maxHeap.poll());

		}
		else if(maxHeap.size() < minHeap.size()) {

			maxHeap.add(minHeap.poll());
		}
	}
}