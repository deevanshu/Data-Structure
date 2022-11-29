package com.datastructures.MATRIX;

import java.util.ArrayList;

public class SpriralTraversalMatrix {

	public static void main(String args[]) {

		int r = 4, c = 4, 
				matrix[][] = {
						{1, 2, 3, 4},
						{5, 6, 7, 8},
						{9, 10, 11, 12},
						{13, 14, 15,16}
		};

		ArrayList<Integer> ans = new ArrayList<>();
		int top=0, bottom=r-1, left=0, right=c-1,dir=0;

		while(top<=bottom && left<=right)
		{

			// FirstRow
			if(dir==0) {
				for(int i=left; i<=right; i++){

					System.out.println(matrix[top][i]);
				}
				top++;
				dir++;
			}

			else if(dir==1) {
				for(int i=top; i<=bottom; i++){

					System.out.println(matrix[i][right]);
				}
				right--;
				dir++;
			}

			else if(dir==2) {
				for(int i=right; i>=left; i-- ){

					System.out.println(matrix[bottom][i]);

				}
				bottom--;
				dir++;
			}

			else if(dir==3) {
				for(int i=bottom; i>=top; i-- ){

					System.out.println(matrix[i][left]);

				}
				left++;
				dir++;
			}
			dir=dir%4;
		}
	}
}