package com.datastructures.MATRIX;

public class RotateMatrixBy90Degrees {

	public static void main(String[] args)
	{
//		int mat[][] = {
//				{ 10,20,30,40},
//				{ 15,25,35,45},
//				{ 27,29,37,48},
//				{ 32,33,39,50} };


		int mat[][] = {
				{ 1,2,3},
				{ 4,5,6},
				{ 7,8,9}
				};
		//transpose of mat : convert rows into columns  

		for(int i=0;i<mat.length;i++) {

			for(int j=i+1;j<mat[0].length;j++) {

				int temp = mat[i][j];
				mat[i][j]=mat[j][i];
				mat[j][i]=temp;
			}
		}

//		[1, 4, 7],
//		[2, 5, 8],
//		[3, 6, 9]
		
//		[
//		 [7, 4, 1],
//		 [8, 5, 2],
//		 [9, 6, 3]
//				 ]
		
		//  END  // 
//		for(int i=0;i<mat.length;i++) {
//
//			int low=0,high=mat[0].length-1;
//			while(low<high) {
//
//				int temp=mat[i][low];
//				mat[i][low]=mat[i][high];
//				mat[i][high]=temp;
//				low++;
//				high--;
//			}
//		}
//		{
//		 [32, 27, 15, 10],
//		 [33, 29, 25, 20], 
//		 [39, 37, 35, 30],
//		 [50, 48, 45, 40]
//		}
        int low = 0, high = mat[0].length-1;
        while(low < high){
            
            for(int i=0 ; i<mat.length ; i++){
                
               int temp = mat[i][low] ;
               mat[i][low] = mat[i][high];
               mat[i][high] = temp;
            }
            low++;
            high--;
        } 
		System.out.println("h");

	}
}