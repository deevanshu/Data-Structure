package com.datastructures.ARRAYS;

import java.util.Arrays;

public class TripletSumInArray {
	public static void main(String args[]) {

		int arr[] = {1, 4, 45, 6, 10, 8};
		int X = 13;
		boolean found =false;
		Arrays.sort(arr); // 1 , 4 , 6 ,8 , 10 ,45 ;

		for(int i=0;i<arr.length;i++) {

			int l=0 ,r=arr.length-1;

			while(l<r) {

				if(l==i) {
					l++;
					continue;
				}
				else if(arr[l] + arr[r]+arr[i]==X) {
					System.out.println("Element that form Triplet are : "+arr[i] +" "+ arr[l] +" "+ arr[r]);
					found = true;
					break;
				}
				else if(arr[l] + arr[r]+arr[i] > X) {
					r--;

				}
				else {
					l--;
				}
			}
			if(found) {
				break;
			}
		}
		if(!found) {
			System.out.println("Not Found");
		}
	}
}


