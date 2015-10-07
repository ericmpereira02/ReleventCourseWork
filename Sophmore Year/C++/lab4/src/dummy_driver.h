/*
 PROGRAM: dummy_driver.h
 Written by Marcello Tomasini
 This program implement the most simple driver to test a function
 */
#ifndef DUMMY_DRIVER_H
#define DUMMY_DRIVER_H

// DO NOT MODIFY THE SIGNATURE
int test1(void (*func)(const char*, const char*)){
/*****************************************/
    /** You can add your test cases here by calling func with different parameters **/
    func("A.dat","B.dat");
    // If we reach this point everything was good
    return 0;
}
// DO NOT MODIFY THE SIGNATURE
int test2(void (*func)(const char*, const char*)){
/*****************************************/
    /** You can add your test cases here by calling func with different parameters **/
    func("ImageA.pgm","ImageB.pgm");
    // If we reach this point everything was good
    return 0;
}

#endif