/*
 * Author : Austin Haggard, ahaggard2013@my.fit.edu
 * Course : CSE 2010, Section 01, Fall 2014
 * Project: Lab 10, Graphs
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Graph.java
public class Graph {
	private int V;  // number of vertices
	private int E;  // number of edges
	private ArrayList<Integer>[] adj;  // for every vertex there is a list of other vertices adjacent to it (adjacency list representation of a graph)
	
	/**
	 * constructor
	 * @param V number of vertices
	 */
	public Graph(int V){
	// Initialize a graph with V vertices and 0 edges
		this.V = V;
		this.E = 0;
		this.adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			this.adj[i] = new ArrayList<Integer>();
		}
	}
	/**
	 * to String Method
	 */
	public String toString() {
	// return printable representation of a Graph
		String result = "";
		result = String.format("%d vertices, %d edges\n", this.V , this.E);
		for (int i = 0; i < this.adj.length; i++) {
			result += String.format("%d: ", i);
			for (int j = 0; j < this.adj[i].size(); j++) {
				result += String.format("%d ", this.adj[i].get(j));
			}
			result += String.format("\n");
		}
		return result;
	}
	/**
	 *  performs breath first search
	 * @param s where to begin the traversal
	 * @return graph of traversal
	 */
	public Graph bfs(int s) {
	// breadth-first search from a single source s
		int node;
		Graph result = new Graph(this.V);
		Queue<Integer> q = new LinkedList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(s);
		q.add(s);
		while(!q.isEmpty()) {
			node = q.poll();
			for (Integer edge : this.adj[node]) {
				if (!set.contains(edge)) {
					result.addEdge(node, edge);
					set.add(edge);
					q.add(edge);
				}
			}
		}
		return result;
	}
	/**
	 * performs a depth first search
	 * @param s place to begin the traversal
	 * @return graph of traversed nodes
	 */
	public Graph dfs(int s){
	// depth-first search from a single source s
		int node;
		Graph result = new Graph(this.V);
		Stack<Integer> stack = new Stack<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		stack.push(s);
		while (!stack.isEmpty()) {
			node = stack.pop();
			if (!set.contains(node)) {
				set.add(node);
				for (int edge : this.adj[node]) {
					stack.push(edge);
				}
				if (edgeDNE(result, node, stack))
					result.addEdge(node, stack.peek());
			}
		}
		return result;
	}
	/**
	 * 
	 * @param result graph to check
	 * @param node possible node to add
	 * @param stack possible node to add
	 * @return true or false if these nodes have already been added
	 */
	private boolean edgeDNE(Graph result, int node, Stack<Integer> stack) {
		// checks if two nodes have already been added to the result
		for (int i = 0; i < result.adj.length; i++) {
			for (int j = 0; j < result.adj[i].size(); j++) {
				if (node == i && stack.peek() == result.adj[i].get(j))
					return false;
					
			}
		}
		return true;
	}
	/**
	 * Adds an edge into the graph
	 * @param v vertex
	 * @param w undirected edge
	 */
	public void addEdge(int v, int w){
	// create an edge from the vertex v to the vertex w (edge is undirected)
		this.adj[v].add(w);
		this.adj[w].add(v);
		this.E++;
	}
	
	/**Override equals methods for graphs: compare number of edges, vertices and the
	 * adjacency lists correspondence. Nothing to implement here ( will be used for grading)
	 * 
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Graph)) {
			return false;
		}

		Graph that = (Graph) other;

		boolean isAdjSame=true;

		// iterate over adjacency list to check if they are the same
		try{
			for (int i = 0; i < Math.max(this.adj.length, that.adj.length); i++) {
				// sort so that order doesn't matter
				Collections.sort(this.adj[i]);
				Collections.sort(that.adj[i]);
				for (int j = 0; j < Math.max(this.adj[i].size(), that.adj[i].size()); j++) {
					if (this.adj[i].get(j)!=that.adj[i].get(j)){
						isAdjSame=false;
						// once at least one is found there is no need to continue
						break;
					}
				}
				if (!isAdjSame) break;
			}

		}catch(ArrayIndexOutOfBoundsException e){
			isAdjSame=false;
		}

		// if graphs are the same all should match
		return this.V==(that.V)&& this.E==(that.E)&&isAdjSame;
	}
}