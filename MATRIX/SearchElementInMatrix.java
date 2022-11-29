package com.datastructures.MATRIX;

public class SearchElementInMatrix {

	public static void main(String args[]) {
		int matrix[][] = {
				{1 ,  3,  5, 7 },
				{10, 11, 16, 20},
				{23, 30, 34, 60}
		};
		int target=3;

		int i = 0; 
		int j = matrix[0].length - 1;
		boolean res=false;
		if(target < matrix[0][0]  || target > matrix[matrix.length-1][matrix[0].length - 1]){
			res=false;
		}
		while (j >= 0 && i < matrix.length) {

			if (matrix[i][j]  < target) {
				i++;
			}
			else if (matrix[i][j] > target) {
				j--;
			}

			else {
				res=true;
				break;
			}
		}
		System.out.println(res);
	}
}
