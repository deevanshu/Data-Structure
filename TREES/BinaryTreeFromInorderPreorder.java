package com.datastructures.TREES;

import java.util.HashMap;

class NodeIP {

	int data;
	NodeIP left;
	NodeIP right;

	public NodeIP(int data) {

		this.data = data;
		this.left = null;
		this.right = null;
	}
}
public class BinaryTreeFromInorderPreorder {
	static int preorderStartIndex = 0;

	public static void main(String[] args)
	{
		int inorder[]  = {1, 6, 8, 7}; // LRR
		int preorder[] = {1 ,6, 7, 8}; // RLR
		int n = 4;
		HashMap <Integer , Integer> hm = new HashMap<>();

		for(int i=0 ; i<n ;i++) {

			hm.put(inorder[i], i);
		}
		
		NodeIP ans = buildTree( inorder, preorder, n ,hm);
	}
	
	public static NodeIP buildTree(int inorder[], int preorder[], int n, HashMap<Integer, Integer> hm)
	{
		// code here 
		int inorderStartIndex=0;
		int inorderEndIndex = n-1;
		NodeIP ans = solve(inorder , preorder , preorderStartIndex , inorderStartIndex , inorderEndIndex  , n , hm);

		return ans ; 
	}
	
	static NodeIP solve(int inorder[] ,int preorder[] , int preorderStartIndex , int inorderStartIndex ,int inorderEndIndex  , int n, HashMap<Integer, Integer> hm){

		if(preorderStartIndex >= n || inorderStartIndex > inorderEndIndex){

			return null;
		}
		
		int data = preorder[ preorderStartIndex++] ;
		
		NodeIP root = new NodeIP( data );
		int position = findPosition(data , hm);

		root.left  = solve(inorder , preorder, preorderStartIndex , inorderStartIndex , position - 1  , n, hm);
		root.right = solve(inorder , preorder, preorderStartIndex , position + 1   , inorderEndIndex  , n, hm);

		return root;
	}
	
	static int findPosition(int data , HashMap<Integer, Integer> hm){

		return hm.get(data);
	}
}



//     IMPORTANT TREE FROM PREORDER AND POSTORDER ::-


//public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
//    HashMap<Integer, Integer> map = new HashMap<>();
//    for(int i=0; i<postorder.length; i++) {
//        map.put(postorder[i], i);
//    }
//    
//    TreeNode root = construct(preorder, postorder, map, 0, preorder.length - 1, 0, postorder.length - 1);
//    return root;
//}
//
//public TreeNode construct(int[] pre, int[] post, HashMap<Integer, Integer> map, int prelo, int prehi, int postlo, int posthi) {
//    if(prelo > prehi || postlo > posthi) {
//        return null;
//    }
//    
//    TreeNode node = new TreeNode(pre[prelo]);
//    
//    if(prelo + 1 <= prehi) {
//        int index = map.get(pre[prelo + 1]);
//        int lhs = index - postlo + 1;
//        
//        node.left = construct(pre, post, map, prelo + 1, prelo + lhs, postlo, postlo + lhs - 1);
//        node.right = construct(pre, post, map, prelo + lhs + 1, prehi, postlo + lhs, posthi - 1);
//    }
//    
//    return node;
//}