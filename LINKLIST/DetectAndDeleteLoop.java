package com.datastructures.LINKLIST;

public class DetectAndDeleteLoop {

	static Node head;

	public static void main(String[] args)
	{
		head = new Node(85);
		head.next = new Node(15);
		head.next.next = new Node(4);
		head.next.next.next = new Node(20);

		System.out.println("Given Linked list");
		printList(head);
		head = DetectLoopAndRemove(head);
		System.out.println("");
		System.out.println("Reversed linked list ");
		printList(head);
	}

	private static Node DetectLoopAndRemove(Node head2) {
		Node slowptr = null , fastptr = null ;
		boolean res = false;
		while(fastptr!=null && fastptr.next!=null) {

			slowptr= slowptr.next;
			fastptr=fastptr.next.next;

			if(slowptr==fastptr) {
				res=true;
				removeloop(slowptr , fastptr , head);
				break;
			}
		}

		return null;
	}

	private static void removeloop(Node slowptr, Node fastptr, Node head2) {

		slowptr = head;
		if(slowptr!=fastptr) {

			while(slowptr.next!=fastptr.next) {
				fastptr=fastptr.next;
				slowptr=slowptr.next;

			}
			fastptr.next=null;
		}
		else {  // Case where loop begins at first node i.e. circular link list
			while(fastptr.next!=slowptr) {
				fastptr=fastptr.next;
			}
			fastptr.next=null;
		}
	}

	static void printList(Node node)
	{
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
}
