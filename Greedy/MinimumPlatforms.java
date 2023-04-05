package com.datastructure.Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumPlatforms {

	public static void main(String args[]) {

		//		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		//		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		int arr[] = { 900, 940, 950, 1130};
		int dep[] = { 910, 1200, 1120, 1140};

		combinedArray [] array = new combinedArray[arr.length];

		for(int i=0; i<arr.length; i++) {

			combinedArray s11 =  new combinedArray(arr[i] , dep[i] );
			array[i] = s11;
		}

		Arrays.sort(array,  (a , b) ->{
			return a.start - b.start;
		} );	


		PriorityQueue<combinedArray> pq = new PriorityQueue<>(array.length, (a ,b) -> { return a.end - b.end ;} );

		int platforms=1;
		pq.add(array[0]);

		for(int i=1 ; i<array.length ; i++) {
			if(pq.peek().end < array[i].start) {

				pq.poll();
			}
			else {
				platforms++;
			}
			pq.add(array[i]);
		}
		System.out.println("platforms :" + platforms);
	}
}
class combinedArray{

	int start , end ;

	public combinedArray(int start ,int end ) {

		this.end = end;
		this.start = start;
	}
}
