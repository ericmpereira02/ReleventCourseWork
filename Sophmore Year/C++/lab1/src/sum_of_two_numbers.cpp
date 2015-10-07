/*
PROGRAM: sum_of_two_numbers.CPP
Written by Austin Haggard
This program accepts two integers, stores the sum and returns it
Last modification: 25JAN2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/

/** DO NOT MODIFY FUNCTION SIGNATURE **/
int sum_of_two_numbers(int num1, int num2){
/**************************************/

    /** Implement the function **/

	//Stores the two numbers in a variable named total
	int total = num1 + num2;
	//returns total
	return total;
}


int main()
{
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test1(sum_of_two_numbers);
    return retval;
}
