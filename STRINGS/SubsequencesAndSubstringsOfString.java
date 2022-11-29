package com.datastructures.STRINGS;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesAndSubstringsOfString {

	public static void main(String[] args)
	{
		String s = "abc";
		List <String>subseqList = findsubsequences(s); 

		System.out.println("SubSequences"+"\t");

		for(int i=0;i<subseqList.size();i++)
			System.out.println(subseqList.get(i)+"\t");

		System.out.println("\n"+"SubStrings"+"\n");

		List <String>substringList = findsubstrings(s);
		for(int i=0;i<substringList.size();i++)
			System.out.println(substringList.get(i)+"\t");

	}

	private static List<String> findsubstrings(String s) {
		ArrayList <String> outputList = new ArrayList<>();

		for(int i=0;i<s.length();i++) {
			for(int j=i+1;j<=s.length();j++) {

				outputList.add(s.substring(i, j));
			}
		}

		return outputList;
	}

	private static List<String> findsubsequences(String s) {

		int i = 0;
		ArrayList <String> outputList = new ArrayList<>();
		String outputString ="";
		subsequence(outputList ,outputString , s ,i);
		return outputList;

	}

	private static void subsequence(ArrayList<String> outputList, String outputString, String s, int i) {

		// Base Case
		if(i>=s.length()) {

			outputList.add(outputString);
			return;
		}
		// Exclude
		subsequence(outputList , outputString , s ,i+1);
		
		// Include
		char temp = s.charAt(i);
		outputString+=String.valueOf(temp);
		subsequence(outputList , outputString , s ,i+1);
	}
}
