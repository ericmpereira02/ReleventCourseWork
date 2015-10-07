/*
 * Author : Austin Haggard, ahaggard2013@my.fit.edu
 * Course : CSE 2010, Section 01, Fall 2014
 * Project: Lab 4, Matrix Multiplicaiton
 */

/**
 * 
 * @author ahaggard2013
 * 
 */
public class Matrix {
	/**
	 * Accuracy of the matrices being equal
	 */
	private static final double EQUAL_ACCURACY = .000001;
	/**
	 * Base Case of the recursive function
	 */
	private static final int BASE_CASE = 1;
	/**
	 * Elements inside of the matrix
	 */
	private double[][] elements; // elements of the matrix
	/**
	 * size of the matrix
	 */
	private int n; // size

	/**
	 * Constructor
	 * 
	 * @param elements_
	 *            Array to be turned into a Matrix
	 */
	public Matrix(double[][] elements_) {
		// constructor
		this.elements = elements_;
		this.n = elements_.length;
	}

	/**
	 * This method uses the Strassen Method to Multiply two Matrices
	 * 
	 * @param b
	 *            Matrix to be multiplied
	 * @return Product of the two Matrices
	 */
	public Matrix multiplyStrassen(Matrix b) {
		// implement Strassen method for matrix multiplication. This function
		// should be recursive.
		double[][] c = new double[this.n][this.n];
		Matrix ans = new Matrix(c);
		if (this.n == BASE_CASE) {
			ans.elements[0][0] = this.elements[0][0] * b.elements[0][0];
		} else {
			double[][] A11_ = new double[n / 2][n / 2];
			double[][] A12_ = new double[n / 2][n / 2];
			double[][] A21_ = new double[n / 2][n / 2];
			double[][] A22_ = new double[n / 2][n / 2];
			double[][] B11_ = new double[n / 2][n / 2];
			double[][] B12_ = new double[n / 2][n / 2];
			double[][] B21_ = new double[n / 2][n / 2];
			double[][] B22_ = new double[n / 2][n / 2];
			// Creates locations to hold elements
			Matrix A11 = new Matrix(A11_);
			Matrix A12 = new Matrix(A12_);
			Matrix A21 = new Matrix(A21_);
			Matrix A22 = new Matrix(A22_);
			Matrix B11 = new Matrix(B11_);
			Matrix B12 = new Matrix(B12_);
			Matrix B21 = new Matrix(B21_);
			Matrix B22 = new Matrix(B22_);
			// Converts current Matrix into a smaller one
			parentToChild(this, A11, 0, 0);
			parentToChild(this, A12, 0, n / 2);
			parentToChild(this, A21, n / 2, 0);
			parentToChild(this, A22, n / 2, n / 2);
			// Does the same with the second one
			parentToChild(b, B11, 0, 0);
			parentToChild(b, B12, 0, n / 2);
			parentToChild(b, B21, n / 2, 0);
			parentToChild(b, B22, n / 2, n / 2);
			// First ten addition and subtraction operations
			Matrix S1 = A11.add(A22);
			Matrix S2 = B11.add(B22);
			Matrix S3 = A21.add(A22);
			Matrix S4 = B12.subtract(B22);
			Matrix S5 = B21.subtract(B11);
			Matrix S6 = A11.add(A12);
			Matrix S7 = A21.subtract(A11);
			Matrix S8 = B11.add(B12);
			Matrix S9 = A12.subtract(A22);
			Matrix S10 = B21.add(B22);
			// Recursive multiplication operations
			Matrix P1 = S1.multiplyStrassen(S2);
			Matrix P2 = S3.multiplyStrassen(B11);
			Matrix P3 = A11.multiplyStrassen(S4);
			Matrix P4 = A22.multiplyStrassen(S5);
			Matrix P5 = S6.multiplyStrassen(B22);
			Matrix P6 = S7.multiplyStrassen(S8);
			Matrix P7 = S9.multiplyStrassen(S10);
			// More addition and subtraction
			Matrix C11 = P1.subtract(P5).add(P4.add(P7));
			Matrix C12 = P3.add(P5);
			Matrix C21 = P2.add(P4);
			Matrix C22 = P1.subtract(P2).add(P3.add(P6));
			// Converts subMatrices into the product
			compile(C11, ans, 0, 0);
			compile(C12, ans, 0, n / 2);
			compile(C21, ans, n / 2, 0);
			compile(C22, ans, n / 2, n / 2);
		}
		return ans;
	}

