/*
PROGRAM: cyborg_data_type_sizes.CPP
Written by Austin Haggard
This program determines th amount of memory used by data types
Last modification:1FEB2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/

/** DO NOT MODIFY FUNCTION SIGNATURE **/
void cyborg_data_type_sizes(void){
/**************************************/

    /** Implement the function **/
	//displays size of different data types
	cout << sizeof(char) << endl;
	cout << sizeof(int) << endl;
	cout << sizeof(float) << endl;
	cout << sizeof(double) << endl;
}


int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test1(cyborg_data_type_sizes);
    return retval;
}
