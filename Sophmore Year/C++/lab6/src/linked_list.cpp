/*
PROGRAM: linked_list.CPP
Written by Austin Haggard
This program implements a singly linked list
Last modification: 1MARCH2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "dummy_header.h"
/******************************************/
/** You might need to add some headers here **/
#include <iostream>
#include <cassert>
using namespace std;

void add(List* L, unsigned index, myType element){
	//makes sure the list is big enough to add a element
	assert(L->length > index);
	//checks if it is being added to the begining or end of the list
	if (index == 0) {
		addFirst(L,element);
		return;
	}
	if (index == L->tail->index) {
		addLast(L,element);
		return;
	}
	//creates the node that will be added to the list
	Node *newNode = new Node;
	Node *temp = new Node;
	newNode->x = element;
	newNode->index = index;
	temp = L->head;
	//finds node before location of insertion
	while (temp->index != index - 1) {
		temp = temp->next;
	}
	newNode->next = temp->next;
	temp->next = newNode;
	temp = newNode->next;
	//fixes indexes
	for (unsigned i = newNode->index; i < L->length; i++) {
		temp->index++;
		temp = temp->next;
	}
	L->length++;
}

bool addAll(List* L, unsigned index, const myType* collection, unsigned N){
	for (int i = N - 1; i >= 0; i--) {
		add(L,index,collection[i]);
	}
	if (N > 0)
		return true;
	return false;
}

void addFirst(List* L, myType element){
	Node *newNode = new Node;
	Node *temp = new Node;
	newNode->x = element;
	newNode->index = 0;
	//if list is empty
	if (L->length == 0) {
		L->head = newNode;
		L->tail = newNode;
	}

	else {
		newNode->next = L->head;
		L->head = newNode;
		temp = newNode->next;
		for (unsigned i = 0; i < L->length; i++) {
			temp->index++;
			temp = temp->next;
		}
	}
	L->length++;
}

void addLast(List* L, myType element){
	Node *newNode = new Node;
	newNode->x = element;
	if (L->length == 0) {
		newNode->index = 0;
		L->head = newNode;
		L->tail = newNode;
	}
	else {
		newNode->index = L->tail->index + 1;
		L->tail->next = newNode;
		L->tail = newNode;
	}
	L->length++;
}

void clear(List* L){
	L->head->next = 0;
	L->head = 0;
	L->tail = 0;
	L->length = 0;
}

bool contains(const List* L, myType element){
	Node *reader = new Node;
	reader = L->head;
	for (unsigned i = 0; i < L->length; i++) {
		if (reader->x == element)
			return true;
		reader = reader->next;
	}
	return false;
}

myType get(const List* L, unsigned index){
	assert (L->length > index);
	myType thisWontHappen = -1;
	Node *reader = new Node;
	reader = L->head;

	for (unsigned i = 0; i < L->length; i++) {
		if (reader->index == index)
			return reader->x;
		reader = reader->next;
	}
	//it was asserted that the index size exists within the list
	return thisWontHappen;
}

myType getFirst(const List* L){
	return L->head->x;
}

myType getLast(const List* L){
	return L->tail->x;
}

int indexOf(const List* L, myType element){
	Node * reader = new Node;
	reader = L->head;
	for (unsigned i = 0; i < L->length; i++) {
		if (reader->x == element)
			return reader->index;
		reader = reader->next;
	}
	return -1;
}

void print(const List* L){
	if (L->length == 0) {
		cout << "List is Empty!" << endl;
		return;
	}
	Node *reader = new Node;
	reader = L->head;
	cout << "List: ";
	for (unsigned i = 0; i < L->length; i++) {
		cout << reader->x << " ";
		reader = reader->next;
	}
	cout << endl;
}

myType removeFirst(List* L){
	myType head = L->head->x;
	Node *reader = new Node;
	L->head = L->head->next;
	reader = L->head;
	L->length--;

	for (unsigned i = 0; i < L->length; i++) {
		reader->index--;
		reader = reader->next;
	}
	return head;
}

myType removeLast(List* L){
	myType tail = L->tail->x;
	Node *reader = new Node;
	reader = L->head;
	for (unsigned i = 0; i < L->length; i++) {
		if (reader->next == L->tail)
			break;
		reader = reader->next;
	}
	reader->next = 0;
	L->tail = reader;
	L->length--;
	return tail;
}

