/*
 PROGRAM: dummy_driver.h
 Written by Marcello Tomasini
 This program implement the most simple driver to test a function
 */
#include <cassert>
#include <iostream>
using namespace std;
// DO NOT MODIFY THE SIGNATURE
int test1(int (*func)(int, int)){
/*****************************************/
    
    /** You can add your test cases here by calling func with different parameters **/
    int result = func(17, 11);
    assert(result == 28);
    
    // If we reach this point everything was good
    return 0;
}

// DO NOT MODIFY THE SIGNATURE
int test2(double (*func)(double)){
/*****************************************/
    /** You can add your test cases here by calling func with different parameters **/
    double result = func(4.6);
    assert(result == 2.852);

    // If we reach this point everything was good
    return 0;
}

// DO NOT MODIFY THE SIGNATURE
int test3(double (*func)(double)){
/*****************************************/
    /** You can add your test cases here by calling func with different parameters **/
    double result = func(100);
    assert(result == 6);

    // If we reach this point everything was good
    return 0;
}

// DO NOT MODIFY THE SIGNATURE
int test4(void (*func)(double)){
/*****************************************/
    /** You can add your test cases here by calling func with different parameters **/
    func(10);
    cout << "The meal cost should be: " << 10 << endl
         << "Taxes should be: " << 0.675<< endl
         << "Tip should be: " << 1.60125 << endl
	 << "Total bill should be: " << 12.27625 << endl;

    // If we reach this point everything was good
    return 0;
}

// DO NOT MODIFY THE SIGNATURE
int test5(double (*func)()){
/*****************************************/
    /** You can add your test cases here by calling func with different parameters **/
    double retval = func();
    cout << "The sum value should be: " << 154 << endl;
    assert(retval == 30.8);

    // If we reach this point everything was good
    return 0;
}

// DO NOT MODIFY THE SIGNATURE
int test6(double (*func)(double, int)){
/*****************************************/
    
    /** You can add your test cases here by calling func with different parameters **/
    double result = func(1700.00,26);
    assert(result == 44200);
    
    // If we reach this point everything was good
    return 0;
}

// DO NOT MODIFY THE SIGNATURE
int test7(void (*func)(double)){
/*****************************************/
    /** You can add your test cases here by calling func with different parameters **/
    func(1.5);
    cout << "In 5 years should be: " << 7.5 << endl
         << "In 7 years be: " << 10.5<< endl
         << "In 10 years should be: " << 15 << endl;

    // If we reach this point everything was good
    return 0;
}

// DO NOT MODIFY THE SIGNATURE
int test8(double (*func)(double)){
/*****************************************/
    /** You can add your test cases here by calling func with different parameters **/
    double result = func(0.06);
    cout << "Subtotal should be: " << 63.75 << endl
         << "Sales tax should be: " << 3.825 << endl;
    assert(result == 67.575);

    // If we reach this point everything was good
    return 0;
}
