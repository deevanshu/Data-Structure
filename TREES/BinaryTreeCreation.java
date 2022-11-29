package com.datastructures.TREES;

import java.util.Scanner;

class Node {

	int data;
	Node left;
	Node right;

	public Node(int data) {

		this.data = data;
		this.left = null;
		this.right = null;
	}
}
public class BinaryTreeCreation {

	static Node head;
	static int index=0;
	public static void main(String[] args)
	{

			head = createBinaryTree();
			System.out.println(head.data);

		int [] array = {1 ,2 ,4 , -1 , -1 ,5 ,-1 ,-1 , 3 ,6 ,-1 , -1 , 7, -1 , -1};
		System.out.println(head.data);
	}

	private static Node createBinaryTree() {


		System.out.println("Please Enter Data Of Node : ");

		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();

		Node head = new Node(data);

		if(data == -1) {

			return null;
		}

		System.out.println("Please Enter Data For Left Of: "+ data);
		head.left = createBinaryTree();

		System.out.println("Please Enter Data For Right Of: "+ data);
		head.right = createBinaryTree();

		return head;
	}
}
