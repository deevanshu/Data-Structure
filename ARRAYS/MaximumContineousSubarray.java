package com.datastructures.ARRAYS;

public class MaximumContineousSubarray {

	public static void main (String args[]) {

		int Arr[] = {1, 2, 3, -2, 5};
		maxSubarraySum(Arr , 5);
		maximumSubarraySum(Arr);
		maxSubArraySum(Arr , Arr.length);
	}
	//KADANES ALGORITHM
	static void maxSubarraySum(int arr[], int n){

		// Your code here
		int maxTillHere = 0 , maxSoFar =  0 ;

		for(int i = 0 ; i < arr.length ; i++){

			maxTillHere += arr[i];

			if(maxTillHere < arr[i]){
				maxTillHere = arr[i];
			}

			if( maxSoFar < maxTillHere){

				maxSoFar = maxTillHere;
			}
		}
		System.out.println(maxSoFar);
	}
	public  static void maximumSubarraySum(int[] arr) {

		int maxTillHere=0 , maxSoFar=Integer.MIN_VALUE , lower = 0, higher = 0;

		for(int i=0; i < arr.length ; i++) {

			maxTillHere = maxTillHere + arr[i];

			if(maxTillHere < arr[i]) {

				maxTillHere =  arr[i] ;

				lower = i;
				if(maxSoFar < maxTillHere) {
					lower = i;
				}
			}
			if(maxSoFar < maxTillHere) {

				maxSoFar=maxTillHere;
				higher = i;
			}
		}


		System.out.println("Max Sum :" + maxSoFar + " Starting Index :" + lower + " Higher Index :" + higher);
	}
	static void maxSubArraySum(int a[], int size)
	{
		int maxSoFar = Integer.MIN_VALUE,
				maxTillHere = 0,start = 0,
				end = 0, s = 0;

		for (int i = 0; i < size; i++)
		{
			maxTillHere = maxTillHere + a[i];

			if (maxSoFar < maxTillHere)
			{
				maxSoFar = maxTillHere;
				start = s;
				end = i;
			}

			if (maxTillHere < a[i])
			{
				maxTillHere = a[i];
				s = i + 1;
			}
		}

		System.out.println("Maximum contiguous sum is "
				+ maxSoFar);
		System.out.println("Starting index " + start);
		System.out.println("Ending index " + end);

	}
}
