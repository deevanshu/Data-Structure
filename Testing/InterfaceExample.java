package Testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

interface MyInterface{

	public static int num = 100;
	public default void display() {
		System.out.println("display method of MyInterface");
	}

	public static void d1() {

		System.out.println("Static Method");
	}
}

public class InterfaceExample implements MyInterface{
	public void display() {
		System.out.println("display method of class");
	}

	static int count = 0;
	public static boolean checkPartitioning(String s) {

		if(s.length()==3){

			return true ;
		}

		count = 0;
		int ans = cuts(0 , s.length()-1 , s );

		System.out.println("ans "+ans);
		System.out.println(count);
		if(count==2 ){

			System.out.println(count);
			return true;
		}
		else{

			return false;
		}
	}

	public static int cuts(int start , int end , String s ){

		if(isPalind(start , end , s)){

			return 0;
		}
		int ans = 0 ,  finalAns =100001;

		for(int i = start ; i< end ; i++ ){


			if(isPalind(start , i , s)){


				ans =   1 + cuts(i+1 ,end , s );
			}

			if(ans==2 || finalAns==2){

				count = 2 ;
			}
			finalAns = Math.min(finalAns , ans);
		}

		return finalAns ;
	}
	public static boolean isPalind(int s ,int e , String s1){

		while(s<e){

			if(s1.charAt(s)!=s1.charAt(e)){

				return false;
			}

			s++;
			e--;
		}
		return true;

	}

	public static boolean jumpToLast(int[] stones , int currentIndex , int finalIndex ,HashMap<String , Boolean > memo , int last) {


		if(currentIndex>finalIndex || currentIndex != stones[currentIndex]){

			return false;
		}
		if(currentIndex==finalIndex-1 ){

			return true;
		}

		if(currentIndex == 0){

			jumpToLast(stones , currentIndex + 1 , stones.length , memo , 1);
		}
		//	String currentKey = currentIndex +"-"+ last;
		//
		//		if(memo.containsKey(currentKey)){
		//
		//			return memo.get(currentKey);
		//		}
		boolean minusOne = false ;
		if(last-1 > 0){
			minusOne = jumpToLast(stones , currentIndex + (last - 1) , stones.length , memo , (last -1) );
		}
		boolean same     = jumpToLast(stones , currentIndex + (last   ) , stones.length , memo ,  (last   ) );
		boolean plusOne  = jumpToLast(stones , currentIndex + (last +1) , stones.length , memo , (last +1) );

		//	memo.put(currentKey , minusOne || same || plusOne);

		return minusOne || same || plusOne ;
	}



	public static boolean helper(int[] stones, int currentIndex, int prevJump, HashMap<HashMap<Integer, Integer> , Boolean> dp){
		if(currentIndex>=stones.length-1)
			return true;

		HashMap<Integer, Integer> currentkey = new HashMap<>();
		currentkey.put(currentIndex, prevJump);

		if(dp.containsKey(currentkey))
			return dp.get(currentkey);

		// For jump k-1
		int x = stones[currentIndex]+prevJump-1; 
		if(x>stones[currentIndex]){
			for(int j=currentIndex+1;j<stones.length;j++){
				if(stones[j] == x)
				{
					if(helper(stones, j, prevJump-1, dp))
						return true;
				}

				if(stones[j] > x)
					break;
			}
		}

		// For jump k
		x = stones[currentIndex]+prevJump; 
		for(int j=currentIndex+1;j<stones.length;j++){
			if(stones[j] == x)
				if(helper(stones, j, prevJump, dp))
				{
					return true;
				}
			if(stones[j] > x)
				break;
		}

		// For jump k+1
		x = stones[currentIndex]+prevJump+1; 
		for(int j=currentIndex+1;j<stones.length;j++){
			if(stones[j] == x)
				if(helper(stones, j, prevJump+1, dp))
				{
					return true;
				}
			if(stones[j] > x)
				break;
		}

		// NOT FOUND PUT FALSE
		dp.put(currentkey, false);
		return dp.get(currentkey);
	}
	public static boolean canCross(int[] stones) {

		HashMap<HashMap<Integer, Integer> , Boolean> dp = new HashMap<>(15);
		return helper(stones, 0, 0, dp);
	}

