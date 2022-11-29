package com.datastructures.ARRAYS;

public class MinimiseHeightDifferenceBwMaxMinVal {

	public static void main (String args[]) {

		int k = 3;
		int arr[] = {3, 12, 9, 20 , 16};
		//	int Arr[] = {1, 5, 8, 10};

		int sortArr[] = sorting(arr , 0 , arr.length-1); // 3 , 9 , 12 , 16 , 20  ->  17 

		int Min =  sortArr[0] + k , Max=sortArr[sortArr.length-1] - k ;

		int ans =  Max - Min ;//sortArr[sortArr.length-1] - sortArr[0];

		for(int i = 0; i < sortArr.length-1 ; i++) {

				Min = Math.min(Math.min((sortArr[i] + k) , (sortArr[i+1] - k) ) ,  Min );
			    Max = Math.max(Math.max((sortArr[i] + k) , (sortArr[i+1] - k) ) ,  Max );

			if(Min < 0 || Max < 0) {
				continue;
			}

			ans = Math.min(ans, Max-Min);
		}

		System.out.println(ans);
	}

	private static int[] sorting(int[] arr, int l, int h) {

		if(l<h) {

			int pi= partition(arr , l , h);
			sorting(arr , l , pi-1);
			sorting(arr , pi+1 , h);
		}

		return arr;
	}

	private static int partition(int[] arr, int l, int h) {


		int pivot = arr[h];

		int i =l-1;

		for(int j=l ; j<= h-1 ; j++) {

			if(arr[j] < pivot) {
				i++;

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[h];
		arr[h] = temp;

		return i+1;
	}
}