	/**
	 * Multiplies two Matices the standard way
	 * 
	 * @param b
	 *            Matrix to multiply
	 * @return product of two matrices
	 */
	public Matrix multiply(Matrix b) {
		// implement regular matrix multiplication method (hint: you might want
		// to use it for testing)
		double[][] c = new double[this.n][this.n];
		for (int i = 0; i < b.n; i++) {
			for (int j = 0; j < b.n; j++) {
				for (int j2 = 0; j2 < b.n; j2++) {
					c[i][j] += this.elements[i][j2] * b.elements[j2][j];
				}
			}
		}
		Matrix newMatrix = new Matrix(c);
		return newMatrix;
	}

	/**
	 * Checks if two Matices are equal
	 * 
	 * @param b
	 *            Matrix to compare to
	 * @return True or False value if the two matrices are the same
	 */
	public boolean equals(Matrix b) {
		// check if matrices are equal. Compare elements up to certain
		// precision, say 1e-6, e.g.
		// abs(this.elements[i][j]-b.elements[i][j])<1e-6
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				if (Math.abs(this.elements[i][j] - b.elements[i][j]) > EQUAL_ACCURACY) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Puts the matrix back into its full size
	 * 
	 * @param C
	 *            Matrix that will be compiled into an answer
	 * @param ans
	 *            will end up holding the final answer when everything is
	 *            combined
	 * @param i2
	 *            allows you to assign where the values will be placed in ans
	 * @param j2
	 *            allows you to assign where the values will be placed in ans
	 */
	public void compile(Matrix C, Matrix ans, int i2, int j2) {
		// Assigns the elements into the answer Matrix
		for (int i = 0, i1 = i2; i < C.elements.length; i++, i1++) {
			for (int j = 0, j1 = j2; j < C.elements.length; j++, j1++) {
				ans.elements[i1][j1] = C.elements[i][j];
			}
		}
	}

	/**
	 * Converts the Matrix into a smaller piece of the matrix
	 * 
	 * @param A
	 *            Matrix that will be divided into smaller matrices
	 * @param B
	 *            Where the smaller matrices will be assigned
	 * @param i2
	 *            allows you to place Matrix pieces in the right place
	 * @param j2
	 *            allows you to place Matrix pieces in the right place
	 */
	public void parentToChild(Matrix A, Matrix B, int i2, int j2) {
		// Converts matrix into smaller portions
		for (int i = 0, i1 = i2; i < B.elements.length; i++, i1++) {
			for (int j = 0, j1 = j2; j < B.elements.length; j++, j1++) {
				B.elements[i][j] = A.elements[i1][j1];
			}
		}
	}

	/**
	 * Converts Matrix to a String
	 */
	public String toString() {
		// return string representation of the matrix
		StringBuilder matrix = new StringBuilder();
		String size = "Matrix of the size [" + this.n + "," + this.n + "]";
		matrix.append(size);
		matrix.append('\n');
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				matrix.append(this.elements[i][j] + " ");
			}
			matrix.append('\n');
		}
		return matrix.toString();
	}

	/**
	 * Adds two Matrices
	 * 
	 * @param b
	 *            Matrix that will be added to this
	 * @return sum of two matrices
	 */
	public Matrix add(Matrix b) {
		// addition
		double[][] c = new double[this.n][this.n];
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				c[i][j] = this.elements[i][j] + b.elements[i][j];
			}
		}
		Matrix answer = new Matrix(c);
		return answer;
	}

	/**
	 * Subtracts two Matrices
	 * 
	 * @param b
	 *            Matrix to be subtracted form this
	 * @return difference of the two matrices
	 */
	public Matrix subtract(Matrix b) {
		// subtraction
		double[][] c = new double[this.n][this.n];
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				c[i][j] = this.elements[i][j] - b.elements[i][j];
			}
		}
		Matrix answer = new Matrix(c);
		return answer;
	}

}