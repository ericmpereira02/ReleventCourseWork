/*
 PROGRAM: dummy_driver.h
 Written by Marcello Tomasini
 This program implement the most simple driver to test a function
 */
#ifndef DUMMY_DRIVER_H
#define DUMMY_DRIVER_H

#include<string>

/**
 * Define a new type myType that is the same as an int, but with a different name.
 */
typedef int myType;

/**
 * This is a node of the list, and it holds a integer value.
 */
struct Node{
    // value hold by the node
    myType x;
    // index of the node. Start from 0, as this is a C/C++ convention
    unsigned index;
    // next node in the list
    Node* next;
};

/**
 * This is a list that allows to add elements to its end or beginning in O(1).
 */
struct List {
    Node* head;
    Node* tail;
    // this store the number of nodes in the list. Useful for loops.
    unsigned length;
};


/**
 * Inserts the specified element at the specified position in this list. 
 * Shifts the element currently at that position (if any) and any subsequent elements to the right 
 * (adds one to their indices).
 *
 * @param L - list to which add element
 * @param index - index at which the specified element is to be inserted
 * @param element - element to be inserted
 */
void add(List* L, unsigned index, myType element);

/**
 *Inserts all of the elements in the specified collection into this list, starting at the specified position.
 * Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices).
 * The new elements will appear in the list in the order they are in the collection, i.e. collection[0],...,collection[N].
 *
 * @param L - the list to which add elements
 * @param index - index at which to insert the first element from the specified collection
 * @param collection - array containing elements to be added to the list
 * @param N - the number of elements in the collection
 * @return true if the list changed as a result of the call
 */
bool addAll(List* L, unsigned index, const myType* collection, unsigned N);

/**
 * Inserts the specified element at the beginning of the list.
 *
 * @param L - list to which add element
 * @param element - element to be inserted
 */
void addFirst(List* L, myType element);

/**
 * Add an element at the end of the list (right append)
 *
 * @param L - list to which add element
 * @param element - element to be inserted
 */
void addLast(List* L, myType element);

/**
 * Removes all of the elements from the list. The list will be empty after this call returns.
 *
 * @param L - list to empty
 */
void clear(List* L);

/**
 * Returns true if this list contains the specified element at least once.
 *
 * @param L - list which might contain the element
 * @param element - element whose presence in this list is to be tested
 * @return true if this list contains the specified element
 */
bool contains(const List* L, myType element);

/**
 * Returns the element at the specified position in the list.
 *
 * @param L - list that contain the element
 * @param index - index of the element to return
 * @return the element at the specified position in the list
 */
myType get(const List* L, unsigned index);

/**
 * Returns the first element in the list.
 * 
 * @param L - the list 
 * @return the first element in the list
 */
myType getFirst(const List* L);

/**
 * Returns the Last element in the list.
 *
 * @param L - the list
 * @return     the last element in the list
 */
myType getLast(const List* L);

/**
 * Returns the index of the first occurrence of the specified element in the list,
 * or -1 if this list does not contain the element.
 *
 * @param L - list containing the element
 * @param elemt - element to search for
 * @return  the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
 */
int indexOf(const List* L, myType element);

/**
 * Print the list to stdout in a formatted way
 *
 * @param L - list to print
 */
void print(const List* L);

/**
 * Retrieves and removes the head (first element) of the list.
 *
 * @param L - the list from which remove the first element
 * @return     the value in the head of the list
 */
myType removeFirst(List* L);

/**
 * Retrieves and removes the tail (first element) of the list.
 *
 * @param L - the list from which remove the first element
 * @return     the value in the tail of the list
 */
myType removeLast(List* L);

/**
 * Removes the element at the specified position in this list.
 * Shifts any subsequent elements to the left (subtracts one from their indices).
 * Returns the element that was removed from the list.
 *
 * @param L - the list from which remove the element
 * @param index - the index of the element to be removed
 * @return the element previously at the specified position
 */
myType remove(List* L, unsigned index);

/**
 * Removes the first occurrence of the specified element in the list (when traversing the list from head to tail).
 * If the list does not contain the element, it is unchanged.
 *
 * @param L - the list from which remove the element
 * @param element - element to be removed from this list, if present
 * @return true if this list contained the specified element
 */
bool removeFirstOccurence(List* L, myType element);

/**
 * Removes the last occurrence of the specified element in the list (when traversing the list from head to tail).
 * If the list does not contain the element, it is unchanged.
 *
 * @param L - the list from which remove the element
 * @param element - element to be removed from this list, if present
 * @return true if this list contained the specified element
 */
bool removeLastOccurence(List* L, myType element);

/**
 * Replaces the element at the specified position in this list with the specified element.
 *
 * @param L - the list to change
 * @param index - index of the element to replace
 * @param element - element to be stored at the specified position
 * @return the element previously at the specified position
 */
myType set(List* L, unsigned index, myType element);


/**
 * Returns the number of elements in this list.
 *
 * @param L - the list
 * @return the number of elements in this list
 */
unsigned size(List* L);

/**
 * Returns an array containing all of the elements in this list in proper sequence (from first to last element).
 *
 * @param L - the list
 * @return an array containing the elements of the list in proper sequence
 */
myType* toArray(const List* L);

#endif
