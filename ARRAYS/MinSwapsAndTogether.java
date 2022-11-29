package com.datastructures.ARRAYS;

public class MinSwapsAndTogether {

	public static void main(String args[]) {

		int arr[] = {4 ,16, 3, 8, 13, 2, 19, 4, 12, 2, 7, 17, 4, 19, 1}; // c=3 , b=1
		int k = 9;
		int n = arr.length;

		int lessThanK=0 ,greaterThankKInFirstWind=0,minSwaps;


		for(int i=0;i<arr.length;i++){

			if(arr[i]<=k) {

				lessThanK++;
			}
		}

		for(int i=0;i<lessThanK;i++) {

			if(arr[i]>k) {

				greaterThankKInFirstWind++;
			}
		}

		int lower=0,higher=lessThanK-1,finalAns = greaterThankKInFirstWind;
		minSwaps=greaterThankKInFirstWind;

		while(higher<n-1) {


			higher++;

			lower++;

			if(arr[higher] > k && arr[lower-1]<= k) {

				minSwaps++;
			}
			else if(arr[higher] <= k && arr[lower-1]> k ){

				minSwaps--;
			}
			
			finalAns=Math.min(minSwaps, finalAns);
		}

		System.out.println(finalAns);
	}
}
