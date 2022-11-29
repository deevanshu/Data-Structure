package com.datastructures.STRINGS;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfString {

	static int count;
	public static void main (String args[]) {

		String s="ABC";   
		ArrayList <String> outputList = new ArrayList<>();
		permutations(outputList,0,s);
	//	subsets(s , "" , outputList , 0 ,s.length()); // Backtracking not needed happening automatically for string as string is pass by value 
		
		int nums[] = {1,2,3,4};
		
        List<List<Integer>> ans1 = new ArrayList<>();
     //   genSubsets(nums , 0 , new ArrayList<>() , ans1);
     //   System.out.println( ans1);
	}	

	public static void subsets(String S , String currentString , ArrayList<String> ans , int currentIndex , int n ){

		if(currentIndex>= n){

			ans.add(currentString);  // directly added not a copy like in case of array below questn
			System.out.println(currentString);
			return;
		}


		subsets(S , currentString+S.charAt(currentIndex) , ans ,currentIndex+1 , n );
		subsets(S , currentString , ans ,currentIndex+1 , n );

		return;

	}
	public static void genSubsets(int[] nums , int currentIndex , List<Integer> currentSubset , List<List<Integer>> answer ){

		if(currentIndex >= nums.length){

			answer.add(new ArrayList<>(currentSubset));
			return;
		}

		currentSubset.add(nums[currentIndex]);
		genSubsets(nums , currentIndex+1 ,currentSubset , answer );
		currentSubset.remove(currentSubset.size()-1);
		genSubsets(nums , currentIndex+1 ,currentSubset , answer );

		return ; 
	}

	public static void permutations(ArrayList<String> outputList ,int currentindex, String currentstring) {

		if(currentindex>=currentstring.length()-1) {
			System.out.println(currentstring);

			outputList.add(currentstring);
			return;
		}
		for(int i=currentindex ; i<currentstring.length();i++) {

			currentstring=swap(currentstring , currentindex , i);
			permutations(outputList,currentindex+1,currentstring);   // recursion
			currentstring=swap(currentstring , currentindex , i); //    backtracking
		}
	}

	public static void  permute(String str ) {

		for(int i=0;i<str.length();i++) {

			for(int j=i+1;j<str.length();j++) {

				String st=swap(str,i,j);
				System.out.println(st);
			}
		}
	}

	private static String swap(String string, int charAt, int charAt2) {

		char temp;
		char array[]=string.toCharArray();

		temp = array[charAt];
		array[charAt]= array[charAt2];
		array[charAt2]=temp;

		return String.valueOf(array);
	}
}