myType remove(List* L, unsigned index){
	assert (L->length > index);
	myType elementDeleted;
	if (index == 0) {
		elementDeleted = L->head->x;
		removeFirst(L);
		return elementDeleted;
	}
	if (index == L->tail->index) {
		elementDeleted = L->tail->x;
		removeLast(L);
		return elementDeleted;
	}
	Node *reader = new Node;
		reader = L->head;
		for (unsigned i = 0; i < L->length; i++) {
			if (reader->next->index == index){
				elementDeleted = reader->next->x;
				reader->next = reader->next->next;
				break;
			}
			reader = reader->next;
		}
		L->length--;
		reader = reader->next;
		for (unsigned i = reader->index; i < L->length; i++) {
			reader->index--;
			reader = reader->next;
		}
		return elementDeleted;
}

bool removeFirstOccurence(List* L, myType element){
	Node *reader = new Node;
	reader = L->head;
	for (unsigned i = 0; i < L->length; i++) {
		if (reader->x == element) {
			remove(L,reader->index);
			return true;
		}
		reader = reader->next;
	}
	return false;
}

bool removeLastOccurence(List* L, myType element){
	Node *reader = new Node;
	reader = L->head;
	bool numExists = false;
	unsigned indexOfLast = -1;
	for (unsigned i = 0; i < L->length; i++) {
		if (reader->x == element) {
			indexOfLast = reader->index;
			numExists = true;
		}
		reader = reader->next;
	}
	if (numExists) {
		remove(L,indexOfLast);
		return true;
	}
	return false;

}

myType set(List* L, unsigned index, myType element){
	assert(L->length > index);
	myType oldElement;
	Node *reader = new Node;
	reader = L->head;
	for (unsigned i = 0; i < L->length; i++) {
		if (reader->index == index) {
			oldElement = reader->x;
			reader->x = element;
		}
		reader = reader->next;
	}
	return oldElement;
}

unsigned size(List* L){
	return L->length;
}

myType* toArray(const List* L){
	myType *array = new myType[L->length];
	Node *reader = new Node;
	reader = L->head;
	for (unsigned i = 0; i < L->length; i++) {
		array[i] = reader->x;
		reader = reader->next;
	}
	return array;
}

int main()
{
    
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    // create a new list
    List* L = new List;
    
    // add elements to list
    addFirst(L, 15);
    addFirst(L, 6);
    addFirst(L, 1);
    addLast(L, 15);
    addLast(L, 6);
    addLast(L, 1);
    add(L, 3, 20);
    
    // Expected output: 1  6   15  20  15  6   1
    print(L);
    // Expected output: 7
    std::cout << L->length << std::endl;
    
    // Expected output: true
    std::cout << contains(L, 20) << std::endl;
    //Expected output: 3
    std::cout << indexOf(L, 20) << std::endl;
    
    // mess up the list
    removeFirst(L);
    removeLast(L);
    remove(L, static_cast<unsigned>(1));
    removeFirstOccurence(L, static_cast<myType>(6));
    
    // Expected output: 20  15  6
    myType* array = toArray(L);
    for (unsigned i = 0; i < L->length; i++)
        std::cout << static_cast<int>(array[i]) << "\t";
    std::cout << "\n";
    
    // Expected output: 20
    std::cout << getFirst(L) << std::endl;
    // Expected output: 6
    std::cout << getLast(L) << std::endl;
    // Expected output: 15
    std::cout << get(L, 1) << std::endl;
    
    myType collection[3] = {1, 6, 15};
    addAll(L, 0, collection, 3);
    // Expected output: 1  6   15  20  15  6
    print(L);
    
    removeLastOccurence(L, 15);
    // Expected output: 1 6 15 20 6
    print(L);
    
    // Expected output: 1
    std::cout << set(L, 0, 0) << std::endl;
    // Expected output: 0
    std::cout << getFirst(L) << std::endl;
    // Expected output: 5
    std::cout << size(L) << std::endl;
    
    // empty the list
    clear(L);
    // Expected output: "List is Empty!" <-- or something like that
    print(L);
    
    // If you reach here and expected outputs matches, you will be likely ok.
    // You can go party and have a nice spring break, you deserve it!
    return 0;
}
