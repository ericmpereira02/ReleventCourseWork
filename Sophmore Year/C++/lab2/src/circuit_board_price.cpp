/*
PROGRAM: circuit_board_price.CPP
Written by Austin Haggard
This program calulates selling price of a circuit board with 40 percent profit
Last modification: 1FEB2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/

/** DO NOT MODIFY FUNCTION SIGNATURE **/
double circuit_board_price(double circuitBoardPrice){
/**************************************/

    /** Implement the function **/
	double sellingPrice;
	//calculate selling price
	sellingPrice = circuitBoardPrice / (circuitBoardPrice * .060);
	cout << sellingPrice << endl;
	return sellingPrice;
}


int main()
{

    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test5(circuit_board_price);
    return retval;
}
