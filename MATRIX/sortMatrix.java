package com.datastructures.MATRIX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class sortMatrix {

	public static void main(String[] args)
	{
		int mat[][] = { 
				{ 10,20,30,40},
				{ 15,25,35,45},
				{ 27,29,37,48},
				{ 32,33,39,50} };

		ArrayList <Integer>list=new ArrayList<>(mat.length*mat[0].length);

		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				list.add(mat[i][j]);
			}
		}

		Collections.sort(list);

		int col=mat[0].length , temp=0 ,count=0;
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {

				System.out.println(list.get(count));
				mat[i][j]=list.get(count);
				count++;
			}
		}
		System.out.println("Sorted");
	}
}