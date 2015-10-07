#ifndef LINKED_LIST_H
#define LINKED_LIST_H

#include <ostream>
#include "collection.h"


/**
 * This is a list that allows to add elements to its end or beginning in O(1).
 */
class LinkedList : public Collection {
    
public:
    /**
     * Constructs an empty list.
     */
    LinkedList();
    
    /**
     * Constructs a list containing the elements of the specified collection.
     *
     * @param collection - the collection whose elements are to be placed into this list
     */
    LinkedList(const Collection* collection);
    
    /**
     * Destruct the list.
     */
    virtual ~LinkedList();
    
    /**
     * Copy constructor
     *
     * @param obj - const reference of the object to copy
     */
    LinkedList(const LinkedList& obj);
    
    /**
     *
     * Overload assignment operator. Check here:
     * http://stackoverflow.com/questions/3105798/why-must-the-copy-assignment-operator-return-a-reference-const-reference
     *
     * @param rhs - the right hand side of the operator
     * @return reference to the list
     */
    LinkedList& operator= (const LinkedList& rhs);
    
    /**
     * Return a list which is the result of the concatenation of the lists.
     *
     * @param rhs - the right hand side of the operator
     * @return a list which is the result of the concatenation of the operands
     */
    LinkedList operator+ (LinkedList& rhs) const;
    
    /**
     * Modify an element of the list at a specified index
     *
     * @param index - the index of the element
     * @return reference to element at position index to modify
     */
    myType& operator[] (unsigned index);
    
    /**
     * Return the element at the index specified between the square brackets
     *
     * @param index - the index of the element
     * @return element at position index
     */
    myType operator[] (const unsigned index) const;
    
    /**
     * Compare two list L1 and L2. Return true if and only if L1.length() == L2.length() and L1[i] == L2[i] for all i.
     *
     * @param obj - const reference to the list to compare
     * @return true if the list are identical
     */
    bool operator==(const LinkedList& obj);
    
    /**
     * Print the list. Check here:
     * http://stackoverflow.com/questions/236801/should-operator-be-implemented-as-a-friend-or-as-a-member-function
     *
     * @param ostream - the output stream to print to
     * @param rhs - the list to print
     * @return the reference to the output stream
     */
    friend std::ostream& operator<<(std::ostream& ostream, const LinkedList &rhs);
    
    /**
     * Inserts the specified element in the list.
     *
     * @param element - element to be inserted
     * @return true if the operation succeed
     */
    bool add(myType element);
    
    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right
     * (adds one to their indices).
     *
     * @param index - index at which the specified element is to be inserted
     * @param element - element to be inserted
     */
    void add(unsigned index, myType element);
    
    /**
     * Inserts all of the elements in the specified collection.
     * The new elements will appear in the list in the order they are in the collection, i.e. collection[0],...,collection[N].
     *
     * @param collection - collection containing elements to be added to the list
     * @return true if the list changed as a result of the call
     */
    bool addAll(const Collection& collection);
    
    /**
     *Inserts all of the elements in the specified collection into this list, starting at the specified position.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices).
     * The new elements will appear in the list in the order they are in the collection, i.e. collection[0],...,collection[N].
     *
     * @param index - index at which to insert the first element from the specified collection
     * @param collection - array containing elements to be added to the list
     * @param N - the number of elements in the collection
     * @return true if the list changed as a result of the call
     */
    bool addAll(unsigned index, const Collection& collection);
    
    /**
     * Inserts the specified element at the beginning of the list.
     *
     * @param element - element to be inserted
     */
    void addFirst(myType element);
    
    /**
     * Add an element at the end of the list (right append)
     *
     * @param element - element to be inserted
     */
    void addLast(myType element);
    
    /**
     * Removes all of the elements from the list. The list will be empty after this call returns.
     */
    void clear();
    
    /**
     * Returns true if this list contains the specified element at least once.
     *
     * @param element - element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    bool contains(myType element) const;
    
    /**
     * Returns the element at the specified position in the list.
     *
     * @param index - index of the element to return
     * @return the element at the specified position in the list
     */
    myType get(unsigned index) const;
    
    /**
     * Returns the first element in the list.
     *
     * @return the first element in the list
     */
    myType getFirst() const;
    
    /**
     * Returns the Last element in the list.
     *
     * @return     the last element in the list
     */
    myType getLast() const;
    
    /**
     * Returns the index of the first occurrence of the specified element in the list,
     * or -1 if this list does not contain the element.
     *
     * @param elemt - element to search for
     * @return  the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    int indexOf(myType element) const;
    
    /**
     * Print the list to stdout in a formatted way
     */
    void print() const;
    
    /**
     * Retrieves and removes the head (first element) of the list.
     *
     * @return     the value in the head of the list
     */
    myType removeFirst();
    
    /**
     * Retrieves and removes the tail (first element) of the list.
     *
     * @return     the value in the tail of the list
     */
    myType removeLast();
    
    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     *
     * @param index - the index of the element to be removed
     * @return the element previously at the specified position
     */
    myType remove(unsigned index);
    
    /**
     * Removes the first occurrence of the specified element in the list (when traversing the list from head to tail).
     * If the list does not contain the element, it is unchanged.
     *
     * @param element - element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    bool removeFirstOccurence(myType element);
    
    /**
     * Removes the last occurrence of the specified element in the list (when traversing the list from head to tail).
     * If the list does not contain the element, it is unchanged.
     *
     * @param element - element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    bool removeLastOccurence(myType element);
    
    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index - index of the element to replace
     * @param element - element to be stored at the specified position
     * @return the element previously at the specified position
     */
    myType set(unsigned index, myType element);
    
    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    unsigned size() const;
    
    /**
     * Returns an array containing all of the elements in this list in proper sequence (from first to last element).
     *
     * @return an array containing the elements of the list in proper sequence
     */
    myType* toArray() const;

};

#endif
