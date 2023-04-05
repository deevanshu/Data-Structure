package com.datastructures.ARRAYS;

import java.util.Scanner;

public class SepratenegativeAndPositiveNumbers {

	public static void main (String args[]) {

		int inputArray[] = { -12, 11, -13, -5, 6, -7, 5, -3, -6};


		//		Scanner sc = new Scanner(System.in);
		//		int n = sc.nextInt();

		//	System.out.println("number :"+n);
		sepratePositiveAndNegative(inputArray);
		printArray(inputArray);
	}

	private static void printArray(int[] arr) {

		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	private static void sepratePositiveAndNegative(int[] inputArray) {

		int negpointr=0,m=0;

		while(m<=inputArray.length-1) {

			if(inputArray[m]<0) { //negative

				int temp=inputArray[m];
				inputArray[m]=inputArray[negpointr];
				inputArray[negpointr]=temp;

				m++;
				negpointr++;

			}
			else {
				m++;
			}

		}

	}

}
