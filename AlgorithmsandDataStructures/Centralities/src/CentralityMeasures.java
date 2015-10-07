/*
 * Author : Austin Haggard, ahaggard2013@my.fit.edu
 * Course : CSE 2010, Section 01, Fall 2014
 * Project: Lab 11, Centralities
 */
public class CentralityMeasures {


	private double[][] D;
    private Integer[][] Pi;
    
    
    private Graph g;
    
	/**
	 * Returns matrix D
	 * @return Matrix D
	 */
    public double[][] getD() {
		return D;
	}
    /**
     * sets d to something else
     * @param d value to change D too
     */
	public void setD(double[][] d) {
		D = d;
	}
	/**
	 * returns pi matrix
	 * @return Pi matrix
	 */
	public Integer[][] getPi() {
		return Pi;
	}
	/**
	 * sets pi to another matrix
	 * @param pi matrix to set Pi too
	 */
	public void setPi(Integer[][] pi) {
		Pi = pi;
	}
	
	/**
	 * constructor method
	 * @param g_ graph passed in
	 */
	public CentralityMeasures(Graph g_) {
		this.g=g_;
		this.D = new double[this.g.V()][this.g.V()];
		this.Pi = new Integer[this.g.V()][this.g.V()];
		for (int i = 0; i < this.D.length; i++) {
			for (int j = 0; j < this.D.length; j++) {
				this.D[i][j] = Double.POSITIVE_INFINITY;
			}
		}
	}
	
	/**
	 * calculates shortest path
	 */
	public void calculateAllPairsShortestPaths() {
		// calculate all pairs shortest path 
		//if traveling to itself, set to zero
		for (int i = 0; i < this.g.V(); i++) {
			this.D[i][i] = 0;
		}
		for (int i = 0; i < this.g.V(); i++) {
			for (Integer edge: this.g.adj(i)) {
				this.D[i][edge] = this.g.weights[i][edge];
				this.Pi[i][edge] = i;
			}
		}
		// Floyd Warshall algorithm
		for (int k = 0; k < g.V(); k++) {
			for (int i = 0; i < g.V(); i++) {
				for (int j = 0; j < g.V(); j++) {
					if (D[i][j] > D[i][k] + D[k][j]) {
						D[i][j] = D[i][k] + D[k][j];
						Pi[i][j] = Pi[k][j];
					}
				}
			}
		}
	}
	
	/**
	 * finds betweenness 
	 * @param k node to find
	 * @return betweenness
	 */
	public double betweenness(int k) {
		// calculate betweenness for the vertex k
		int ans, notStartEndK = 0, passKAmnt = 0;
		boolean endK;
		for (int i = 0; i < Pi.length; i++) {
			for (int j = 0; j < Pi.length; j++) {
				ans = j;
				//if not to itself and not getting path
				if (Pi[i][j] != null && i != k && j != k) {
					endK = false;
					ans = j;
					//loops until k is found
					while (!endK) {
						ans = Pi[i][ans];
						if (ans == k)
							passKAmnt++;
						if (ans == i) {
							notStartEndK++;
							endK = true;
						}
					}
				}
			}
		}
		return (double) passKAmnt / notStartEndK;
	}

	/**
	 * Finds closeness
	 * @param i vertex to find
	 * @return closeness
	 */
	public  double closeness(int i) {
	// calculate closeness for the vertex i
		double closeness = 0;
		for (int j = 0; j < D.length; j++) {
			if (i != j)
				closeness += D[i][j];
		}
		
		return D.length / closeness;
	}

	/**
	 * Prints matrix
	 * @param M matrix to print
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
	 * prints matrix
	 * @param M matrix to print
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
