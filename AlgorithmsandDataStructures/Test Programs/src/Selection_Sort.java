public class Selection_Sort {
	
	void selectionSort(int list[]) {
		int last = list.length;
		int maxPos;
		while (last > 0) {
			// INV: list[last-1] ... list[list.length-1] is sorted &&
			// everything in list[0] ... list[last] <=
			// everything in list[last+1] ... last[list.length-1]
			maxPos = findMax(list, last + 1);
			swap(list, maxPos, last);
			last--;
		}
	}
}

// Worst Case O(n^2)
// Best Case O(n^2)