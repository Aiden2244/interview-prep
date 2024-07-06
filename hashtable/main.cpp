#include "node.h"
#include "linkedList.h"
#include "hashtable.h"


void nodeTest() {
    node *n = new node(5);
    cout << "Made node" << endl;

    n->print();

    delete n;
    cout << "Deleted node" << endl;

    n->print(); 
}

void linkedListTest() {
    linkedList *l = new linkedList();
    for (int i = 0; i < 16; i++) {
        l->add(i);
    }

    l->print();

    cout << endl;

    cout << " Looking for int: " << 11 << ", located at index " << l->indexOf(11) << ", now attempting to remove: " << l->remove(11) << endl;
    cout << " Looking for int: " << 4 << ", located at index " << l->indexOf(4) << ", now attempting to remove: " << l->remove(4) << endl;
    cout << " Looking for int: " << 17 << ", located at index " << l->indexOf(17) << ", now attempting to remove: " << l->remove(17) << endl;
    cout << " Looking for int: " << 0 << ", located at index " << l->indexOf(0) << ", now attempting to remove: " << l->remove(0) << endl;
    cout << " Looking for int: " << 16 << ", located at index " << l->indexOf(16) << ", now attempting to remove: " << l->remove(16) << endl;
    cout << " Looking for int: " << 15 << ", located at index " << l->indexOf(15) << ", now attempting to remove: " << l->remove(15) << endl;
    cout << " Looking for int: " << 9 << ", located at index " << l->indexOf(9) << ", now attempting to remove: " << l->remove(9) << endl;
    cout << " Looking for int: " << 4 << ", located at index " << l->indexOf(4) << ", now attempting to remove: " << l->remove(4) << endl;


    cout << endl;

    l->print();

    delete l;

}

void hashtableTest() {
    hashtable ht = hashtable();
    cout << "TESTING ADD" << endl;
    for (int i = 0; i < SIZE + SIZE; i++) {
        cout << "Element " << i << " hashed to index " << ht.add(i) << endl;
    }
    
    cout << endl << "TESTING FIND" << endl;
    cout << "Attempting to locate element " << 32 << ": " << ht.find(32) << endl;
    cout << "Attempting to locate element " << -11 << ": " << ht.find(-11) << endl;
    cout << "Attempting to locate element " << 200 << ": " << ht.find(200) << endl;

    cout << endl << "TESTING REMOVE" << endl;
    cout << "Attempting to remove element " << 32 << ": " << ht.remove(32) << endl;
    cout << "Attempting to remove element " << -11 << ": " << ht.remove(-11) << endl;
    cout << "Attempting to remove element " << 200 << ": " << ht.remove(200) << endl;
    cout << "Attempting to remove element " << 99 << ": " << ht.remove(99) << endl;
    cout << "Attempting to remove element " << 200 << ": " << ht.remove(200) << endl;


    cout << endl << "TESTING PRINT" << endl;
    ht.print();
}


int main() {

    try {
        // nodeTest();
        // linkedListTest();
        hashtableTest();

        return 0;
    }
    catch (exception &e){
        cout << e.what() << endl;
    }

    
}

