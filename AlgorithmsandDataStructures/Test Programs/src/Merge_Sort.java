public class Merge_Sort {
	static void mergesort(int list[], int first, int last) {
		if (first >= last)
			return;
		int m = (first + last) / 2;
		mergesort(list, first, m);
		mergesort(list, m + 1, last);
		merge(list, first, m, last);
	}

	static void merge(int[] list, int first, int m, int last) {
		int i, j;
		int[] aux = new int[list.length];
		for (i = m + 1; i > first; i--) {
			aux[i - 1] = list[i - 1];
		}

		for (j = m; j < last; j++) {
			aux[last + m - j] = list[j + 1];
		}

		for (int k = first; k <= last; k++) {
			if (aux[j] < aux[i]) {
				list[k] = aux[j--];
			} else
				list[k] = aux[i++];
		}
	}
	
	static void quicksort(int list[], int first, int last) {
		if (first >= last)
			return;
		int split = partition(list, first, last);
		quicksort(list, first, split - 1);
		quicksort(list, split + 1, last);
	}
	
	static int partition (int list[], int first, int last) {
		int lastSmall = first;
		for (int i = first + 1; i <= last; i++) {
			if (list[i] <= list[first]) {
				lastSmall++;
				int temp = list[lastSmall];
				list[lastSmall] = list[i];
				list[i] = temp;
			}
		}
		int temp = list[first];
		list[first] = list[lastSmall];
		list[lastSmall] = temp;
		return lastSmall;
	}

	static void selectionsort(int[] list, int first, int last) {
		int pos = first;
		while (pos <= last) {
			int smallest = pos;
			for(int i = pos; i <= last; i++) {
				if(list[i] >= list[smallest]) 
					smallest = i;
				int temp = list[smallest];
				list[smallest] = list[i];
				list[i] = temp;
			}
			pos++;
		}
	}
	
	static void insertionsort(int[] list, int first, int last) {
		int pos = last;
		while (pos > 0) {
			int newIndex = pos - 1;
			int newVal = list[newIndex];
			while (newIndex < last && newVal > list[newIndex + 1]) {
				list[newIndex] = list[newIndex + 1];
				newIndex++;
			}
			list[newIndex] = newVal;
			pos--;
		}
	}
	
	public static void main(String[] args) {
		int[] array = { 1, 6, 5, 8, 32, 98, 12, 34, 56 };
		insertionsort(array, 0, array.length - 1);

		for (int num : array) {
			System.out.print(num + ",");
		}
	}
}

// Worst Case/ Best Case = O(n log n)