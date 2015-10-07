/*
PROGRAM: time_calculator.CPP
Written by Austin Haggard
This program calculates the amount of minuites between to given times
Last modification: 7FEB2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/
#include <math.h>
#include <cmath>
using namespace std;
/** DO NOT MODIFY FUNCTION SIGNATURE **/
unsigned time_calculator(float time1, float time2){
/**************************************/

    /** Implement the function **/
	assert (time1 >= 0 && time2 >= 0);
	unsigned minutes;
	//caclulates the time between hours
	minutes = 60 * abs(static_cast<int>(time1) - static_cast<int>(time2));
	//calculates the difference in minutes
	minutes += 100* abs(fmod(time1,1) - fmod(time2,1));
	cout << minutes;
	return minutes;
}


int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test3(time_calculator);
    return retval;
}
