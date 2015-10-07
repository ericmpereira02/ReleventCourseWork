/*
PROGRAM: average_of_values.CPP
Written by Austin Haggard
This program calculates the average of some given numbers
Last modification: 25JAN2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/

/** DO NOT MODIFY FUNCTION SIGNATURE **/
double average_of_values(){
/**************************************/

    /** Implement the function **/
	double num1, num2, num3, num4, num5, sum, average;
	num1 = 28;
	num2 = 32;
	num3 = 37;
	num4 = 24;
	num5 = 33;
	//calculates sum and average
	sum = num1 + num2 + num3 + num4 + num5;
	average = sum / 5;
	//prints variables to te screen
	cout << sum << endl;
	cout << average << endl;
	//returns the average
	return average;
}


int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test5(average_of_values);
    return retval;
}
