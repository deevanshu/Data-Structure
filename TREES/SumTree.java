package com.datastructures.TREES;

import java.util.LinkedList;
import java.util.Queue;

class NodeSTQ
{
	int data;
	NodeSTQ left, right;

	NodeSTQ(int item)
	{
		data = item;
		left = right = null;
	}
}


//		      62        
//		    /   \       
//		  16      15      
//		    \     / \     
//		     8    4  7    
//		      \  /
//		       8 4

public class SumTree
{
	NodeSTQ root;

	static boolean res = true ;
	int toSumTree(NodeSTQ node)
	{
		// Base case
		if (node == null )
			return 0;
		if( node.left==null && node.right ==null )
			return node.data;

		if(node.data != toSumTree(node.left) + toSumTree(node.right)) {

			res = false;
		}
		else {
			if(node.left!=null && node.right!=null) {

				node.data = node.data  + node.left.data + node.right.data;
			}
			else if(node.left!=null) {

				node.data = node.data  + node.left.data;
			}
			else {
				node.data = node.data + node.right.data;
			}
		}

		return node.data ;
	}

	public static void main(String args[])
	{
		SumTree tree = new SumTree();


		//		tree.root.left = new NodeSTQ(16);
		//		tree.root.right = new NodeSTQ(46);
		//		tree.root.left.left = new NodeSTQ(8);
		//		tree.root.left.right = new NodeSTQ(8);
		//		tree.root.right.left = new NodeSTQ(7);
		//		tree.root.right.right = new NodeSTQ(39);


		//		      62        
		//		    /   \       
		//		  16      15      
		//		    \     / \     
		//		     8    4  7    
		//		      \  /
		//		       8 4

		//	62 16 15 N 8 4 7 N 8 4
		//	tree.root = new NodeSTQ(62);
		//	tree.root = buildTree("62 16 15 N 8 4 7 N 8 4");                       
	//	tree.toSumTree(tree.root);

		tree.root = new NodeSTQ(1);
		tree.root.left = new NodeSTQ(2);
		tree.root.right = new NodeSTQ(3);
		NodeSTQ ans = tree.root;
		int a = 2 , b=3;
		int aDist = distanceFromLca(ans , a , 0);
		int bDist = distanceFromLca(ans , b , 0);
		System.out.println(res);
	}

	public static int distanceFromLca(NodeSTQ root , int val , int dist){

		if(root==null){
			return -1;
		}
		if(root.data==val){
			return dist;
		}
		int left  = distanceFromLca(root.left  ,val , dist+1);
		if(left!=-1){
			return dist;
		}
		return distanceFromLca(root.right ,val , dist+1);
	}
	static NodeSTQ buildTree(String str){

		if(str.length()==0 || str.charAt(0)=='N'){
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		NodeSTQ root = new NodeSTQ(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<NodeSTQ> queue = new LinkedList<>(); 

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while(queue.size()>0 && i < ip.length) {

			// Get and remove the front of the queue
			NodeSTQ currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if(!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new NodeSTQ(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if(i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if(!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new NodeSTQ(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}
}
