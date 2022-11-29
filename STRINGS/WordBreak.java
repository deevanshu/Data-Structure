package com.datastructures.STRINGS;
//A Dynamic Programming based program to test whether a given String can
//be segmented into space separated words in dictionary
import java.util.*;

class WordBreak{
	public static boolean wordBreakSol(int i , String A , ArrayList<String> B){

		if(i==A.length()){

			return true;
		}
		String temp="";

		for(int j=i;j<A.length();j++){

			temp+=A.charAt(j);

			if(B.contains(temp)){

				if(wordBreakSol(j+1 , A, B )){

					return true;
				}
			}
		}

		return false;
	}
	  public static int wordBreak(String A, ArrayList<String> B )
	    {
		  boolean ans=wordBreakSol(0 , A , B );
	        if(ans==true)
	        	return 1;
	        		
	        else {
	        	return 0;
	        }	
	    }
	public static void main(String[] args)
	{
		String A = "abcd";

		ArrayList<String> B = new ArrayList<>();
//		B.add("i");
//		B.add("ilice");
//		B.add("sam");
//		B.add("sung");
//		B.add("samsung");
//		B.add("mobile");
//		B.add("ice");
//		B.add("cream"); 
//		B.add("icecream");
//		B.add("man");
//		B.add("go");
//		B.add( "mango");
		B.add("ab");
		B.add("bcd");
		B.add("b");
		B.add("a");
		System.out.println(wordBreak(A , B));

	}
}