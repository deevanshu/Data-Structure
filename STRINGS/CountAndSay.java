package com.datastructures.STRINGS;

public class CountAndSay {


	public static void main(String[] args)
	{
		int N = 9;
		System.out.println(countnndSay(N));
	}

	private static String countnndSay(int n) {

		int cntr=1;

		if (n == 1)   {
			return "1";
		}
		if (n == 2)   {  
			return "11";
		}
		String ans = "11";


		String temp="";

		for(int i=3;i<=n;i++) {
			char [] array = ans.toCharArray();
			for(int j=0;j<array.length;j++) {

				if(j+1 < array.length && array[j]==array[j+1]) {

					cntr+=1;
				}else {
					temp=temp+String.valueOf(cntr)+array[j];
					cntr=1;
				}
			}
			ans = temp;
			temp="";
		}
		return ans;
	}
}
