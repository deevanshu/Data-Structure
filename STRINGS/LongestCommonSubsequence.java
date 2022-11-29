package com.datastructures.STRINGS;

public class LongestCommonSubsequence {


	public static void main(String[] args)
	{
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String s1 = "ACADB";
		String s2 = "CBDA";

		char[] X=s1.toCharArray();
		char[] Y=s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " +
				lcs( X, Y, m, n ,s1 ,s2 ) );
	}

	private static int lcs(char[] x, char[] y, int m, int n , String S1 , String S2) {

		int dp[][]= new int[m+1][n+1];

		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {

				if(i==0 || j==0) {
					dp[i][j]=0;
				}
				else if(x[i-1]==y[j-1]) {

					dp[i][j]=1+dp[i-1][j-1];	

				}
				else {

					dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
				}				

			}
		}
		int index = dp[m][n];
		int temp = index;

		char[] lcs = new char[index + 1];
		lcs[index] = '\0';

		int i = m, j = n;
		while (i > 0 && j > 0) {
			if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
				lcs[index - 1] = S1.charAt(i - 1);

				i--;
				j--;
				index--;
			}

			else if (dp[i - 1][j] > dp[i][j - 1])
				i--;
			else
				j--;
		}

		return temp;
	}
}
