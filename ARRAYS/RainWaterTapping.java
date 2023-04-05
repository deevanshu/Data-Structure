package com.datastructures.ARRAYS;

public class RainWaterTapping {


	public static void main(String args[]) {
		int arr[] = {6,9,9};

		if(arr.length==0 || arr.length ==1){

			System.out.println(0);
		}
		long ans = 0 ;
		int  leftMax = arr[0] , rightMax = arr[arr.length-1] ;

		int left = 1 , right = arr.length-2;

		while(left<=right){

			if(leftMax < rightMax){

				if(arr[left]  >= leftMax){

					leftMax = arr[left];

				}
				else{

					ans += leftMax - arr[left] ;
				}

				left++ ;
			}
			else{

				if(arr[right]  >= rightMax){

					rightMax = arr[right] ;

				}
				else{

					ans += rightMax - arr[right] ;
				}
				right -- ;

			}
		}

		System.out.println(ans);


	}
}