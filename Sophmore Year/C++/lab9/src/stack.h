#ifndef STACK_H
#define STACK_H

#include "linked_list.h"
#include <ostream>


/**
 * This is a stack.
 * https://en.wikipedia.org/wiki/Stack_%28abstract_data_type%29
 */
class Stack : public LinkedList {

public:
    /**
     * Constructs an empty stack.
     */
    Stack();
    
    /**
     * Constructs a stack containing the elements of the specified collection.
     *
     * @param collection - the collection whose elements are to be placed into the stack
     */
    Stack(const Collection& collection);
    
    /**
     * Destruct the stack.
     */
    ~Stack();
    
    /**
     * Copy constructor
     *
     * @param obj - const reference of the object to copy
     */
    Stack(const Stack& obj);
    
    /**
     *
     * Overload assignment operator. Check here:
     * http://stackoverflow.com/questions/3105798/why-must-the-copy-assignment-operator-return-a-reference-const-reference
     *
     * @param rhs - the right hand side of the operator
     * @return reference to the stack data structure
     */
    Stack& operator= (const Stack& rhs);
    
    /**
     * Print the stack. Check here:
     * http://stackoverflow.com/questions/236801/should-operator-be-implemented-as-a-friend-or-as-a-member-function
     *
     * @param ostream - the output stream to print to
     * @param rhs - the stack to print
     * @return the reference to the output stream
     */
    friend std::ostream& operator<<(std::ostream& ostream, const Stack &rhs);
    
    /**
     * Tests if this stack is empty.
     *
     * @return true if and only if this stack contains no items; false otherwise.
     */
    bool empty();
    
    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     *
     * @return the object at the top of this stack
     */
    myType peek();
    
    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
     *
     * @return The object at the top of this stack
     */
    myType pop();
    
    /**
     * Pushes an item onto the top of this stack.
     *
     * @param elemt - the item to be pushed onto this stack.
     * @return the element argument.
     */
    myType push(myType element);
    
    /**
     * Returns the 1-based position where an object is on this stack. 
     * If the object o occurs as an item in this stack, this method returns the distance from the top of the stack of the occurrence nearest the top of the stack.
     * The topmost item on the stack is considered to be at distance 1.
     *
     * @param element - the desired element
     * @return the 1-based position from the top of the stack where the object is located; the return value -1 indicates that the object is not on the stack.
     */
    int search(myType element);
    
};

#endif
