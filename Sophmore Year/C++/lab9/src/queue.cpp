/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "queue.h"
/******************************************/
/** You might need to add some headers here **/
#include<cassert>
#include<iostream>
/**
 * Constructs a queue that can hold up to N elements
 *
 * @param N - the number of elements that the queue can hold
 */
Queue::Queue(unsigned N){
	head = NULL;
	tail = NULL;
	length = 0;
	maxSize = N;
}

/**
 * Constructs a queue containing the elements of the specified collection.
 *
 * @param collection - the collection whose elements are to be placed into the queue
 * @param N - the number of elements that the queue can hold
 */
Queue::Queue(const Collection& collection, unsigned N){

	head = NULL;
	tail = NULL;
	length = 0;
	maxSize = N;
	assert(N >= collection.size());
	addAll(collection);
}

/**
 * Destruct the queue.
 */
Queue::~Queue(){

	this->clear();
}

/**
 * Copy constructor
 *
 * @param obj - const reference of the object to copy
 */
Queue::Queue(const Queue& obj):LinkedList(){

	head = NULL;
	tail = NULL;
	maxSize = obj.maxSize;
	length = 0;
	this->addAll(obj);
}

/**
 *
 * Overload assignment operator. Check here:
 * http://stackoverflow.com/questions/3105798/why-must-the-copy-assignment-operator-return-a-reference-const-reference
 *
 * @param rhs - the right hand side of the operator
 * @return reference to the queue
 */
Queue& Queue::operator= (const Queue& rhs){

	if (this == &rhs)
		return *this;

	this->clear();
	this->addAll(rhs);

	return *this;
}

/**
 * Print the queue. Check here:
 * http://stackoverflow.com/questions/236801/should-operator-be-implemented-as-a-friend-or-as-a-member-function
 *
 * @param ostream - the output stream to print to
 * @param rhs - the queue to print
 * @return the reference to the output stream
 */
std::ostream& operator<<(std::ostream& ostream, const Queue &rhs){

	if (rhs.length == 0)
		return ostream << "List is Empty!";
	for (unsigned i = 0; i < rhs.length; i++) {
		ostream << rhs.get(i) << " ";
	}
	return ostream;
}

/**
 * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, returning true upon success or false if no space is currently available.
 *
 * @param element - the element to add
 * @return true upon success
 */
bool Queue::add(myType element){

	if (length == maxSize)
		return false;
	this->addLast(element);
	return true;
}

/**
 * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
 *
 * @return the head of the queue
 */
myType Queue::element(){
	if (length == 0)
		return 0;
	return head->x;
}

/**
 * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions
 *
 * @param element - the element to add
 * @return   true if the element was added to this queue, else false
 */
bool Queue::offer(myType element){

	if (length == maxSize - 1)
		return false;
	this->addLast(element);
	return true;
}

/**
 * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
 *
 * @return the head of the queue
 */
myType Queue::peek(){

	if (length == 0)
		return 0;
	return head->x;

}

/**
 * Retrieves and removes the head of this queue, or returns null if this queue is empty.
 *
 * @return the head of this queue, or null if this queue is empty
 */
myType Queue::poll(){
	if (length == 0)
		return 0;
	return this->removeFirst();
}

/**
 * Retrieves and removes the head of this queue.
 * This method differs from poll only in that it throws an exception if this queue is empty.
 *
 * @return the head of the queue
 */
myType Queue::remove(){

	assert(length != 0);
	return this->removeFirst();
}

