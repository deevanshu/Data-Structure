package com.datastructures.ARRAYS;

import java.util.HashSet;

public class UnionAndIntersectionOf2arrays {

	public static void main (String args[]) {
		int array1[]= {1, 2, 3, 4, 5};

		int array2[]= {1, 2, 3};

		HashSet<Integer> hs = new  HashSet<>();


		for(int i = 0; i<array1.length ; i++) {

			hs.add(array1[i]);

		}
		for(int i = 0; i<array2.length ; i++) {

			hs.add(array2[i]);
			if(hs.add(array2[i])==false) {

				System.out.println(array2[i]+"\t"); //Intersection
			}
		}

		System.out.println(hs.size());
	}
}
