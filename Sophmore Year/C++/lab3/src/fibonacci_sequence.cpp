/*
PROGRAM: fibonacci_sequence.CPP
Written by Austin Haggard
This program calculates the nth number of the fibonacci sequence
Last modification: 6FEB2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/
using namespace std;

/** DO NOT MODIFY FUNCTION SIGNATURE **/
long fibonacci_sequence(int n){
/**************************************/

    /** Implement the function **/
	assert (n >= 0);
	/**returns the first two possibilites which don't need calculations,
	Runs before initilazing anything to improve possible preformance
	**/
	if (n == 0)
		return 0;
	if (n == 1)
		return 1;
	//calculates nth fibonacci sequence
	long f0 = 0, f1 = 1, nextNum;

	for (int i = 0; i < n - 1; i++) {
		nextNum = f0 + f1;
		f0 = f1;
		f1 = nextNum;
	}
	return nextNum;

}


int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test1(fibonacci_sequence);
    return retval;
}
