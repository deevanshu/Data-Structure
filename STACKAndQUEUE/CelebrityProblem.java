package com.datastructures.STACKAndQUEUE;

import java.util.Stack;

public class CelebrityProblem {

	// Person with 2 is celebrity
	//	static int MATRIX[][] = { { 0, 0, 1, 0 },
	//							{ 0, 0, 1, 0 },
	//							{ 0, 0, 0, 0 },
	//							{ 0, 0, 1, 0 } };

	static int M[][] = {
			{ 0, 0, 0 },
			{ 0, 0, 0 },
			{ 0, 0, 0 }

	};

	static boolean knows(int a, int b)
	{
		boolean res;
		return  res = (M[a][b] == 1) ? true :false;
	}

	static int findCelebrity(int n)
	{
		Stack <Integer > st = new Stack<>();

		for(int i=0;i<n;i++){

			st.push(i);
		}

		while(st.size() > 1 ){

			int a = st.pop();
			int b = st.pop() ;

			if(knows(a , b)  && !knows(b , a) ){

				st.push(b);
			}
			else if (knows(b , a)  && !knows(a , b) ){

				st.push(a);
			}

		}

		if(st.size()>0){

			int temp = st.peek();
            int rowZeroCountOfPotentialCeleb = 0;
            boolean rowCheck = false , colCheck=false;
			for(int i=0 ; i<n ; i++){

				if(M[temp][i]==0) {
					
					rowZeroCountOfPotentialCeleb++;
				}
			}

			if(rowZeroCountOfPotentialCeleb == n) {
				
				rowCheck = true;
			}
			
			 int colZeroCountOfPotentialCeleb = 0;
			for(int i=0 ; i<n ; i++){

				if(M[i][temp]==1) {
					
					colZeroCountOfPotentialCeleb++;
				}
			}

			if(colZeroCountOfPotentialCeleb == n-1) {
				
				colCheck = true;
			}
			
			
			if(rowCheck && colCheck) {
				
				return temp;
			}
			else {
				return -1;
			}
		}
		else{

			return -1;
		}
	}

	public static void main(String[] args)
	{
		int n = 3;
		int result = findCelebrity(n);
		if (result == -1)
		{
			System.out.println("No Celebrity");
		}
		else
			System.out.println("Celebrity ID " +
					result);
	}
}