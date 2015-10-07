/** DO NOT REMOVE THIS INCLUDE STATEMENT **/
#include "linked_list.h"
#include "queue.h"
#include "stack.h"
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
    
    // Expected output: 1  6   15  20  15  6
    Stack S(L);
    S.push(15);
    S.push(6);
    S.push(1);
    std::cout << "S\n";
    std::cout << S << "\n";
    
    // Expected output: 1  6  15  20  15  6
    Queue Q(S, 7);
    std::cout << "Q\n";
    std::cout << Q << "\n";
    
    // Expected output: 1  6
    std::cout << S.pop() << " ";
    std::cout << S.pop() << "\n";
    // Expected output: 4
    std::cout << S.search(6) << "\n";
    // Expected output: true
    S.clear();
    std::cout << "S is empty: " << S << "\n";
    
    // Expected output: 1  6  15  20  15  6
    Queue Q2;
    Q2 = Q;
    Q.clear();
    std::cout << Q2 << "\n";
    
    // Expected output: 1  1  6  15  20  20  15  6
    std::cout << Q2.peek() << " ";
    std::cout << Q2.poll() << " ";
    std::cout << Q2.poll() << " ";
    std::cout << Q2.poll() << " ";
    std::cout << Q2.element() << " ";
    std::cout << Q2 << "\n";
    
    // Expected output: 99 20  15  6 or 20  15  6 99
    LinkedList L2 = L;
    L2.add(99);
    std::cout << "L2\n";
    std::cout<< L2 << "\n";
    // Expected output: false
    bool same = L == L2;
    std::cout << "L == L2 : " << same << "\n";
    
    // Expected output: 20  15  6  99 20  15  6 or 20  15  6  20  15  6  99
    LinkedList L3 = L + L2;
    std::cout << "L3\n";
    std::cout << L3 << "\n";
    
    // Expected output: 20  6  20
    L3[4] = 20;
    std::cout << L3[0] << " ";
    std::cout << L3[2] << " ";
    std::cout << L3[4] << "\n";
    
    // empty the list
    L.clear();
    // Expected output: "List is Empty!" <-- or something like that
    std::cout << "L\n";
    std::cout << L << "\n";
    // Expected output: 99 20  15  6 or 20  15  6 99
    std::cout << "L2\n";
    std::cout << L2 << "\n";
    // Expected output: 20  15  6  99 20  15  6 or 20  15  6  20  20  6  99
    std::cout << "L3\n";
    std::cout << L3 << "\n";
    
    return 0;
}
