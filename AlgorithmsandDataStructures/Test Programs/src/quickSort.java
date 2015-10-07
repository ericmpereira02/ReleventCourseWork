
public class quickSort {
	
	static void quick_sort(int[] list, int first, int last) {
		
		if (first >= last) {
			return;
		}
		int split = partition(list, first, last);
		quick_sort(list, first, split - 1);
		quick_sort(list,split + 1, last);
	}
	
	static int partition(int list[], int first, int last) {
		int lastSmall = first;
		for (int i = first + 1; i <= last; i++) {
			if (list[i] <= list[first]) {
				lastSmall++;
				int temp = list[lastSmall];
				list[lastSmall] = list[i];
				list[i] = temp;
			}
				
		}
		int temp = list[lastSmall];
		list[lastSmall] = list[first];
		list[first] = temp;
		
		return lastSmall;
	}
	
	public static void main(String[] args) {
		int[] array = {1 ,6, 5, 8, 32, 98, 12, 34, 56};
		quick_sort(array, 0, array.length - 1);
		
		for(int num: array) {
			System.out.print(num + ",");
		}
	}
}
