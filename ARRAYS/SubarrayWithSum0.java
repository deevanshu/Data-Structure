package com.datastructures.ARRAYS;
import java.util.HashSet;

public class SubarrayWithSum0 {

	public static void main(String args[]) {

		int array[]= {4 , 2 , -3 , 1 ,  6};

		HashSet<Integer> hs = new HashSet<Integer>();
		int sum=0;
		boolean flag=false;
		for(int i=0;i<array.length;i++) {
			sum=sum+array[i];
			if( array[i]==0 || hs.contains(array[i]) || sum==0 ) {
				flag=true;
			}
			else {
				hs.add(sum);
			}
		}
		if(flag) {
			System.out.println("Contains");
		}
		else {
			System.out.println("Not Contains");
		}
	}
}