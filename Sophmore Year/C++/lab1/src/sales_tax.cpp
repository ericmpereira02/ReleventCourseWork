/*
PROGRAM: sales_tax.CPP
Written by Austin Haggard
This program computes sales tax of 6 percent
Last modification: 25JAN2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/

/** DO NOT MODIFY FUNCTION SIGNATURE **/
double sales_tax(double purchase){
/**************************************/

    /** Implement the function **/
	double finalPrice;
	//calculates total sales tax
	finalPrice = .06 * purchase;
	//returns final price
	return finalPrice;
}


int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test3(sales_tax);
    return retval;
}
