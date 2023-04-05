package com.datastructures.TREES;

import java.util.HashSet;

class NodeSTD
{
	int data;
	NodeSTD left, right;

	NodeSTD(int item)
	{
		data = item;
		left = right = null;
	}
}
public class DuplicateSubTreeInBinaryTree {

	static NodeSTD root;
	static NodeSTD subRoot;
	
	public static void main(String args[])
	{
		DuplicateSubTreeInBinaryTree tree = new DuplicateSubTreeInBinaryTree();
		//DuplicateSubTreeInBinaryTree subRoot = new DuplicateSubTreeInBinaryTree();
		tree.subRoot = new NodeSTD(1);
//		tree.subRoot.left = new NodeSTD(1);
//		tree.subRoot.right = new NodeSTD(5);

		tree.root = new NodeSTD(1);

		tree.root.left = new NodeSTD(2);
		tree.root.right = new NodeSTD(3);

		tree.root.left.left        = new NodeSTD(4);
		tree.root.left.right       = new NodeSTD(5);

		tree.root.right.left       = new NodeSTD(7);
		tree.root.right.right      = new NodeSTD(2);

		tree.root.right.right.left = new NodeSTD(4);
		tree.root.right.right.right = new NodeSTD(5);

		//	          1
		//	        /   \ 
		//	      2       3
		//	    /   \    / \    
		//	   4     5  7   2     
		//	               / \    
		//	               4  5

		//	duplicateBinarySubTree(root);
		isSubtree(root , subRoot);
	}
	static private HashSet<String> set;
	static boolean found = false;
	static Boolean[] ar = {false};

	public static boolean isSubtree(NodeSTD root, NodeSTD subRoot) {
		duplicateBinarySubTree(root);
		return ar[0];
	}

	private static int duplicateBinarySubTree(NodeSTD root) {

		set = new HashSet<String>();
		duplicate(root);
		if (found) 
		{
			System.out.println("Found");
			return 1;
		}
		System.out.println("Not Found");
		return 0;
	}

	private static String duplicate(NodeSTD root) {

		StringBuilder s = new StringBuilder();
		
		if (root == null) {
			return "";
		}
		if (root.left==null && root.right==null) return root.data+"";

		s.append(root.data+"");
		s.append(duplicate(root.left));
		s.append(duplicate(root.right));
		
		if (set.contains(s.toString())) {
			found = true;
		}
		else {
			set.add(s.toString());
		}
		return s.toString();
	}
}

//			    1
//			  /   \ 
//			 2     3
//			/  \  /  \    
//		   4    57    2     
//			         /  \    
//			        4    5