	public static void gen(int[] nums , int currentIndex , List<Integer> currentSubset , List<List<Integer>> answer ){

		if(currentIndex >= nums.length){

			answer.add(new ArrayList<>(currentSubset));
			return;
		}


		currentSubset.add(nums[currentIndex]);
		gen(nums , currentIndex+1 ,currentSubset , answer );
		currentSubset.remove(currentSubset.size()-1);
		gen(nums , currentIndex+1 ,currentSubset , answer );

		//      answer.add(new ArrayList<>(currentSubset));
		//     for(int i=currentIndex ; i<nums.length;i++)
		//     {
		//         currentSubset.add(nums[i]);
		//         gen(nums , i+1, currentSubset , answer);
		//         currentSubset.remove(currentSubset.size()-1);
		//     }



		return ; 

	}

	public static int networkDelayTime(int[][] times, int n, int k) {

		ArrayList < ArrayList < ArrayList < Integer > > > graph = constructGraph(times , n);

		int[] costs = new int[n+1];
		Arrays.fill(costs , -1);

		PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>(){

			public int compare(Pair P1 , Pair P2){

				return P1.cost - P2.cost ; 
			}
		});
		queue.add(new Pair(k , 0));

		int ans = -1;
		while(!queue.isEmpty()){

			Pair pair =  queue.remove();

			int currentVertex = pair.vertex;
			int currentCost = pair.cost;

			if(costs[currentVertex]!=-1){
				continue;
			}

			costs[currentVertex] = currentCost;
			ArrayList<ArrayList<Integer>> neighbours = graph.get(currentVertex);

			for(ArrayList<Integer> currNeighbour : neighbours){

				int vertex = currNeighbour.get(0);
				int cost   = currNeighbour.get(1);

				queue.add(new Pair(vertex , cost + currentCost));
				ans = Math.max(ans , (cost + currentCost));

			}

		}

