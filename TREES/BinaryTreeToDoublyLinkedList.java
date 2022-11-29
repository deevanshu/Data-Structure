package com.datastructures.TREES;

class NodeDLL
{
	int data;
	NodeDLL left, right;

	public NodeDLL(int data)
	{
		this.data = data;
		left = right = null;
	}
}

public class BinaryTreeToDoublyLinkedList
{
	NodeDLL root;

	// head --> Pointer to head node of created doubly linked list
	NodeDLL head;

	// Initialize previously visited node as NULL. This is
	// static so that the same value is accessible in all recursive
	// calls
	static NodeDLL prev = null;

	// A simple recursive function to convert a given Binary tree
	// to Doubly Linked List
	// root --> Root of Binary Tree
	void BinaryTree2DoubleLinkedList(NodeDLL root)
	{
		// Base case
		if (root == null)
			return;

		// Recursively convert left subtree
		BinaryTree2DoubleLinkedList(root.left);

		// Now convert this node
		if (prev == null)
			head = root;
		else
		{
			root.left = prev;
			prev.right = root;
		}
		prev = root;

		// Finally convert right subtree
		BinaryTree2DoubleLinkedList(root.right);
	}

	/* Function to print nodes in a given doubly linked list */
	void printList(NodeDLL node)
	{
		while (node != null)
		{
			System.out.print(node.data + " ");
			node = node.right;
		}
	}

	// Driver program to test above functions
	public static void main(String[] args)
	{
		// Let us create the tree as shown in above diagram
		BinaryTreeToDoublyLinkedList tree = new BinaryTreeToDoublyLinkedList();
		tree.root = new NodeDLL(10);
		tree.root.left = new NodeDLL(12);
		tree.root.right = new NodeDLL(15);
		tree.root.left.left = new NodeDLL(25);
		tree.root.left.right = new NodeDLL(30);
		tree.root.right.left = new NodeDLL(36);

		// convert to DLL
		tree.BinaryTree2DoubleLinkedList(tree.root);

		// Print the converted List
		tree.printList(tree.head);

	}
}
//This code has been contributed by Mayank Jaiswal(mayank_24)
