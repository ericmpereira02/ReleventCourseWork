/*
PROGRAM: personal_information.CPP
Written by Austin Haggard
This program displays personal information
Last modification: 1FEB2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
/******************************************/

/** You might need to add some headers here **/
#include <string.h>
/** DO NOT MODIFY FUNCTION SIGNATURE **/
void personal_information(){
/**************************************/

    /** Implement the function **/
	string name, address, city, state, zip, phone, major;
	//asks for and takes in personal information
	cout << "Enter your name: " << endl;
	getline(cin,name);
	cout << "Enter your address: " << endl;
	getline(cin,address);
	cout << "Enter your city: " << endl;
	getline(cin,city);
	cout << "Enter your state: " << endl;
	getline(cin,state);
	cout << "Enter your zip: " << endl;
	getline(cin,zip);
	cout << "Enter your phone number: " << endl;
	getline(cin,phone);
	cout << "Enter your major: " << endl;
	getline(cin,major);
	cout << name << endl << address + ", " + city + ", " + state + ", " + zip << endl << phone << endl << major << endl;
}


int main()
{

    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test6(personal_information);
    return retval;
}
