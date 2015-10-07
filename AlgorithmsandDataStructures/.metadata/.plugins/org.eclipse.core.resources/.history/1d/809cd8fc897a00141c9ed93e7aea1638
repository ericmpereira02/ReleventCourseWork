import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFindCliquesForSpeed {


	@Test
	public void test() {
		
		int seed=1000;
		int n=500;
		double p=0.2;
		
		int k=3;
		ErdosRenyi s = new ErdosRenyi(seed);
		
		Graph g=s.randomGraph(n, p);
		
		
		int cliqueSize=6;
		
		CliquePercolation name = new CliquePercolation(g,k);
		
		long t1,t2;
		
		t1=System.currentTimeMillis();
		
		HashSet<HashSet<Integer>> cliques=name.findCliques(cliqueSize);
		
		System.out.println(cliques.size());
		
		t2=System.currentTimeMillis();
		
		System.out.println((t2-t1)/1000.0+" seconds to calculate cliques of size "+
		cliqueSize+" in the graph with params: n="+n+" p="+p);
	}

}