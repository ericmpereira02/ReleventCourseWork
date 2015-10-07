/*
* Author : Alyssa Marcoux, amarcoux2013@my.fit.edu
* Course : CSE 2010, Section 03, Fall 2014
* Project: lab11, Centralities
*/
public class CentralityMeasures {

	/**
	 * Distance matrix with weights of paths
	 */
	private double[][] D;
	/**
	 * Predecessor matrix with shortest paths
	 */
    private Integer[][] Pi;
    
    /**
     * Graph with directed and weighted paths
     */
    private Graph g;
	
    /**
     * Getter method for distance matrix
     * @return D matrix
     */
    public double[][] getD() {
		return D;
	}

    /**
     * Setter method for distance matrix
     * @param d distance matrix setter
     */
	public void setD(double[][] d) {
		D = d;
	}

	/**
	 * Getter method for predecessor matrix
	 * @return predecessor matrix
	 */
	public Integer[][] getPi() {
		return Pi;
	}

	/**
	 * Setter method for predecessor matrix
	 * @param pi predecessor matrix setter
	 */
	public void setPi(Integer[][] pi) {
		Pi = pi;
	}

	/**
	 * Constructor for CentralityMeasures
	 * @param g_ graph
	 */
	public CentralityMeasures(Graph g_) {
		this.g=g_;
		D = new double[g.V()][g.V()];
		Pi = new Integer[g.V()][g.V()];
	}

	/**
	 * calculate all pairs shortest path using Floyd-Warshall algorithm
	 */
	public void calculateAllPairsShortestPaths() {
		// calculate all pairs shortest path 
		double d[][] = new double[g.V()][g.V()];
		Integer pi[][] = new Integer[g.V()][g.V()];
		
		// fill distance matrix with max value
		for (int i = 0; i < g.V(); i++) {
			for (int j = 0; j < g.V(); j++) {
				d[i][j] = Double.MAX_VALUE;
			}
		}
		// change distance for a vertex to itself to 0
		for(int v = 0; v < g.V(); v++){
			d[v][v] = 0;
		}
		// populate distance and predecessor matrices with weights and initial values
		for (int u = 0; u < g.V(); u++) {
			for (int v: g.adj(u)) {
				d[u][v] = g.weights[u][v];
				pi[u][v] = u;
			}
		}
		// Floyd-Warshall algorithm
		for (int k = 0; k < g.V(); k++) {
			for (int i = 0; i < g.V(); i++) {
				for (int j = 0; j < g.V(); j++) {
					if (d[i][k] +  d[k][j] < d[i][j]) {
						d[i][j] = d[i][k] + d[k][j];
						pi[i][j] = pi[k][j];
					}
				}
			}
		}
		setD(d);
		setPi(pi);
	}
	
	/**
	 * Calculate Betweenness
	 * @param k vertex for which calculating betweenness
	 * @return betweenness calculated betweenness of vertex
	 */
	public double betweenness(int k) {
	// calculate betweenness for the vertex k
		Integer[][] pi = getPi();
		double betweenness = 0;
		// total paths containing K but don't start or end with K
		double pathsWithK = 0;
		// total paths not starting or ending in K
		double paths = 0;
		for(int i = 0; i < g.V(); i++){
			for(int j = 0; j < g.V(); j++){
				// if not a path from vertex to its self and not calculating path
				// starting or ending in K
				if(pi[i][j] != null && i != k && j != k){
					boolean endAtI = false;
					int next = j;
					// run through path
					while(!endAtI){
						next = pi[i][next];
						// if path contains k increment counter
						if(next == k){
							pathsWithK++;
						}
						// if reached end of path increment total paths and end while loop
						if(next == i){
							paths++;
							endAtI = true;
						}
					}
				}
			}
		}
		// calculate betweenness by dividing paths containing K with total paths
		betweenness = pathsWithK/paths;
		return betweenness;
	}
	
	/**
	 * Calculate closeness
	 * @param i vertex for which calculating closeness
	 * @return closeness calculated closeness of vertex
	 */
	public double closeness(int i) {
	// calculate closeness for the vertex i
		double[][] d = getD();
		double closeness = 0.0;
		// the sum of the shortest paths between the nodes
		for(int j = 0; j < g.V(); j++){
			if(i != j){
				closeness += d[i][j];
			}
		}
		// divide the total number of vertices by the sum of shortest paths
		closeness = g.V()/closeness;
		return closeness;
	}


	/**
	 * Prints Integer(predecessor) matrix
	 * @param M matrix to be printed
	 */
	public  void printMatrix(Integer[][] M) {

		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M.length; j++) {


				System.out.print(M[i][j] + "  ");

			}
			System.out.println("");
		}
	}

	/**
	 * Prints double(distance) matrix
	 * @param M matrix to be printed
	 */
	public  void printMatrix(double[][] M) {

		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M.length; j++) {
				if (M[i][j] == Integer.MAX_VALUE) {
					System.out.print("Inf  ");
				} else {
					System.out.print((double)Math.round(M[i][j]*100)/100 + "  ");
				}

			}
			System.out.println("");
		}
	}

}