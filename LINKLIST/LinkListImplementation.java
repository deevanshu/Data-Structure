package com.datastructures.LINKLIST;
import java.util.Scanner;

class NodeL{

	int data;
	NodeL next;

	NodeL(int data){

		this.data=data;
		this.next=null;
	}
}

public class LinkListImplementation {
	public static void main(String args[]) {


		System.out.println("Enter Number Of Nodes \n");
		Scanner sc = new Scanner(System.in);
		int nodes = sc.nextInt();

		NodeL head = null;
		for(int i=0 ; i<nodes ; i++) {

			System.out.println("Enter "+ i +" NodeL Data : \t");
			Scanner sc1 = new Scanner(System.in);
			int data = sc.nextInt();
			if(head==null) {

				head = new NodeL(data);

			}else {

				NodeL temp = new NodeL(data);
				NodeL tempnode=head;
				while(tempnode.next!=null) {
					tempnode = tempnode.next;
				}

				tempnode.next = temp;

			}
		}
		NodeL tempnode=head;
		while(tempnode!=null) {

			System.out.println(tempnode.data +" -> ");
			tempnode = tempnode.next;
		}	
	}
}
