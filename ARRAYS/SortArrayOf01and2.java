package com.datastructures.ARRAYS;

public class SortArrayOf01and2 {

	public static void main (String args[]) {

		int arr[]= {0 , 2  ,1 , 2 , 0 ,1 , 1, 2 , 2, 0};  // 0 ,0 ,1,2,2

		SortArray(arr);
		printArray(arr);

	}

	private static void printArray(int[] arr) {

		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

		System.out.println();

	}

	private static void SortArray(int[] arr) {

		int l=0 , m=0,h=arr.length-1 ,  c=0;

		while(m<=h) {
              c=c+1;
			if(arr[m]==0) {

				int temp = arr[m];
				arr[m]= arr[l];
				arr[l]=temp;

				l++;
				m++;
			}
			else if (arr[m]==1) {
				m++;	
			}
			else {
				int temp = arr[m];
				arr[m]= arr[h];
				arr[h]=temp;

				h--;
			}
		}
		System.out.println(c);
	}
}
