/*
PROGRAM: energy_drink_consuption.CPP
Written by Austin Haggard
This program calculates who buys one or more energy drink a week and who prefers citrus flavor
Last modification:1FEB2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/

/** DO NOT MODIFY FUNCTION SIGNATURE **/
void energy_drink_consuption(){
/**************************************/

    /** Implement the function **
	//calculates how many people buy atleast one drink a week and perfer citrus
	 * used int because you cant have a fraction of a person
	 */
	int oneDrinkPerWeek = 12467 * .14;
	cout << oneDrinkPerWeek << endl;
	int preferCitrus = .64 * oneDrinkPerWeek;
	cout << preferCitrus << endl;
}


int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test8(energy_drink_consuption);
    return retval;
}
