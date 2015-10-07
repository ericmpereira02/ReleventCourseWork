/*
PROGRAM: land_calculation.CPP
Written by Austin Haggard
This program converts square feet to acres
Last modification: 1FEB2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/

/** DO NOT MODIFY FUNCTION SIGNATURE **/
double land_calculation(int landSize){
/**************************************/

    /** Implement the function **/
	//calculates acre size
	double acres = landSize / 43560;
	return acres;
}


int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test4(land_calculation);
    return retval;
}
