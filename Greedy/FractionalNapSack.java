package com.datastructure.Greedy;
import java.util.Arrays;
import java.util.Comparator;

class Item{

	int val , weight;

	Item(int x , int y){

		this.val=x;
		this.weight=y;
	}
}
class itemComparator implements Comparator<Item>{

	@Override
	public int compare(Item a, Item b) {

		double r1 = (double)(a.val) / (double)(a.weight);
		double r2 = (double)(b.val) / (double)(b.weight);
		if(r1<r2) {
			return 1;
		}
		else {

			return -1;
		}
	}
}

public class FractionalNapSack {

	private static double getMaxValue(Item arr[], int totalWeight)
	{
		Arrays.sort(arr , new itemComparator());
		int currWeight = 0;
		int currValue  = 0;

		for(int i=0;i<arr.length;i++) {

			if(currWeight + arr[i].weight <=totalWeight) {

				currWeight = currWeight + arr[i].weight;
				currValue  = currValue  + arr[i].val ;
			}
			else {
				
				int remaining  = totalWeight - currWeight;
				double finalValue = ( (double)arr[i].val / (double)arr[i].weight ) * (double)remaining ;
				break;
			}
		}
		return (double)currValue;
	}

	public static void main(String[] args)
	{
		int[] wt = { 10, 40, 20, 30 };
		int[] val = { 60, 40, 100, 120 };

		Item array[] = new Item[5];

		for(int i=0;i<wt.length;i++) {
			
			array[i] = new Item(wt[i] , val[i]); 
		}
//		Item I1 = new Item(60  ,10);
//		Item I2 = new Item(40  ,40);
//		Item I3 = new Item(100 ,20);
//		Item I4 = new Item(120 ,30);
//
//		array[0] = I1;
//		array[1] = I2;
//		array[2] = I3;
//		array[3] = I4;

		int totalWeight = 50;

		double maxValue = getMaxValue(array , totalWeight);

		// Function call
		System.out.println("Maximum value we can obtain = "
				+ maxValue);
	}
}