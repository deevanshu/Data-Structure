package Testing;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

class NodeT{

	int data;
	NodeT left;
	NodeT right;

	public NodeT(int data) {
		this.data=data;
		this.left=null;
		this.right=null;
	}
}
public class TreeCreation {

	public static void main(String args[]) {

		
		NodeT head = treeCreation();
		System.out.println(head.data);
		int height = HeightOfTree(head);
		NodeT mirrorHead = mirrorImage(head);
		InOrderTraversalWithoutRecusrion(head);
	}

	private static void InOrderTraversalWithoutRecusrion(NodeT head) { // L Root R

		Stack<NodeT>st = new Stack<>();
		NodeT curr = head;
		while(curr!=null || !st.empty()) {

			while(curr!=null) {

				st.push(curr);
				curr = curr.left;
			}
			curr = st.pop();
			System.out.println(curr.data);
			curr = curr.right;
		}
	}

	private static NodeT mirrorImage(NodeT head) {
		if(head==null) {
			return null;
		}
		NodeT newNode = new NodeT(head.data);
		newNode.left  = mirrorImage(head.right);
		newNode.right  = mirrorImage(head.left);
		return newNode;
	}

	private static int HeightOfTree(NodeT head) {

		if(head==null) {
			return 0;
		}
		return 1 + Math.max(HeightOfTree(head.left) , HeightOfTree(head.right));
	}

	private static NodeT treeCreation() {

		System.out.println("Please eneter data : ");
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		if(data ==-1) {
			return null;
		}
		NodeT head = new NodeT(data);
		System.out.println("Please eneter data of left for NodeT : "+ data);
		head.left = treeCreation();
		System.out.println("Please eneter data of right for NodeT : "+ data);
		head.right = treeCreation();

		return head;
	}
}
