#include "node.h"
#include "linkedList.h"
#include "globals.h"


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


int main() {

    try {
        // nodeTest();
        linkedListTest();

        return 0;
    }
    catch (exception &e){
        cout << e.what() << endl;
    }

    
}

