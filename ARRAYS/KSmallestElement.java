package com.datastructures.ARRAYS;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class KSmallestElement {  //sorting can also be done

	public static void main (String args[]) {
		int k = 2;
		int[] inputArray = { 12, 3, 5, 3, 3 };

		ksmallestElement(inputArray , k);

	}

	private static void ksmallestElement(int[] inputArray , int k) {

		TreeMap <Integer , Integer> tm = new TreeMap<>();

		for(int i=0 ; i<inputArray.length ; i++) {

			int freq=1;
			if(tm.containsKey(inputArray[i])) {

				tm.put(inputArray[i],tm.get(inputArray[i]) +1 );
			}
			else {

				tm.put(inputArray[i], 1);
			}

		}
	
		
		int count=0;
		for(Map.Entry<Integer, Integer> it : tm.entrySet()) {
	
			 count=count + it.getValue();
			
			 if(count>=k) {
				 
				 System.out.println("Element is :" + it.getKey());
				 break;
			 }
		}
	}
}
