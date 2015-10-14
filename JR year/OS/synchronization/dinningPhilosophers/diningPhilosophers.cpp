// Adapted using some code from Downey's book on semaphores
//
// Compilation:
//
/* Includes */

#include "semaphore_class.h"


/* prototype for thread routine */
void philosopherCheck (int);
void *get_fork ( void *ptr );
void *put_fork ( void *ptr );
void *start (void *ptr);
int  left (int num);
int  right (int);


/* global vars */
/* semaphores are declared global so they can be accessed
 in main() and in thread routine. */
string state[5] = {"thinking","thinking","thinking","thinking","thinking"};
vector<Semaphore> sem;
Semaphore mutex(1);


int main() {
 for (int i=0; i < 5; i++)
    sem.push_back(Semaphore(0));
    int i[5];
    pthread_t thread_a;
    pthread_t thread_b;
    pthread_t thread_c;
    pthread_t thread_d;
    pthread_t thread_e;
    
    i[0] = 0; /* argument to threads */
    i[1] = 1;
    i[2] = 2;
    i[3] = 3;
    i[4] = 4;
    
    /* Note: you can check if thread has been
     successfully created by checking return value of
     pthread_create */
    pthread_create (&thread_a, NULL, start, (void *) &i[0]);
    pthread_create (&thread_b, NULL, start, (void *) &i[1]);
    pthread_create (&thread_c, NULL, start, (void *) &i[2]);
    pthread_create (&thread_d, NULL, start, (void *) &i[3]);
    pthread_create (&thread_e, NULL, start, (void *) &i[4]);

     // Join threads
    (void) pthread_join(thread_a, NULL);
    (void) pthread_join(thread_b, NULL);
    (void) pthread_join(thread_c, NULL);
    (void) pthread_join(thread_d, NULL); 
    (void) pthread_join(thread_e, NULL); 
    /* exit */
    exit(0);
    
} /* main() */

/* only runs once but can continue to run longer with a loop */
void *start(void *ptr) {
    int philosopherNum; 
    philosopherNum = *((int *) ptr);
        get_fork(&philosopherNum);
        put_fork(&philosopherNum);
}
void philosopherCheck (int philosopherNum) {
    if (state[philosopherNum] == "hungry" && state[left(philosopherNum)]
            != "eating" && state[right(philosopherNum)] != "eating") {
        state[philosopherNum] = "eating";
        printf("Philosopher: %d: is eating!\n", philosopherNum);
    }
    sem[philosopherNum].signal();
}

void *put_fork( void *ptr) {
    mutex.wait();
    int philosopherNum; 
    philosopherNum = *((int *) ptr);
    state[philosopherNum] = "thinking";
    printf("Philosopher: %d: is putting fork down!\n", philosopherNum);
    philosopherCheck(right(philosopherNum));
    philosopherCheck(left(philosopherNum));
    mutex.signal();
}

void *get_fork( void *ptr) {
    mutex.wait();
    int philosopherNum; 
    philosopherNum = *((int *) ptr);
    printf("Philosopher: %d: is picking fork up!\n", philosopherNum);
    state[philosopherNum] = "hungry";
    philosopherCheck(philosopherNum);
    mutex.signal();
    sem[philosopherNum].wait();
}

int left(int num) {
    return num;
}
int right(int num) {
   return ((num + 1) % 5);
}


