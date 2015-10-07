import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import org.junit.Test;



public class test {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		
	int n=8;
		
		// arrays to be sorted
		Integer[] list = new Integer[n];
		Date[] dates = new Date[n];
	
		
		Random random = new Random(1);

		
		
		// populates arrays with random numbers, dates, grades
		for (int i = 0; i < n; i++) {
			
			list[i]=random.nextInt(100);
			dates[i]=new Date(random.nextInt(115), random.nextInt(12), random.nextInt(31),random.nextInt(24),random.nextInt(60));

		}
		
		Integer[] listCopy = Arrays.copyOfRange(list, 0, list.length);
		
		SelectionSort sort = new SelectionSort();
		
		sort.sort(listCopy);
		
		Arrays.sort(list);
		
		assertArrayEquals(list, listCopy);
	}

	
}
