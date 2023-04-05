package com.datastructures.ARRAYS;
public class QuickSort {

	static int partition(int[] arr, int low, int high)
	{	
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
	
	/* The main function that implements QuickSort
			arr[] --> Array to be sorted,
			low --> Starting index,
			high --> Ending index
	 */
	static void quickSort(int[] arr, int low, int high)
	{
		if (low < high)
		{

			// pi is partitioning index, arr[p]
			// is now at right place
			int pi = partition(arr, low, high);

			// Separately sort elements before
			// partition and after partition
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	public static void main(String[] args)
	{
		//int[] arr = { 10, 7, 8, 9, 1, 5 };
		int[] arr = { 1,5,8,10 };
		int n = arr.length;

		quickSort(arr, 0, n - 1);
		System.out.println("Sorted array: ");
		printArray(arr, n);
	}

	// Function to print an array
	static void printArray(int[] arr, int size)
	{
		for(int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");

		System.out.println();
	}


}
