package com.datastructures.TREES;

class NodST
{
	int data;
	NodST left, right;

	NodST(int item)
	{
		data = item;
		left = right = null;
	}
}

class ConvertToTreeToSumTree
{
	NodST root;

	// Convert a given tree to a tree where every node contains sum of
	// values of nodes in left and right subtrees in the original tree
	int toSumTree(NodST node)
	{
		// Base case
		if (node == null)
			return 0;

		// Store the old value
		int old_val = node.data;

		// Recursively call for left and right subtrees and store the sum
		// as new value of this node
		node.data = toSumTree(node.left) + toSumTree(node.right);

		// Return the sum of values of nodes in left and right subtrees
		// and old_value of this node
		return node.data + old_val;
	}
	
	// A utility function to print inorder traversal of a Binary Tree
	void printInorder(NodST node)
	{
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	/* Driver function to test above functions */
	public static void main(String args[])
	{
		ConvertToTreeToSumTree tree = new ConvertToTreeToSumTree();

		/* Constructing tree given in the above figure */
		tree.root = new NodST(10);
		tree.root.left = new NodST(-2);
		tree.root.right = new NodST(6);
		tree.root.left.left = new NodST(8);
		tree.root.left.right = new NodST(-4);
		tree.root.right.left = new NodST(7);
		tree.root.right.right = new NodST(5);

		tree.toSumTree(tree.root);

		// Print inorder traversal of the converted tree to test result
		// of toSumTree()
		System.out.println("Inorder Traversal of the resultant tree is:");
		tree.printInorder(tree.root);
	}
}
