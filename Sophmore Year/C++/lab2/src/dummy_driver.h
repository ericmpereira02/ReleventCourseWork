/*
 PROGRAM: dummy_driver.h
 Written by Marcello Tomasini
 This program implement the most simple driver to test a function
 */
#include <cassert>
#include <iostream>
using namespace std;
// DO NOT MODIFY THE SIGNATURE
int test1(void (*func)(void)){
/*****************************************/
    
    /** You can add your test cases here by calling func with different parameters **/
    func();
    
    // If we reach this point everything was good
    return 0;
}

// DO NOT MODIFY THE SIGNATURE
int test2(double (*func)(int,int)){
/*****************************************/
    /** You can add your test cases here by calling func with different parameters **/
    double result = func(10,10);
    assert(result == 1);

    // If we reach this point everything was good
    return 0;
}

// DO NOT MODIFY THE SIGNATURE
int test3(void (*func)(int)){
/*****************************************/
    /** You can add your test cases here by calling func with different parameters **/
    func(10);

    // If we reach this point everything was good
    return 0;
}

// DO NOT MODIFY THE SIGNATURE
int test4(double (*func)(int)){
/*****************************************/
    /** You can add your test cases here by calling func with different parameters **/
    double result = func(43560);
    assert(result == 1);

    // If we reach this point everything was good
    return 0;
}

// DO NOT MODIFY THE SIGNATURE
int test5(double (*func)(double)){
/*****************************************/
    /** You can add your test cases here by calling func with different parameters **/
    double retval = func(10);
    assert(retval < 16.68 && retval > 16.66);

    // If we reach this point everything was good
    return 0;
}

// DO NOT MODIFY THE SIGNATURE
int test6(void (*func)(void)){
/*****************************************/
    
    /** You can add your test cases here by calling func with different parameters **/
    func();
    
    // If we reach this point everything was good
    return 0;
}

// DO NOT MODIFY THE SIGNATURE
int test7(void (*func)(int, double, double)){
/*****************************************/
    /** You can add your test cases here by calling func with different parameters **/
    func(1, 10, 0.02);

    // If we reach this point everything was good
    return 0;
}

// DO NOT MODIFY THE SIGNATURE
int test8(void (*func)(void)){
/*****************************************/
    /** You can add your test cases here by calling func with different parameters **/
    func();

    // If we reach this point everything was good
    return 0;
}
