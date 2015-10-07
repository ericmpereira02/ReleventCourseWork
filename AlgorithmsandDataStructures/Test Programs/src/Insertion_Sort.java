public class Insertion_Sort {
	void insertionSort(int list[]) {
		
		int pos = list.length-1;
		while (pos > 0) {
		int indexNew = pos - 1;
		int valueNew = list[indexNew];
		while ((indexNew < list.length-1) && (valueNew > list[indexNew+1])) {
		list[indexNew] = list[indexNew+1];
		indexNew++;
		}
		list[indexNew] = valueNew;
		pos--;
		}
	}
}

// Worst Case O(n^2)
// Best Case O(n)
