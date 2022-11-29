package com.datastructures.ARRAYS;

import java.util.Arrays;

public class ChoclateDistribution {


	public static void main(String args[]) {

		int M = 3 ,diff=99999 ,initial=0 , finalv=0;
		int A[] = {7, 3, 2, 4, 9, 12, 56}; // 2,3,4,7,9,12,56

		Arrays.sort(A);

		for(int i=0; (i+M-1) <A.length; i++) {

          
			if(A[i+M-1] - A[i] < diff) {
				
				diff = A[i+M-1] - A[i];
				initial=i;
				finalv=i+M-1;
				
			}
		}
		
		System.out.println(diff);
	}

}
