/*
PROGRAM: stock_commission.CPP
Written by Austin Haggard
This program displays amount paid for stock and stock commissions
Last modification:1FEB2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/

/** DO NOT MODIFY FUNCTION SIGNATURE **/
void stock_commission(int amountOfShares, double sharePrice, double brokerCommission){
/**************************************/

    /** Implement the function **/
	double stockAlone, commission, total;
	stockAlone = amountOfShares * sharePrice;
	cout << stockAlone << endl;
	commission = brokerCommission * stockAlone;
	cout << commission << endl;
	total = stockAlone + commission;
	cout << total << endl;
}


int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test7(stock_commission);
    return retval;
}
