#ifndef LINKED_LIST_H
#define LINKED_LIST_H

#include "globals.h"
#include "node.h"

class linkedList {
private:
    node* head;
    node* tail;
    unsigned int length;

public:
    linkedList();
    ~linkedList();

    int add(int x);
    int indexOf(int x);
    int remove(int x);
    void print();

    int getHead();
    int getTail();
    int getLength();
};

#endif // LINKED_LIST_H