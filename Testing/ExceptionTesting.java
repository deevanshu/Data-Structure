package Testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionTesting implements Runnable{

	static List<Integer>list;
	static volatile int x=1;  


	@Override
	public void run() {

		System.out.println("Before Name :" +Thread.currentThread().getId() + " x value : "+x);

		Thread.currentThread().setName(String.valueOf(x));
		System.out.println(Thread.activeCount());
		synchronized(this) {
			x++;
		}

		System.out.println("After Name :" +Thread.currentThread().getName() + " x value : "+(x));
	} 
	public static int removeDuplicates(int[] nums) {


		int maxCount = 1 ,currCount=1;
		if(nums[0] ==0){

			currCount = 0;
			maxCount  = 0;
		}

		for(int i=1 ; i<= nums.length-1 ;i++){

			if(nums[i]==1 && nums[i-1]==1){

				currCount++;
			}
			else if(nums[i]==0 && (nums[i-1]==1 || nums[i-1]==0)){

				currCount = 0 ;
			}
			else {

				currCount = 1;
			}
			maxCount = Math.max(maxCount  , currCount) ;
		}

		return maxCount;
	}

	private static boolean validateInput(int val , int boardSize){

		if (val<1 || val>(boardSize*boardSize)) return false;

		int row = 2*( (val%boardSize==0)?(val/boardSize)-1:val/boardSize );
		int col = 2*( (val%boardSize==0 ? boardSize : val%boardSize) -1  );
		if((int)board[row][col] != 0) return false;

		return true;

	}
	static char board[][] = new char[5][5];

	//		_|_|_
	//		_|_|_
	//		 | |

	public static double myPow(double x, int n) {

		int count=0;
		double ans=1.0;
		long nn=n;
		if(nn<0)
			nn=-(nn);

		while(nn>0){
			count++;
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

		System.out.println("count :"+ count);
		return ans;


	}

	public static int majorityElement(int[] nums) {
		int count = 0;
		int candidate = 0;

		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			if(num==candidate)
				count += 1; 
			else count -= 1; 
		}

		return candidate;
	}

	public static int lengthOfLongestSubstring(String s) {

		int maxLength=0 , start=0 , end=-1 , currLength=0;

		HashMap<Character , Integer > hm = new HashMap<>();  // abcadcbb

		for(int i=0 ; i< s.length() ; i++){

			if(!hm.containsKey(s.charAt(i)) ){

				currLength+=1 ;
				hm.put(s.charAt(i) , i );
				end = end +1 ;
			}
			else{

				start = hm.get(s.charAt(i)) + 1 ;
				hm.put(s.charAt(i) , i);
				end = i ; 
				currLength = end - start + 1 ; 
				int remove = start -1 ;
				hm.entrySet().removeIf( entries-> entries.getValue() < remove );
			}
			maxLength = Math.max(maxLength  , currLength);
		}

		return maxLength ;
	}

	public static int maxProduct(int[] nums) {


		if(nums.length==1){

			return nums[0] ; 
		}

		int maxSoFar= Integer.MIN_VALUE , maxTillHere=Integer.MIN_VALUE , minTillHere=Integer.MAX_VALUE; 

		for(int i=0 ; i< nums.length ; i++){

			if(nums[i] < 0){

				int temp = maxTillHere ;
				maxTillHere = minTillHere ;
				minTillHere = temp ;
			}

			maxTillHere = Math.max( maxTillHere , maxTillHere * nums[i] )  ;
			minTillHere = Math.min( minTillHere , minTillHere * nums[i] ) ;

			if(maxTillHere < nums[i]){

				maxTillHere = nums[i];
			}

			if(minTillHere > nums[i]){

				minTillHere = nums[i];
			}

			maxSoFar = Math.max(maxTillHere , maxSoFar) ;

		}

		return maxSoFar ; 

	}

	static ArrayList<Integer> countDistinct(int A[], int n, int k) // [1, 2, 1, 3, 4, 2, 3]
	{
		// code here 
		HashMap<Integer , Integer > memo = new HashMap<>();

		int distinct = 0 ,start=0 ;
		ArrayList<Integer> ans = new ArrayList<>();

		for(int i = 0 ; i<n ; i++){

			if( !((i - start) + 1 <= k)) {

				ans.add(distinct);
				int count =  memo.get(A[start]);
				count = count - 1 ;
				if(count==0){

					memo.remove(A[start]);
					distinct -- ;
				}
				else{

					memo.put(A[start] , count);
				}
				start+=1 ;

			}

			if(memo.containsKey(A[i])){

				memo.put(A[i] , memo.get(A[i]) + 1 );
			}
			else{

				memo.put(A[i] , 1);

				distinct+=1 ;
			}
		}

		ans.add(distinct);
		return ans ; 
	}

	public static int lengthOfLongestSubstring1(String s) {


		int ans= 0;
		int release = 0 ;

		HashMap<Character , Integer> memo = new HashMap<>();

		for(int acquire = 0 ; acquire < s.length() ;  acquire++){

			while(memo.containsKey(s.charAt(acquire)) && release < acquire ){

				Integer temp =  memo.get(s.charAt(release));
				temp -=1 ; 
				if(temp==0){

					memo.remove(s.charAt(release));
				}
				release++;
			} 

			memo.put(s.charAt(acquire) , 1);
			ans = Math.max(ans , acquire - release +1);
		}

		return ans;
	}



	static int preorderStartIndex = 0;

	public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {


		int n = preorder.length;

		if(n==1){

			return new TreeNode(preorder[0]);
		}


		HashMap <Integer , Integer> hm = new HashMap<>();

		for(int i=0 ; i<n ;i++) {

			hm.put(postorder[i], i);
		}

		TreeNode ans = buildTree( preorder, postorder, n ,hm);

		System.out.println("here : "+ans.val);
		return ans;
	}

	public static TreeNode buildTree(int preorder[], int postorder[], int n, HashMap<Integer, Integer> hm)

	{
		// code here 
		int postorderStartIndex=0;
		int postorderEndIndex = n-1;
		TreeNode ans = solve(preorder , postorder , postorderStartIndex , postorderEndIndex  , n , hm);

		return ans ; 
	}

	static TreeNode solve(int preorder[] ,int postorder[]  , int postorderStartIndex ,int postorderEndIndex  , int n,HashMap<Integer, Integer> hm){

		if(preorderStartIndex >= n || postorderStartIndex > postorderEndIndex){

			return null;
		}

		int data = preorder[ preorderStartIndex] ;

		TreeNode root = new TreeNode( data );

		preorderStartIndex = preorderStartIndex + 1 ;

		if (postorderStartIndex == postorderEndIndex  || preorderStartIndex >= n)
			return root;

		int position = findPosition(preorder[ preorderStartIndex] , hm);

		root.left  = solve(preorder , postorder,  postorderStartIndex , position   , n, hm);
		root.right = solve(preorder , postorder,  position + 1   , postorderEndIndex-1  , n, hm);

		return root;
	}

	public int longestCommonSubsequence(String text1, String text2) {

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


		for(int i=1 ; i<= m ;i++){

			for(int j=1 ; j<= n ; j++){

				if(text1.charAt(i-1) == text2.charAt(j-1)){

					dp[i][j] = 1 +  dp[i-1][j-1]; 
				}
				else{

					dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]) ;
				}
			}
		}

		int length = dp[m][n] ; 
		int i = m ;
		int j = n;
		int index =0;
		String ans="";

		for(index=0; index<length;index++){
			ans +="$"; 
		}

		while(i > 0 && j>0){

			if(text1.charAt(i-1)==text2.charAt(j-1)){

				//   ans.setCharAt(index , text1.charAt(i-1));
				index--;
				i--;
				j--;

			}
			else if(dp[i-1][j] > dp[i][j-1]){

				i--;
			}
			else{
				// dp[i-1][j] < dp[i][j-1]
				j--;
			}
		}

		System.out.println("ans : "+ans);
		return dp[m][n];
	}
	public static int gcd(int n1,int n2)
	{
		while(n1%n2!=0){
			int rem=n1%n2;
			n1=n2;
			n2=rem;
		}
		return n2;
	}

	static int findPosition(int data , HashMap<Integer, Integer> hm){

		return hm.get(data);
	}  public static void vertical(TreeNode root , int level , int vd , TreeMap<Integer, List<List<Integer>>> memo){

		Queue<Triplet> qu = new LinkedList<>();

		qu.add(new Triplet(root , level , vd));

		while(!qu.isEmpty()){

			Triplet trip      = qu.poll();
			TreeNode currRoot = trip.root;
			int currlevel     = trip.level;
			int currVd        = trip.vd;

			if(memo.containsKey(currVd)){
				for(int i=0 ; i<=currlevel ; i++) {

					memo.get(currVd).add(new ArrayList<>());
				}
				memo.get(currVd).get(currlevel).add(currRoot.val);
			}
			else{

				memo.put(currVd , new ArrayList<>());
				List<Integer> list1 = new ArrayList<Integer>(); 
				list1.add(currRoot.val); 
				for(int i=0 ; i<=currlevel ; i++) {

					memo.get(currVd).add(new ArrayList<>());
				}
				memo.get(currVd).set(currlevel ,list1);
			}

			if(currRoot.left!=null){

				qu.add(new Triplet(currRoot.left , currlevel+1 , currVd-1));
			}
			if(currRoot.right!=null){

				qu.add(new Triplet(currRoot.right , currlevel+1 , currVd+1));
			} 
		}
	}

	public static ArrayList < Integer > majorityElement1(int[] nums) {

		int number1 = -1, number2 = -1, count1 = 0, count2 = 0, len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == number1)
				count1++;
			else if (nums[i] == number2)
				count2++;
			else if (count1 == 0) {
				number1 = nums[i];
				count1 = 1;
			} else if (count2 == 0) {
				number2 = nums[i];
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		ArrayList < Integer > ans = new ArrayList < Integer > ();
		count1 = 0;
		count2 = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == number1)
				count1++;
			else if (nums[i] == number2)
				count2++;
		}
		if (count1 > len / 3)
			ans.add(number1);
		if (count2 > len / 3)
			ans.add(number2);
		return ans;
	}
	public static int[][] kClosest(int[][] points, int k) {

		int[][] dist = new int[k][2];
		TreeMap<Double , String> tm = new TreeMap<>();

		for(int i = 0 ; i<points.length ; i++){

			double key = Math.sqrt(points[i][0]*points[i][0] + points[i][1]*points[i][1]) ; 
			if(tm.containsKey(key)){

				String num =  tm.get(key);
				String newValue =  num + "-" + i ;
				tm.put(key , newValue);
			}
			else{

				tm.put( key , String.valueOf(i)) ;
			}
		}

		int i = 0 ;
		for(Map.Entry<Double,String> entry : tm.entrySet()){

			if(i==k){
				break;
			}
			else{
				String value =  entry.getValue();

				if(value.contains("-")){

					String[] numberOfEntries = value.split("-");
					for(int j = 0 ; j < numberOfEntries.length && i<k; j++){

						String a1 = numberOfEntries[j];
						int a1Int = Integer.parseInt(a1); 
						dist[i][0] = points[a1Int][0];
						dist[i][1] = points[Integer.parseInt(numberOfEntries[j])][1]; 
						i++;
					}
				}
				else{
					dist[i][0] = points[Integer.parseInt(entry.getValue())][0];
					dist[i][1] = points[Integer.parseInt(entry.getValue())][1];
					i++;
				}
			} 
		}

		return dist;
	}

	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
	{
		// Create a list from elements of HashMap

		List<Map.Entry<String, Integer>> list1 = new LinkedList<>(hm.entrySet());

		List<Map.Entry<String, Integer> > list =
				new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {

			public int compare(Map.Entry<String, Integer> o1,
					Map.Entry<String, Integer> o2)
			{
				//	return (o1.getValue()).compareTo(o2.getValue());
				return o1.getValue()==o2.getValue() ?o1.getKey().compareTo(o2.getKey()):(o1.getValue()).compareTo(o2.getValue());
			}
		});

		// put data from sorted list to hashmap
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	public static boolean isMatch(String word, int i, String pattern, int j,
			Map<Character, String> map)
	{
		// invalid word
		if (word == null || pattern == null || word.length() < pattern.length()) {
			return false;
		}

		int n = word.length(), m = pattern.length();

		// if both pattern and the string reaches the end
		if (i == n && j == m) {
			return true;
		}

		// if either string or pattern reaches the end
		if (i == n || j == m) {
			return false;
		}

		// consider the next character from the pattern
		char curr = pattern.charAt(j);

		// if the character is seen before
		if (map.containsKey(curr))
		{
			String s = map.get(curr);
			int k = s.length();

			// `ss` stores next `k` characters of the given string
			String ss;
			if (i + k < word.length()) {
				ss = word.substring(i, i + k);
			}
			else {
				ss = word.substring(i);
			}

			// return false if the next `k` characters don't match with `s`
			if (ss.compareTo(s) != 0) {
				return false;
			}

			// recur for remaining characters if the next `k` characters match
			return isMatch(word, i + k, pattern, j + 1, map);
		}

		// process all remaining characters in the string if the current
		// character is never seen before
		for (int k = 1; k <= n - i; k++)
		{
			// insert substring formed by next `k` characters of the string
			// into the map
			System.out.println(word.substring(i, i + k));
			map.put(curr, word.substring(i, i + k));

			// check if it leads to the solution
			if (isMatch(word, i + k, pattern, j + 1, map)) {
				return true;
			}

			// otherwise, backtrack – remove the current character from the map
			map.remove(curr);
		}

		return false;
	}
	public static void main(String args[]) throws Exception{ 

	        String word = "codesleepcode";
	        String pattern = "XYX";
	 
	        // create a map to store mappings between the pattern and string
	        Map<Character, String> mapping = new HashMap<>();
	 
	        // check for solution
	        if (isMatch(word, 0, pattern, 0, mapping)) {
	            System.out.println(mapping);
	        } else {
	            System.out.println("Solution doesn't exist");
	        }
	        
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		// enter data into hashmap
		hm.put("Math", 98);
		hm.put("Data Structure", 98);

		System.out.println(hm.get(hm.size()));
		Map<String, Integer> hm1 = sortByValue(hm);

		// print the sorted hashmap
		for (Map.Entry<String, Integer> en : hm1.entrySet()) {
			System.out.println("Key = " + en.getKey() +
					", Value = " + en.getValue());
		}

		String lii[] = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		String intff[] = lii[0].split(" ");

		int hjh = Integer.parseInt("0");
		int a1Int = Integer.parseInt("0"); 
		int[][] points= {{0,1},{1,0} , {2,3}};
		int k45 = 2;
		kClosest(points,  k45);
		String s12 = "1-4-3";
		s12.substring(k45);
		boolean res  = s12.contains("-");
		boolean res12  = s12.contains("*");
		String[] arrr= s12.split("-");
		s12 = s12.concat("bu");	 
		List<String> list = new LinkedList<String>();

		// Adding elements to above LinkedList
		// using add() method
		list.add("Geeks");
		list.add("for");
		list.add("Geeks");
		list.add("Practice");

		// Converting List to array
		// using toArray() method
		String[] arr3 = list.toArray(new String[0]);

		int arr[] = {1, 2, 2, 3, 2};
		ArrayList < Integer > majority = majorityElement1(arr);
		System.out.print("The majority element is: ");

		HashMap<Integer , ArrayList<Integer>> memo1 = new HashMap<>();

		ArrayList<Integer> lo = new ArrayList<>();
		lo.add(1);
		memo1.put(0 , new ArrayList<>(2));

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		List<List<Integer>> list1 = new ArrayList<>();

		//if(root==null) return list;

		TreeMap<Integer , List<List<Integer>> > memo = new TreeMap<>();
		vertical(root , 0 , 0 , memo);

		for(Map.Entry<Integer ,List<List<Integer>>> entry : memo.entrySet() ){

			int distance = entry.getKey();
			List<List<Integer>> innerValue = entry.getValue();
			for(List<Integer> val : innerValue) {
				Collections.sort(val);

				if(val.size()>0) {
					list1.add(val);
				}
			}
		}

		System.out.println(gcd(26 , 12));
		System.out.println(gcd(16 , 12));
		int k  = -2 % 3;

		int [][] a2 = {
				{2,1,1},
				{2,3,1},
				{3,4,1}
		};

		ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

		for(int i=0 ; i<3 ; i++) {

			adj.add( new ArrayList<ArrayList<Integer>>() );
		}
		ArrayList<ArrayList<Integer>> neighbourCost = new ArrayList<>();

		for(int i=0 ; i< 3 ; i++) {

			neighbourCost.add(new ArrayList<>());
		}
		//		
		int z =neighbourCost.size();
		ArrayList<Integer> t1 = new ArrayList<>();
		ArrayList<Integer> t2 = new ArrayList<>();
		t1.add(0);
		t1.add(5);

		t2.add(1);
		t2.add(5);

		adj.get(0).add(t1);
		adj.get(1).add(t2);

		ArrayList<ArrayList<Integer>> ne = adj.get(0);

		ArrayList<Integer> t12 = new ArrayList<>();
		ArrayList<Integer> t22 = new ArrayList<>();
		t1.add(0);
		t1.add(1);

		t2.add(2);
		t2.add(1);

		adj.get(0).add(t12);
		adj.get(2).add(t22);


		for(ArrayList<Integer> curr : ne) {

			System.out.println(curr);
		}
		neighbourCost.get(0).add(1);
		neighbourCost.get(0).add(2);


		neighbourCost.get(0).add(1);
		neighbourCost.get(0).add(11);

		neighbourCost.get(1).add(3);
		neighbourCost.get(1).add(13);

		adj.set(0 , neighbourCost);
		neighbourCost = new ArrayList<>() ;
		for(int i=0 ; i< 3 ; i++) {

			neighbourCost.add(new ArrayList<>());
		}

		neighbourCost.get(0).add(4);
		neighbourCost.get(0).add(15);

		neighbourCost.get(1).add(5);
		neighbourCost.get(1).add(16);

		neighbourCost.get(2).add(6);
		neighbourCost.get(2).add(18);

		adj.add(neighbourCost);
		neighbourCost = new ArrayList<>() ;
		for(int i=0 ; i< 1 ; i++) {

			neighbourCost.add(new ArrayList<>());
		}

		neighbourCost.get(0).add(7);
		neighbourCost.get(0).add(20);

		adj.add(neighbourCost);

		//             0                          1                        2           
		//  [  [[1, 11], [3, 13]]  ,  [[4, 15], [5, 16], [6, 18]]  ,   [[6, 20]]  ]

		//           0                 1            2
		//  [  [  []  ,  []  ] ,  [ [] ,[] ,[] ]  , [  []  ]   ]

		//  0th index has 2 neighbours(1 ,3) , 1st has 3 neighbours(4,5,6) , 2 index has 1 neighbour(6)
		char ch = 'a';

		// Printing the character value
		System.out.println("char value: " + ch);

		// Converting character to its integer value
		int a22 = ch - '0';

		int b = ch - 'a';

		List<Integer> al = new ArrayList<Integer>(); 
		al.add(10); 
		al.add(20); 
		al.add(30); 
		al.add(40); 

		Integer[] arr1 = new Integer[al.size()]; 
		arr1 = al.toArray(arr1); 

		int preorder[]  = {2 ,1}; // LRR
		int postorder[] = {1 ,2}; // RLR

		constructFromPrePost(preorder ,postorder);
		System.out.println(lengthOfLongestSubstring1("pwwkew"));
		int N = 7, K = 4;
		int	A[] = {1,2,1,3,4,2,3};
		countDistinct (A , N , K) ;

		int ar1[] = {2,3,-2,4} ; 

		maxProduct(ar1);

		ArrayList<Integer> an = new ArrayList<>();
		an.add(1 , 1);
		an.add(1 , 5);

		int index = an.get(1);

		int V = 11;
		ArrayList < Integer > ans = new ArrayList < > ();
		int coins[] = {1,5,6,9};
		int n = coins.length;
		for (int i = n - 1; i >= 0; i--) {
			while (V >= coins[i]) {
				V -= coins[i];
				ans.add(coins[i]);
			}
		}
		System.out.println("The minimum number of coins is "+ans.size());
		System.out.println("The coins are ");
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(" " + ans.get(i));
		}


		int arr11[] = new int[] {1,1,0,1,1,1};
		removeDuplicates(arr11);
		double x = 2;
		int power = 32;
		System.out.println(myPow(x ,power));

		lengthOfLongestSubstring("abcabcbb");

		int nums[]= {1,1,1,2,2,2,3,2};

		majorityElement(nums);
		DeliveryHistoryItem d1 = new DeliveryHistoryItem(1 , 101);
		DeliveryHistoryItem d2 = new DeliveryHistoryItem(2 , 103);

		List<DeliveryHistoryItem> deliveryHistoryItemCronData = new ArrayList<>();
		deliveryHistoryItemCronData.add(d1);
		deliveryHistoryItemCronData.add(d2);



		List<DeliveryHistoryItem> toRemove = new ArrayList<>();

		LinkedHashMap<Long, Integer> delHistItemKeyToClinMessKey = new LinkedHashMap<>();
		for (DeliveryHistoryItem item : deliveryHistoryItemCronData) {

			delHistItemKeyToClinMessKey.put((long) item.clinicalMessKey, item.deliveryHistItemKey);
		}

		delHistItemKeyToClinMessKey.entrySet().removeIf( entries -> entries.getValue() < 102 );

		for(int i = 0  ;  i< delHistItemKeyToClinMessKey.size() ; i++) {

			delHistItemKeyToClinMessKey.get(i);
		}

		for (Map.Entry<Long, Integer> entry : delHistItemKeyToClinMessKey.entrySet()) {

			deliveryHistoryItemCronData.forEach(v -> {
				if (v.getDeliveryHistItemKey() == entry.getValue()) {
					toRemove.add(v);
				}
			});
		}

		deliveryHistoryItemCronData.removeAll(toRemove);

		StringBuilder inKeys = new StringBuilder("(");
		for (int i = 0; i < deliveryHistoryItemCronData.size() - 1; i++) {
			inKeys.append(deliveryHistoryItemCronData.get(i).getDeliveryHistItemKey()).append(", ");
		}
		inKeys.append(deliveryHistoryItemCronData.get(deliveryHistoryItemCronData.size() - 1).getDeliveryHistItemKey()).append(")");

		System.out.println(inKeys.toString());

		//		int a = 2/3;
		//		int b = 2%3;
		//		
		//		validateInput(1 , 3);

		long v=23;
		int i=2;
		String val =v+"|"+1;
		ArrayList < Integer> lll = new ArrayList<Integer>();
		lll.get(-1);


		int startingindex = val.indexOf("-9");

		int a = Integer.valueOf("");
		String indexWithValue = String.valueOf("");


		Map<String, String> cityCode = new HashMap<String, String>();
		cityCode.put("Delhi", "India");
		cityCode.put("Moscow", "Russia");
		cityCode.put("New York", "USA");

		Iterator iterator = cityCode.keySet().iterator();

		while (iterator.hasNext()) {
			System.out.println(cityCode.get(iterator.next()));

			// adding an element to Map
			// exception will be thrown on next call
			// of next() method.
			//    cityCode.put("Istanbul", "Turkey");
		}

		CopyOnWriteArrayList<Integer> list11
		= new CopyOnWriteArrayList<Integer>(new Integer[] { 1, 3, 5, 8 });
		Iterator itr = list11.iterator();
		while (itr.hasNext()) {
			Integer no = (Integer)itr.next();
			System.out.println(no);
			if (no == 1)

				// This will not print,
				// hence it has created separate copy
				list11.add(14);
		}
		System.out.println(list11);

		//		
		//		list = new ArrayList<>();
		//		for(int i=0;i<10;i++) {
		//
		//			list.add(i);
		//		}
		//		
		//		ExecutorService ex =  Executors.newFixedThreadPool(96);
		//
		//		ExceptionTesting obj = new ExceptionTesting();
		//		for(int i=0;i<10000;i++) {
		//			ex.submit(obj);
		//		}
		//		
		//	}
	}
}
class Triplet{

	TreeNode root ; 
	int  level;
	int  vd;

	public Triplet(TreeNode root , int level , int vd){

		this.root = root;
		this.level = level;
		this.vd = vd;
	}
}

class DeliveryHistoryItem {

	int clinicalMessKey ; 
	int deliveryHistItemKey;

	public DeliveryHistoryItem(int clinicalMessKey, int deliveryHistItemKey) {
		this.clinicalMessKey = clinicalMessKey;
		this.deliveryHistItemKey = deliveryHistItemKey;
	}

	public int getClinicalMessKey() {
		return clinicalMessKey;
	}

	public void setClinicalMessKey(int clinicalMessKey) {
		this.clinicalMessKey = clinicalMessKey;
	}

	public int getDeliveryHistItemKey() {
		return deliveryHistItemKey;
	}

	public void setDeliveryHistItemKey(int deliveryHistItemKey) {
		this.deliveryHistItemKey = deliveryHistItemKey;
	}

}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	public TreeNode(int val) { this.val = val; }
	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}