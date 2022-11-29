package com.datastructures.MATRIX;

public class SpecificPairInMatrix {
	static int findMaxValue(int N,int mat[][])
	{
		// stores maximum value
		int maxValue = Integer.MIN_VALUE;
		for (int a = 0; a < N - 2; a++)
			for (int b = 0; b < N - 2; b++)

				for (int d = a + 1; d < N; d++)
					for (int e = b + 1; e < N; e++)

						if (maxValue < (mat[d][e] - mat[a][b]))
							maxValue = mat[d][e] - mat[a][b];

		return maxValue;
	}

	static int optimizedFindMaxValue(int n,int mat[][]) {

		int array[]= new int[n];
		int max = -999 , min = 999,maxRowIndex=0,maxColIndex=0 ; 
		for(int i=1 ; i<n;i++){
			
			array=mat[i];
			for(int j=1;j<n;j++){
				
				if(array[j]>max){
					max=array[j];
					maxRowIndex= i;
					maxColIndex = j;
				}
			}
		}
		for(int i=0 ;i<maxRowIndex;i++){
			
			for(int j=0;j<maxColIndex ;j++){
			
				if(mat[i][j]<min){
					min = mat[i][j];
				}
			}
		}
		System.out.print(max-min);
		return (max-min);
    }

	public static void main (String[] args)
	{
		
		int mat[][] = 
			{
					{ 1, 2, -1, -4, -20 },
					{-8, 3,  4,  2,   1 },
					{ 3, 8,  6,  1,   3 },
					{-4,-1,  1,  7,  -6 },
					{ 0,-4, 10, -5,   1 }
			};
		int N = mat.length;
//		{ -20, -4, 1, -4, -20 },
//		{-8, 3,  4,  2,   1 },
//		{ 3, 8,  6,  1,   3 },
//		{-4,-1,  1,  7,  -6 },
//		{ 0,-4, 10, -5,   1 }



//				int mat[][] = {
//						{1 ,5},
//						{4,2 }
//				};
		System.out.print("Ans " +
				optimizedFindMaxValue(N,mat));
	}
}