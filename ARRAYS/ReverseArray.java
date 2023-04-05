package com.datastructures.ARRAYS;


//Input  : arr[] = {1, 2, 3,4,5}
//Output : arr[] = {5,4,3, 2, 1}

public class ReverseArray {

	public static void main (String args[]) {
		
		int inputArray[] = {1,2,3};
		
		int outputArray[]=reverseArray(inputArray);
		
		printArray(outputArray);
	}

	public  static void printArray(int[] outputArray) {
		for(int i=0;i<=outputArray.length-1;i++) {
			
			System.out.println(outputArray[i]+"\n");
		}
		
	}

	public static  int[] reverseArray(int[] inputArray) {
		
		int start=0 , end=inputArray.length-1;
		
		for(int i=0;i<inputArray.length-1 ; i++) {
			
			if(start!=end) {
				
				int temp=inputArray[start];
				inputArray[start]=inputArray[end];
				inputArray[end]=temp;
				start++;
				end  --;
			}
			else {
				break;
			}
		}
		return inputArray;
	}
	
}
