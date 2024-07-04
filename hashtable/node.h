#ifndef NODE_H
#define NODE_H

#include "globals.h"

class node {
    public:
        // data members
        int data;
        node* next;
        node* prev;

        // constructor and destructor
        node(int x);
        ~node();
        
        // member functions
        void print();
};

#endif // NODE_H