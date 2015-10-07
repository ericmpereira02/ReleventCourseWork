
import java.util.Random;

public class ErdosRenyi {

	private long seed;

	public ErdosRenyi(long seed) {
		super();
		this.seed = seed;
	}

	public Graph randomGraph(int n,double p){

		Random r=new Random(this.seed);

		Graph G=new Graph(n);
		
		double prob;
		for (int i = 0; i < G.V(); i++) {
			for (int j = i+1; j < G.V(); j++) {
				prob=r.nextDouble();
				if(prob<p){
					G.addEdge(i, j);
					G.setEdgeWeight(i, j, round(prob,2));
				}
			}
		}

		return G;
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n=50;
		double p=4/(n*1.0);
		ErdosRenyi er=new ErdosRenyi(112);
		Graph G=er.randomGraph(n, p);
		System.out.println(G);
	}


}