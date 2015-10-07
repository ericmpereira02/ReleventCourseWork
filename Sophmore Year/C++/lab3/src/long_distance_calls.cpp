/*
PROGRAM: long_distance_calls.CPP
Written by Austin Haggard
This program calculates the price of a long distance call
Last modification: 9FEB2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
#include <math.h>

/******************************************/

/** You might need to add some headers here **/
int checkTime(int);
/** DO NOT MODIFY FUNCTION SIGNATURE **/
double long_distance_calls(float startTime, int minutes){
/**************************************/
	//checks for negative values
	assert (startTime >= 0);
    /** Implement the function **/
	const double rpm1 = 0.12, rpm2 = 0.55, rpm3 = 0.35;
	int hour = startTime;
	int mins = (startTime - hour) * 100;
	//checks for time errors
	assert(mins <= 60);
	assert(hour < 24);
	double cost = 0;
	//calculates cost
	for (int i = 0; i < minutes; i++) {
		mins = checkTime(mins);
		if (mins == 0)
			hour++;

		if (hour >= 0 && hour < 7)
			cost += rpm1;

		else if (hour >= 7 && hour < 19)
			cost += rpm2;

		else if (hour >= 19 && hour < 24)
			cost += rpm3;
	}
	std::cout << cost;
	return  round(cost);
}
//changes when there's a new hour
int checkTime(int mins) {
	if (mins == 59)
		return 0;
	return mins + 1;
}
double round( double value ) {
    return floor( value*100 + 0.5 )/100;
}
int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test4(long_distance_calls);
    return retval;
}
