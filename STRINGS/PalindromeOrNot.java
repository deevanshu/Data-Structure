package com.datastructures.STRINGS;

public class PalindromeOrNot {


	public static void main(String args []) {


		String s = "abab";

		int low =0 , high = s.length()-1;
		boolean ispalindrom = true;

		while(low<high) {

			if(s.charAt(low)==s.charAt(high)) {

				low++;
				high--;
			}
			else {
				ispalindrom=false;
				break;
			}
		}	
		
		System.out.println(ispalindrom);
		
	}
}
