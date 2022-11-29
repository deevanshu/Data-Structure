package com.datastructures.MATRIX;

public class RowWithMaxone {


	static int R = 4, C = 4;
	// Function that returns index of row
	// with maximum number of 1s.
	static int rowWithMax1s(int mat[][])
	{
		int j,max_row_index = -1;
		j = C - 1;

		for (int i = 0; i < R; i++) {

			while (j >= 0 && mat[i][j] == 1) {
				j = j - 1; 
				max_row_index = i; 
			}
		}

		return max_row_index;
	}
	// Driver Code
	public static void main(String[] args)
	{
		int mat[][] = {
				{ 1, 1, 1, 1 },
				{ 0, 1, 1, 1 },
				{ 1, 1, 1, 1 },
				{ 0, 0, 0, 0 } };
		System.out.println("Index of row with maximum 1s is "+ rowWithMax1s(mat));
	}
}
