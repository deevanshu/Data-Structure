package com.datastructures.ARRAYS;
public class MaxProdSubarray {

	public static void main (String args[]) {
		int  arr[] = {6, -3, -10, 0, 2};

		Long ans = maxProdSubarray(arr);
	}
	static long maxProdSubarray(int arr[]) {

		int max=1 , min=1, ans=arr[0];

		for(int i=0;i<arr.length;i++) {

			if(arr[i]==0) {


				max=1;
				min=1;
			}

			int temp = arr[i]*max;

			max = Math.max(min*arr[i],Math.max(arr[i],arr[i]*max));
			min = Math.min(temp,Math.min(arr[i],min*arr[i]));

			ans = Math.max(ans, Math.max(min,max) );
		}

		System.out.println(ans);
		return ans;

	}
}
