package com.datastructures.MATRIX;
import java.util.Stack;


public class MaxRectangleInMatrix {
	public static void main(String args[]) {

		int matrix[][] = {
				{0, 1, 1, 0},
				{1, 1, 1, 1},
				{1, 1, 1, 1},
				{1, 1, 0, 0}
		};

		int rows=matrix.length;
		int columns=matrix[0].length;
		
		int input[]=new int[columns];
		input=matrix[0];
		int max = largestInHistogram(matrix[0]);
		int resultFromRow=0;

		for(int i=1;i<rows;i++) {
			for(int j=0;j<columns;j++) {

				if(matrix[i][j]==0) {
					input[j]=0;
				}
				else {
					input[j]=input[j]+1;
				}
			}
			resultFromRow=largestInHistogram(input);
			max=Math.max(resultFromRow, max);
		}

		System.out.println("Ans:"+max);
	}
	private static int largestInHistogram(int[] hist) {

		int left [] = new int[hist.length];
		int right[] = new int[hist.length];
		int max=0;

		Stack<Integer> st= new Stack<>();
		int n=hist.length-1;
		//	System.out.println(n);
		for(int i=0;i<hist.length;i++) {

			if(st.empty()) {   // 0 1 1 0
				left[i]=0;
				st.push(i);
				continue;
			}
			if(hist[i] > hist[st.peek()]) {
				left[i]=st.peek()+1;
				st.push(i);
			}else {

				while(st.size()>0 && hist[st.peek()] >= hist[i] ) {
					st.pop();
				}
				if(st.size()>0) {
					left[i]=st.peek() + 1  ;
				}
				else {
					left[i]=0;
				}
				st.push(i);
			}
		}
		st=new Stack<>();
		for(int i=n;i>=0;i--) {

			if(st.empty()) {
				right[i]=hist.length-1;
				st.push(i);
				continue;
			}
			if(hist[i] > hist[st.peek()]) {
				right[i]=st.peek()-1;
				st.push(i);
			}else {

				while(st.size()>0 && hist[st.peek()] >= hist[i] ) {
					st.pop();
				}
				if(st.size()>0) {
					right[i]=st.peek() - 1  ;
				}
				else {
					right[i]=hist.length-1;
				}
				st.push(i);
			}
		}
		int area=0;
		for(int i=0;i<n;i++) {

			area=(right[i]-left[i]+1 ) * hist[i];
			max=Math.max(max, area);
		}
		System.out.println(max);
		return max;
	}
}