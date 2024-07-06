#ifndef HASHTABLE_H
#define HASHTABLE_H

#include "globals.h"
#include "linkedList.h"

class hashtable {

private:
    linkedList buckets[SIZE];

    int hash(int x);

public:
    hashtable();
    ~hashtable();

    int add(int x);
    int find(int x);
    int remove(int x);
    void print();

};

#endif // HASHTABLE_H