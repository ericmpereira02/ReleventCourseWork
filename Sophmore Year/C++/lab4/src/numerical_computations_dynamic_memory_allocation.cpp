/*
PROGRAM: numerical_computations_dynamic_memory_allocation.CPP
Written by Ausitn Haggard
This program does matrix multiplication and dynamically allocates memory
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
int get_M(const char*);
using namespace std;

/** DO NOT MODIFY FUNCTION SIGNATURE **/
int load_matrix(const char* fileName, double** Matrix){
/**************************************/

    /** Implement the function **/
	//implements file
	ifstream file(fileName);
	if (file.bad())
		return -1;
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
			convertor >> Matrix[row][col];
			col++;
		}
		row++;
		col = 0;
	}
return row;

}
/** DO NOT MODIFY FUNCTION SIGNATURE **/
void product(const double* const* A, const double* const* B, double** productMatrix, int M){
/**************************************/
	//calculates matrix multiplication
	for (int i = 0; i < M; ++i) {
		for (int j = 0; j < M; ++j) {
			for (int k = 0; k < M; ++k) {
				productMatrix[i][j] += A[i][k] * B[k][j];
			}
		}
	}
}
/** DO NOT MODIFY FUNCTION SIGNATURE **/
void display_matrix(const double* const* Matrix, int M){
/**************************************/

    /** Implement the function **/
	for (int i = 0; i < M; ++i) {
		for (int j = 0; j < M; ++j) {
			cout << Matrix[i][j];
		}
		cout << endl;
	}
}
/** DO NOT MODIFY FUNCTION SIGNATURE **/
void matrix_multiplication(const char* fileNameMatrixA, const char* fileNameMatrixB){
/**************************************/

    /** Implement the function **/
	int Ma, Mb;
	assert(strcmp(fileNameMatrixA, "A.dat") == 0 && strcmp(fileNameMatrixB, "B.dat") == 0);
	//initialize matrix A
	Ma = get_M(fileNameMatrixA);
	double** matrixa = new double*[Ma];
	for (int i = 0; i < Ma; ++i)
		matrixa[i] = new double[Ma];
	load_matrix(fileNameMatrixA,matrixa);
	//initialize matrix B
	Mb = get_M(fileNameMatrixB);
	//checks if matricies are the same size
	assert(Ma == Mb);
	double** matrixb = new double*[Mb];
	for (int i = 0; i < Mb; ++i)
		matrixb[i] = new double[Mb];
	load_matrix(fileNameMatrixB,matrixb);
	//create product matrix
	double** productMatrix = new double*[Ma];
	for (int i = 0; i < Ma; ++i)
		productMatrix[i] = new double[Ma];
	product((const double**) matrixa,(const double**) matrixb, productMatrix, Ma);
	display_matrix((const double**) productMatrix, Ma);

}
//gets M
int get_M(const char* fileName) {
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
