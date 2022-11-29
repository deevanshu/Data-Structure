package com.datastructures.ARRAYS;

public class MaxProBuyAndSellStockTwice {

	public static void main(String args[]) {

		int price[] = {10, 22, 5, 75, 65, 80};
		
		int Ma=price[price.length-1],Mi=price[0];

		int profit[]= new int[price.length];

		for (int i = 0; i < price.length; i++)
		{ 
			profit[i] = 0;
		}

		for(int i=price.length-2;i>=0;i--) {

			if (price[i] > Ma)
			{
				Ma = price[i];
			}

			profit[i]= Math.max(profit[i+1], Ma-price[i]);
		}
		for(int i=1;i<price.length;i++) {

			if (price[i] < Mi)
			{
				Mi = price[i];
			}
			profit[i]= Math.max(profit[i-1],profit[i]+ price[i] - Mi);
		}

		for(int i=0;i<profit.length;i++) {

			System.out.println(profit[i]);
		}
	}
}