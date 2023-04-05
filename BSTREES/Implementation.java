package com.datastructures.BSTREES;
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
public class Implementation {

	static Node head;
	public static void main(String[] args)
	{

		Implementation obj = new Implementation();
		obj.head   = new Node(50);
		head.left  = new Node(30);
		head.right = new Node(70);

		head.left.left  = new Node(20);
		head.left.right = new Node(40);

		head.right.right = new Node(80);
		head.right.left  = new  Node(60);
		//		System.out.println("Please Enter No. Of Node In tree ");
		//		Scanner sc = new Scanner(System.in);
		//		int numberOfNodes = sc.nextInt();
		//
		//		for(int i=0 ; i<numberOfNodes ;i++ ) {
		//
		//			System.out.println("Please Enter Data Other than -1:");
		//			int data = sc.nextInt();
		//			head = insertNodeBinarySearchTree(head , data);
		//		}
		System.out.println(head.data);

		//		System.out.println("Please Enter Data Of Node To Search ");
		//		Scanner sc = new Scanner(System.in);
		//		int data = sc.nextInt();
		//
		//		Node temp  = searchIntree(data , head);
		//		System.out.println(temp);

		int dataDel = 20;
		Node     del  = deleteIntree(30 , head);
		         del  = deleteIntree(30 , head);
	             del  = deleteIntree(50 , head);
		System.out.println(del);	
	}
	
//      50                                     
//    /     \
//   30      70             
//  /  \    /  \
// 20   40  60   80 
	
	private static Node deleteIntree(int data, Node head) {

		if(head==null) {

			return head;
		}
		if(data < head.data) {

			head.left =  deleteIntree(data , head.left);
 		}
		else if(data > head.data) {

			head.right = deleteIntree(data , head.right);
		}
		else {

			if(head.left == null) {
				return head.right;
			}
			else if(head.right == null) {
				return head.left;
			}

			head.data  = findMinInRightSubtree(head.right);
			head.right = deleteIntree(head.data , head.right);
		}

		return head;
	}
	private static int findMinInRightSubtree(Node head2) {

		int datamin = head2.data;
		while(head2.left !=null) {

			datamin = head2.left.data;
			head2 = head2.left;
		}

		return datamin;
	}
	private static Node insertNodeBinarySearchTree(Node head , int data) {

		if(head==null) {
			return head = new Node(data);
		}
		if(data < head.data) {

			head.left = insertNodeBinarySearchTree(head.left , data);
		}
		else {

			head.right = insertNodeBinarySearchTree(head.right , data);
		}

		return head;
	}	
	private static Node searchIntree(int data, Node head) {

		if(head==null) {

			return head;
		}
		if(data==head.data) {

			return head;
		}
		if(data < head.data) {

			return searchIntree(data , head.left);
		}

		return searchIntree(data , head.right);
	}
}