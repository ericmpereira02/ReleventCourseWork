/*
PROGRAM: linked_list.CPP
Written by Austin Haggard
This program implements a singly linked list
Last modification: 1MARCH2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "linked_list.h"
/******************************************/
/** You might need to add some headerss here **/
#include <iostream>
#include <cassert>
using namespace std;

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
	Node *temp = new Node;
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

bool LinkedList::addAll(unsigned index, const myType* collection, unsigned N){
	for (int i = N - 1; i >= 0; i--) {
		add(index,collection[i]);
	}
	if (N > 0)
		return true;
	return false;
}

void LinkedList::addFirst(myType element){
	Node *newNode = new Node;
	Node *temp = new Node;
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

void LinkedList::clear(){
	head->next = 0;
	head = 0;
	tail = 0;
	length = 0;
}

bool LinkedList::contains(myType element) const{
	Node *reader = new Node;
	reader = head;
	for (unsigned i = 0; i < length; i++) {
		if (reader->x == element)
			return true;
		reader = reader->next;
	}
	return false;
}

myType LinkedList::get(unsigned index) const{
	assert (length > index);
	myType thisWontHappen = -1;
	Node *reader = new Node;
	reader = head;

	for (unsigned i = 0; i < length; i++) {
		if (reader->index == index)
			return reader->x;
		reader = reader->next;
	}
	//it was asserted that the index size exists within the list
	return thisWontHappen;
}

myType LinkedList::getFirst() const{
	return head->x;
}

myType LinkedList::getLast() const{
	return tail->x;
}

int LinkedList::indexOf(myType element) const{
	Node * reader = new Node;
	reader = head;
	for (unsigned i = 0; i < length; i++) {
		if (reader->x == element)
			return reader->index;
		reader = reader->next;
	}
	return -1;
}

void LinkedList::print() const{
	if (length == 0) {
		cout << "List is Empty!" << endl;
		return;
	}
	Node *reader = new Node;
	reader = head;
	cout << "List: ";
	for (unsigned i = 0; i < length; i++) {
		cout << reader->x << " ";
		reader = reader->next;
	}
	cout << endl;
}

myType LinkedList::removeFirst(){
	myType first = head->x;
	Node *reader = new Node;
	Node *tmp = head;
	head = head->next;
	delete tmp;
	reader = head;
	length--;

	for (unsigned i = 0; i < length; i++) {
		reader->index--;
		reader = reader->next;
	}
	return first;
}

myType LinkedList::removeLast(){
	myType last = tail->x;
	Node *reader = new Node;
	reader = head;
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
	Node *reader = new Node;
	reader = head;
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

bool LinkedList::removeFirstOccurence(myType element){
	Node *reader = new Node;
	reader = head;
	for (unsigned i = 0; i < length; i++) {
		if (reader->x == element) {
			remove(reader->index);
			return true;
		}
		reader = reader->next;
	}
	return false;
}

bool LinkedList::removeLastOccurence(myType element){
	Node *reader = new Node;
	reader = head;
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

myType LinkedList::set(unsigned index, myType element){
	assert(length > index);
	myType oldElement;
	Node *reader = new Node;
	reader = head;
	for (unsigned i = 0; i < length; i++) {
		if (reader->index == index) {
			oldElement = reader->x;
			reader->x = element;
		}
		reader = reader->next;
	}
	return oldElement;
}

unsigned LinkedList::size() const{
	return length;
}

myType* LinkedList::toArray() const{
	myType *array = new myType[length];
	Node *reader = new Node;
	reader = head;
	for (unsigned i = 0; i < length; i++) {
		array[i] = reader->x;
		reader = reader->next;
	}
	return array;
}

LinkedList::LinkedList() {
	head = NULL;
	tail = NULL;
	length = 0;
}

LinkedList::LinkedList(const myType* collection, unsigned N) {
	head = NULL;
	tail = NULL;
	length = 0;
	addAll(0,collection,N);
}

LinkedList::~LinkedList() {
Node *reader = head;
Node *tmp;
while (reader != 0) {
	tmp  = reader->next;
	delete reader;
	reader = tmp;
}
head = 0;
}
