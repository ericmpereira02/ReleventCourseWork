
public class Driver {
	
	public static void main(String[] args) {
		ErdosRenyi er=new ErdosRenyi(1);
		Graph G=er.randomGraph(7, 0.45);

		
		CentralityMeasures centrality = new CentralityMeasures(G);
		
		centrality.calculateAllPairsShortestPaths();
		
		double[][] D = centrality.getD();
		Integer[][] Pi = centrality.getPi();
		
		
		double betweenneesVar=0;
		double closenessVar=0;
		System.out.println("Matrix D");
		System.out.println("---------------");
		centrality.printMatrix(D);
		System.out.println("---------------");
		System.out.println("Matrix Pi");
		System.out.println("---------------");
		centrality.printMatrix(Pi);
		System.out.println("---------------");
		for (int i = 0; i < Pi.length; i++) {
			
			System.out.println("Centrality measures for vertex "+i);
			closenessVar=centrality.closeness(i);
			betweenneesVar=centrality.betweenness(i);
			System.out.println("Closeness:");
			System.out.println(closenessVar);
			System.out.println("Betweennees:");
			System.out.println(betweenneesVar);
			System.out.println("---------------");
		}


	}
}
