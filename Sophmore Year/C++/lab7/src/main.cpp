/*
PROGRAM: main.CPP
Written by Austin Haggard
This program implements a linkedl ist using a class
Last modification: March 19 2015
*/

/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "linked_list.h"
/******************************************/
/** You might need to add some headers here **/
#include <iostream>


int main()
{
    /**                       DO NOT MODIFY UNDER THIS LINE
     * ***************************************************************************************/
    // create a new list
    LinkedList L;
    
    // add elements to list
    L.addFirst(15);
    L.addFirst(6);
    L.addFirst(1);
    L.addLast(15);
    L.addLast(6);
    L.addLast(1);
    L.add(3, 20);
    
    // Expected output: 1  6   15  20  15  6   1
    L.print();
    // Expected output: 7
    std::cout << L.size() << std::endl;
    
    // Expected output: true
    std::cout << L.contains(20) << std::endl;
    //Expected output: 3
    std::cout << L.indexOf(20) << std::endl;
    
    // mess up the list
    L.removeFirst();
    L.removeLast();
    L.remove(1);
    L.removeFirstOccurence(static_cast<myType>(6));
    
    // Expected output: 20  15  6
    myType* array = L.toArray();
    for (unsigned i = 0; i < L.size(); i++)
        std::cout << static_cast<int>(array[i]) << "\t";
    std::cout << "\n";
    
    // Expected output: 20
    std::cout << L.getFirst() << std::endl;
    // Expected output: 6
    std::cout << L.getLast() << std::endl;
    // Expected output: 15
    std::cout << L.get(1) << std::endl;
    
    myType collection[3] = {1, 6, 15};
    LinkedList L2(collection, 3);
    std::cout << "L2\n";
    // Expected output: 1  6  15
    L2.print();
    std::cout << "L\n";
    L.addAll(0, collection, 3);
    // Expected output: 1  6   15  20  15  6
    L.print();
    
    L.removeLastOccurence(15);
    // Expected output: 1 6 15 20 6
    L.print();
    
    // Expected output: 1
    std::cout << L.set(0, 0) << std::endl;
    // Expected output: 0
    std::cout << L.getFirst() << std::endl;
    // Expected output: 5
    std::cout << L.size() << std::endl;
    
    // empty the list
    L.clear();
    // Expected output: "List is Empty!" <-- or something like that
    L.print();
    
    // Hopefully you had a great spring break. This assignment is easy
    // to let you recover from any hangover
    return 0;
}
