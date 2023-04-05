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


		Long numD1= Long.valueOf("57999855392987");
		
        String sumS = String.valueOf(390);
        System.out.println(sumS.charAt(0));
        
        Node newNodeh = new Node(Integer.parseInt(String.valueOf(sumS.charAt(0))));
        
        Node tempHead = newNodeh;
        if(sumS.length()>1){
        int i = 1;
        while(i<sumS.length()){
        	Node newNode3 = new Node(Integer.valueOf(sumS.charAt(i)));
            tempHead.next = newNode3;
            tempHead = tempHead.next;
            i++;
        }
      }
        
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
	 static Node addTwoLists(Node first, Node second){
	        // code here
	        // return head of sum list
	        
	        Node head1 = first;
	        Node head2 = second;
	        
	        String num1="";
	        while(head1!=null){
	            
	            num1 = num1 +   String.valueOf(head1.data);
	            head1=head1.next;
	        }
	        int numD1= Integer.valueOf("432567");
	      
	        String num2="";
	        while(head2!=null){
	            
	            num2 = num2 +  String.valueOf(head2.data);
	            head2=head2.next;
	        }
	        int numD2= Integer.valueOf(num2);
	      //  System.out.println(numD2);
	        int sum = numD1 + numD2 ;
	        String sumS = String.valueOf(sum);
	        
	        Node newNodeh = new Node(Integer.valueOf(String.valueOf(sumS.charAt(0))));
	        
	        Node tempHead = newNodeh;
	        if(sumS.length()>1){
	        int i = 1;
	        while(i<sumS.length()){
	            Node newNode = new Node(Integer.valueOf(String.valueOf(sumS.charAt(i))));
	            tempHead.next = newNode;
	            tempHead = tempHead.next;
	            i++;
	        }
	      }
	      
	      return newNodeh;
	    }
}
