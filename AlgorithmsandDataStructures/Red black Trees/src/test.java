

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class test {

	int size;
	int seed;
	
	public test(int size_,int seed_) {
		size=size_;
		seed=seed_;
		
	}
	
	@Parameters(name = "test({index})")
	public static Iterable<Object[]> data() {

		return Arrays.asList(new Object[][] { 
				{600,3},{300,4},{100,5},{400,10},{923,123},{234,23423}
		});
	}

	@Test
	public void testInsert() {
		Random rnd = new Random(this.seed);
		int n=size;
		ArrayList<Integer> list = new ArrayList<Integer>(n);

		for (int i = 0; i < n	; i++) {
			list.add(i);
		}
		
		Collections.shuffle(list, rnd);	
		
		RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
		for (int i = 0; i < n; i++) {
			tree.insert(list.get(i));
			assertEquals(tree.checkIfRBPropertySatisfied(), true);
		}
		
	}

//	@Test
//	public void testDelete() {
//		Random rnd = new Random(this.seed);
//		int n=size;
//		ArrayList<Integer> list = new ArrayList<Integer>(n);
//
//		for (int i = 0; i < n	; i++) {
//			list.add(i);
//		}
//		
//		Collections.shuffle(list, rnd);	
//		
//		RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
//		for (int i = 0; i < n; i++) {
//			tree.insert(list.get(i));
//			assertEquals(tree.checkIfRBPropertySatisfied(), true);
//		}
//		
//		
//		for (int i = 0; i < n; i++) {
//			tree.delete(list.get(i));
//			assertEquals(tree.checkIfRBPropertySatisfied(), true);
//		}
//	}

}
