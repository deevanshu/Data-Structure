package com.datastructures.TREES;

import java.util.HashMap;

class NodeIPo {

	int data;
	NodeIPo left;
	NodeIPo right;

	public NodeIPo(int data) {

		this.data = data;
		this.left = null;
		this.right = null;
	}
}
public class BinaryTreeFromInorderPostorder {    
	public static int postorderStartIndex = 0;
	
	public static void main(String[] args)
	{
		int inorder[]   = {9, 5, 2, 3, 4}; // LRootR
		int postorder[] = {5, 9, 3, 4, 2}; // RLRoot
		int n = 4;
		HashMap <Integer , Integer> hm = new HashMap<>();

		for(int i=0 ; i<n ;i++) {

			hm.put(inorder[i], i);
		}

		NodeIPo ans = buildTree( inorder, postorder, n ,hm);
	}
	public  static NodeIPo buildTree(int inorder[], int postorder[], int n , HashMap<Integer, Integer> hm)
	{
		postorderStartIndex = n-1;
		NodeIPo ans = build(inorder, postorder, n ,hm);
		return ans;
	}

	public static NodeIPo build(int[] inorder , int[] postorder , int n , HashMap <Integer , Integer> hm){

		int inorderStartIndex=0;
		int inorderEndIndex = n-1;
		NodeIPo ans = solve(inorder , postorder , postorderStartIndex , inorderStartIndex , inorderEndIndex  , n , hm);

		return ans ;
	}

	static NodeIPo solve(int inorder[] ,int postorder[] , int postorderStartIndex , int inorderStartIndex ,int inorderEndIndex  , int n, HashMap<Integer, Integer> hm){

		if(inorderStartIndex > inorderEndIndex  ||  postorderStartIndex < 0){
			return null;
		}
		int data = postorder[ postorderStartIndex--] ;
		NodeIPo root = new NodeIPo( data );

		if (inorderStartIndex == inorderEndIndex)
			return root;

		int position = findPosition(data , hm);

		root.right = solve(inorder , postorder , postorderStartIndex , position + 1   , inorderEndIndex  , n , hm);
		root.left  = solve(inorder , postorder , postorderStartIndex , inorderStartIndex , position - 1  , n , hm);

		return root;
	}

	static int findPosition(int data , HashMap<Integer, Integer> hm){

		return hm.get(data);
	}}

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