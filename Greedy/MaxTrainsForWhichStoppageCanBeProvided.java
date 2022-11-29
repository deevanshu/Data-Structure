package com.datastructure.Greedy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class MyComparatorArray implements Comparator<sortArray>{

	@Override
	public int compare(sortArray o1, sortArray o2) {
		if(o1.end - o2.end >0) {
			return 1;
		}
		else {

			return -1;
		}
	}
}
public class MaxTrainsForWhichStoppageCanBeProvided {

	public static void main(String args[]) {

		int m=2 , n=5;

		int arr[][] = {
				{1000, 1030, 1} ,
				{1010, 1020, 1} ,
				{1025, 1040, 1} ,
				{1130, 1145, 2} ,
				{1130, 1140, 2} 
		};

		sortArray [] array = new sortArray[arr.length];

		for(int i=0; i<arr.length; i++) {

			sortArray s11 =  new sortArray(arr[i][0] , arr[i][1] , arr[i][2]);
			array[i] = s11;
		}

		Arrays.sort(array, new MyComparatorArray());	
		System.out.println(array);

		//		int ar[] = new int[] {1,2,3,4};
		//		int ar1[] = new int[4];
		//		int arr1[][] = new int [2][3];

		sortArray [] array1 = new sortArray[2];
		ArrayList<sortArray> ar111 = new ArrayList<sortArray>(Arrays.asList(array1));
		int count=0;
		for(int i=0 ; i<array.length ;i++) {

			if(ar111.get(array[i].number)==null) {
				ar111.set( array[i].number, array[i]);
				count++;
			}
			else {

				if(ar111.get(array[i].number).end < array[i].start) {
					
					ar111.remove(array[i].number);
					ar111.set(array[i].number, array[i]);
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}

class sortArray{

	int start , end , number;

	public sortArray(int start ,int end ,int number) {

		this.end = end;
		this.start = start;
		this.number = number;
	}
}
