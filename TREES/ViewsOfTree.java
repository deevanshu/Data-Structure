package com.datastructures.TREES;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

class NodeVT {

	int data;
	NodeVT left;
	NodeVT right;

	public NodeVT(int data) {

		this.data = data;
		this.left = null;
		this.right = null;
	}
}
class NodeHD{

	int hd ;
	NodeVT node ;

	public NodeHD(int hd , NodeVT node){
		this.hd = hd;
		this.node = node ;
	}
}
public class ViewsOfTree {

	static NodeVT root;
	public static void main(String[] args)
	{
		//	head = createBinaryTree();
		TreeMap <Integer , ArrayList<Integer>> tm = new TreeMap<>();
		ViewsOfTree tree = new ViewsOfTree();
		tree.root = new NodeVT(1);
		tree.root.left = new NodeVT(2);
		tree.root.right = new NodeVT(3);
		tree.root.left.left = new NodeVT(4);
		tree.root.left.right = new NodeVT(5);
		tree.root.right.left = new NodeVT(6);
		tree.root.right.right = new NodeVT(7);
		tree.root.left.left.right = new NodeVT(8);

		System.out.println(root);
		//	    leftView(root);
		//	    rightView(root);
		//	    topView(root);
		//	    bottomView(root);
		//	    zigzagTraversal(root);
		//      boundaryTraversal(root);
	}

	//  1
	// /  \
	//2     3
	///  \  /  \
	//4   56   7
	//\
	//8

