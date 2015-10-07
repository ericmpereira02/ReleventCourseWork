/*
PROGRAM: distance_per_tank_of_gas.CPP
Written by Austin Haggard
This program calculates the distance the car can travel on one tank of gas on the town and highway
Last modification: 1FEB2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/

/** DO NOT MODIFY FUNCTION SIGNATURE **/
void distance_per_tank_of_gas(int tankSize){
/**************************************/

    /** Implement the function **/
	const double mpgTown = 21.5, mpgHighway = 26.8;
	//calculates distance in town and highway
	cout << mpgTown * tankSize << endl;
	cout << mpgHighway * tankSize << endl;
}


int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test3(distance_per_tank_of_gas);
    return retval;
}
