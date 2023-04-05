package com.datastructures.BSTREES;
//Java program to demonstrate
//delete operation in binary
//search tree
public class BinarySearchOperations {

	class Node {
		int key;
		Node left, right;

		public Node(int item)
		{
			key = item;
			left = right = null;
		}
	}

	Node root;

	BinarySearchOperations() { root = null; }

	void deleteKey(int key) { root = deleteRec(root, key); }

	Node deleteRec(Node root, int key)
	{
		if (root == null)
			return null;

		if (key < root.key)
			root.left = deleteRec(root.left, key);
		else if (key > root.key)
			root.right = deleteRec(root.right, key);

		// if key is same as root's
		// key, then This is the
		// node to be deleted
		else {
			// node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// node with two children: Get the inorder
			// successor (smallest in the right subtree)
			root.key   = minValue(root.right);

			// Delete the node 
			root.right = deleteRec(root.right, root.key);
		}

		return root;
	}

	int minValue(Node root)
	{
		int minv = root.key;
		while (root.left != null)
		{
			minv = root.left.key;
			root = root.left;
		}
		return minv;
	}

	void insert(int key) { root = insertRec(root, key); }

	Node insertRec(Node root, int key)
	{

		/* If the tree is empty,
		return a new node */
		if (root == null) {
			root = new Node(key);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		/* return the (unchanged) node pointer */
		return root;
	}

	void inorder() { inorderRec(root); }


	void inorderRec(Node root)
	{
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.key + " ");
			inorderRec(root.right);
		}
	}


	public static void main(String[] args)
	{
		BinarySearchOperations tree = new BinarySearchOperations();

		/* Let us create following BST
			50
		/	 \
		30	 70
		/ \ / \
		20 40 60 80 */
		tree.insert(5);
		tree.insert(3);
		tree.insert(6);
		tree.insert(4);
		tree.insert(7);
		tree.insert(2);

		System.out.println(
				"Inorder traversal of the given tree");
		tree.inorder();

		System.out.println("\nDelete 3");
		tree.deleteKey(3);
		System.out.println(
				"Inorder traversal of the modified tree");
		tree.inorder();

	}
}