package com.datastructures.ARRAYS;
public class MinJumpsToReachEndOfrry {

	public static void main (String args[]) {
		int arr[] = {1, 4, 3, 2, 6, 7} ;
		MinJumps(arr);
	}
	
	private static void MinJumps(int[] arr) {
		int jumps=0;
		for(int i=0; i <arr.length;) {
			int val = arr[i];
			if(val==0) {
				jumps=-1;
				break;
			}
			if(i!=arr.length-1){
				jumps+=1;
			}
			i=i+val;
		}
		System.out.println(jumps);
	}
}
