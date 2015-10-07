/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "stack.h"
/******************************************/
/** You might need to add some headers here **/
#include<iostream>
#include<cassert>
/**
 * Constructs an empty stack.
 */
Stack::Stack(){

	head = NULL;
	tail = NULL;
	length = 0;
}

/**
 * Constructs a stack containing the elements of the specified collection.
 *
 * @param collection - the collection whose elements are to be placed into the stack
 */
Stack::Stack(const Collection& collection){

	head = NULL;
	tail = NULL;
	length = 0;
	addAll(collection);
}

/**
 * Destruct the stack.
 */
Stack::~Stack(){

	this->clear();
}

/**
 * Copy constructor
 *
 * @param obj - const reference of the object to copy
 */
Stack::Stack(const Stack& obj):LinkedList(){

	head = NULL;
	tail = NULL;
	length = 0;
	this->addAll(obj);
}

/**
 *
 * Overload assignment operator. Check here:
 * http://stackoverflow.com/questions/3105798/why-must-the-copy-assignment-operator-return-a-reference-const-reference
 *
 * @param rhs - the right hand side of the operator
 * @return reference to the stack data structure
 */
Stack& Stack::operator= (const Stack& rhs){

	if (this == &rhs)
		return *this;

	this->clear();
	this->addAll(rhs);

	return *this;
}

/**
 * Print the stack. Check here:
 * http://stackoverflow.com/questions/236801/should-operator-be-implemented-as-a-friend-or-as-a-member-function
 *
 * @param ostream - the output stream to print to
 * @param rhs - the stack to print
 * @return the reference to the output stream
 */
std::ostream& operator<<(std::ostream& ostream, const Stack &rhs){

	if (rhs.length == 0)
		return ostream << "List is Empty!";
	for (unsigned i = 0; i < rhs.length; i++) {
		ostream << rhs.get(i) << " ";
	}
	return ostream;
}

/**
 * Tests if this stack is empty.
 *
 * @return true if and only if this stack contains no items{} false otherwise.
 */
bool Stack::empty(){
	if (length == 0)
		return true;
	return false;
}

/**
 * Looks at the object at the top of this stack without removing it from the stack.
 *
 * @return the object at the top of this stack
 */
myType Stack::peek(){
	return this->get(0);
}

/**
 * Removes the object at the top of this stack and returns that object as the value of this function.
 *
 * @return The object at the top of this stack
 */
myType Stack::pop(){
	myType first = removeFirst();
	return first;
}

/**
 * Pushes an item onto the top of this stack.
 *
 * @param elemt - the item to be pushed onto this stack.
 * @return the element argument.
 */
myType Stack::push(myType element){

	this->addFirst(element);
	return element;
}

/**
 * Returns the 1-based position where an object is on this stack.
 * If the object o occurs as an item in this stack, this method returns the distance from the top of the stack of the occurrence nearest the top of the stack.
 * The topmost item on the stack is considered to be at distance 1.
 *
 * @param element - the desired element
 * @return the 1-based position from the top of the stack where the object is located{} the return value -1 indicates that the object is not on the stack.
 */
int Stack::search(myType element){

	if (!this->contains(element))
		return -1;
	Node *tmp = this->head;
	for (unsigned i = 0; i < this->length; i++) {

		if (element == tmp->x)
			return indexOf(element) + 1;
		tmp = tmp->next;
	}
	return -1;
}

