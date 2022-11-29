package com.datastructure.TRIE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Trie
{
	// Define the alphabet size (26 characters for `a – z`)
	private static final int CHAR_SIZE = 26;
	private boolean isLeaf;
	private List<Trie> children ;

	public Trie()
	{
		isLeaf = false;
		children = new ArrayList<>(Collections.nCopies(CHAR_SIZE, null));
	}

	public void insert(String key)
	{
		System.out.println("Inserting \"" + key + "\"");

		Trie curr = this;
		TrieNode crawler = TrieImplementation.root ;


		for(Character curr1 : key.toCharArray()){

			if(!crawler.childrens.containsKey(curr1)){

				crawler.childrens.put(curr1 , new TrieNode());
			}

			crawler = crawler.childrens.get(curr1);
		}

		crawler.isEndOfWord = true;
		for (char c: key.toCharArray())
		{

			System.out.println(c - 'a');

			if (curr.children.get(c - 'a') == null) {
				curr.children.set(c - 'a', new Trie());
			}

			curr = curr.children.get(c - 'a');
		}
		// mark the current node as a leaf
		curr.isLeaf = true;
	}

	public boolean search(String key)
	{
		System.out.print("Searching \"" + key + "\" : ");

		Trie curr = this;
		TrieNode crawler = TrieImplementation.root ;

		for (char c: key.toCharArray())
		{
			if (!crawler.childrens.containsKey(c)) {
				return false;
			}
			crawler = crawler.childrens.get(c);
		}
		// do for each character of the key
		for (char c: key.toCharArray())
		{
			if (curr.children.get(c - 'a') == null) {
				return false;
			}
			curr = curr.children.get(c - 'a');
		}

		return curr.isLeaf;
	}
}

class TrieNode{

	HashMap<Character , TrieNode > childrens ;
	boolean isEndOfWord;

	public TrieNode(){

		childrens = new HashMap<Character , TrieNode>();
		isEndOfWord = false;
	}
}

public class TrieImplementation
{
	static TrieNode root;
	public static void main (String[] args)
	{
		// construct a new Trie node
		Trie head = new Trie();
		root = new TrieNode();

		head.insert("techie");
		head.insert("techi");
		head.insert("tech");

		System.out.println(head.search("tech"));            // true
		System.out.println(head.search("tec"));           //   true
		System.out.println(head.search("techie"));          // true
		System.out.println(head.search("techiedelight"));   // false

		head.insert("techiedelight");

		System.out.println(head.search("tech"));            // true
		System.out.println(head.search("techi"));           // true
		System.out.println(head.search("techie"));          // true
		System.out.println(head.search("techiedelight"));   // true
	}
}
