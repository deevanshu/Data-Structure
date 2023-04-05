package com.datastructures.TREES;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class NodeBBT {

	int data;
	NodeBBT left;
	NodeBBT right;

	public NodeBBT(int data) {

		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class MinimumTimeToBurnBinaryTree {

	public static void main(String args[])
	{

		NodeBBT root = new NodeBBT(1);

		root.left = new NodeBBT(2);
		root.right = new NodeBBT(3);

		root.left.left = new NodeBBT(4);
		root.left.right = new NodeBBT(5);

		root.right.right = new NodeBBT(6);

		root.left.right.left = new NodeBBT(7);
		root.left.right.right = new NodeBBT(8);

		root.right.right.right = new NodeBBT(9);
		root.right.right.right.right = new NodeBBT(10);

		int target = 8;

		HashMap <NodeBBT , NodeBBT> hm = new HashMap<>();
		HashMap <NodeBBT , Boolean> visited = new HashMap<>();

		NodeBBT targetNode = parentToNodeMapping(root , target ,hm ,visited);
		int ans = burnTree(targetNode ,hm , visited);
		System.out.println(ans);
	}

	private static int burnTree(NodeBBT targetNode, HashMap<NodeBBT, NodeBBT> hm, HashMap<NodeBBT, Boolean> visited) {

		Queue<NodeBBT> qu = new LinkedList<>();
		Integer sec = 0;
		qu.add(targetNode);
		visited.put(targetNode, true);

		while(!qu.isEmpty()) {

			boolean flag = false;
			int size = qu.size();

			for(int i=0;i<size;i++){

				NodeBBT temp = qu.poll();
				visited.put(temp , true);
				
				if(temp.left !=null && visited.get(temp.left)==false)
				{

					qu.add(temp.left);
					flag = true;
				}

				if(temp.right !=null && visited.get(temp.right)==false)
				{

					qu.add(temp.right);
					flag = true;
				}

				if(hm.get(temp)!=null && visited.get(hm.get(temp))==false)
				{

					qu.add(hm.get(temp));
					flag = true;
				}
			}
			if(flag) {
				sec++;
			}
		}

		return sec;
	}

	private static NodeBBT parentToNodeMapping(NodeBBT root, int target, HashMap<NodeBBT, NodeBBT> hm, HashMap<NodeBBT, Boolean> visited) {

		hm.put(root, null);
		Queue <NodeBBT> qu = new LinkedList<>();
		qu.add(root);
		NodeBBT targetNode = null;

		while(!qu.isEmpty()) {

			NodeBBT data = qu.poll();
			visited.put(data , false);

			if(data.data == target) {
				targetNode = data;
			}

			if(data.left!=null) {
				hm.put(data.left, data);
				qu.add(data.left);

			}

			if(data.right!=null) {
				hm.put(data.right, data);
				qu.add(data.right);

			}
		}
		return targetNode;
	}
}