/*
PROGRAM: roman_numeral_converter.CPP
Written by Austin Haggard
This program returns a string roman numeral for ints 1-10
Last modification: 7FEB2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/

/** DO NOT MODIFY FUNCTION SIGNATURE **/
std::string roman_numeral_converter(int n){
/**************************************/

    /** Implement the function **/
	assert(n <= 10 && n >= 1);
	//returns roman numerals for numbers 1 - 10
	switch (n) {
	case 1:
		std::cout << "I" << std::endl;
		return "I";
		break;
	case 2:
		std::cout << "II" << std::endl;
		return "II";
		break;
	case 3:
		std::cout << "III" << std::endl;
		return "III";
		break;
	case 4:
		std::cout << "III" << std::endl;
		return "IV";
		break;
	case 5:
		std::cout << "V" << std::endl;
		return "V";
		break;
	case 6:
		std::cout << "VI" << std::endl;
		return "VI";
		break;
	case 7:
		std::cout << "VII" << std::endl;
		return "VII";
		break;
	case 8:
		std::cout << "IIX" << std::endl;
		return "IIX";
		break;
	case 9:
		std::cout << "IX" << std::endl;
		return "IX";
		break;
	case 10:
		std::cout << "X" << std::endl;
		return "X";
		break;
	}
	return "this should never happen";
}


int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test2(roman_numeral_converter);
    return retval;
}
