
public class Counting_Sort {

	public void countingSort(int[] A, int[] B, int k) {
		int[] C = new int[k];
		
		for (int i = 0; i < k; i++) {
			C[i] = 0;	
		}
		
		for (int i = 1; i < A.length; i++)	{
			C[A[i]] = C[A[i]] + 1;
		}
		
		for (int i = 2; i < k; i++) {
			C[i] = C[i] + C[i - 1];
		}
		
		for (int i  = A.length; i > 1; i--) {
			B[C[A[i]]] = A[i];
			C[A[i]] = C[A[i]] - 1;
		}
	}
	
}

// O(n) O(k+n) need to know range of numbers ie.. 0-k out of 0-n numbers
