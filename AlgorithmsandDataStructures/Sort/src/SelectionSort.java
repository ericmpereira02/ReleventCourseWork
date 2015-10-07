/*
 * Author : Austin Haggard, ahaggard2013@my.fit.edu
 * Course : CSE 2010, Section 01, Fall 2014
 * Project: Lab 5, MixAndMatchSort
 */
/**
 * 
 * @author ahaggard2013
 * 
 */
public class SelectionSort implements Sort {

	@SuppressWarnings("rawtypes")
	@Override
	/**
	 * Splits the array into a sorted and unsorted group 
	 * @param list List to be sorted
	 * @param first location of first index to be split
	 * @param last location of last index to be split
	 * @return index of the start of unsorted list
	 */
	public int split(Comparable[] list, int first, int last) {
		// splits list into sorted and unsorted sections
		return first + 1;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	/**
	 * Performs Selection sort on defined area of the list
	 * @param list List to be sorted
	 * @param from location of the first index to be sorted
	 * @param to location of the last index to be sorted
	 */
	public void sort(Comparable[] list, int from, int to) {
		if (from >= list.length - 1) {
			return;
		}
		int min = from;
		// finds minimum element
		for (int i = from + 1; i < list.length; i++) {
			if (list[i].compareTo(list[min]) < 0) {
				min = i;
			}
		}
		// swaps elements into sorted list
		Comparable temp = list[from];
		list[from] = list[min];
		list[min] = temp;
		sort(list, split(list, from, to), to);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	/**
	 * Combines the split portions of the list together
	 * @param list list to be combined
	 * @param first first index location of what to sort
	 * @param middle middle index of the array
	 * @param last last index to sort in the array
	 */
	public void combine(Comparable[] list, int first, int middle, int last) {
		Comparable[] temp = new Comparable[list.length];
		// assigns needed elements to temporary list
		for (int i = first; i <= last; i++) {
			temp[i] = list[i];
		}
		int low_index = first;
		int mid = middle + 1;
		int start_index = first;
		// reassembles the broken apart array in a sorted order
		while (low_index <= middle && mid <= last) {
			if (temp[low_index].compareTo(temp[mid]) < 0) {
				list[start_index] = temp[low_index];
				low_index++;
			} else {
				list[start_index] = temp[mid];
				mid++;
			}
			start_index++;
		}
		while (low_index <= middle) {
			list[start_index] = temp[low_index];
			start_index++;
			low_index++;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	/**
	 * @param list
	 */
	public void sort(Comparable[] list) {
		// sorts entire list
		sort(list, 0, list.length - 1);

	}

}
