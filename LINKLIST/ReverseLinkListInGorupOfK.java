package com.datastructures.LINKLIST;
public class ReverseLinkListInGorupOfK {

	private static void printList(Node node) {

		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	static Node head;

	static Node reverse(Node headnode)
	{
		Node curr=headnode , prev = null , nextnode;

		while(curr.next!=null) {
			nextnode=curr.next;
			curr.next=prev;
			prev=curr;
			curr=nextnode;
		}
		curr.next=prev;
		head=curr;
		return head;
	}

	public static void main(String[] args)
	{
		int k = 2;
		head = new Node(85);
		head.next = new Node(15);
		head.next.next = new Node(4);
		head.next.next.next = new Node(20);
		head.next.next.next.next = new Node(21);


		System.out.println("Given Linked list");
		printList(head);
		head = reverseGroupOfK(head , k);
		System.out.println("");
		System.out.println("Reversed linked list ");
		printList(head);
	}

	private static Node reverseGroupOfK(Node head1 , int k) {

		Node curr=head1 , prev = null , nextnode = null;
		int count=0;
		while(curr!=null && count < k) {
			nextnode=curr.next;
			curr.next=prev;
			prev=curr;
			curr=nextnode;
			count++;
		}
		if(nextnode!=null) {
			head1.next = reverseGroupOfK(nextnode, k);
		}

		return prev;	
	}
}

