/*
PROGRAM: annual_pay.CPP
Written by Austin Haggard
This program calcualtes the annual pay given pay periods nad amount paid
Last modification: 25JAN2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/

/** DO NOT MODIFY FUNCTION SIGNATURE **/
double annual_pay(double payAmount, int payPeriods){
/**************************************/

    /** Implement the function **/
	double annualPay;
	//calculates annual pay
	annualPay = payAmount * payPeriods;
	//returns annual earnings
	return annualPay;
}


int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test6(annual_pay);
    return retval;
}
