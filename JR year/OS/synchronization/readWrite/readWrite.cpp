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
void *reader ( void *ptr );
void *writer ( void *ptr );


/* global vars */
/* semaphores are declared global so they can be accessed
 in main() and in thread routine. */
int readCount = 0;
Semaphore mutex(1);
Semaphore readSem(1);
Semaphore writeSem(1);


int main()
{
    int i[4];
    pthread_t thread_a;
    pthread_t thread_b;
    pthread_t thread_c;
    pthread_t thread_d;
    
    i[0] = 0; /* argument to threads */
    i[1] = 1;
    i[2] = 2;
    i[3] = 3;
    
    /* Note: you can check if thread has been
     successfully created by checking return value of
     pthread_create */
    pthread_create (&thread_a, NULL, reader, (void *) &i[0]);
    pthread_create (&thread_b, NULL, reader, (void *) &i[1]);
    pthread_create (&thread_c, NULL, writer, (void *) &i[2]);
    pthread_create (&thread_d, NULL, writer, (void *) &i[3]);

     // Join threads
    (void) pthread_join(thread_a, NULL);
    (void) pthread_join(thread_b, NULL);
    (void) pthread_join(thread_c, NULL);
    (void) pthread_join(thread_d, NULL); 
    /* exit */
    exit(0);
    
} /* main() */


void *reader ( void *ptr ) {

    int threadNum; 
    threadNum = *((int *) ptr);
    // 100 is a number of choice to let it run a good amount of time
    for (int i = 0; i < 100; ++i) { 
        readSem.wait();
        mutex.wait();
        readCount++;
        if (readCount == 1)
            writeSem.wait();
        mutex.signal();
        readSem.signal();
        printf("Reader thread %d: Reading is now taking place\n", threadNum);
        mutex.wait();
        readCount--;
        if (readCount == 0)
            writeSem.signal();
        mutex.signal();
    }
    pthread_exit(0); /* exit thread */
}

void *writer ( void *ptr ) {
 
    int threadNum; 
    threadNum = *((int *) ptr);
    // 100 is a number of choice to let it run a good amount of time
    for (int i = 0; i < 100; ++i) {
        readSem.wait();
        writeSem.wait();
        printf("Writer thread %d: Writing is now taking place\n", threadNum);
        writeSem.signal();
        readSem.signal();
    } 
        
    pthread_exit(0); /* exit thread */
}
