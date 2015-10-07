

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
	private int V;
	private int E;
	double[][] weights;
	private ArrayList<Integer>[] adj;

	public Graph(int V){
		this.V=V;
		this.E=0;
		adj=new ArrayList[V];
		for (int v=0;v<V;v++){
			adj[v]=new ArrayList<Integer>();
		}
		weights=new double[V][V];
	}
	
	
	public int V(){
		return V;
	}

	public int E(){
		return E;
	}


	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	public boolean containsEdge(int v1, int v2) {
		for (int edge: this.adj[v1]) {
			if (edge == v2) {
				// has edge
				return true;
			}
		}
		// does not have edge
		return false;
	}
	
	public ArrayList<Integer> adj(int v){
		return adj[v];
	}

	public void setEdgeWeight(int v, int w, double weight){
		this.weights[v][w]=weight;
		this.weights[w][v]=weight;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		String NEWLINE = System.getProperty("line.separator");
		s.append(V + " vertices, " + E + " edges " + NEWLINE);
		for (int v = 0; v < V; v++) {
			s.append(v + ": ");
			for (int w : adj[v]) {
				s.append(w+" ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}
	
	
	public double[][] getWeights() {
		return weights;
	}
	public void setWeights(double[][] weights) {
		this.weights = weights;
	}


}