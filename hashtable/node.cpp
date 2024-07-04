#include "node.h"

node::node(int x) {
    data = x;
    next = nullptr;
    prev = nullptr;
}

node::~node() {}

void node::print() {
    cout << "NODE ADDRESS: " << this << endl;
    cout << "Node data: " << this->data << endl;
    cout << "Node next ptr: " << this->next << endl;  
    cout << "Node prev ptr: " << this->prev << endl;
}