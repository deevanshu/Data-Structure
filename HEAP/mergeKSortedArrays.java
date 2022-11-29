package com.datastructure.HEAP;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class mergeKSortedArrays {

	public static void main(String args[]) {

		int k=3;
		int arr[][] = new int[][] {

			{1,2,3},
			{4,5,6},
			{7,8,9}
		};

		//		int k=2;
		//		int arr[][] = new int[][] {
		//
		//			{57,81},
		//			{63,71}
		//		};

		ArrayList<Integer> ans = mergeKArrays(arr, k );

		for(int i : ans) {
			System.out.print(i+" ");
		}
	}

	public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
	{

		ArrayList<Integer> answer =  new ArrayList<Integer>();
		int [] index = new int[K];

		PriorityQueue<CustomSorts> minHeap = new PriorityQueue<>( new Comparator<>(){

			public int compare(CustomSorts s1, CustomSorts s2) {
				if (s1.value1 > s2.value1)
					return 1;
				else if (s1.value1 < s2.value1)
					return -1;

				return 0;
			}
		});

		for(int i = 0 ; i<K ; i++) {

			CustomSorts c1 = new CustomSorts(arr[i][0] , i);	
			minHeap.add(c1);
			index[i] = 0;
		}

		while(minHeap.size() >0){

			CustomSorts obj = minHeap.peek() ; 
			answer.add(obj.value1);
			minHeap.poll();
			if(index[obj.arrayNumber1] + 1 < arr[obj.arrayNumber1].length) {
				index[obj.arrayNumber1] = index[obj.arrayNumber1] + 1;
				int val = arr[obj.arrayNumber1][index[obj.arrayNumber1]];
				CustomSorts objCreate = new CustomSorts( val  , obj.arrayNumber1);
				minHeap.add(objCreate) ;
			}
		}

		return answer;
	}
}

class CustomSorts{

	int value1;
	int arrayNumber1;

	public CustomSorts(int value1 , int arrayNumber1){

		this.value1 = value1;
		this.arrayNumber1 = arrayNumber1;
	}  
}