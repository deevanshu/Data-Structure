package com.datastructures.MATRIX;
import java.util.Stack;

public class LargestRectAreaInHistogram {

	public static void main(String args[]) {

		int hist[]= {0,1,1,0};
		int left[] =new int[hist.length];
		int right[]=new int[hist.length];
		int max=0;

		Stack<Integer> st= new Stack<>();
		int n=hist.length-1;
		System.out.println(n);
		for(int i=0;i<hist.length;i++) {

			if(st.empty()) {
				left[i]= -1;
				st.push(i);
				continue;
			}

			if( hist[i] > hist[st.peek()]) {
				left[i] = st.peek();
				st.push(i);
			}

			else {
				while( st.size()>0 && hist[st.peek()] >= hist[i] ) {
					st.pop();
				}
				if(st.size()>0) {
					left[i]=st.peek()  ;
				}
				else {
					left[i]=-1;
				}
				st.push(i);
			}
		}
		st=new Stack<>();
		for(int i = n-1;i>=0;i--) {

			if(st.empty()) {
				right[i]=hist.length;
				st.push(i);
				continue;
			}
			if(hist[i] > hist[st.peek()]) {
				right[i]=st.peek();
				st.push(i);
			}else {

				while(st.size()> 0 && hist[st.peek()] >= hist[i] ) {
					st.pop();
				}
				if(st.size()>0) {
					right[i]=st.peek()  ;
				}
				else {
					right[i]=hist.length;
				}
				st.push(i);
			}
		}
		int area=0; 
		            // 0 1 1 0
		
		 //  PS   // -1 0 0 -1
		//   NS  //   4 3 3  4
		for(int i=0;i<n;i++) {

			area=(right[i]-left[i]-1 ) * hist[i];
			max=Math.max(max, area);
		}
		System.out.println(max);
	}
}