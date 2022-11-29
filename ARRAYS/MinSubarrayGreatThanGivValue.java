package com.datastructures.ARRAYS;

public class MinSubarrayGreatThanGivValue {

	public static void main(String args[]) {


		int arr[] = {1, 2, 4} ; // 0,1,4,6,19,45
		int x  =  280;
		int sum=0,index=-1 ,lower=0;
		// {1 ,5, 50,56, 56,75 }
		// {76,75,70,25, 19,19 }


		//		{1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
		//		{1, 12, 112,113,113,313,316,318,319,569}
		//	 x=280


		int leftSub[]=new int[arr.length];

		for(int i=0;i<arr.length;i++) {

			sum=sum+arr[i];
			leftSub[i]=sum;
			if(sum>=x && index==-1) {

				index=i;
			}
		}
		if(index==-1) {
			System.out.println("Does Not Exist");
		}
		else {
			sum=0;
			for(int i=index;i>=0;i--) {

				sum	= sum+arr[i];
				if(sum>x) {

					lower=i;
					break;
				}
			}
		}
		for(int i=lower;i<=index;i++) {

			System.out.println(arr[i]+"\t");
		}
	}
}
