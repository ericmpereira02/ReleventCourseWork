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
void *producer ( void *ptr );
void *consumer ( void *ptr );


/* global vars */
/* semaphores are declared global so they can be accessed
 in main() and in thread routine. */
/* Semaphores used to manage threads that 
 * are adding and removing things from buffer */
const int BUFFER_SIZE = 5;
Semaphore mutex(1);
Semaphore fillCount(0);
Semaphore emptyCount(BUFFER_SIZE);
vector<int> buffer;


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
    pthread_create (&thread_a, NULL, producer, (void *) &i[0]);
    pthread_create (&thread_b, NULL, producer, (void *) &i[1]);
    pthread_create (&thread_c, NULL, consumer, (void *) &i[2]);
    pthread_create (&thread_d, NULL, consumer, (void *) &i[3]);

     // Join threads
    (void) pthread_join(thread_a, NULL);
    (void) pthread_join(thread_b, NULL);
    (void) pthread_join(thread_c, NULL);
    (void) pthread_join(thread_d, NULL); 
    /* exit */
    exit(0);
    
} /* main() */


void *producer ( void *ptr ) {

    int threadNum; 
    threadNum = *((int *) ptr);
    // 100 is a number of choice to let it run a good amount of time
    for (int i = 0; i < 100; ++i) { 
        emptyCount.wait();
        mutex.wait();
        buffer.push_back(1);
        printf("Producer thread %d: Adding a number to the list\n", threadNum);
        mutex.signal();
        fillCount.signal();
    }
    pthread_exit(0); /* exit thread */
}

void *consumer ( void *ptr ) {
 
    int threadNum; 
    threadNum = *((int *) ptr);
    // 100 is a number of choice to let it run a good amount of time
    for (int i = 0; i < 100; ++i) {
       fillCount.wait();
       mutex.wait();
       buffer.erase(buffer.begin());
       printf("Consumer thread %d: Removing a number from the list\n", threadNum);
       mutex.signal();
       emptyCount.signal();
    } 
        
    pthread_exit(0); /* exit thread */
}
