import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class test {

	public static void main(String[] args) {

		int[] array = {5 , 4, 8 , 7 ,9 , 4, 2, 10, 30, 21};
		CountingSort(array, 30);
		for (int num: array){
			System.out.print(num + ",");
		}
	}
	
	static void CountingSort(int[] A, int k) {
		int[] C = new int[k + 1];
		int[] B = new int[A.length];
		for (int i = 0; i < C.length; i++) {
			C[i] = 0;
		}
		for(int i = 0; i < A.length; i++) {
			C[A[i]] = C[A[i]] + 1;
		}
		for (int i = 2; i < k; i++) {
			C[i] = C[i - 1] + C[i];
		}
		for (int i = A.length; i > 1; i--) {
			B[C[A[i]]] = A[i];
			C[A[i]] = C[A[i]]  - 1;
		}

	}
}
