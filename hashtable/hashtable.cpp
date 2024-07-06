#include "hashtable.h"

// constructor
hashtable::hashtable () {
    for (int i = 0; i < SIZE; i++) {
        buckets[i] = linkedList();
    }
}

// destructor
hashtable::~hashtable() {}

// the actual hash compression function
int hashtable::hash(int x) {
    return (x * LARGE_PRIME) % SIZE;
}

// print the table
void hashtable::print() {
    for (int i = 0; i < SIZE; i++) {
        cout << "Bucket " << i << ": "; buckets[i].print(); cout << endl;
    }
}

// add an element
int hashtable::add(int x) {
    buckets[hash(x)].add(x);
    return hash(x);
}

// loctate an element
int hashtable::find(int x) {
    return buckets[hash(x)].indexOf(x);
}

// remove an element
int hashtable::remove(int x) {
    if (find(x) == -1) { return -1; }
    return buckets[hash(x)].remove(x);
}
