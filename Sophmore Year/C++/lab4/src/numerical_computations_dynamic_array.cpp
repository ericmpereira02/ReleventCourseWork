/*
PROGRAM: numerical_computations_dynamic_array.CPP
Written by Austin Haggard
This program calculates matrix multiplication using dynamic array
Last modification: 15FEB2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/
#include <fstream>
#include <sstream>
#include <string.h>
#include <cassert>
#include <iostream>
unsigned get_M(const char*);
using namespace std;

/** DO NOT MODIFY FUNCTION SIGNATURE **/
unsigned index(unsigned i, unsigned j, unsigned M){
/**************************************/

    /** Implement the function **/
	return (unsigned) i + M * j;

}
/** DO NOT MODIFY FUNCTION SIGNATURE **/
double* load_matrix(const char* fileName, unsigned& M){
/**************************************/

    /** Implement the function **/
	//implement array
	double *matrix = new double[M * M];
		//implements file
		ifstream file(fileName);
		assert(!file.bad());
		string line;
		int row = 0, col = 0;
		//inputs file into matrix
		while(getline(file, line)) {
			stringstream iss(line);
			string val;
			while(getline(iss,val, ' ')) {
				//makes sure matrix is square
				assert(!val.empty());
				stringstream convertor(val);
				convertor >> matrix[index(row,col,M)];
				col++;
			}
			row++;
			col = 0;
		}
	return matrix;

}
/** DO NOT MODIFY FUNCTION SIGNATURE **/
double* product(const double* A, const double* B, int M){
/**************************************/
	double *matrix = new double[M * M];
	for (int i = 0; i < M; ++i) {
		for (int j = 0; j < M; ++j) {
			for (int k = 0; k < M; ++k) {
				matrix[index(i,j,M)] += A[index(i,k,M)] * B[index(k,j,M)];
			}
		}
	}
	return matrix;
}
/** DO NOT MODIFY FUNCTION SIGNATURE **/
void display_matrix(const double* Matrix, int M){
/**************************************/

    /** Implement the function **/
	for (int i = 0; i < M; ++i) {
		for (int j = 0; j < M; ++j) {
			cout << Matrix[index(i,j,M)];
		}
		cout << endl;
	}

}
/** DO NOT MODIFY FUNCTION SIGNATURE **/
void matrix_multiplication(const char* fileNameMatrixA, const char* fileNameMatrixB){
/**************************************/

    /** Implement the function **/
	unsigned Ma, Mb;
	double *matrixA, *matrixB, *productMatrix;
	assert(strcmp(fileNameMatrixA, "A.dat") == 0 && strcmp(fileNameMatrixB, "B.dat") == 0);
	//initialize matrix A
	Ma = get_M(fileNameMatrixA);
	matrixA = load_matrix(fileNameMatrixA,Ma);
	//initialize matrix B
	Mb = get_M(fileNameMatrixB);
	//checks if matricies are the same size
	assert(Ma == Mb);
	matrixB = load_matrix(fileNameMatrixB,Mb);
	//create product matrix
	productMatrix = product((const double*) matrixA,(const double*) matrixB, Ma);
	display_matrix((const double*) productMatrix, Ma);

}

//gets M
unsigned get_M(const char* fileName) {
	int M = 0;
	ifstream file(fileName);
	string line;
	//returns number of rows in file
	while(getline(file, line)) {
		M++;
	}
	return M;
}

int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test1(matrix_multiplication);
    return retval;
}
