/*
 PROGRAM: dummy_driver.h
 Written by Marcello Tomasini
 This program implement the most simple driver to test a function
 */
#ifndef DUMMY_DRIVER_H
#define DUMMY_DRIVER_H
#include <cassert>
#include <iostream>
// DO NOT MODIFY THE SIGNATURE
int test1(long (*func)(int)){
/*****************************************/
    /** You can add your test cases here by calling func with different parameters **/
    assert(func(43) == 433494437);
    std::cout << func(-17) << std::endl;
    // If we reach this point everything was good
    return 0;
}

// DO NOT MODIFY THE SIGNATURE
int test2(std::string (*func)(int)){
/*****************************************/
    /** You can add your test cases here by calling func with different parameters **/
    assert(func(10) == "X");
    std::cout << func(11) << std::endl;
    // If we reach this point everything was good
    return 0;
}

// DO NOT MODIFY THE SIGNATURE
int test3(unsigned (*func)(float, float)){
/*****************************************/
    /** You can add your test cases here by calling func with different parameters **/
    assert(func(21.33,22.45) == 72);
    std::cout << func(-21.33,-22.45) << std::endl;
    // If we reach this point everything was good
    return 0;
}

// DO NOT MODIFY THE SIGNATURE
int test4(double (*func)(float, int)){
/*****************************************/
    /** You can add your test cases here by calling func with different parameters **/
    assert(func(6.30,59) == 19.98);
    std::cout << func(-6.30, -10) << std::endl;
    std::cout << func(6.66, 10) << std::endl;
    std::cout << func(24.30, 10) << std::endl;
    // If we reach this point everything was good
    return 0;
}

// DO NOT MODIFY THE SIGNATURE
int test5(void (*func)(void)){
/*****************************************/
    /** You can add your test cases here by calling func with different parameters **/
    func();
    // If we reach this point everything was good
    return 0;
}

// DO NOT MODIFY THE SIGNATURE
int test6(void (*func)(const char*, const char*)){
/*****************************************/
    /** You can add your test cases here by calling func with different parameters **/
    func("A.dat","B.dat");
    // If we reach this point everything was good
    return 0;
}

#endif
