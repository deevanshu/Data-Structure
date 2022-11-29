package com.datastructures.ARRAYS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntrevals {

	public static void main (String args[]) {
//		int intervals [][] = { {1,3} ,  {5,5} , {2,6} , {15,18} };
		int intervals [][] = { {1,4} ,  {0,2} , {3,5}  };
		
		mergeIntervals(intervals);
	}
	//O(n2) solution is wid 2 for loops
	private static void  mergeIntervals(int[][] intervals) {

		//Arrays.sort(intervals, (a , b) -> a[0]-b[0] ) ;
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] - o2[0]>0) {
					
					return 1;
				}
				else {
				
				return -1;
				}
			}	
		}) ;
		
		int [][] resultarray = new int[intervals.length][2];

		int j=0 , start=0 , end=0;
		List<int[]> answer = new ArrayList<>();
		
		for(int i = 0 ;i<intervals.length-1; i++) {

			end = intervals[i][1];
			start = intervals[i+1][0];

			if(start <=end) {

				intervals[i+1][0]=intervals[i][0];
				intervals[i+1][1]=Math.max(intervals[i][1] , intervals[i+1][1]);
			}
			
			else {
				
				answer.add(intervals[i]);
				resultarray[j][0]=intervals[i][0];
				resultarray[j][1]=intervals[i][1];
				j++;
			}
		}

		answer.add(intervals[intervals.length-1]);
		int[][] array1 = answer.toArray( new int [answer.size()][]);

		for(int i=0;i<answer.size();i++) {

			System.out.println("["+array1[i][0] +","+array1[i][1]+"]" +"\n");
		}
	}
}