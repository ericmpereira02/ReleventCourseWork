//
// Example from: http://www.amparo.net/ce155/sem-ex.c
//
// Adapted using some code from Downey's book on semaphores
//
// Compilation:
//
//       g++ serialization.cpp -lpthread -o serial -lm
//
//
//
/* Includes */

#include "semaphore_class.h"


/* prototype for thread routine */
void *threadB ( void *ptr );
void *threadA ( void *ptr );


/* global vars */
/* semaphores are declared global so they can be accessed
 in main() and in thread routine. */
Semaphore B_Done(0);


int main()
{
    int i[3];
    pthread_t thread_a;
    pthread_t thread_b;
    
    i[0] = 0; /* argument to threads */
    i[1] = 1;
    
    
    /* Note: you can check if thread has been
     successfully created by checking return value of
     pthread_create */
    pthread_create (&thread_a, NULL, threadA, (void *) &i[0]);
    pthread_create (&thread_b, NULL, threadB, (void *) &i[1]);
    
    // Join threads
    (void) pthread_join(thread_a, NULL);
    (void) pthread_join(thread_b, NULL);
    
    /* exit */
    exit(0);
    
} /* main() */


void *threadA ( void *ptr )
{
    int x;
    x = *((int *) ptr);
    
    B_Done.wait();

    printf("Thread %d: Statement A: Must run after Statement B. \n", x);
    fflush(stdout);
    
    B_Done.signal();
    
    
    pthread_exit(0); /* exit thread */
}

void *threadB ( void *ptr )
{
    int x;
    x = *((int *) ptr);
    printf("Thread %d: Statement B: Must run before Statement A. \n", x);
    fflush(stdout);
    
    B_Done.signal();
    
    
    pthread_exit(0); /* exit thread */
}
