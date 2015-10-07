/*
PROGRAM: sales_prediction.CPP
Written by Austin Haggard
This program takes a number a returns 62 percent of it
Last modification: 25JAN2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/

/** DO NOT MODIFY FUNCTION SIGNATURE **/
double sales_prediction(double totalSales){
/**************************************/

    /** Implement the function **/
	double eastCoastSales;
	//calculates the east coast sale percentage based on total (62%)
	eastCoastSales = .62 * totalSales;
	return eastCoastSales;

}


int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test2(sales_prediction);
    return retval;
}
