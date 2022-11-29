package com.datastructures.ARRAYS;

import java.util.ArrayList;

/* Java program for Merge Sort */
class InversionCount
{
	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	int  merge(int arr[], int l, int m, int r)
	{
		int inversion=0;
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/*Copy data to temp arrays*/
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */


		int cnt = 0;
		int j1 = m + 1; 

		for(int i = l;i<=m;i++) {
			while(j1<=r && arr[i] > (2 * (long) arr[j1])) {
				j1++;
			}
			cnt += (j1 - (m+1));
		}

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {

			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				//	inversion=inversion + n1 - i;    // as both arrays are sorted arrays  therefore if L[i] > R[j] that means all the elements after it will be larger 
				// and whole length is n1 , therefore elements after ith index are ( n1 -i)
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}

		return cnt;
	}

	// Main function that sorts arr[l..r] using
	// merge()
	int  sort(int arr[], int l, int r)
	{
		int count = 0 , inversion=0 ;
		if (l < r) {
			// Find the middle point
			int m = l+ (r-l)/2;

			// Sort first and second halves
			inversion+=sort(arr, l, m);
			inversion+=sort(arr, m + 1, r);

			// Merge the sorted halves
			inversion+=merge(arr, l, m, r);
		}
		return inversion;
	}

	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[])
	{
		//		int arr[] = { 12, 11, 13, 5, 6, 7 };
		int arr[] = { 40 ,25,19 ,12,9,6,2};

		System.out.println("Given Array");
		printArray(arr);

		InversionCount ob = new InversionCount();
		int inversion = ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);
		System.out.println(inversion);
	}
}