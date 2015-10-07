#ifndef COLLECTION_H
#define COLLECTION_H

#include <ostream>

/**
 * Define a new type myType that is the same as an int, but with a different name.
 */
typedef int myType;

/**
 * This is an abstract class for a list data structure.
 */
class Collection {
protected:
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
    Node* head;
    Node* tail;
    // this store the number of nodes in the collection. Useful for loops.
    unsigned length;
    
public:
    // This make sure that whatever inherit Collection will call the correct destructor.
    // It also silence a compiler warning on code.fit.edu.
    virtual ~Collection(){}
    /**
     * Inserts the specified element in the collection
     *
     * @param element - element to be inserted
     * @return true if the operation succeed
     */
    virtual bool add(myType element) = 0;
    
    /**
     * Inserts all of the elements in the specified collection.
     * The new elements will appear in the list in the order they are in the collection, i.e. collection[0],...,collection[N].
     *
     * @param collection - collection containing elements to be added to the list
     * @return true if the list changed as a result of the call
     */
    virtual bool addAll(const Collection& collection) = 0;
    
    /**
     * Removes all of the elements from the list. The list will be empty after this call returns.
     */
    virtual void clear() = 0;
    
    /**
     * Returns true if this list contains the specified element at least once.
     *
     * @param element - element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    virtual bool contains(myType element) const = 0;
    
    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     *
     * @param index - the index of the element to be removed
     * @return the element previously at the specified position
     */
    virtual myType remove(unsigned index) = 0;
    
    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    virtual unsigned size() const = 0;
    
    /**
     * Returns an array containing all of the elements in this list in proper sequence (from first to last element).
     *
     * @return an array containing the elements of the list in proper sequence
     */
    virtual myType* toArray() const = 0;
};

#endif
