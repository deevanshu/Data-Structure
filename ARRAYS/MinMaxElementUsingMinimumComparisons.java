package com.datastructures.ARRAYS;

public class MinMaxElementUsingMinimumComparisons {
	
	public static void main(String args[]) {
		
		int inputArray[] = {1000, 11, 445, 1, 330, 3000};
		
		MinMaxFinder(inputArray);
		
	}
	
	private static void MinMaxFinder(int array[]) {
		
		int min=0,max=0 , i=0;
		if(array.length%2==0) { // to make rest array as pair of elements
			
			if(array[0] > array[1]) {
				
				max=array[0];
				min=array[1];
				
			}
			else {
				max=array[1];
				min=array[0];
				
			}
			
			i=2;
		}
		else {
			min=array[0];
			max=array[0];
			i=1;
		}
		
		while(i<array.length-1) {
			
	     if(array[i]>array[i+1]) {
	    	 
	    	 if(array[i]>max) {
	    		 max=array[i];
	    	 }
	    	 if(array[i+1]<min) {
	    		 min =array[i+1];
	    	 }
	    		 
	     }	
	     else {
	    	 if(array[i+1]>max) {
	    		 max=array[i+1];
	    	 }
	    	 if(array[i]<min) {
	    		 min =array[i];
	    	 }
	    	 
	     }
	     i=i+2;
		}
	//	for even compar -> 1+ 3*(n-2)/2 
//		for odd compar ->   3*(n-1)/2 
		System.out.println("min :"+ min +"\n" + "max :" + max);
	}

}
