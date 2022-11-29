package com.datastructure.GRAPH;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
	int first;
	int second;
	public Node(int first, int second) {
		this.first = first;
		this.second = second; 
	}
}

public class graphImplementationBFSAndDFS {

	static ArrayList< ArrayList<Integer> > graph = new ArrayList<>();
	public static void main(String args[]) {

		int[][] isConnected = {
				{1,0,0},
				{0,1,0},
				{0,0,1} 
		};
		int vertex1 = isConnected.length;
		int ans=0;

		boolean visited[] = new boolean[vertex1];

		for(int i = 0 ; i<vertex1 ; i++){

			if(!visited[i]){
				dfs1(isConnected , visited , i , vertex1);  
				ans++;
			}   
		}
		System.out.println("Ans" +ans);
		int vertex = 5  ;
		boolean isBiDirectional = false;
		initializeGraph(graph , vertex);
		//for(int i=0; i<=vertex; i++) {

		//			addEdge(0, 1, true);
		//			addEdge(0, 4, true);
		//			addEdge(1, 2, true);
		//			addEdge(1, 3, true);
		//			    addEdge(1, 4, true);
		//			    addEdge(2, 3, true);
		//			    addEdge(3, 4, true);

		addEdge(0, 2 , true);
		addEdge(0, 3 , true);
		addEdge(0, 1 , true);
		addEdge(2, 4 , true);
		//}

		getVertexCount(graph);
		getEdgesCount (graph);

		boolean containsEdge = hasEdge(graph , 0 , 3);
		System.out.println("Edge : "+containsEdge);
		boolean containsVertex = hasVertex(graph ,5); 	
		System.out.println("Vertex : " +containsVertex);

		boolean isVisited[] = new boolean[vertex];      // has particular vertex been visited 
		int     distance [] = new int    [vertex+1];     // distance of all vertex from source
		int     predescor[] = new int    [vertex+1];    // parent or source node through which this node was visited 

		int componentsBFS=0;
		int componentsDFS=0;

		//		for(int i=0 ; i<isVisited.length ; i++) {
		//
		//			if(!isVisited[i]) {
		//				componentsBFS++;
		//				BFS(graph , i , vertex , isVisited , distance , predescor);
		//			}
		//		}

		for(int i=0 ; i<isVisited.length ; i++) {

			if(!isVisited[i]) {
				componentsDFS++;
				DFS(graph , i , vertex , isVisited);
			}
		}

		int V = 5;

		ArrayList<Integer> ans1  = new ArrayList<>();
		boolean [] visited1 = new boolean[V];
		depthFirstSearch(ans1 , visited1 , V , 0 , graph);


		int parent = -1;
		boolean resultUndir = false;
		for(int i=0 ; i<isVisited.length ; i++) {

			if(!isVisited[i]) {
				componentsDFS++;
				if(cycleInUndirectedGraphUsingDFS(graph , i , parent , isVisited)) {

					resultUndir = true;
				}
			}
		}

		boolean[] recursionStack = new boolean[vertex+1];
		boolean resultDir = false;
		for(int i=0 ; i<isVisited.length ; i++) {

			if(!isVisited[i]) {
				componentsDFS++;
				if(cycleInDirectedGraphUsingDFS(graph , i , recursionStack , isVisited)) {

					resultDir=true;
				}
			}
		}

		boolean resultBFS=false;
		boolean vis[] = new boolean[vertex];

		Arrays.fill(vis,false);
		for(int i=0;i<vertex;i++) {
			if(vis[i]==false) 
				if(checkForCycle(graph, i,vis)) 
				{
					resultBFS= true;
				}
		}
	}
	static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s,
			boolean vis[])
	{
		Queue<Node> q =  new LinkedList<>(); //BFS
		q.add(new Node(s, -1));
		vis[s] =true;

		while(!q.isEmpty())
		{
			int node = q.peek().first;
			int par = q.peek().second;
			q.remove(); 

			for(Integer it: adj.get(node))
			{
				if(vis[it]==false)  
				{
					q.add(new Node(it, node));
					vis[it] = true; 
				}

				else if(par != it) return true;
			}
		}

		return false;
	}
	private static boolean cycleInDirectedGraphUsingDFS(ArrayList<ArrayList<Integer>> graph, int source, boolean[] recursionStack,
			boolean[] isVisited) {

		isVisited[source] = true;
		recursionStack[source] = true;

		for(Integer neighbour : graph.get(source)) {

			if(!isVisited[neighbour]) {

				if(cycleInDirectedGraphUsingDFS(graph , neighbour , recursionStack , isVisited)) {
					return true;
				}
			}
			else if(recursionStack[neighbour]) {
				return true;
			}
		}
		recursionStack[source] = false;
		return false;
	}
	private static boolean cycleInUndirectedGraphUsingDFS(ArrayList<ArrayList<Integer>> graph, int source, int parent,
			boolean[] isVisited) {

		isVisited[source] = true;
		for(Integer neighbour : graph.get(source)) {

			if(!isVisited[neighbour]) {

				if(cycleInUndirectedGraphUsingDFS(graph , neighbour , source , isVisited)) {
					return true;
				}
			}
			else if(parent !=neighbour) {

				return true;
			}
		}
		return false;
	}
	private static void DFS(ArrayList<ArrayList<Integer>> graph, int source, int vertex, boolean[] isVisited) {

		isVisited[source] = true;
		System.out.println(source);


		for(int i=0 ; i<graph.get(source).size() ; i++) {

			if(!isVisited[graph.get(source).get(i)]) {

				DFS(graph , graph.get(source).get(i) , vertex , isVisited);
			}
		}	
		return;
	}
	public static void depthFirstSearch(ArrayList<Integer> ans ,boolean [] visited , int V , int currentVertex ,  ArrayList<ArrayList<Integer>> adj )

	{
		if(visited[currentVertex]){

			return;
		}

		visited[currentVertex] = true;
		ans.add(currentVertex);

		List<Integer> neighbours = adj.get(currentVertex);

		for(int neighbour : neighbours){

			depthFirstSearch(ans , visited ,V , neighbour , adj);
		}

		return;
	}
	public static void dfs1(int[][] isConnected ,boolean visited[] , int currentVertex , int totalVertex ){

		if(visited[currentVertex]==true){

			return;
		}

		visited[currentVertex] = true;
		int [] neighbours = isConnected[currentVertex] ; 
		for(int i =0 ; i< neighbours.length ; i++){

			if(neighbours[i]==1){

				dfs1(isConnected , visited , i , totalVertex); 
			}  
		}

		return ; 
	}

	private static void BFS(ArrayList<ArrayList<Integer>> graph, int source ,  int vertex, boolean[] isVisited, int[] distance,
			int[] predescor) {

		for(int i=0 ; i<=vertex;i++) {

			isVisited[i] = false;
			distance [i] = Integer.MAX_VALUE;
			predescor[i] = -1;
		}
		Queue <Integer> que = new LinkedList<>();

		que.add(source);
		isVisited[source] = true;
		distance [source] = 0;
		predescor[source] = source;


		while(!que.isEmpty()) {

			int curr = que.poll();
			System.out.println(curr);
			for(int i = 0 ; i<graph.get(curr).size() ; i++) {

				int neighbour = graph.get(curr).get(i);
				if(!isVisited[neighbour]) {

					isVisited[neighbour]= true;
					distance[neighbour] = distance[curr] +1;
					predescor[neighbour] = curr ; 
					que.add(neighbour);
				}	
			}
		}
	}
	private static boolean hasEdge(ArrayList<ArrayList<Integer>> graph, int i, int j) {

		if(graph.get(i).contains(j) || graph.get(j).contains(i)) {

			return true;
		}
		else {

			return false;
		}
	}
	private static boolean hasVertex(ArrayList<ArrayList<Integer>> graph, int i) {

		if(graph.size()>=i) {
			return true;
		}
		else {
			return false;
		}
	}
	private static void getEdgesCount(ArrayList<ArrayList<Integer>> graph2 ) {

		int count = 0;
		for(int i = 0 ; i < graph.size() ; i++) {

			count+= graph.get(i).size();	

		}
		System.out.println(count);
	}
	private static void getVertexCount(ArrayList<ArrayList<Integer>> graph) {

		System.out.println(graph.size());

	}
	private static void initializeGraph(ArrayList<ArrayList<Integer>> graph , int vertex) {

		for(int i=0 ; i<vertex ; i++) {

			graph.add(new ArrayList<Integer>());

		}
	}
	private static void addEdge(int source, int directional, boolean isBiDirectional) {

		if(isBiDirectional) {
			graph.get(source).add(directional);
			graph.get(directional).add(source);
		}		
	}
}