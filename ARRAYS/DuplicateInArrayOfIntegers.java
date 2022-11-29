package com.datastructures.ARRAYS;

public class DuplicateInArrayOfIntegers {

	public static void main(String args[]) {

		//      METHOD 1  to find more than 1 duplicate and orig array signs changed

				int array[] = {1,3,4,2,2};
		
				for(int i=0 ; i < array.length ; i++) {
		
					if(array[Math.abs(array[i])] < 0 ) {
		
						System.out.println(Math.abs(array[i]) +"\t");
					}
					else {
		
						array[Math.abs(array[i])] = - array[Math.abs(array[i])];
					}
				}

		//      METHOD 2 Only 1 duplicate and original array not modified

		
		//      METHOD 3 Sorting can also be done 


//		int fast=0 , slow=0 ;
//	//	int array[] = {1, 2, 3, 4, 2};
//
//		slow = array[slow];
//		fast = array[array[fast]];
//
//		while(slow!=fast) {
//
//			slow = array[slow];
//			fast = array[array[fast]];
//		}
//
//		slow = 0;
//		while(slow!=fast) {
//
//			slow = array[slow];
//			fast = array[fast];
//		}

	//	System.out.println(fast);
	}
}