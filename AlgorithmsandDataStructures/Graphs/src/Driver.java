//Driver.java
public class Driver{
	public static void main(String[] args){
		Graph g = new Graph(10);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 7);
		
		g.addEdge(1, 4);
		
		g.addEdge(2,5);
		g.addEdge(2,6);
		
		g.addEdge(6, 3);
		g.addEdge(6, 9);
		g.addEdge(8, 4);
		g.addEdge(8, 9);
		
		g.addEdge(9, 7); 
		
		// print out the graph 
		// Note that it is exactly the same copy as in the figure 1.1
		System.out.println(g);
		
		int source=0;
		
		Graph bfs=g.bfs(source);
		
		// graph from the figure 1.2
		System.out.println(bfs);
		
		Graph dfs=g.dfs(source);
		
		// graph from the figure 1.2
		System.out.println(dfs);
	}
}