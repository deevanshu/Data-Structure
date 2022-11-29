package com.datastructures.STRINGS;
public class PrintDuplicatesAndTheirCount {

	public static void main(String args []) {


		String str = "test string";

		int array [] = new int[256];

		for (int i = 0; i < str.length(); i++)
		{
			int pos = (int) str.charAt(i);

			array[pos] = array[pos] + 1;
		}

		for (int i = 0; i < 256; i++)
			if (array[i] > 1)
				System.out.println((char)(i) +
						", count = " + array[i]);
	}
}
