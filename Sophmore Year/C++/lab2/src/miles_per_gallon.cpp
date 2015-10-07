/*
PROGRAM: miles_per_gallon.CPP
Written by Austin Haggard
This program calculates MPG given the size of the tank an distance it can travel
Last modification: 1FEB2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/

/** DO NOT MODIFY FUNCTION SIGNATURE **/
double miles_per_gallon(int gallons, int miles){
/**************************************/

    /** Implement the function **/

	//calculates MPG
	double MPG = miles / gallons;

	cout << MPG << endl;

	return MPG;
}


int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test2(miles_per_gallon);
    return retval;
}
