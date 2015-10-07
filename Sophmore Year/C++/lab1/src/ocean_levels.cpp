/*
PROGRAM: ocean_levels.CPP
Written by Austin Haggard
This program calcualtes how high the ocean will raise in given amount of years
Last modification: 25JAN2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/

/** DO NOT MODIFY FUNCTION SIGNATURE **/
void ocean_levels(double raisePerYear){
/**************************************/

    /** Implement the function **/
	double fiveYears, sevenYears, tenYears;
	//calculates raise height for year length
	fiveYears = 5 * raisePerYear;
	sevenYears = 7 * raisePerYear;
	tenYears = 10 * raisePerYear;
	//prints out highth changes
	cout << fiveYears << endl;
	cout << sevenYears << endl;
	cout << tenYears << endl;
}


int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test7(ocean_levels);
    return retval;
}