	private static void bottomView(NodeVT root) {
		if(root==null) {
			return ;
		}
		TreeMap <Integer , Integer> tm = new TreeMap<>();
		Queue<NodeHD> qu = new LinkedList<>();
		NodeHD head = new NodeHD(0 , root);
		qu.add(head);
		while(!qu.isEmpty()) {
			NodeHD temp = qu.poll();
			if(!tm.containsKey(temp.hd)) {
				tm.put(temp.hd, temp.node.data);
			}
			else {
				//				Integer te = tm.get(temp.hd);
				//				te=temp.node.data;
				tm.put(temp.hd, temp.node.data);
			}
			if(temp.node.left!=null) {
				qu.add(new NodeHD(temp.hd-1 , temp.node.left));
			}
			if(temp.node.right!=null) {
				qu.add(new NodeHD(temp.hd+1 , temp.node.right));
			}
		}
		Set<Map.Entry<Integer , Integer>> entries= tm.entrySet();
		ArrayList<Integer> ar = new ArrayList<Integer>();

		for(Map.Entry<Integer, Integer> i : tm.entrySet()) {

			ar.add(i.getValue());
		}
		System.err.println(tm);
		System.err.println(ar);
	}
	private static void topView(NodeVT root) {
		if(root==null) {
			return ;
		}
		TreeMap <Integer , Integer> tm = new TreeMap<>();
		Queue<NodeHD> qu = new LinkedList<>();
		NodeHD head = new NodeHD(0 , root);
		qu.add(head);
		while(!qu.isEmpty()) {
			NodeHD temp = qu.poll();
			if(!tm.containsKey(temp.hd)) {

				tm.put(temp.hd, temp.node.data);
			}
			if(temp.node.left!=null) {
				qu.add(new NodeHD(temp.hd-1 , temp.node.left));
			}
			if(temp.node.right!=null) {
				qu.add(new NodeHD(temp.hd+1 , temp.node.right));
			}
		}
		Set<Map.Entry<Integer , Integer>> entries= tm.entrySet();
		ArrayList<Integer> ar = new ArrayList<Integer>();

		for(Map.Entry<Integer, Integer> i : entries) {

			ar.add(i.getValue());
		}
		System.err.println(tm);
		System.err.println(ar);
	}
	private static void rightView(NodeVT root2) {
		//  1378
		rightViewRecusrion(root2);
		rightViewWithoutRecusrion(root2);
	}
	private static void rightViewWithoutRecusrion(NodeVT root2) {

		if(root2==null) {
			return ;
		}
		Queue<NodeVT> qu = new LinkedList<>();
		qu.add(root2);
		NodeVT temp=null;

		while(!qu.isEmpty()) {

			int size = qu.size();

			for(int i = 1 ; i<= size; i++) {			

				temp = qu.poll();

				if(i==size) {

					System.out.print(temp.data);
				}
				if(temp.left!=null) {

					qu.add(temp.left);
				}
				if(temp.right!=null) {

					qu.add(temp.right);
				}

			}
		}
	}
	private static void rightViewRecusrion(NodeVT root2) {


		if(root2==null) {
			return ;
		}
		ArrayList<Integer> ar = new ArrayList<Integer>();
		right(root2 , 0 ,ar);
		System.out.println(ar);

	}
	private static void right(NodeVT root2, int level, ArrayList<Integer> ar) {



		if(root2==null) {

			return ;
		}

		if(ar.size() == level) {

			System.out.print(root2.data);
			ar.add(root2.data);
		}

		left(root2 .right, level+1,ar );

		left(root2.left , level+1 ,ar);
	}
	private static void leftView(NodeVT root2) {
		//  1248
		leftViewRecusrion(root2);
		leftViewWithoutRecusrion(root2);
	}
	private static void leftViewWithoutRecusrion(NodeVT root2) {  

		if(root2 == null) {
			return ;
		}
		Queue<NodeVT> qu = new LinkedList<>();
		qu.add(root2);
		NodeVT temp=null;

		while(!qu.isEmpty()) {

			int size = qu.size();
			for(int i = 1; i<=size ; i++) {

				temp = qu.poll();

				if(i==1) {

					System.out.print(temp.data);
				}
				if(temp.left!=null) {

					qu.add(temp.left);
				}
				if(temp.right!=null) {

					qu.add(temp.right);
				}
			}
		}
	}
	private static void leftViewRecusrion(NodeVT root2) {

		if(root2==null) {
			return ;
		}
		ArrayList<Integer> ar = new ArrayList<Integer>();
		left(root2 , 0 ,ar);
		System.out.println(ar);
	}
	private static void left(NodeVT root2, int level ,ArrayList<Integer> ar ) {

		if(root2==null) {

			return ;
		}
		if(ar.size() == level) {

			System.out.print(root2.data);
			ar.add(root2.data);
		}

		left(root2.left , level+1 ,ar);


		left(root2 .right, level+1,ar );

	}
	private static void zigzagTraversal(NodeVT root) {

		if(root==null) {
			return ;
		}
		boolean leftToRight = true;
		Queue <NodeVT> qu = new LinkedList<>();

		qu.add(root);
		ArrayList<Integer> ar = new ArrayList<>();

		while(!qu.isEmpty()) {

			int size = qu.size();
			int temp[] = new int[size];


			if(leftToRight) {
				for(int i = 0; i<size;i++) {

					NodeVT node = qu.poll();

					temp[i]= node.data;

					if(node.left!=null) {

						qu.add(node.left);
					}
					if(node.right!=null) {

						qu.add(node.right);
					}
				}
			}
			else {
				for(int i = size-1; i>=0;i--) {

					NodeVT node = qu.poll();

					temp[i]= node.data;

					if(node.left!=null) {

						qu.add(node.left);
					}
					if(node.right!=null) {

						qu.add(node.right);
					}
				}
			}
			for(int i=0;i<temp.length;i++) {

				ar.add(temp[i]);
			}

			leftToRight= !leftToRight;
		}
		System.out.println(ar);
	}
	private static ArrayList <Integer> boundaryTraversal(NodeVT root) {

		ArrayList <Integer> ar = new ArrayList<>();
		if(root==null){

			return ar;
		}
		ar.add(root.data);
		if(isLeaf(root)) {

			return ar;
		}
		leftTraversalExceptRoot(root.left , ar);
		LeafTraversal(root , ar);
		rightTraversalExceptRoot(root.right , ar);
		System.out.println(ar);

		return ar;
	}
	public static boolean isLeaf(NodeVT root) {

		if(root.left==null && root.right ==null) {

			return true;
		}
		return false;
	}
	private static void rightTraversalExceptRoot(NodeVT root, ArrayList<Integer> ar) {

		if(root==null) {
			return ;
		}
		ArrayList<Integer> temp = new ArrayList<>();
		while(root!=null) {

			if(!isLeaf(root)) {
				temp.add(root.data);
			}
			if(root.right!=null) {

				root = root.right;
			}
			else {
				root = root.left;
			}
		}
		Collections.reverse(temp);
		for(int i :temp){
			ar.add(i);
		}
	}
	private static void LeafTraversal(NodeVT root, ArrayList<Integer> ar) {

		//		if(root==null) {
		//			return ;
		//		}
		//		Queue<NodeVT> qu = new LinkedList<>();
		//		qu.add(root);
		//
		//		while(!qu.isEmpty() ) {
		//
		//			int size =qu.size();
		//			for(int i=1;i<=size;i++) {
		//
		//				NodeVT temp = qu.poll();
		//
		//				if(temp.left==null && temp.right==null ) {
		//					ar.add(temp.data);
		//				}
		//				if(temp.left!=null)
		//					qu.add(temp.left);
		//				if(temp.right!=null)
		//					qu.add(temp.right);
		//			}
		//		}

		if (root.left == null && root.right == null)
		{
			ar.add(root.data);
			return;
		}
		if(root.left!=null) {
			LeafTraversal(root.left, ar);
		}else {
			LeafTraversal(root.right, ar);
		}

	}
	private static void leftTraversalExceptRoot(NodeVT root, ArrayList<Integer> ar) {

		if(root==null) {
			return ;
		}

		while(root!=null) {

			if(!isLeaf(root)) {
				ar.add(root.data);
			}
			if(root.left!=null) {

				root = root.left;
			}else {
				root= root.right;
			}
		}
	}
}

//       1
//      /  \
//     2     3
//    /  \  /  \
//    4   56   7
//    \
//     8
