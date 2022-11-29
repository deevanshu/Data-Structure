package com.datastructures.ARRAYS;
public class MergeTwoSortedArray {// { Driver Code Starts

	// Driver code
	public static void main(String[] args) throws Exception {

		//		int arr1[] = {1, 3, 5, 7};
		//		int arr2[] = {0, 2, 6, 8, 9}; 

		int arr1[] = {1,2,3,0,0,0};
		int arr2[] = {2, 5 ,6}; 

		int n = arr1.length;
		int m = arr2.length;

		merge(arr1 ,arr2 , n ,m);
	}

	public static void merge(int nums1[], int nums2[], int m, int n) {

		//		if(n<m){
		//			int upperArr1 = 0 , lowerArr2 = 0 ;
		//			for(int i=0 ; i<n ; i++){
		//
		//				if(arr1[upperArr1] < arr2[lowerArr2]){
		//
		//					System.out.println(arr1[upperArr1]+" ");
		//					upperArr1++;
		//
		//				}
		//				else{
		//
		//					int temp = arr2[lowerArr2] ;
		//					arr2[lowerArr2] = arr1[upperArr1] ;
		//					arr1[upperArr1] = temp ;
		//
		//					if(arr2[lowerArr2] > arr2[lowerArr2 +1]){
		//
		//						temp = arr2[lowerArr2] ;
		//						arr2[lowerArr2] = arr2[lowerArr2+1] ;
		//						arr2[lowerArr2+1] = temp ;
		//
		//					}
		//					System.out.println(arr1[upperArr1]+" ");
		//					upperArr1++;
		//				}
		//			}
		//
		//			System.out.println(arr2[0]+" ");
		//
		//			for(int i=1 ; i<m-1;i++){
		//
		//				if(arr2[i] > arr2[i+1]){
		//
		//					int temp = arr2[i] ;
		//					arr2[i] = arr2[i+1] ;
		//					arr2[i+1] = temp ;
		//					System.out.println(arr2[i]+" ");
		//				}
		//				else{
		//					System.out.println(arr2[i]+" ");
		//				}
		//			}
		//			System.out.println(arr2[arr2.length-1]+" ");
		//
		//		}
		//		else{
		//			int upperArr1 = 0 , lowerArr2 = 0 ;
		//			for(int i=0 ; i<m ; i++){
		//
		//				if(arr2[upperArr1] < arr1[lowerArr2]){
		//
		//					System.out.println(arr2[upperArr1]+" ");
		//					upperArr1++;
		//				}
		//				else{
		//
		//					int temp = arr1[lowerArr2] ;
		//					arr1[lowerArr2] = arr2[upperArr1] ;
		//					arr2[upperArr1] = temp ;
		//
		//					if(arr1[lowerArr2] > arr1[lowerArr2 +1]){
		//
		//						temp = arr1[lowerArr2] ;
		//						arr1[lowerArr2] = arr1[lowerArr2+1] ;
		//						arr1[lowerArr2+1] = temp ;
		//
		//					}
		//					System.out.println(arr2[upperArr1]+" ");
		//					upperArr1++;
		//				}
		//			}
		//			
		//			System.out.println(arr1[0]+" ");
		//			
		//			for(int i=1 ; i<n-1;i++){
		//				if(arr1[i] > arr1[i+1]){
		//
		//					int temp = arr1[i] ;
		//					arr1[i] = arr1[i+1] ;
		//					arr1[i+1] = temp ;
		//					System.out.println(arr1[i]+" ");
		//				}
		//				else {
		//					System.out.println(arr1[i]+" ");
		//				}
		//			}
		//			System.out.println(arr1[arr1.length-1]+" ");
		//		}

		//        int nums1Ptr=0 , nums2Ptr=0 , swapPosition=nums1.length -1;
		//        for(int i=0 ; i<nums1.length ; i++){
		//            
		//            if(nums1[nums1Ptr]  <= nums2[nums2Ptr]){
		//                
		//                nums1Ptr++;
		//            }
		//            else{
		//                int temp = nums1[swapPosition];
		//                nums1[swapPosition] = nums2[nums2Ptr];
		//                nums2[nums2Ptr]=temp;
		//                nums2Ptr++;
		//                swapPosition--;
		//            }
		//        }
		//        Arrays.sort(nums1);
		//        Arrays.sort(nums2);

		int p1 = n-1;
		int p2 = n-1;
		int i = m-1;
		while(p2>=0){
			if(p1>=0 && nums1[p1]>nums2[p2]){
				nums1[i--] = nums1[p1--];
			} else{
				nums1[i--] = nums2[p2--];
			}
		}
	}
}