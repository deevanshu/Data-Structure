package com.datastructures.ARRAYS;

public class RotateArrayBy1 {

	public static void main (String args[]) {
		int A[] = {1, 2, 3, 4, 5};

		int N=1;

		for(int i= A.length-1; i>0 ; i--) {
			
			
			int temp=A[i];
			A[i]=A[i-1];
			A[i-1]=temp;
			
		}
		for(int i=0; i<A.length; i++) {
			
			System.out.println(A[i]);
		}
	}
}
