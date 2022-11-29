package com.datastructures.ARRAYS;

import java.util.HashMap;
import java.util.HashSet;

public class ArraySubsetOfOtherArray {

	public static void main(String args[]) {

		int a1[] = {11, 1, 13, 21, 3, 7};
		int a2[] = {11, 3, 7, 1};

        boolean isSubset=true;
		HashMap<Integer , Integer >hs = new HashMap<Integer , Integer>();

		for(int i=0;i<a1.length;i++) {

			if(hs.containsKey(a1[i])) {

				int value=hs.get(a1[i]);
				hs.put(a1[i], value+1);
			}
			else {

				hs.put(a1[i], 1);
			}
		}
		
		for(int i=0;i<a2.length;i++) {
			
			if(!(hs.containsKey(a2[i]))) {
				
				isSubset = false;
				break;
			}
		}
		
		System.out.println("It's a subset :"+isSubset);
	}
}
