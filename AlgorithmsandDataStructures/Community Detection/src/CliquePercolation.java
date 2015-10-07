/*
 * Author : Austin Haggard, ahaggard2013@my.fit.edu
 * Course : CSE 2010, Section 01, Fall 2014
 * Project: Lab 12, Community Detection
 */

import java.util.ArrayList;
import java.util.HashSet;



public class CliquePercolation {
	private Graph g;
	private  int k;

	private int[] communities;

	/**
	 * 
	 * @param G graph
	 * @param k size
	 */
	public CliquePercolation(Graph G, int k) {
		this.g = G;
		this.k = k;
	}
	
	
	/**
	 * finds cliques
	 * @param n size of cliques
	 * @return
	 */
	public HashSet<HashSet<Integer>> findCliques(int n){
        HashSet<HashSet<Integer>> answer = cliqueSizeTwo();
        // loops through size of n
        for(int i = 2; i < n; i++){
            answer  = findCliquesRec(answer);
        }
        return answer;
    }
	
	/**
	 * finds cliques using recursion
	 * @param prev previous clique 
	 * @return cliques
	 */
    private HashSet<HashSet<Integer>> findCliquesRec(HashSet<HashSet<Integer>> prev){
        HashSet<HashSet<Integer>> result = new HashSet<HashSet<Integer>>();
        // loop through cliques
        for(HashSet<Integer> c: prev){
            for(int i = 0; i < g.V(); i++){
                //check if a large clique is made
                if(largerClique(c, i)){
                    HashSet<Integer> larger = new HashSet<Integer>();
                    larger.addAll(c);
                    larger.add(i);
                    result.add(larger);
                }
            }
        }
        return result;
    }
    
    /**
     * 
     * @param clique clique from previous code
     * @param v vertex
     * @return if we should continue
     */
    private boolean largerClique(HashSet<Integer> clique, int v){
        boolean result = true;
        // if clique contains vertex do nto continue
        if(clique.contains(v)){
            return false;
        }
        for(Integer vertex: clique){
            if(!g.adj(v).contains(vertex)){
                return false;
            }
        }
        return result;
    }
    
    /**
     *  finds clique of size 2
     * @return cliques of size 2
     */
    private HashSet<HashSet<Integer>> cliqueSizeTwo(){
        HashSet<HashSet<Integer>> q = new HashSet<HashSet<Integer>>();
        // loop through vertices
        for(int i = 0; i <g.V(); i++){
        	// loop through edges
            for(int j: g.adj(i)){
                HashSet<Integer> s = new HashSet<Integer>();
                s.add(i);
                s.add(j);
                q.add(s);
            }
        }
        return q;
    }
	
	/**
	 * find communities in cliques
	 * @return int[] of communities
	 */
	public int[] findCommunities(){
		// find all communities using clique perlocation.
		// result should be an array where each vertex has community ID
		// two vertices are from the same community if communities[i]==communities[j]
		HashSet<HashSet<Integer>> cliques = findCliques(k);
		this.communities = new int[k];
		return this.communities;
	}

}
