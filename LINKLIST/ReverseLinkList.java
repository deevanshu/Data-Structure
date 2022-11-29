package com.datastructures.LINKLIST;

class Node {

	int data;
	Node next;

	Node(int d)
	{


		data = d;
		next = null;


	}
}

public class ReverseLinkList {


	static Node head;
	static Node newhead;

	static Node reverse(Node headnode)
	{
		Node curr=headnode , prev = null , nextnode;

		while(curr!=null) {
			nextnode=curr.next;
			curr.next=prev;
			prev=curr;
			curr=nextnode;
		}

		return prev;
	}

	static void ReverseRecursive(Node p)
	{
		Node q = null ;

		if(p.next==null) {

			newhead=p;
			return;
		}
		ReverseRecursive(p.next);
		q=p.next;
		q.next = p ;
		p.next=null;
	}

	static void printList(Node node)
	{
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args)
	{
		head = new Node(85);
		head.next = new Node(15);
		head.next.next = new Node(4);
		head.next.next.next = new Node(20);

		System.out.println("Given Linked list");
		printList(head);
		//	head = reverse(head);
		ReverseRecursive(head);
		System.out.println("");
		System.out.println("Reversed linked list ");
		printList(newhead);
	}
}

