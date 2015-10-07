/*
PROGRAM: total_purchase.CPP
Written by Austin Haggard
This program Display each item’s price, the subtotal of the sale,
the amount of sales tax, and the total, then return the total.
Last modification: 25JAN2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/

/** DO NOT MODIFY FUNCTION SIGNATURE **/
double total_purchase(double salesTax){
/**************************************/

    /** Implement the function **/
	double item1, item2, item3, item4, item5, subTotal, tax, total;
	//assigns values to items
	item1 = 12.95;
	item2 = 24.95;
	item3 = 6.95;
	item4 = 14.95;
	item5 = 3.95;
	//calculates subtotal of items
	subTotal = item1 + item2 + item3 + item4 + item5;
	//caculate tax
	tax = subTotal * salesTax;
	//calculate total
	total = subTotal + tax;
	//print items, tax, and total
	cout << item1 << endl;
	cout << item2 << endl;
	cout << item3 << endl;
	cout << item4 << endl;
	cout << item5 << endl;
	cout << subTotal << endl;
	cout << tax << endl;
	cout << total << endl;
	//return total value
	return total;
}


int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test8(total_purchase);
    return retval;
}
