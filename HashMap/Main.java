package com.datastructure.HashMap;

import java.util.HashMap;

public class Main {

	// with atmost k q unique characters
	public static void main(String args[]) {

		String s = "";
		int k = 3;

		LengthOfSubArray_WithSum_K();

		CountOfSubArray_WithSum_K();

		LongestSubstring_Without_Repeating_Characters();

		Largest_Subarray_0_1();

		CountOfSubString_Atmost_K_Unique_Characters(s , k);

		LengthOfSubString_AtmostKUnique_Characters(s , k);

		LengthOfSubString_EXACTLY_KUnique_Characters(s , k);

		CountOfSubString_Atleast_K_Unique_Characters(s , k);

		CountOfSubstring_EqualNoOf012(s);

		LengthOfSubstring_EqualNoOf012(s);

	}


	private static int Largest_Subarray_0_1() {

		int arr[] = {10, 5, 2, 7, 1, 9} ;
		int N = 15 ;

		// Your code here
		int ans = 0 ; 
		int sum = 0 ;
		HashMap<Integer , Integer  > memo = new HashMap<>();

		memo.put(0 , -1);
		for(int i = 0 ; i<arr.length ; i++){

			if(arr[i]==0){

				arr[i] = -1;
			}
			sum+=arr[i];
			if(memo.containsKey(sum)){

				ans = Math.max(ans , i - memo.get(sum));


			}
			else{

				memo.put(sum , i);
			}
		}

		return ans ; 
	}

	private static int LongestSubstring_Without_Repeating_Characters() {

		String  s = "abcabcbb";
		int ans= 0;
		int release = 0 ;

		HashMap<Character , Integer> memo = new HashMap<>();

		for(int acquire = 0 ; acquire < s.length() ;  acquire++){


			//             //   1- Method 
			while(memo.containsKey(s.charAt(acquire)) && release < acquire ){
				Integer temp =  memo.get(s.charAt(release)) ; 

				memo.remove(s.charAt(release));

				release++;
			} 


			//   2-Method

			//             if(memo.containsKey(s.charAt(acquire)) && release < acquire ){

			//                 release = memo.get(s.charAt(acquire)) + 1; 
			//                 int remove = release - 1 ;
			//                 memo.entrySet().removeIf( entries-> entries.getValue() <= remove );

			//             }

			//  3 - Method

			//                if(memo.containsKey(s.charAt(acquire)) && release < acquire && memo.get(s.charAt(acquire)) >= release ){

			//                 release = memo.get(s.charAt(acquire)) + 1; 

			//             }


			memo.put(s.charAt(acquire) , acquire);
			ans = Math.max(ans , acquire - release +1);
		}

		return ans;
	}

	private static int CountOfSubArray_WithSum_K() {

		int arr[] = {10, 5, 2, 7, 1, 9} ;
		int k = 15 ;

		HashMap<Integer , Integer> memo = new HashMap<>();

		int currSum = 0  ;
		int answer  = 0  ;
		memo.put(0 , 1);

		for(int i = 0 ; i < arr.length ; i++){           

			currSum += arr[i] ; 

			if(memo.containsKey(currSum - k)){      

				answer += memo.get(currSum - k);
			}

			if(memo.containsKey(currSum)){
				memo.put(currSum , memo.get(currSum ) +1 );
			}
			else{

				memo.put(currSum,1);
			}
		}

		return answer;
	}

	private static int LengthOfSubArray_WithSum_K() {

		int arr[] = {10, 5, 2, 7, 1, 9} ;
		int k = 15 ;

		HashMap<Integer,Integer> memo = new HashMap<>();
		memo.put(0 , -1);

		int currSum=0 , max = 0;
		for(int i = 0 ; i<arr.length ; i++){

			currSum = currSum+arr[i];
			if(memo.containsKey(currSum-k)){

				max = Math.max(max , i - memo.get(currSum-k));
			}
			if(!memo.containsKey(currSum)){

				memo.put(currSum , i);
			}
		}
		return max;

	}

