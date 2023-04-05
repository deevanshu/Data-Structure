package com.datastructures.ARRAYS;

public class SubarrayWidMaxproduct {

	public static void main(String args[]) {

		int Arr[] = {6, -3, -10, 0, 2};

		int start=0,high=0 , product=1 , maxProd = 0;

		for(int i=0 ; i<Arr.length;i++) {

			product=product*Arr[i];

			if(maxProd<product) {
				maxProd=product;
				high=i;
			}
		}

		System.out.println("From"+start+"to"+high+"index :"+maxProd);

	}
}
