package com.datastructures.ARRAYS;

import java.math.BigInteger;

public class FactorialOfLargeNumber {

	public static void main(String args[]) 
	{
		int N = 3;
		System.out.println(factorial(N));
	}
	static BigInteger factorial(int N)
	{
		BigInteger f = new BigInteger("1");
		for (int i = 2; i <= N; i++)
			f = f.multiply(BigInteger.valueOf(i));
		return f;
	}
}
