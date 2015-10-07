#ifndef QUEUE_H
#define QUEUE_H

#include <ostream>
#include "linked_list.h"

/**
 * This is a queue with a FIFO (First In First Out) policy.
 * https://en.wikipedia.org/wiki/Queue_%28abstract_data_type%29
 */
class Queue : public LinkedList {
protected:
    unsigned maxSize;
    
public:
    /**
     * Constructs a queue that can hold up to N elements
     *
     * @param N - the number of elements that the queue can hold
     */
    Queue(unsigned N = -1);
    
    /**
     * Constructs a queue containing the elements of the specified collection.
     *
     * @param collection - the collection whose elements are to be placed into the queue
     * @param N - the number of elements that the queue can hold
     */
    Queue(const Collection& collection, unsigned N = -1);
    
    /**
     * Destruct the queue.
     */
    ~Queue();
    
    /**
     * Copy constructor
     *
     * @param obj - const reference of the object to copy
     */
    Queue(const Queue& obj);
    
    /**
     *
     * Overload assignment operator. Check here:
     * http://stackoverflow.com/questions/3105798/why-must-the-copy-assignment-operator-return-a-reference-const-reference
     *
     * @param rhs - the right hand side of the operator
     * @return reference to the queue
     */
    Queue& operator= (const Queue& rhs);
    
    /**
     * Print the queue. Check here:
     * http://stackoverflow.com/questions/236801/should-operator-be-implemented-as-a-friend-or-as-a-member-function
     *
     * @param ostream - the output stream to print to
     * @param rhs - the queue to print
     * @return the reference to the output stream
     */
    friend std::ostream& operator<<(std::ostream& ostream, const Queue &rhs);
    
    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, returning true upon success or false if no space is currently available.
     *
     * @param element - the element to add
     * @return true upon success
     */
    bool add(myType element);
    
    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     *
     * @return the head of the queue
     */
    myType element();
    
    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions
     *
     * @param element - the element to add
     * @return   true if the element was added to this queue, else false
     */
    bool offer(myType element);
    
    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     *
     * @return the head of the queue
     */
    myType peek();
    
    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     *
     * @return the head of this queue, or null if this queue is empty
     */
    myType poll();
    
    /**
     * Retrieves and removes the head of this queue. 
     * This method differs from poll only in that it throws an exception if this queue is empty.
     *
     * @return the head of the queue
     */
    myType remove();
    
};

#endif
