/*
PROGRAM: numerical-coputations.CPP
Written by Austin Haggard
This program preforms matrix multiplication
Last modification: 9FEB2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/
#include <fstream>
#include <sstream>
#include <string.h>
using namespace std;
/** DO NOT MODIFY FUNCTION SIGNATURE **/
int load_matrix(const char* fileName, double** Matrix){
/**************************************/
    /** Implement the function **/
	//implements file
	ifstream file(fileName);
	string line;
	int row = 0;
	//inputs file into matrix
	while(row < 4) {
		getline(file, line);
		stringstream iss(line);
		for(int col = 0; col < 4; col++) {
			string val;
			getline(iss,val, ' ');
			//makes sure matrix is square
			assert (!val.empty());
			stringstream convertor(val);
			convertor >> Matrix[row][col];
		}
		row++;
	}
return 0;
}
/** DO NOT MODIFY FUNCTION SIGNATURE **/
void product(const double** A, const double** B, double** productMatrix){
/**************************************/
	//calculates matrix multiplication
	for (int i = 0; i < 4; ++i) {
		for (int j = 0; j < 4; ++j) {
			for (int k = 0; k < 4; ++k) {
				productMatrix[i][j] += A[i][k] * B[k][j];
			}
		}
	}
}
/** DO NOT MODIFY FUNCTION SIGNATURE **/
void display_matrix(const double** Matrix){
/**************************************/

    /** Implement the function **/
	//displays matrix
	for (int i = 0; i < 4; ++i) {
		for (int j = 0; j < 4; ++j) {
			cout << Matrix[i][j];
		}
		cout << endl;
	}
}
/** DO NOT MODIFY FUNCTION SIGNATURE **/
void matrix_multiplication(const char* fileNameMatrixA, const char* fileNameMatrixB){
/**************************************/

    /** Implement the function **/
	//initialize matrix A
	double a[4][4];
	double *matrixa[4];
	for (int i = 0; i < 4; i++)
		matrixa[i] = a[i];
	load_matrix(fileNameMatrixA,matrixa);
	//initialize matrix B
	assert(strcmp(fileNameMatrixA, "A.dat") == 0 && strcmp(fileNameMatrixB, "B.dat") == 0);
	double b[4][4];
	double *matrixb[4];
	for (int i = 0; i < 4; i++)
		matrixb[i] = b[i];
	load_matrix(fileNameMatrixB,matrixb);
	//create product matrix
	double p[4][4];
	double *productMatrix[4];
	for (int i = 0; i < 4; i++)
		productMatrix[i] = p[i];
	product((const double**) matrixa,(const double**) matrixb, productMatrix);
	display_matrix((const double**) productMatrix);
}


int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test6(matrix_multiplication);
    return retval;
}
