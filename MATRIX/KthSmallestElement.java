package com.datastructures.MATRIX;

public class KthSmallestElement {
	//
	//	public static void main (String[] args) {
	//
	//		int mat[][] = { 
	//              { 10, 20, 30, 40 },
	//				{ 15, 25, 35, 45 },
	//				{ 25, 29, 37, 48 },
	//				{ 32, 33, 39, 50 } };
	//		int res = kthSmallest(mat, 4, 7);
	//
	//		System.out.print("7th smallest element is "+ res);
	//	}
	//
	//	static int kthSmallest(int[][]mat,int n,int k)
	//	{
	//
	//		int[] a=new int[n*n];
	//		int v=0;
	//
	//		for(int i=0;i<n;i++){
	//			for(int j=0;j<n;j++){
	//				a[v]=mat[i][j];
	//				v++;
	//			}
	//		}
	//
	//		Arrays.sort(a);
	//		int result=a[k-1];
	//		return result;
	//	}

	// This returns count of elements in
	// matrix less than of equal to num
	static int getElementsGreaterThanOrEqual(int num, int n, int mat[][])
	{
		int ans = 0;

		for (int i = 0; i < n; i++)
		{

			// if num is less than the first element
			// then no more element in matrix
			// further are less than or equal to num
			if (mat[i][0] > num) {
				return ans;
			}

			// if num is greater than last element,
			// it is greater than all elements
			// in that row
			if (mat[i][n - 1] <= num) {
				ans += n;
				continue;
			}

			// This contain the col index of last element
			// in matrix less than of equal
			// to num
			int greaterThan = 0;
			for (int jump = n / 2; jump >= 1; jump /= 2) {
				while (greaterThan + jump < n &&
						mat[i][greaterThan + jump] <= num) {
					greaterThan += jump;
				}
			}

			ans += greaterThan + 1;
		}
		return ans;
	}

	// reuturs kth smallest index in the matrix
	static int kthSmallest(int mat[][], int n, int k)
	{
		int l = mat[0][0], r = mat[n - 1][n - 1];

		while (l <= r) {
			int mid = l + (r - l) / 2;
			int greaterThanOrEqualMid = getElementsGreaterThanOrEqual(mid, n, mat);

			if (greaterThanOrEqualMid >= k)
				r = mid - 1;
			else
				l = mid + 1;
		}
		return l;
	}

	public static void main(String args[]) {
		int mat[][] = {

				{ 10, 20, 30, 40 },
				{ 15, 25, 35, 45 },
				{ 25, 29, 37, 48 },
				{ 32, 33, 39, 50 },
		};
		System.out.println("7th smallest element is " + kthSmallest(mat, 4, 7));
	}
}
