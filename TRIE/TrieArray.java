package com.datastructure.TRIE;

import java.util.ArrayList;
import java.util.List;

//Java implementation of search and insert operations
//on TrieArray
public class TrieArray {

	// trie node
	static class TrieNode
	{
		TrieNode[] children = new TrieNode[26];
		boolean isEndOfWord = false;
		List<String> suggestions = new ArrayList<>();

			public TrieNode(String word){
			isEndOfWord = false;
			this.suggestions.add(word);
			for (int i = 0; i < 26; i++)
				 children[i] = null;
		}
	};
	
	static TrieNode root;
	static void insert(String key)
	{
		TrieNode Crawler = root;
		System.out.println('b'-'a');
		for (char c: key.toCharArray())
		{
			if (Crawler.children[c - 'a'] ==null) {
				Crawler.children[c - 'a'] = new TrieNode(key);
			}
			if(!Crawler.suggestions.contains(key)) {
				Crawler.suggestions.add(key);
			}
			Crawler = Crawler.children[c - 'a'];
		}
		// mark last node as leaf
		Crawler.isEndOfWord = true;
	}

	// Returns true if key presents in trie, else false
	static boolean search(String key)
	{

		TrieNode Crawler = root;

		for (int level = 0; level < key.length(); level++)
		{
			if (Crawler.children[key.charAt(level) - 'a'] == null)
			{
				return false;
			}

			Crawler = Crawler.children[key.charAt(level) - 'a'];
		}
		return Crawler.isEndOfWord;

		//	return searchWord(root , key , 0);  // Specifically when . (dots) are given 
	}
	public static boolean searchWord(TrieNode crawler , String word , int currIndex){

		if(crawler==null){

			return false;
		}
		if(currIndex>=word.length()){
			return crawler.isEndOfWord;
		}

		char currChar = word.charAt(currIndex);

		if(currChar=='.'){

			TrieNode childrens[] = crawler.children;

			for(int i = 0 ; i <childrens.length ;i++){

				if(searchWord(childrens[i] , word ,currIndex+1 )){
					return true;
				}
			}

			return false; 
		}
		else{

			if(crawler.children[currChar - 'a']==null){
				return false;
			}

			crawler = crawler.children[currChar - 'a'];
			return searchWord(crawler , word , currIndex+1);
		}
	}

	// Driver
	public static void main(String args[])
	{
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = {"the", "a", "there", "answer", "any",
				"by", "bye", "their"};

		String output[] = {"Not present in trie", "Present in trie"};


		root = new TrieNode("");

		// Construct trie
		int i;
		for (i = 0; i < keys.length ; i++)
			insert(keys[i]);

		// Search for different keys
		if(search("the") == true)
			System.out.println("the --- " + output[1]);
		else System.out.println("the --- " + output[0]);

		if(search("these") == true)
			System.out.println("these --- " + output[1]);
		else System.out.println("these --- " + output[0]);

		if(search("their") == true)
			System.out.println("their  --- " + output[1]);
		else System.out.println("their --- " + output[0]);

		//
		//		if(search("..e") == true)
		//			System.out.println("..e  --- " + output[1]);
		//		else System.out.println("..e  --- " + output[0]);

		if(search("thaw") == true)
			System.out.println("thaw --- " + output[1]);
		else System.out.println("thaw --- " + output[0]);

	}
}
//This code is contributed by Sumit Ghosh
