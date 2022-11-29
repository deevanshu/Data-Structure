package com.datastructures.ARRAYS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class CommonElementsInThreeSortedArray {


	public static void main (String args[]) {



		int A [] = {1, 5, 10, 20, 40, 80} ;
		int B [] = {6, 7, 20, 80, 100} ;
		int C [] = {3, 4, 15, 20, 30, 70, 80, 120} ;

		//		HashMap<Integer , Integer> hs = new HashMap<>();
		//		HashMap<Integer , Integer> hsB = new HashMap<>();
		//		HashMap<Integer , Integer> hsC = new HashMap<>();
		//
		//		List<Integer> arr = new ArrayList<>();
		//		Vector<Integer> vr;
		//
		//		for(int i=0;i<A.length;i++) {
		//
		//			if(hs.containsKey(A[i]))
		//			{
		//
		//				hs.put(A[i] , hs.get(A[i]) + 1);
		//			}
		//			else {
		//
		//				hs.put(A[i] , 1);
		//			}
		//		}
		//		for(int i=0;i<B.length;i++) {
		//
		//			if(hsB.containsKey(B[i]))
		//			{
		//
		//				hsB.put(B[i] , hsB.get(B[i]) + 1);
		//			}
		//			else {
		//
		//				hsB.put(B[i] , 1);
		//			}
		//		}
		//		for(int i=0;i<C.length;i++) {
		//
		//
		//			if(hsB.containsKey(C[i]) && hs.containsKey(C[i])) {
		//
		//				System.out.println(C[i]);
		//			}
		//		}	


		//		int A [] = {1, 5, 10, 20, 40, 80} ;
		//		int B [] = {6, 7, 20, 80, 100} ;
		//		int C [] = {3, 4, 15, 20, 30, 70, 80, 120} ;

		int maxlength = Math.max(Math.max(A.length,B.length) , C.length);
		int a=0 , b=0 , c=0 , i=0;
		ArrayList<Integer> arr=new ArrayList<>();
		
		if(maxlength==A.length) {
			
			while(a<maxlength){

				if(A[a] == B[b] && B[b] == C[c])
				{

					System.out.println(B[b]);

					arr.add(B[b]);

					if(a+1 < A.length)
					{
						a+=1 ; 
					}
					if(b+1 < B.length)
					{
						b+=1 ;
					}
					if(c+1 < C.length) {
						c+=1;
					}
				}
				else if (A[a] < B[b] && A[a] < C[c]){

					if(a+1 < A.length)
					{
						a+=1 ; 
					}
					else {
						break;
					}

				}
				else if(B[b] < C[c] && B[b] < A[a]){

					if(b+1 < B.length)
					{
						b+=1 ;
					}
					else {
						break;
					}
				}
				else{

					if(c+1 < C.length) {
						c+=1;
					}
					else {

						break;
					}
				}
				
			}
		}
		else if(maxlength==B.length) {
			
			
			while(b<maxlength){

				if(A[a] == B[b] && B[b] == C[c])
				{

					System.out.println(B[b]);

					arr.add(B[b]);

					if(a+1 < A.length)
					{
						a+=1 ; 
					}
					if(b+1 < B.length)
					{
						b+=1 ;
					}
					if(c+1 < C.length) {
						c+=1;
					}
				}
				else if (A[a] < B[b] && A[a] < C[c]){

					if(a+1 < A.length)
					{
						a+=1 ; 
					}
					else {
						break;
					}

				}
				else if(B[b] < C[c] && B[b] < A[a]){

					if(b+1 < B.length)
					{
						b+=1 ;
					}
					else {
						break;
					}
				}
				else{

					if(c+1 < C.length) {
						c+=1;
					}
					else {

						break;
					}
				}
				
			}
		}
		else {
			
			
			while(c<maxlength){

				if(A[a] == B[b] && B[b] == C[c])
				{

					System.out.println(B[b]);

					arr.add(B[b]);

					if(a+1 < A.length)
					{
						a+=1 ; 
					}
					if(b+1 < B.length)
					{
						b+=1 ;
					}
					if(c+1 < C.length) {
						c+=1;
					}
				}
				else if (A[a] < B[b] && A[a] < C[c]){

					if(a+1 < A.length)
					{
						a+=1 ; 
					}
					else {
						break;
					}

				}
				else if(B[b] < C[c] && B[b] < A[a]){

					if(b+1 < B.length)
					{
						b+=1 ;
					}
					else {
						break;
					}
				}
				else{

					if(c+1 < C.length) {
						c+=1;
					}
					else {

						break;
					}
				}
				
			}
		}
	

		while(i<maxlength){

			if(A[a] == B[b] && B[b] == C[c])
			{

				System.out.println(B[b]);

				arr.add(B[b]);

				if(a+1 < A.length)
				{
					a+=1 ; 
				}
				if(b+1 < B.length)
				{
					b+=1 ;
				}
				if(c+1 < C.length) {
					c+=1;
				}
			}
			else if (A[a] < B[b] && A[a] < C[c]){

				if(a+1 < A.length)
				{
					a+=1 ; 
				}
				else {
					break;
				}

			}
			else if(B[b] < C[c] && B[b] < A[a]){

				if(b+1 < B.length)
				{
					b+=1 ;
				}
				else {
					break;
				}
			}
			else{

				if(c+1 < C.length) {
					c+=1;
				}
				else {

					break;
				}
			}
			
		}
	}
}
