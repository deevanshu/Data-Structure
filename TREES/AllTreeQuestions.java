package com.datastructures.TREES;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class NodeBT {

	int data;
	NodeBT left;
	NodeBT right;

	public NodeBT(int data) {

		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class AllTreeQuestions {


	static NodeBT root;
	public static void main(String[] args)
	{
		//	head = createBinaryTree();

		AllTreeQuestions tree = new AllTreeQuestions();

		//		tree.root = new NodeBT(1);
		//		tree.root.left = new NodeBT(0);
		//		tree.root.right = new NodeBT(1);
		//
		//		tree.root.left.left = new NodeBT(0);
		//		tree.root.left.right = new NodeBT(1);

		tree.root = buildTree("4 10 N 5 5 N 6 7 N 8 8 N 8 11 N 3 4 N 1 3 N 8 6 N 11 11 N 5 8");

		//		tree.root.right.left = new NodeBT(0);
		//		tree.root.right.right = new NodeBT(1);
		//
		//		tree.root.left.right.left = new NodeBT(6);

		//             1
		// 	       /        \
		// 	      2          7
		// 	     /  \      /  \
		// 	    4    3     8    9
		//     / \  / \   / \  / \
		//	  nu nu 5  6 nu nu nu nu
		//		    /
		//		    7
		System.out.println(root);

		    levelOrderTraversal(root);
		//		int height = HeightOfTree(root);
		//		System.out.println(height);
		//		NodeBT mirrorHead = mirrorImage(root);
		//		System.out.println(mirrorHead);

		sumRootToLeaf(root);
		//		InOrderTraversal(root);  // Left  Node Right  LNR ;
		//		PrOrderTraversal(root); //  Node  Left Right  NLR ;
		//    	PostOrderTraversal(root);// Right Left Node   RLN ;


		InOrderTraversalWithoutRecusrion(root);   // Left NodeBT Right LNR ;
		//		PreOrderTraversalWithoutRecusrion(root);  //  NodeBT Left Right NLR ;
		//      PostOrderTraversalWithoutRecusrion(root); // Right Left NodeBT RLN ;


		//      isbalanced(root);
		//	    leafAtSameLevel(root);

		//	    sumOfNodesOnLongestPath(root);

		//	    NodeBT res = lca(root , 7  ,6  );
		//		System.out.println(res.data);
	}


	//          1
	// 	     /     \
	// 	    2       3
	// 	   /  \    / \
	// 	  4    5  6   7
	private static NodeBT lca(NodeBT node, int n1, int n2) {

		// Your code here
		if (node == null)
			return null;
		// If either n1 or n2 matches with root's key, report
		// the presence by returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if (node.data == n1 || node.data == n2)
			return node;
		// Look for keys in left and right subtrees
		NodeBT left_lca = lca(node.left, n1, n2);
		NodeBT right_lca = lca(node.right, n1, n2);

		if (left_lca!=null && right_lca!=null)
			return node;

		return (left_lca != null) ? left_lca : right_lca;
	}

	static LinkedHashSet<Integer> left = new LinkedHashSet<>();
	static LinkedHashSet<Integer> right = new LinkedHashSet<>();
	private static void leafAtSameLevel(NodeBT root) {

		int level=0;
		boolean result = recursiveLrafLevel(root , level);



		LeafLevel(root.left ,level);

		right=left;

		left=new LinkedHashSet<>();

		LeafLevel(root.right, level);

		if(left.size() != right.size() ) {

			if( ( left.size()==0 && right.size()>1) || (right.size()==0 && left.size()>1) ) {

				System.out.println(false);
			}
			else if ( ( left.size()==0 && right.size()==1) || (right.size()==0 && left.size()==1)) {

				System.out.println(true);
			}

			else {
				System.out.println(false);
			}

		}

		left.removeAll(right);
		if(left.size()>0) {

			System.out.println(false);
		}else {

			System.out.println(true);
		}

	}

	static int Leaflevel =1;
	public static boolean  recursiveLrafLevel(NodeBT root2, int level) {
		if(root2==null) {

			return true;
		}
		if(root2.left==null && root2.right==null) {

			if(Leaflevel==1) { // checking if it's first leaf node encountered then return true and save its level

				Leaflevel = level;
				return true;
			}
			else {

				return Leaflevel==level ; // if leaf nodes at diff levels are found then return false
			}
		}

		return recursiveLrafLevel(root2.left , level+1) && recursiveLrafLevel(root2.right , level+1); // recursively checking ofr left and right subtrees

	}


	//			  10
	//		     /   \
	//		   20     30
	//		  /  \        
	//		10    15
	private static void LeafLevel(NodeBT root2 , int level) {

		if(root2==null) {
			return ;
		}
		LeafLevel(root2.left ,  level+1 );
		LeafLevel(root2.right , level+1);

		if(root2.left==null && root2.right==null){

			left.add(level+1);
		}   
	}
	//		     4        
	//		    / \       
	//		   2   5      
	//		  / \ / \     
	//		 7   12  3    
	//		    /
	//		   6
	public static int sumRootToLeaf(NodeBT root) {

		ArrayList<Integer> memo=new ArrayList<>();
		memo.add(0);

		sum(root , Integer.toString(root.data), memo);

		return memo.get(0);

	}
	public static void sum(NodeBT root , String currPath , ArrayList<Integer> memo){


		if(root.left==null && root.right==null){

			System.out.println("currPath : "+Integer.parseInt(currPath , 2));
			memo.set(0 , memo.get(0) + Integer.parseInt(currPath , 2) );
			System.out.println("currPath : "+ memo.get(0) + Integer.parseInt(currPath));
			return ;
		}

		if(root.left!=null){

			sum(root.left , currPath + Integer.toString(root.left.data),memo);
		}

		if(root.right!=null){

			sum(root.right , currPath + Integer.toString(root.right.data),memo);
		}
		return;
	}

	static  int  maxlen;
	static  int  maxsum;
	private static void sumOfNodesOnLongestPath(NodeBT root2) {

		int len =  0    ;
		int sum =  0    ;
		maxsum  = -9999 ;
		maxlen  =  0    ;

		ArrayList<Integer> ar = new ArrayList<Integer>();
		sumLongest(root , len , sum  , ar);

		System.out.println(maxsum );	
	}
	private static void sumLongest(NodeBT root, int len, int sum, ArrayList<Integer> ar) {
		if(root == null){
			return ;
		}
		if(root.left == null && root.right == null){

			if(len >= maxlen){

				maxsum = Math.max (sum ,maxsum);
				maxlen = len ;
				ar.add(maxsum);
			}
		}

		sumLongest(root.left  , len = len + 1 , sum = sum + root.data ,ar);
		sumLongest(root.right , len = len + 1 , sum = sum + root.data ,ar);

		return;
	}

	private boolean     isbalanced(NodeBT root)
	{
		// Your code here

		if (root == null){

			return true;
		}

		int lh = HeightOfTree(root.left);
		int rh = HeightOfTree(root.right);

		if (Math.abs(lh - rh) <= 1 && Math.abs(lh - rh) >= -1
				&& isbalanced(root.left)
				&& isbalanced(root.right))
			return true;

		return false;
	}
	private static void PostOrderTraversalWithoutRecusrion(NodeBT root2) {
		if(root2==null) {

			return;
		}
		Stack<NodeBT> s = new Stack<>();
		NodeBT curr = root2;
		while(s.size() > 0 || curr!=null) {


			while(curr!=null) {

				s.push(curr);
				curr= curr.left;
			}
			NodeBT temp = s.peek().right;

			if(temp==null) {
				temp = s.pop();
				System.out.println(temp.data);

				while(s.size() > 0 && temp == s.peek().right) {

					temp = s.pop();
					System.out.println(temp.data);
				}
			}
			else {
				curr = temp;
			}
		}
	}
	private static void PreOrderTraversalWithoutRecusrion(NodeBT root2) {

		if(root2==null) {

			return;
		}
		Stack<NodeBT> s = new Stack<>();
		NodeBT curr = root2;
		while(s.size() > 0 || curr!=null) {
			while(curr!=null) {

				System.out.print(curr.data);
				s.push(curr);
				curr= curr.left;
			}
			curr = s.pop();
			curr= curr.right;
		}
	}
	private static void InOrderTraversalWithoutRecusrion(NodeBT root2) {

		if(root2==null) {

			return;
		}
		Stack<NodeBT> s = new Stack<>();
		NodeBT curr = root2;

		while(s.size() > 0 || curr!=null) {
			while(curr!=null) {

				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			System.out.println(curr.data);
			curr = curr.right;
		}
	}
	private static void PostOrderTraversal(NodeBT root2) {

		if(root2==null) {

			return ;
		}
		PostOrderTraversal(root2.left);
		PostOrderTraversal(root2.right);
		System.out.print(root2.data);

	}
	private static void PrOrderTraversal(NodeBT root2) {
		if(root2==null) {

			return ;
		}
		System.out.print(root2.data);
		PrOrderTraversal(root2.left);
		PrOrderTraversal(root2.right);

	}

	//         1
	//       /   \
	//      2     3
	//     / \
	//	  4   5
	private static void InOrderTraversal(NodeBT root2) {
		if(root2==null) {

			return ;
		}
		InOrderTraversal(root2.left);
		System.out.print(root2.data+" ");
		InOrderTraversal(root2.right);
	}
	private static NodeBT mirrorImage(NodeBT root) {
		if(root==null) {
			return null;
		}
		NodeBT node = new NodeBT(root.data);
		node.left  = mirrorImage(root.right);
		node.right = mirrorImage(root.left);
		return node;
	}
	private static int HeightOfTree(NodeBT root2) {

		if(root2==null) {
			return 0;
		}

		int leftHeight=HeightOfTree(root2.left);
		int rightHeight=HeightOfTree(root2.right);

		return 1 + Math.max(leftHeight, rightHeight) ;
	}
	private static void levelOrderTraversal(NodeBT head2) {

		if(head2==null) {

			return;
		}
		Queue<NodeBT> qu = new LinkedList<NodeBT>();
		NodeBT node1 = qu.poll();
		qu.add(head2);

		qu.add(null);

		while(!qu.isEmpty()) {

			NodeBT node = qu.poll();

			if(node==null) {

				if(!qu.isEmpty()) {

					qu.add(null);
					System.out.println();
				}
			}
			else {

				if(node.left!=null) {

					qu.add(node.left);
				}

				if(node.right!=null) {

					qu.add(node.right);
				}

				System.out.print(node.data +" ");
			}

		}
	}
	private static NodeBT createBinaryTree() {

		System.out.println("Please Enter Data : ");

		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();

		NodeBT head = new NodeBT(data);

		if(data == -1) {

			return null;
		}

		System.out.println("Please Enter Data For Left Of: "+ data);
		head.left = createBinaryTree();

		System.out.println("Please Enter Data For Right Of: "+ data);
		head.right = createBinaryTree();

		return head;

	}	
	static  NodeBT buildTree(String str){

		if(str.length()==0 || str.charAt(0)=='N'){
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		NodeBT root = new NodeBT(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<NodeBT> queue = new LinkedList<>(); 

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while(queue.size()>0 && i < ip.length) {

			// Get and remove the front of the queue
			NodeBT currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if(!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new NodeBT(Integer.parseInt(currVal));
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
				currNode.right = new NodeBT(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

}