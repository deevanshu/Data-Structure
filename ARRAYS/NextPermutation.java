package com.datastructures.ARRAYS;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String args[]) {

		int nums[] = {1,3,2};

		nextPermutation(nums);	

		for(int i =0 ; i< nums.length ; i++) {

			System.out.print(nums[i] +"\t");
		}
	}

	private static void nextPermutation(int[] nums) {

		int peakFromRight=-1 , i=1;

		while(i<nums.length) {

			if(nums[i] > nums[i-1]) {

				peakFromRight = i;
			}
			
			i=i+1;
		}

		if(peakFromRight==-1) {

			sorting(nums , 0 , nums.length-1);
			return ;
		}
		int index = peakFromRight;

		// check for special case 
		
		for(int j = peakFromRight+1 ; j<nums.length ; j++) {

			if(nums[j] > nums[peakFromRight-1] && nums[j] < nums[peakFromRight]) {

				index = j;
			}
		}

		//
		
		swap (nums , peakFromRight-1, index);

		if(peakFromRight<nums.length-1 ) {
		//	sorting(nums ,peakFromRight ,nums.length-1);
			Arrays.sort(nums, peakFromRight, nums.length);
		}
	}

	private static void swap(int arr[] , int i, int j) {

		int temp = arr[i];
		arr[i]= arr[j]; 
		arr[j]= temp;

	}

	private static void sorting(int[] nums, int low, int high) {

		if(low < high) {

			int pi = partition(nums, low, high) ;
			sorting(nums ,low, pi-1);
			sorting(nums ,pi+1 , high);
		}

	}

	private static int partition(int[] arr, int low, int high) {
		// pivot
		int pivot = arr[high];

		// Index of smaller element and
		// indicates the right position
		// of pivot found so far
		int i = (low - 1);

		for(int j = low; j <= high - 1; j++)
		{

			// If current element is smaller
			// than the pivot
			if (arr[j] < pivot)
			{

				// Increment index of
				// smaller element
				i++;

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;

		return (i + 1);
	}
}