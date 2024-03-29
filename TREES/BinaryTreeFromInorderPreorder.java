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
		int inorder[]  = {1, 6, 8, 7}; // LRootR
		int preorder[] = {1 ,6, 7, 8}; // RootLR
		int n = 4;
		HashMap <Integer , Integer> hm = new HashMap<>();

		for(int i=0 ; i<n ;i++) {

			hm.put(inorder[i], i);
		}

		NodeIP ans = buildTree( inorder, preorder, n ,hm);
	}

	public static NodeIP buildTree(int inorder[], int preorder[], int n, HashMap<Integer, Integer> hm)
	{
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
//    
//    HashMap<Integer,Integer> preMap  = new HashMap<>();
//    HashMap<Integer,Integer> postMap = new HashMap<>();
//
//    for(int i = 0 ; i<preorder.length ; i++ ){
//
//       preMap.put(preorder[i] , i);
//    }
//   for(int i = 0 ; i<postorder.length ; i++ ){
//        
//       postMap.put(postorder[i] , i);
//    }
//
//   return build(0 , 0 , preorder.length-1 ,postorder.length-1 , preorder , postorder , preMap , postMap);
//
//}
//
//public static TreeNode build(int preLow , int postLow , int preHigh , int postHigh , int[] preorder , int[] postorder ,HashMap<Integer,Integer> preMap ,HashMap<Integer,Integer> postMap ){
//
// if(preLow > preHigh || postLow > postHigh){
//     return null;
// }
//
// TreeNode node = new TreeNode(preorder[preLow]);
//
// if(preLow == preHigh || postLow == postHigh){
//     return node;
// }
//
//    int indexInsidePre  =  preMap.get(postorder[postHigh-1]);
//    int indexInsidePost =  postMap.get(preorder[preLow+1]);
//    
//    int temp   = preLow + (indexInsidePost - postLow + 1);
//
//    node.left  = build(preLow+1 ,postLow ,temp    ,indexInsidePost ,preorder ,postorder , preMap , postMap );
//    node.right = build(temp+1   ,indexInsidePost+1 ,preHigh ,postHigh-1 ,preorder ,postorder, preMap , postMap );
//
//    return node;
//}