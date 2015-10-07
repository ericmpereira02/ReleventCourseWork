/*
PROGRAM: geometry_calculator.CPP
Written by Austin Haggard
This program calculates the area of different shapes
Last modification: 9FEB2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_driver.h"
#include <math.h>
/******************************************/

/** You might need to add some headers here **/
using namespace std;
/** DO NOT MODIFY FUNCTION SIGNATURE **/
double circle_area(int radius){
/**************************************/
    /** Implement the function **/
	//calculates circle area
	return (double)3.14 * pow(radius, 2);
}
/** DO NOT MODIFY FUNCTION SIGNATURE **/
double rectangle_area(int length, int width){
/**************************************/

    /** Implement the function **/
	//calculates rectangle area
	return (double)length * width;

}
/** DO NOT MODIFY FUNCTION SIGNATURE **/
double triangle_area(int base, int height){
/**************************************/

    /** Implement the function **/
	//calculates triangle area
	return (double)(base * height) / 2;
}
/** DO NOT MODIFY FUNCTION SIGNATURE **/
void display_menu(void){
/**************************************/

    /** Implement the function **/
	int choice;
	do {
		cout << "1. Calculate the Area of a Circle" << endl;
		cout << "2. Calculate the Area of a Rectangle" << endl;
		cout << "3. Calculate the Area of a Triangle" << endl;
		cout << "4. Quit" << endl;
		cout << "Enter your choice (1-4): ";
		cin >> choice;
		assert (choice >= 0);
		switch (choice) {
		case 1:
			int radius;
			cout << "enter the radius of a circle: ";
			cin >> radius;
			cout << endl;
			cout << circle_area(radius);
			break;
		case 2:
			int length, width;
			cout << "enter the length and width of a rectangle: ";
			cin >> length >> width;
			cout << endl;
			cout << rectangle_area(length, width);
			break;
		case 3:
			int base, height;
			cout << "enter the length of the triangles base and height: ";
			cin >> base >> height;
			cout << endl;
			cout << triangle_area(base,height);
			break;
		case 4:
			return;
		}
	} while(choice != 1 && choice != 2 && choice != 3 && choice != 4);
}


int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    int retval = test5(display_menu);
    return retval;
}
