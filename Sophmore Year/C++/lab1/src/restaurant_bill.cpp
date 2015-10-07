/*
PROGRAM: restaurant_bill.CPP
Written by Austin Haggard
This program calculates tax and tip of a restaurant patron
Last modification: 25JAN2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/

/** DO NOT MODIFY FUNCTION SIGNATURE **/
void restaurant_bill(double mealCharge){
/**************************************/

    /** Implement the function **/
	double taxAmount, totalAmount, tipAmount;
	//calculates tax amount
	taxAmount = .0675 * mealCharge;
	//calculates tip amount
	tipAmount = .15 * (taxAmount + mealCharge);
	//calculates total amount
	totalAmount = taxAmount + tipAmount + mealCharge;
	//prints meal price
	cout << mealCharge << endl;
	//prints tax price
	cout << taxAmount << endl;
	//prints tip amount
	cout << tipAmount << endl;
	//prints total price
	cout << totalAmount << endl;
}


int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test4(restaurant_bill);
    return retval;
}