		return ans;
	}

	public static ArrayList< ArrayList<ArrayList<Integer>>> constructGraph(int[][] times , int n){

		ArrayList< ArrayList<ArrayList<Integer>>> constructedGraph = new ArrayList<>();

		for(int i = 0 ; i <= n ; i++){

			constructedGraph.add(new ArrayList< ArrayList<Integer> >());
		}

		for(int [] array : times){

			int source =  array[0];
			int destination =  array[1];
			int weight =  array[2];

			ArrayList<Integer> list = new ArrayList<>();
			list.add(destination);
			list.add(weight);

			constructedGraph.get(source).add(list);
		}

		return constructedGraph ; 
	}
	static int findLongestConseqSubseq(int arr[], int N)
	{

		TreeSet<Integer> set=new TreeSet<Integer>();  

		for(int i = 0 ; i< arr.length ; i++){

			set.add(arr[i]);
		}

		int i = 0 , prevValue = -1 , lengthOfLongest = 0 , maxLength = 0 ;
		for (Integer value : set){

			if(prevValue==-1){
				prevValue = value;
				lengthOfLongest++;
				maxLength = Math.max(maxLength , lengthOfLongest);
				continue;
			}

			if(value == prevValue + 1){

				System.out.println("Inside If");
				lengthOfLongest++;
				maxLength = Math.max(maxLength , lengthOfLongest);
			}
			else{

				System.out.println("Inside Else");
				lengthOfLongest = 1;
				maxLength = Math.max(maxLength , lengthOfLongest);
			}
		}
		return maxLength;
	}

	public static int search(int[] nums, int target) {

		int low = 0 , high = nums.length-1 ; 
		int ans = 0 ;
		boolean found = false;
		while(low < high){

			int mid = low + (high - low)/2 ;

			if(nums[mid] == target){

				ans = mid ; 
				found = true;
				break;
			}
			else if(nums[mid] > target){

				high = mid-1;
			}
			else{

				low = mid+1;
			}
		}
		return found==true?ans:-1 ; 
	}

	public static int countSetBits(int n)
	{
		int count = 0;
		while (n != 0) {
			count++;
			//   n &= (n - 1);
			n = n&(n-1);  //   & operator converts different bits to 0 and does nothing to same bits i.e. loop runs no. of times of significant bits
			//    gives result no. of one in number.
		}
		return count;
	}

	// Function that return count of
	// flipped number
	public static int FlippedCount(int a, int b)
	{
		// Return count of set bits in
		// a XOR b
		return countSetBits(a ^ b);
	}

	public static int kthSmallest(int[] arr,int k) 
	{ 
		//Your code here

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>( k , Collections.reverseOrder() );

		for(int i = 0 ; i  < k ; i++){

			pq.add(arr[i]);
		}

		for(int i = k ; i < arr.length ; i++){

			if(arr[i] < pq.peek()){
				pq.poll();
				pq.add(arr[i]);
			}
		}

		return pq.peek();
	} 
	public static String rremove(String s) {        

		while(true){

			int i = 0 ;
			String str="";

			while(i<s.length()){

				int j = i+1 ; 
				while(j<s.length() && s.charAt(i)==s.charAt(j)){

					j++;
				}
				if(j==i+1){ // means didn't went in obove loop so i & j are diff . add i in answer

					str+=s.charAt(i);
				} 

				i=j; // make j as i , as if i & j were not same then anyways we needed to start from from j again and if equal then 
			}

			if(str.length()==s.length() || s.length()==0){
				break;
			}
			s = str;
		}
		return s;
	}
	public static boolean isRobotBounded(String instructions) {
		//                        North      Left(West)      South          Right(East)
		//  int dirArray[][] = { { 0 , 1 } , { -1 , 0  }  , {  0 , -1  }  , {  1 , 0    } };
		//                             0           1              2              3 

		// int dir = 0 , x = 0 , y = 0 ;

		int x =0 , y=0;
		char dir = 'G' ;

		for(int i = 0 ; i < instructions.length() ; i++){

			if(instructions.charAt(i) == 'L'){
				//      dir = ( dir + 1 ) % 4;

				if(dir == 'G' ){  
					dir = 'L';   
				}
				if(dir == 'L' ){ 
					dir = 'S';  
				}
				if(dir == 'S'){  
					dir = 'R';  
				}
				else{           
					dir = 'G'; 
				}
			}
			else if(instructions.charAt(i) == 'R'){
				//     dir = ( dir +  3 ) % 4;

				if(dir == 'G' ){   
					dir = 'R';   
				}
				if(dir == 'L' ){ 
					dir = 'G';  
				}
				if(dir == 'S'){  
					dir = 'L';  
				}
				else{           
					dir = 'S'; 
				}
			}
			else{

				// x = x + dirArray[dir][0]
				//  y = y + dirArray[dir][1]

				if(dir == 'G' ){  
					y++;       
				}
				if(dir == 'L' ){ 
					x--;        
				}
				if(dir == 'S'){ 
					y--;        
				}
				else{        
					x++;    
				}
			}
		}

		if( (x==0 && y==0 ) || dir!='G'){
			return true;
		}
		else{
			return false;
		}
	}
	public static String mostCommonWord(String paragraph, String[] banned) {  
		TreeMap<String , Integer > tm = new TreeMap<>();

		HashSet<String> hs = new HashSet<>();

		for(String str : banned){
			str = str.replaceAll("[^A-Za-z0-9]", "");
			hs.add(str.toLowerCase());
		}
		for(String str1: paragraph.split(" ")){

			str1 = str1.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
			if(hs.contains(str1) || str1==""){

				continue;
			}else if(tm.containsKey(str1)){

				tm.put(str1 ,tm.get(str1)+1 );
			}
			else{

				tm.put(str1, 1);
			}
		}

		List<Map.Entry<String , Integer>> list = new LinkedList<>(tm.entrySet());

		Collections.sort(list , new Comparator<Map.Entry<String , Integer>>(){

			public int compare(Map.Entry<String, Integer> o1,
					Map.Entry<String, Integer> o2)
			{
				return (o2.getValue() - o1.getValue());
			}
		});
		String ans = "";
		for(Map.Entry<String , Integer> entry : tm.entrySet()){

			String temp = entry.getKey();
			ans = temp.toLowerCase();
			break;
		}
		return ans ; 
	}
	public static int[] productExceptSelf(int[] nums) {

		int [] output = new int[nums.length];

		output[0] = nums[0];
		for(int i = 1 ; i <nums.length-1 ; i++){

			output[i] = nums[i] * output[i-1] ; 
			System.out.println(output[i]);

		}
		output[nums.length-1] =  output[nums.length-2];
		int prod = nums[nums.length-1] ;
		for(int i = nums.length-2  ; i >0 ; i--){

			output[i] = prod * output[i-1] ; 
			prod = prod * nums[i];
		}
		output[0] = prod;

		return output;
	}
	public static int orangesRotting(int[][] grid)
	{

		//     0 1 2
		//   0   F R
		//   1   F R
		//    2 R F F

		Queue<Pair1> qu = new LinkedList<>();
		int totalOranges =  0 ;

		for(int i = 0 ; i < grid.length ; i++){

			for(int j = 0 ; j< grid[0].length ; j++){

				if(grid[i][j]==1){

					totalOranges++;
				}
				if(grid[i][j]==2){
					totalOranges++;
					qu.add(new Pair1(i , j));
				}
			}
		}

		if(qu.size()==totalOranges || totalOranges==0){

			return -1;
		}

		int freshAndRottenCount = 0 , minTime=0;
		int x[] = {0 , 0 , 1 ,-1};
		int y[] = {1 ,-1 , 0 , 0};

		while(!qu.isEmpty()){

			freshAndRottenCount = freshAndRottenCount + qu.size();
			int size = qu.size();
			while(size>0){

				Pair1 pair = qu.poll();
				int nx = 0 , ny = 0;
				for(int i = 0 ; i < 4 ; i++){

					nx = pair.x + x[i];
					ny = pair.y + y[i];

					if(nx < 0 || nx>=grid.length || ny<0 || ny>=grid[0].length || grid[nx][ny]!=1 ){
						continue;
					}
					grid[nx][ny] = 2;
					qu.add(new Pair1(nx , ny));
				}
				size--;
			}
			if(!qu.isEmpty()){
				minTime++;
			}
		}


		return totalOranges==freshAndRottenCount?minTime:-1 ; 
	}

	static int isCircle(int N, String A[])
	{
		int[] inDegree  = new int[26];
		int[] outDegree = new int[26];
		int[] degree    = new int[26];
		boolean[] visited   = new boolean[26];

		if( A.length==1 && A[0].charAt(0) != A[0].charAt(A[0].length()-1) ){

			return 0;
		}
		System.out.println(A[0].charAt(0));
		System.out.println(A[0].charAt(A[0].length()-1));
		ArrayList<ArrayList<Integer>> graph = constructGraph(A , N , inDegree , outDegree);
		int isEuler = 0;
		boolean greaterThanZero = false;
		for(int i=0;i<26;i++){

			degree[i] = inDegree[i] + outDegree[i];
			if(degree[i] > 0){

				greaterThanZero = true;
			}
		}

		if(greaterThanZero==false){
			isEuler=1;
			return isEuler;
		}

		boolean[] ans = {false};

		depthFirstSearch(ans , visited , A[0].charAt(0) - 'a' , graph);


		for(int i = 0 ; i<26 ; i++){

			if(visited[i]==false && degree[i]>0){
				isEuler=0;
				return isEuler;
			}
			else if (visited[i]==true && degree[i]==0){
				isEuler=0;
				return isEuler;
			}
		}


		return 1;
	}

	public static void depthFirstSearch(boolean[] ans ,boolean [] visited , int currentVertex ,  ArrayList<ArrayList<Integer>> adj )

	{
		if(visited[currentVertex]){

			return;
		}

		List<Integer> neighbours = adj.get(currentVertex);

		for(int neighbour : neighbours){

			visited[neighbour] = true;
			depthFirstSearch(ans , visited , neighbour , adj);
		}

		return;
	}
	public static ArrayList<ArrayList<Integer>> constructGraph(String[] A , int N, int[] inDegree, int[] outDegree){


		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0 ; i<26 ; i++){

			graph.add(new ArrayList<Integer>());
		}

		for(int i=0 ; i<N ; i++){

			String temp = A[i];
			char source = temp.charAt(0);
			char dest   = temp.charAt(temp.length()-1);

			graph.get(source - 'a').add(dest - 'a');
			inDegree[dest - 'a']+=1;
			outDegree[source - 'a']+=1;

		}

		return graph;
	}
	public static int climbStairs(int n) {

		return climb(0 , n , new HashMap<Integer , Integer>());
	}

	public static int climb(int currStair , int finalStair , HashMap<Integer , Integer>memo){

		if(currStair==finalStair){

			return 1;
		}
		if(currStair>finalStair){

			return 0;
		}
		int currKey = currStair;
		if(memo.containsKey(currKey)){
			return memo.get(currKey);
		}
		int oneJump = climb(currStair+1 , finalStair , memo);
		int twoJump = climb(currStair+2 , finalStair , memo);

		memo.put(currKey , oneJump + twoJump);
		return oneJump + twoJump;

	} 
	public static void generate(String currString , int openCount , int closeCount , int n , List<String> ans){

		if(openCount==closeCount && openCount==n){

			ans.add(currString);
			return;
		}

		if(openCount<n){
			generate( currString +"(" ,  openCount + 1,  closeCount ,  n , ans);
		}
		if(closeCount<n){
			generate( currString +")" ,  openCount,  closeCount + 1,  n , ans);
		}
		return;
	}
	static String printLargest(String[] arr) {
		// code here

		Arrays.sort(arr , new Comparator<String>(){

			public int compare(String a , String b){

				return (b+a).compareTo(a+b) ;

			}
		});

		String ans = "";

		for(int i=0;i<arr.length;i++){

			ans = ans + arr[i]; 

		}
		return ans;
	}

	static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
	{

		ArrayList <Integer> ans = new ArrayList <Integer>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(k , Collections.reverseOrder());
		int acquire = 0  , released = 0 ,  max = arr[0] ;
		pq.add(arr[0]);

		for(int i = 1 ; i<n ; i++){


			if(i - acquire + 1  > k){

				ans.add(pq.peek());
				pq.remove(arr[acquire]);
				acquire++;
			}
			pq.add(arr[i]);
		}

		ans.add(pq.peek());
		return ans;
	}
	public static String smallestWindow(String s, String p)
	{
		HashMap<Character,Integer> h=new HashMap<>();

		// Storing count of all characters in given Pattern
		for(int i=0; i<p.length(); i++){

			char c=p.charAt(i);

			if(!h.containsKey(c)) {
				h.put(c,1);
			}
			else {
				h.put(c,h.get(c)+1);
			}
		}

		System.out.println(h.size());
		HashMap<Character,Integer> m=new HashMap<>();
		int c=0; int j=0; String ans=s;

		for(int i=0; i<s.length(); i++){
			char ch=s.charAt(i);
			// storing only those characters which r present in pattern bcz only those are useful for us.
			if(h.containsKey(ch))
			{
				if(!m.containsKey(ch)){
					m.put(ch,1);
				}else{

					m.put(ch,m.get(ch)+1);
				}
				// If we got exact count of character as given in pattern then means we can inc out count by 1 
				if(h.get(ch)==m.get(ch)) {
					c++;
				}
			}

			if(c==h.size()){
				while( !h.containsKey(s.charAt(j))|| h.get(s.charAt(j))< m.get(s.charAt(j))){

					char cc=s.charAt(j);
					if(m.containsKey(cc)){

						m.put(cc,m.get(cc)-1);
					}
					j++;
					if(ans.length()>i-j+1)

						ans=s.substring(j,i+1);
				}
				if(ans.length()>i-j+1)

					ans=s.substring(j,i+1);
			}
		}
		if(c!=h.size()) {
			return "-1";
		}
		return ans;

	}

	static String answer = "";
	static int start = 0;
	static String longestPalindrome(String S){
		// code here
		StringBuilder str = new StringBuilder(S);

		//        int tempans = longestCommonSubstr( S , str.reverse().toString() );
		int tempans = longestCommonSubstr( S , str.reverse().toString() );
		return S.substring(start ,start+tempans);
	}
	public static int longestCommonSubstr(String text1, String text2){
		// code here

		int m = text1.length();
		int n = text2.length();


		int[][] dp = new int[m+1][n+1];


		for(int i=0 ; i<= m ;i++){

			for(int j=0 ; j<=n ; j++){

				dp[i][j] = 0;
			}
		}

		return subsequence(dp , text1 , text2 , m , n);

	}

	public static int subsequence(int[][] dp , String text1 , String text2  , int m ,int n){

		int ans = 0 ;
		for(int i=1 ; i<= m ;i++){
			for(int j=1 ; j<= n ; j++){  // aaaabbaa
				//  aabbaaaa

				if(text1.charAt(i-1) == text2.charAt(j-1)){

					dp[i][j] = 1 +  dp[i-1][j-1]; 

					ans = Math.max(ans,dp[i][j]);
					System.out.println("ans :" + ans);
					System.out.println("i :" + i);
					System.out.println("j :" + j);
					start = ans;

				}
				else{    
					dp[i][j] = 0; ;
				}
			}
		}

		return ans;
	}

	public static int gcd(int a , int b){

		if(a==0){
			return b;
		}
		return gcd(b%a , a);
	}
	static ArrayList<Integer> countDistinct(int A[], int n, int k)
	{

		HashMap<Integer,Integer> memo = new HashMap<>();

		int acquire = 0 , release=0,distinct=0 ;
		ArrayList<Integer> ans = new ArrayList<>();

		for(acquire = 0 ; acquire <A.length ; acquire++){

			if(memo.containsKey(A[acquire])){

				memo.put(A[acquire] , memo.get(A[acquire])+1);
			}
			else{
				memo.put(A[acquire],1);
				distinct++;
			}
			if(acquire - release + 1 == k){

				ans.add(distinct);   
			}
			if(acquire - release + 1 > k){

				int ele = A[release++];
				int count = memo.get(ele);
				count = count - 1;
				if(count==0){
					memo.remove(ele);
					distinct--;
				}
				ans.add(distinct);   
			}
		}
		return ans;
	}

	public static String longestPalindrome3(String s) {

		if(s.length()==1){
			return s;
		}

		int start = 0 , end = 0 , maxLength = 1;

		for(int i = 0 ; i<s.length() ; i++){

			int lenOdd  = expandCentre(s , i , i);
			int lenEven = expandCentre(s , i , i+1);
			int len     = Math.max(lenOdd , lenEven);

			if(len > end - start){

				start = i - (len -1)/2;
				end   = i + len/2;
			}
		}

		return s.substring(start , end+1);
	}

	public static int expandCentre(String s , int i , int j){

		if(i > j || s.length()==0){
			return 0;
		}
		while(i>=0 && j < s.length() && s.charAt(i)==s.charAt(j)){

			i--;
			j++;
		}

		return j-i-1;
	}

	public static int reverse(int x) {

		boolean flag = true;
		if(x < 0) flag = false; // if x is -ve then flag is false;

		x = Math.abs(x);

		long num = 0;
		int r;

		while(x > 0)
		{
			num *= 10;      
			r = x % 10;         // r = remainder;
			num += r;           // remainder is added;
			x /= 10;            // x is divided by 10;
		}
		if(num > Integer.MAX_VALUE)     // if reversed is greater then 0 is returned;
			return 0;

		int result = (int)num;

		if(!flag)           // if the no. is -ve. Subtract it two times;
		{
			result -= num;
			result -= num;            
		}

		return result;
	}

	//	public static String[] findNearest(String[] points, int[] xCoo, int[] yCoo, String[] queries, int n) {
	//
	//		HashMap<Integer, List<String>> xToPoint = new HashMap<>(); // maps from x coordinate to points
	//		HashMap<Integer, List<String>> yToPoint = new HashMap<>(); // maps from y coordinate to points
	//		HashMap<String, Integer> pointToIdx = new HashMap<>();
	//
	//		HashMap<String,Triplet1> hm = new HashMap<>();
	//
	//		for(int i = 0 ; i<points.length ; i++) {
	//
	//			Triplet1 triplet = new Triplet1(points[i] , xCoo[i] , yCoo[i]);
	//			hm.put(points[i], triplet);
	//		}
	//
	//		for(int i = 0 ; i<queries.length ; i++) {
	//
	//		//	findNeighburs(queries[i] , hm);
	//		}
	//
	//	}

	//	private static void findNeighburs(String city, HashMap<String, Triplet> hm) {
	//
	//		for(Map.Entry<String, Triplet> entry : hm.entrySet()) {
	//
	//			if(entry.getKey().equals(city)) {
	//
	//				 
	//			}
	//		}
	//	}

	public static double myPow(double x, int n) {

		double ans=1.0;
		long nn=n;

		if(n==0){

			return 1;
		}
		if(nn < 0)
		{ 
			nn=-(nn);
		}        
		while(nn>0){

			if(nn%2==0)
			{
				x=x*x;
				nn=nn/2;

			}
			else
			{
				ans=ans*x;
				nn--;                                 

			}

		}
		if(n<0)
			ans=(1.0)/(ans);

		return ans;
	}

	public static int firstMissingPositive(int[] nums) {

		int i = 0;
		System.out.println(nums[0]);
		System.out.println(i+1);
		System.out.println(nums[i] != i+1);
		while(i< nums.length){

			if(nums[i]>0 && nums[i]<=nums.length && nums[i] != i+1 && nums[i] != nums[ nums[i]-1 ]) {

				int tmp = nums[i];
				nums[i] = nums[nums[i] - 1];
				nums[tmp - 1] = tmp;
			}
			else {
				i++;
			}
		}

		for(int j=0;j<nums.length; j++)
			if(nums[j]!=j+1) 
			{
				return j+1;
			}
		return nums.length+1;
	}
	public static int  longSubarrWthSumDivByK(int nums[], int n, int k)
	{

		int ans = 0 ;
		int prefSum = 0 ;

		HashMap<Integer , Integer> memo = new HashMap<>();

		memo.put(0 , -1);

		for(int currVal = 0 ; currVal<nums.length; currVal++){

			prefSum = prefSum + currVal;
			int currSum = ((prefSum % k ) + k ) % k;

			if(memo.containsKey(currSum)){
				ans = Math.max(ans , currVal- memo.get(currSum));
			}
			else{
				memo.put(currSum , currVal);
			}
		}
		return ans;

	}
	public static void main(String args[]) {

		int mums[] = {1 ,2 ,-2, 2, 2};
		longSubarrWthSumDivByK( mums,5 , 2);
		int g1 = -2%5;
		int g2= -3%5;
		int g3 = -4%5;
		int g4 = -1%5;
		int numsy[] = {3,4,-1,1};
		System.out.println(firstMissingPositive(numsy));

		int[] ar= {1,2,3,4}; 
		productExceptSelf(ar);

		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		// enter data into hashmap
		hm.put("Math", 98);
		hm.put("Fatabase", 85);
		hm.put("Java", 85);
		hm.put("Daaa Structure", 85);

		hm.put("Operating System", 79);
		hm.put("Networking", 80);

		List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

		//		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
		//
		//
		//			public int compare(Map.Entry<String, Integer> o1 , Map.Entry<String, Integer> o2) {
		//
		//
		//				int ans = o1.getValue() - (o2.getValue());
		//				if(ans==0) {
		//
		//					return o1.getKey().compareTo(o2.getKey());
		//				}
		//				return ans;
		//			}
		//		});

		Collections.sort(list, ( o1 , o2) ->{

			int ans = o1.getValue() - (o2.getValue());
			if(ans==0) {

				return o1.getKey().compareTo(o2.getKey());
			}
			return ans;
		}
				);

		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}

		// print the sorted hashmap
		for (Map.Entry<String, Integer> en : temp.entrySet()) {
			System.out.println("Key = " + en.getKey() +
					", Value = " + en.getValue());
		}

		System.out.println(myPow(2.00000,10));
		String sdsd = "sadbutsad";
		int dfgf = sdsd.indexOf("sad");

		String[] points = new String[] {"p1", "p2","p3", "p4", "p5"};
		int[] xCoo = new int[] {40, 20, 20, 40, 40};
		int[] yCoo = new int[] {10, 40, 30, 40, 30};
		String[] queries = new String[] {"p1", "p2","p3", "p4", "p5"};
		int n = 5;
		//	System.out.println(findNearest(points, xCoo, yCoo, queries, n));

		List<Integer>l1 = new ArrayList<>();
		l1.add(8);
		ConcurrentHashMap<String, List<Integer>> map23 = new ConcurrentHashMap<String, List<Integer>>();
		map23.put("Dell", l1);
		List<Integer>l156 = map23.get("Dell");
		l156.add(9);
		System.out.println(map23);

		reverse(-123);

		longestPalindrome3("rfkqyuqfjkxy");

		StringBuilder str = new StringBuilder("gh");
		str = str.reverse();

		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
		//Adding elements to map
		map.put("Dell", 1);
		map.put("IBM", 2);
		//Getting an Iterator from map
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()){
			String key = (String) it.next();
			System.out.println(key+" : "+map.get(key));
			map.put("Google", 3);
		}
		System.out.println(map);


		Test ob1 = new Test();

		System.out.println(ob1.x + " " + ob1.y);

		// Creating a new reference variable ob2
		// pointing to same address as ob1
		Test ob2 = ob1;

		// Any change made in ob2 will
		// be reflected in ob1
		ob2.x = 100;

		System.out.println(ob1.x + " " + ob1.y);
		System.out.println(ob2.x + " " + ob2.y);
		System.out.println(ob1.hashCode() + " :" + ob2.hashCode());
		int A6t[] = {1,2,1,3,4,2,3} ;
		int n6t = 7,  k6t=4;
		countDistinct(A6t , n6t , k6t);
		int ang = gcd(1,2);
		longestPalindrome("aaaabbaa");
		String s46 = "zoomlazapzo";
		String p46 ="ooa";
		System.out.println(smallestWindow(s46 , p46));
		int N23 = 9, K23 = 3;
		int arr23[] = {1 ,2 ,3, 1, 4, 5, 2, 3, 6};
		ArrayList <Integer> ans23 = max_of_subarrays(arr23 , N23 , K23);

		String sd = "245";
		System.out.println(sd.charAt(0));

		PriorityQueue<Integer> pq = new PriorityQueue<>(3 , Collections.reverseOrder());
		pq.remove(2);
		String[] ary = {"geeksforgeeks", "geeks", "geek",
		"geezer"};

		printLargest(ary);
		String firstValue="geek";
		for(int i = 0 ;i < ary.length; i++) {

			while(ary[i].indexOf(firstValue) != 0) {

				firstValue = firstValue.substring(0, firstValue.length() - 1);

			}

		}

		//		try  
		//		{  
		//			int data=50/0; //may throw exception   
		//			// if exception occurs, the remaining statement will not exceute  
		//			System.out.println("rest of the code");  
		//		}  
		//		// handling the exception   
		//		catch(ArithmeticException  e)  
		//		{  
		//			System.out.println(e);  
		//		}  
		//		catch(Exception e)  
		//		{  
		//			System.out.println(e);  
		//		}  


		System.out.println("rest of the code");  
		List<String> ans123 = new ArrayList<>();
		generate("" , 0 , 0 , 3 , ans123);
		climbStairs(4);
		int N5 = 2;
		String A[] = {"ro" , "oa" };
		System.out.println(isCircle(A.length, A));
		int grid [][] = {{0,1,2},{0,1,2},{2,1,1}};
		int answe = orangesRotting(grid);

		String str4= "a, a, a, a, b,b,b,c, c";
		str4 = str4. replaceAll("[&,.#%^*+-]", "");
		System. out. println(str4);
		String str5= "This#string%contains^special*characters&.";
		str5 = str5. replaceAll("[^A-Za-z0-9]", "");
		System. out. println(str5);

		String paragraph="Bob";

		String[] banned= {"bob", "hit"};
		paragraph = paragraph.replaceAll("[^A-Za-z0-9]", " ").toLowerCase();
		mostCommonWord( paragraph,  banned);
		isRobotBounded( "GGLLGG");
		int dirArray[][] = { { 1 , 0} , { } };

		String string = "We";

		string.toLowerCase();
		boolean bool1 = string.endsWith("for"); 
		HashSet<String> hs = new HashSet<>();
		hs.add(string);
		hs.contains(string);
		System.out.println(rremove("geeksforgeek"));
		int[] arr = {7 ,10, 4, 3, 20, 15};
		int k1=3;
		kthSmallest(arr, k1);
		int z = 10 , b = 20;
		System.out.print(FlippedCount(z, b));
		System.out.println(9&7);
		int numsid[] = {-1,0,3,5,9,12};

		search(numsid , 9);
		int N = 7;
		int a[] = {1,9,3,10,4,20,2};
		findLongestConseqSubseq(a , N);
		TreeSet<Integer> set=new TreeSet<Integer>();    
		set.add(24);    
		set.add(66);    
		set.add(12);    
		set.add(15);    

		System.out.println(set);

		String s = "g";
		HashSet<Integer> hm1 = new HashSet<>();
		hm1.contains(hm1);
		int[][]times = { {1,2,1} , {2,3,2} , {1,3,1}  };
		int n1 = 3, k=2 ;
		System.out.println(" networkDelayTime : "+networkDelayTime(times , n1 , k ));

		int a1='9';    
		char c=(char)a1;    
		System.out.println(c);   

		int  nums[] = {1,2,3};
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> a11 = new ArrayList<>();

		gen(nums , 0 , new ArrayList<>() , ans);



		int[] stones = { 0,1,2,3,4,8,9,11};
		canCross(stones);

		HashMap<String , Boolean > memo = new HashMap<>();

		//         for(int i=0 ; i<stones.length ; i++){

		//             memo.put(stones[i] , new HashSet<>());
		//         }

		System.out.println(jumpToLast(stones , 0 , stones.length , memo , 1));
		List<Integer> al = new ArrayList<Integer>();
		al.add(10);
		al.add(20);
		al.add(30);
		al.add(40);

		// Error: incompatible types: Object[]
		// cannot be converted to Integer[]

		Integer[] objects = (Integer[]) al.toArray();

		List<List<String> > s13 = new ArrayList<>();
		checkPartitioning("bcbddxy");


		InterfaceExample obj = new InterfaceExample();
		obj.display();

		MyInterface.d1();

	}
}
class Pair{

	int vertex ; 
	int cost ;

	public Pair(int vertex , int cost){

		this.vertex = vertex;
		this.cost   = cost;
	}
}
class Pair1{

	int x;
	int y;

	public Pair1(int x , int y){

		this.x = x;
		this.y = y;
	}
}
class Test1 {
	int x, y;
	Test1()
	{
		x = 10;
		y = 20;
	}
}

//class Triplet1{
//	String name;
//	int [] pos = new int[2];
//
//	public Triplet1(String name , int x , int y) {
//
//		this.name = name;
//		this.pos[0] = x;
//		this.pos[1] = y; 
//	}
//
//}