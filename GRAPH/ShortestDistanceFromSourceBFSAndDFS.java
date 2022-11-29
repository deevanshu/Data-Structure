package com.datastructure.GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ShortestDistanceFromSourceBFSAndDFS {

	private static int V=6;
	private static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>() ;
	static boolean  isVisited[] = new boolean[V];
	static int dist[] = new int[V];
	static Queue<Integer> que = new LinkedList<>();
	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String args[])
	{
		for (int i = 0; i < V; ++i) {
			adj.add(new ArrayList<Integer>());
			isVisited[i]=false;
			dist[i] = Integer.MAX_VALUE;
		}

        addEdge( 0, 1);
        addEdge( 0, 3);
        addEdge( 1, 2);
        addEdge( 3, 4);
        addEdge( 3, 7);
        addEdge( 4, 5);
        addEdge( 4, 6);
        addEdge( 4, 7);
        addEdge( 5, 6);
        addEdge( 6, 7);

		shortestDistanceFromSourceUnweightedGraph(dist , isVisited , adj , que , V , 0);

		for (int i = 0; i < V; i++)
			if (isVisited[i] == false)
			{
				topologicalSortDFS(i, isVisited, stack , adj);
			}
		
		shortestDistanceFromSourceWeightedGraph(dist , isVisited , adj , que ,V ,stack);
		
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
	
	private static void shortestDistanceFromSourceWeightedGraph(int[] dist2, boolean[] isVisited2,
			ArrayList<ArrayList<Integer>> adj2, Queue<Integer> que2, int v2, Stack<Integer> stack2) {
		
		
		// Video Youtube ; 
		
	}

	private static void shortestDistanceFromSourceUnweightedGraph(int[] dist, boolean[] isVisited,
			ArrayList<ArrayList<Integer>> adj, Queue<Integer> que, int V , int source) {

		dist[source] = 0;
    	que.add(source);

    	while(que.isEmpty()==false) 
    	{ 
    		int node = que.poll();  
    		 
    		for(int neighbour : adj.get(node)){
    		    if(dist[node] + 1 < dist[neighbour]){
    		        dist[neighbour] = dist[node] + 1;
    		        que.add(neighbour);
    		    }
    		} 
    	}
	}

	private static void addEdge(int i, int j) {
		adj.get(i).add(j);
	}
}
