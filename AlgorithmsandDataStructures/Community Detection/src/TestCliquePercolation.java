import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class TestCliquePercolation {

	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {     
				{ 10 }, { 12}, { 16 }
		});

	}
	int p;


	public TestCliquePercolation(int p_) {
		p=p_;
	}


	public int[] getCorrectResult(){


		if(p==12){

			int[] a={0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2};
			return a;

		}else if(p==16){
			int[] a={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1};
			return a;
		}else{
			int[] a={0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2};
			return a;
		}

	}

	
	public Graph getRandomGraph(){
		
		//%%%%%%%% Code to build a graph %%%%%%%
		int numberOfCommunities=3;
		int numberOfVerticesPerCommunity=6;
		
		
		int n_e=numberOfCommunities*numberOfVerticesPerCommunity; 
		Graph G = new Graph(n_e);

		// number of extra random vertices
	

		for(int c=0;c<numberOfCommunities;c++){
			
			
			for (int i = c*numberOfVerticesPerCommunity; i < numberOfVerticesPerCommunity
					+c*numberOfVerticesPerCommunity; i++) {
				for (int j = i+1; j < numberOfVerticesPerCommunity+
						c*numberOfVerticesPerCommunity; j++) {
					
					G.addEdge(i, j);
				}
			}
			
			
		}

		Random rng = new Random(1);

		for (int i = 0; i < p; i++) {
			int from=rng.nextInt(n_e);
			int to=rng.nextInt(n_e);

			G.addEdge(from, to);
		}
		
		return G;
		
	}

	@Test
	public void testCliquePercolation() {

		System.out.println("Test case for p: "+p);
		
		// will be different for different p
		CliquePercolation cliquePercolation = new CliquePercolation(getRandomGraph(),3);
		
		int[] c=cliquePercolation.findCommunities();
		
		System.out.println(Arrays.toString(c));
		
		assertEquals(true, areSame(c, getCorrectResult()));
		
	}
	
	
	public boolean areSame(int[] a,int[] b){
		
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if ((a[i]==a[j])!=(b[i]==b[j])) return false;
			}
		}
		
		return true;
		
	}

}