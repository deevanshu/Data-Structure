package com.datastructures.BSTREES;

class NodeSNP
{
	int key;
	NodeSNP left, right;

	public NodeSNP(int key) {

		this.key = key;
		this.left = null;
		this.right=null;
	}
};

public class PredecessorAndSuccessor {	
	static NodeSNP pre;
	static NodeSNP suc;

	public static void main(String[] args)
	{
		int key = 65; // Key to be searched in BST

		/* Let us create following BST
	                50
	                / \
	            / \
	            30     70
	            / \     / \
	            / \ / \
	        20 40 60 80
		 */
		
		NodeSNP root = null;
		root = new NodeSNP(50);
		new NodeSNP( 30);
		new NodeSNP( 20);
		new NodeSNP( 40);
		new NodeSNP( 70);
		new NodeSNP( 60);
		new NodeSNP( 80);

		findPreSuc(root,key);

		if (pre != null)
			System.out.println("Predecessor is " +
					pre.key);
		else
			System.out.print("-1");

		if (suc != null)
			System.out.print("Successor is " + suc.key);
		else
			System.out.print("-1");
	}

	private static void findPreSuc(NodeSNP root , int key) {

		if(root==null) {

			return ;
		}

		while(root!=null) {


			if(root.key == key) {

				if(root.left!=null) {

					root = root.left ;
					pre = root;
					while(root.right!=null) {
						root = root.right;
						pre = root;
					}
				}
				if(root.right!=null) {
					root = root.right ;
					suc = root;
					while(root.left!=null) {
						root = root.left;
						suc = root;
					}
				}
				
				return ;
			}
			else if(root.key > key) {

				suc = root;
				root = root.left;
			}
			else  {

				pre = root;
				root = root.right;
			}
		}
	}
}