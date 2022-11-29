package com.datastructures.STRINGS;

public class ReverseAString {


	public static void main(String args []) {

		char array [] = {'h','e','l','l','o'};
		int low =0 , high=array.length-1;

		for(int i=0;i<=array.length-1;i++) {

			System.out.println(array[i]);

		}
		
		while(low < high) {

			char temp   = array[low];
			array[low]  = array[high];
			array[high] = temp;
			low++;
			high--;

		}
		for(int i=0;i<=array.length-1;i++) {

			System.out.println(array[i]);

		}
	}
}
