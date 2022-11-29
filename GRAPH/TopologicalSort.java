package com.datastructure.GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

	private static int V=6;
	private static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>() ;
	static boolean  isVisited[] = new boolean[V];
	static Stack<Integer> stack = new Stack<>();
	static Integer topoSort[]  = new Integer[V];
	static int indegree[]  = new int[V];

	public static void main(String args[])
	{

		for (int i = 0; i < V; ++i) {
			adj.add(new ArrayList<Integer>());
			isVisited[i]=false;
		}

		addEdge(5, 2);
		addEdge(5, 0);
		addEdge(4, 0);
		addEdge(4, 1);
		addEdge(2, 3);
		addEdge(3, 1);

		for (int i = 0; i < V; ++i) {
			for(int neighbour : adj.get(i)) {

				indegree[neighbour]++ ;
			}
		}

		Queue <Integer> que = new LinkedList<Integer>();

		for (int i = 0; i < V; ++i) {
			if(indegree[i]==0) {
				que.add(i);
			}
		}

		topologicalSortBFS(que , adj ,topoSort , indegree);
		
		System.out.println("Following is a Topological sort of the given graph Using BFS");
		for(Integer val : topoSort)
		{
			System.out.print(val + " ");
		}
		
		System.out.println();
		System.out.println("Following is a Topological sort of the given graph Using DFS");
		for (int i = 0; i < V; i++)
			if (isVisited[i] == false)
			{
				topologicalSortDFS(i, isVisited, stack , adj);
			}
		while (stack.empty() == false)
			System.out.print(stack.pop() + " ");
	}

	private static void topologicalSortBFS(Queue<Integer> que, ArrayList<ArrayList<Integer>> adj,
			Integer[] topoSort, int [] indegree) {

		int index=0;
		while(!que.isEmpty()) {

			Integer value = que.poll();
			topoSort[index++] = value;

			for(int neighbour : adj.get(value)) {
				indegree[neighbour] = indegree[neighbour]  - 1 ;
				if(indegree[neighbour] == 0) {
					que.add(neighbour);
				}
			}
		}
	}

	private static void topologicalSortDFS(int source, boolean[] isVisited, Stack<Integer>stack, ArrayList<ArrayList<Integer>> adj) {

		isVisited[source] = true;

		for(Integer neighbour : adj.get(source)) {

			if(!isVisited[neighbour]) {
				topologicalSortDFS(neighbour, isVisited, stack , adj);

			}
		}
		stack.push(source);
	}
	private static void addEdge(int i, int j) {
		adj.get(i).add(j);
	}
}
