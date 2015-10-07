import java.io.IOException;

public class Driver{
	
	public static void main(String[] args) throws IOException {

		String dictionaryFilename="C:/Users/AJ/Documents/FIT/DataStruc/words.txt";
		
		int shingleSize=3;
		long t1,t2;
		t1=System.currentTimeMillis();
		SpellCheck d = new SpellCheck(dictionaryFilename,shingleSize);
		t2=System.currentTimeMillis();
		System.out.println("Time for constructor: "+(t2-t1));
		System.out.println(d.distance("kittens", "sittings")); 
		System.out.println(d.distance("data structures", "algorithms")); 
		System.out.println(d.distance("Monday", "Friday"));
		
		
		String strToCorrect="asfkbnf";
		
		Pair<String, Integer> correction;
		
		t1=System.currentTimeMillis();
		correction=d.naiveCorrect(strToCorrect);
		System.out.println(correction);
		t2=System.currentTimeMillis();
		
		System.out.println("Time for naive approach: "+(t2-t1));
		
		t1=System.currentTimeMillis();
		correction=d.fastCorrect(strToCorrect);
		System.out.println(correction);
		t2=System.currentTimeMillis();
		
		System.out.println("Time for shingle-based approach:" +(t2-t1));
	
		
	}
}