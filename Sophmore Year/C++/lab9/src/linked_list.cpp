/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "linked_list.h"
/******************************************/
/** You might need to add some headers here **/
#include<iostream>
#include<ostream>
#include<cassert>

using namespace std;
/**
 * Constructs an empty list.
 */
LinkedList::LinkedList(){
	head = NULL;
	tail = NULL;
	length = 0;
}

/**
 * Constructs a list containing the elements of the specified collection.
 *
 * @param collection - the collection whose elements are to be placed into this list
 */
LinkedList::LinkedList(const Collection* collection){

	head = NULL;
	tail = NULL;
	length = 0;
	addAll(*collection);
}

/**
 * Destruct the list.
 */
LinkedList::~LinkedList(){

	this->clear();
}

/**
 * Copy constructor
 *
 * @param obj - const reference of the object to copy
 */
LinkedList::LinkedList(const LinkedList& obj){

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
 * @return reference to the list
 */
LinkedList& LinkedList::operator= (const LinkedList& rhs){

	if (this == &rhs)
		return *this;

	this->clear();
	this->addAll(rhs);

	return *this;
}

/**
 * Return a list which is the result of the concatenation of the lists.
 *
 * @param rhs - the right hand side of the operator
 * @return a list which is the result of the concatenation of the operands
 */
LinkedList LinkedList::operator+ (LinkedList& rhs) const{

	LinkedList resultant;
	Node *tmp1 = this->head;
	Node *tmpRhs = rhs.head;

	for (unsigned i = 0; i < this->length; i++) {
		resultant.add(i,tmp1->x);
		tmp1 = tmp1->next;
	}

	for (unsigned i = this->length; i < this->length + rhs.length; i++) {
		resultant.add(i,tmpRhs->x);
		tmpRhs = tmpRhs->next;
	}
	return resultant;
}

/**
 * Modify an element of the list at a specified index
 *
 * @param index - the index of the element
 * @return reference to element at position index to modify
 */
myType& LinkedList::operator[] (unsigned index){

	assert (index <= this->length);
	Node *tmp = head;

	for (unsigned i = 0; i < index; i++)
		tmp = tmp->next;

	return tmp->x;
}

/**
 * Return the element at the index specified between the square brackets
 *
 * @param index - the index of the element
 * @return element at position index
 */
myType LinkedList::operator[] (const unsigned index) const{

	assert (index <= this->length);
	Node *tmp = head;

	for (unsigned i = 0; i < index; i++)
		tmp = tmp->next;

	return tmp->x;
}

/**
 * Compare two list L1 and L2. Return true if and only if L1.length() == L2.length() and L1[i] == L2[i] for all i.
 *
 * @param obj - const reference to the list to compare
 * @return true if the list are identical
 */
bool LinkedList::operator==(const LinkedList& obj){

	if (!(this->length == obj.length))
		return false;
	Node *reader1 = this->head;
	Node *reader2 = obj.head;
	for (unsigned i = 0; i < this->length; i++) {
		if (reader1->x != reader2->x)
			return false;
		reader1 = reader1->next;
		reader2 = reader2->next;
	}
return true;
}

/**
 * Print the list. Check here:
 * http://stackoverflow.com/questions/236801/should-operator-be-implemented-as-a-friend-or-as-a-member-function
 *
 * @param ostream - the output stream to print to
 * @param rhs - the list to print
 * @return the reference to the output stream
 */
std::ostream& operator<<(std::ostream& ostream, const LinkedList &rhs){

	if (rhs.length == 0)
		return ostream << "List is Empty!";
	for (unsigned i = 0; i < rhs.length; i++) {
		ostream << rhs.get(i) << " ";
	}
	return ostream;
}

/**
 * Inserts the specified element in the list.
 *
 * @param element - element to be inserted
 * @return true if the operation succeed
 */
bool LinkedList::add(myType element){
	addLast(element);
	return true;
}

/**
 * Inserts the specified element at the specified position in this list.
 * Shifts the element currently at that position (if any) and any subsequent elements to the right
 * (adds one to their indices).
 *
 * @param index - index at which the specified element is to be inserted
 * @param element - element to be inserted
 */
void LinkedList::add(unsigned index, myType element){

	//makes sure the list is big enough to add a element
	assert(length >= index);
	//checks if it is being added to the begining or end of the list
	if (index == 0) {
		addFirst(element);
		return;
	}
	else if (index == tail->index) {
		addLast(element);
		return;
	}
	//creates the node that will be added to the list
	Node *newNode = new Node;
	Node *temp;
	newNode->x = element;
	newNode->index = index;
	temp = head;
	//finds node before location of insertion
	while (temp->index != index - 1) {
		temp = temp->next;
	}
	newNode->next = temp->next;
	temp->next = newNode;
	temp = newNode->next;
	//fixes indexes
	for (unsigned i = newNode->index; i < length; i++) {
		temp->index++;
		temp = temp->next;
	}
	length++;
}

/**
 * Inserts all of the elements in the specified collection.
 * The new elements will appear in the list in the order they are in the collection, i.e. collection[0],...,collection[N].
 *
 * @param collection - collection containing elements to be added to the list
 * @return true if the list changed as a result of the call
 */
bool LinkedList::addAll(const Collection& collection){

	myType* array = collection.toArray();
	for (unsigned i = 0; i < collection.size(); i++) {
		add(array[i]);
	}
	if (collection.size() > 0)
		return true;
	return false;
}

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
bool LinkedList::addAll(unsigned index, const Collection& collection){

	int i = collection.size() - 1;
	int* array = collection.toArray();
	for (; i >= 0; i--) {
		add(index,array[i]);
	}
	if (collection.size() > 0)
		return true;
	return false;
}

/**
 * Inserts the specified element at the beginning of the list.
 *
 * @param element - element to be inserted
 */
void LinkedList::addFirst(myType element){

	Node *newNode = new Node;
	Node *temp;
	newNode->x = element;
	newNode->index = 0;
	//if list is empty
	if (length == 0) {
		head = newNode;
		tail = newNode;
	}

	else {
		newNode->next = head;
		head = newNode;
		temp = newNode->next;
		for (unsigned i = 0; i < length; i++) {
			temp->index++;
			temp = temp->next;
		}
	}
	length++;
}

/**
 * Add an element at the end of the list (right append)
 *
 * @param element - element to be inserted
 */
void LinkedList::addLast(myType element){

	Node *newNode = new Node;
	newNode->x = element;
	if (length == 0) {
		newNode->index = 0;
		head = newNode;
		tail = newNode;
	}
	else {
		newNode->index = tail->index + 1;
		tail->next = newNode;
		tail = newNode;
	}
	length++;
}

/**
 * Removes all of the elements from the list. The list will be empty after this call returns.
 */
void LinkedList::clear(){

	while (this->size() != 0)
		this->remove(0);
}

/**
 * Returns true if this list contains the specified element at least once.
 *
 * @param element - element whose presence in this list is to be tested
 * @return true if this list contains the specified element
 */
bool LinkedList::contains(myType element) const{

	Node *reader = head;
	for (unsigned i = 0; i < length; i++) {
		if (reader->x == element)
			return true;
		reader = reader->next;
	}
	return false;
}

/**
 * Returns the element at the specified position in the list.
 *
 * @param index - index of the element to return
 * @return the element at the specified position in the list
 */
myType LinkedList::get(unsigned index) const{

	assert (length > index);
	myType thisWontHappen = -1;
	Node *reader = head;

	for (unsigned i = 0; i < length; i++) {
		if (reader->index == index)
			return reader->x;
		reader = reader->next;
	}
	//it was asserted that the index size exists within the list
	return thisWontHappen;
}

/**
 * Returns the first element in the list.
 *
 * @return the first element in the list
 */
myType LinkedList::getFirst() const{

	return head->x;
}

/**
 * Returns the Last element in the list.
 *
 * @return     the last element in the list
 */
myType LinkedList::getLast() const{

	return tail->x;
}

/**
 * Returns the index of the first occurrence of the specified element in the list,
 * or -1 if this list does not contain the element.
 *
 * @param elemt - element to search for
 * @return  the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
 */
int LinkedList::indexOf(myType element) const{

	Node * reader = head;
	for (unsigned i = 0; i < length; i++) {
		if (reader->x == element)
			return reader->index;
		reader = reader->next;
	}
	return -1;
}

/**
 * Print the list to stdout in a formatted way
 */
void LinkedList::print() const{

	if (length == 0) {
		cout << "List is Empty!" << endl;
		return;
	}
	Node *reader = head;
	cout << "List: ";
	for (unsigned i = 0; i < length; i++) {
		cout << reader->x << " ";
		reader = reader->next;
	}
	cout << endl;
}

/**
 * Retrieves and removes the head (first element) of the list.
 *
 * @return     the value in the head of the list
 */
myType LinkedList::removeFirst(){

	myType first = head->x;
	Node *tmp = head;
	head = head->next;
	delete tmp;
	Node *reader = head;
	length--;

	for (unsigned i = 0; i < length; i++) {
		reader->index--;
		reader = reader->next;
	}
	return first;
}

/**
 * Retrieves and removes the tail (first element) of the list.
 *
 * @return     the value in the tail of the list
 */
myType LinkedList::removeLast(){

	myType last = tail->x;
	Node *reader = head;
	for (unsigned i = 0; i < length; i++) {
		if (reader->next == tail)
			break;
		reader = reader->next;
	}
	delete reader->next;
	tail = reader;
	length--;
	return last;
}

/**
 * Removes the element at the specified position in this list.
 * Shifts any subsequent elements to the left (subtracts one from their indices).
 * Returns the element that was removed from the list.
 *
 * @param index - the index of the element to be removed
 * @return the element previously at the specified position
 */
myType LinkedList::remove(unsigned index){

	assert (length > index);
	myType elementDeleted;
	if (index == 0) {
		elementDeleted = head->x;
		removeFirst();
		return elementDeleted;
	}
	if (index == tail->index) {
		elementDeleted = tail->x;
		removeLast();
		return elementDeleted;
	}
	Node *reader = head;
	Node *tmp;
		for (unsigned i = 0; i < length; i++) {
			if (reader->next->index == index){
				elementDeleted = reader->next->x;
				tmp = reader->next;
				reader->next = reader->next->next;
				delete tmp;
				break;
			}
			reader = reader->next;
		}
		length--;
		reader = reader->next;
		for (unsigned i = reader->index; i < length; i++) {
			reader->index--;
			reader = reader->next;
		}
		return elementDeleted;
}

/**
 * Removes the first occurrence of the specified element in the list (when traversing the list from head to tail).
 * If the list does not contain the element, it is unchanged.
 *
 * @param element - element to be removed from this list, if present
 * @return true if this list contained the specified element
 */
bool LinkedList::removeFirstOccurence(myType element){

	Node *reader = head;
	for (unsigned i = 0; i < length; i++) {
		if (reader->x == element) {
			remove(reader->index);
			return true;
		}
		reader = reader->next;
	}
	return false;
}

/**
 * Removes the last occurrence of the specified element in the list (when traversing the list from head to tail).
 * If the list does not contain the element, it is unchanged.
 *
 * @param element - element to be removed from this list, if present
 * @return true if this list contained the specified element
 */
bool LinkedList::removeLastOccurence(myType element){

	Node *reader = head;
	bool numExists = false;
	unsigned indexOfLast = -1;
	for (unsigned i = 0; i < length; i++) {
		if (reader->x == element) {
			indexOfLast = reader->index;
			numExists = true;
		}
		reader = reader->next;
	}
	if (numExists) {
		remove(indexOfLast);
		return true;
	}
	return false;
}

/**
 * Replaces the element at the specified position in this list with the specified element.
 *
 * @param index - index of the element to replace
 * @param element - element to be stored at the specified position
 * @return the element previously at the specified position
 */
myType LinkedList::set(unsigned index, myType element){

	assert(length > index);
	myType oldElement;
	Node *reader = head;
	for (unsigned i = 0; i < length; i++) {
		if (reader->index == index) {
			oldElement = reader->x;
			reader->x = element;
		}
		reader = reader->next;
	}
	return oldElement;
}

/**
 * Returns the number of elements in this list.
 *
 * @return the number of elements in this list
 */
unsigned LinkedList::size() const{
	return length;
}

/**
 * Returns an array containing all of the elements in this list in proper sequence (from first to last element).
 *
 * @return an array containing the elements of the list in proper sequence
 */
myType* LinkedList::toArray() const{

	myType *array = new myType[length];
	Node *reader = head;
	for (unsigned i = 0; i < length; i++) {
		array[i] = reader->x;
		reader = reader->next;
	}
	return array;
}