	private static long LengthOfSubstring_EqualNoOf012(String s) {


		long ans = 0 ;

		int z0 = 0;
		int z1 = 0;
		int z2 = 0;

		HashMap<String,Integer> memo = new HashMap<>();
		memo.put((z1-z0) + "#" + (z2-z1) , -1);

		for(int i = 0 ; i<s.length() ; i++) {

			if(s.charAt(i)=='0') {
				z0 = z0 +1;
			}
			if(s.charAt(i)=='1') {
				z1 = z1 +1;
			}
			if(s.charAt(i)=='2') {
				z2 = z2 +1;
			}
			String exp = z1 - z0 + "#" + (z2 - z1);

			if(memo.containsKey(exp)) {

				ans = Math.max(ans, i - memo.get(exp));
				memo.put(exp, memo.get(exp));
			}
			else {
				memo.put(exp, i);
			}

		}

		return ans;
	}

	private static long CountOfSubstring_EqualNoOf012(String s) {

		long ans = 0 ;

		int z0 = 0;
		int z1 = 0;
		int z2 = 0;

		HashMap<String,Integer> memo = new HashMap<>();
		memo.put((z1-z0) + "#" + (z2-z1) , 1);

		for(int i = 0 ; i<s.length() ; i++) {

			if(s.charAt(i)=='0') {
				z0 = z0 +1;
			}
			if(s.charAt(i)=='1') {
				z1 = z1 +1;
			}
			if(s.charAt(i)=='2') {
				z2 = z2 +1;
			}
			String exp = z1 - z0 + "#" + (z2 - z1);

			if(memo.containsKey(exp)) {

				ans = ans + memo.get(exp);
			}
			else {
				memo.put(exp, 1);
			}

		}
		return ans;
	}

	private static void CountOfSubString_Atleast_K_Unique_Characters(String s, int k) {


		int n = s.length();
		int ans = n*(n+1)/2 - CountOfSubString_Atmost_K_Unique_Characters(s , k-1);
	}

	private static void LengthOfSubString_EXACTLY_KUnique_Characters(String s, int k) {


		HashMap<Character , Integer> memo = new HashMap<>();
		int ans =0, distinct = 0 , release=0;

		for(int acquire = 0 ; acquire<s.length() ; acquire++) {

			Character currChar = s.charAt(acquire);

			if(memo.containsKey(currChar)) {
				memo.put(currChar, memo.get(currChar)+1);
			}
			else {
				memo.put(currChar, 1);
				distinct+=1;
			}
			while(distinct > k) {
				Character disChar = s.charAt(release);
				release++;
				memo.put(disChar, memo.get(disChar)-1);

				if(memo.get(disChar)==0) {
					memo.remove(disChar);
					distinct--;
				}
			}
			if(distinct==k) {   // This Line IS Changed Only
				ans = Math.max(ans ,  acquire - release + 1) ;
			}
		}


	}

	private static void LengthOfSubString_AtmostKUnique_Characters(String s, int k) {

		HashMap<Character , Integer> memo = new HashMap<>();
		int ans =0, distinct = 0 , release=0;

		for(int acquire = 0 ; acquire<s.length() ; acquire++) {

			Character currChar = s.charAt(acquire);

			if(memo.containsKey(currChar)) {
				memo.put(currChar, memo.get(currChar)+1);
			}
			else {
				memo.put(currChar, 1);
				distinct+=1;
			}
			while(distinct > k) {
				Character disChar = s.charAt(release);
				release++;
				memo.put(disChar, memo.get(disChar)-1);

				if(memo.get(disChar)==0) {
					memo.remove(disChar);
					distinct--;
				}
			}

			ans = Math.max(ans ,  acquire - release + 1) ;

		}
	}

	private static int CountOfSubString_Atmost_K_Unique_Characters(String s, int k) {

		HashMap<Character , Integer> memo = new HashMap<>();
		int ans =0, distinct = 0 , release=0;

		for(int acquire = 0 ; acquire<s.length() ; acquire++) {

			Character currChar = s.charAt(acquire);

			if(memo.containsKey(currChar)) {
				memo.put(currChar, memo.get(currChar)+1);
			}
			else {
				memo.put(currChar, 1);
				distinct+=1;
			}
			
			while(distinct > k) {
				Character disChar = s.charAt(release);
				release++;
				memo.put(disChar, memo.get(disChar)-1);

				if(memo.get(disChar)==0) {
					memo.remove(disChar);
					distinct--;
				}
			}
			ans = ans + acquire - release +1 ;

		}

		return ans;
	}
}
