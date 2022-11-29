package com.datastructures.ARRAYS;

public class BuySellStock {

	public static void main(String args[]) {

		int arr[]= {7,1,5,3,6,4};
		System.out.println(maxProfit(arr));
	}

	public static int maxProfit(int[] prices) {
		int profit=0 , minimum=prices[0];
		for (int i = 1 ; i<prices.length; i++){

			minimum = Math.min(minimum , prices[i]);
			profit= Math.max(profit , prices[i] - minimum);
		}
		
		return profit;
	}
}
