package com.datastructures.STRINGS;
public class LongestPalindromicSubstring {

	public static void main(String args[]) {

		String s ="forgeeksskeegfor";
		System.out.println(longestPalin(s));
	}

	private static String longestPalin(String s) {

		if(s.length()<=1) {

			return  s;
		}

		int start=0 , end=0 , lenEven=0 ,lenOdd=0 , len;

		for(int i=0;i<s.length();i++) {


			lenOdd=expandAroundCenter(s , i , i);
			lenEven=expandAroundCenter(s  , i , i+1);
			len=Math.max(lenEven, lenOdd);

			if(len>end-start) {

				start = i-(len/2-1) ;
				end   = i+len/2;           
			}
		}

		return s.substring(start , end+1); //last index is not included
	}

	private static int expandAroundCenter(String s, int i, int j) {

		while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)) {


			i--;
			j++;
		}

		return j-i-1; 
	}
}
