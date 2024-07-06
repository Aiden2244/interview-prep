#include "linkedList.h"

linkedList::linkedList() {
    head = nullptr;
    tail = nullptr;
    length = 0;
}

linkedList::~linkedList() {
    node* temp = this->head;
    while (temp != nullptr) {
        node* before = temp;
        temp = temp->next;
        delete before;
    }
}

int linkedList::add(int x) {
    node* addMe = new node(x);

    if (this->tail == nullptr) {
        this->tail = addMe;
        this->head = addMe;
        length++;
        return 0;
    }

    tail->next = addMe; // the tail NODE's next pointer now points to addMe
    addMe->prev = tail; // the prev pointer of addMe now  
    tail = addMe; // the tail POINTER now is equal to addMe, which is the last node. This should 100% work

    length++;

    return length;
}

int linkedList::indexOf(int x) {
    node* findMe = this->head;
    int i = 0;

    while (findMe != nullptr) {
        if (findMe->data == x) { 
            return i;
        }
        findMe = findMe->next;
        i++;
    }
    return -1; 
}

int linkedList::remove(int x) {
    
    // let's be optimistic and subtract one from the length upfront
    length--;

    // special case if removing the head or tail
    if( head->data == x) {
        node* temp = head;
        int returnMe = head->data;
        head = head->next;
        delete temp;
        
        return returnMe;
    }

    else if( tail->data == x) {
        node* temp = tail;
        int returnMe = tail->data;
        tail = tail->prev;
        tail->next = nullptr;
        delete temp;
        
        return returnMe;
    }
    
    node* deleteMe = this->head;

    while (deleteMe != nullptr) {
        if (deleteMe->data == x) { 

            node* before = deleteMe->prev;
            node* after = deleteMe->next;
            int returnMe = deleteMe->data;

            before->next = after;
            after->prev = before;

            delete deleteMe;

            return returnMe; 
        }
        deleteMe = deleteMe->next;
    }
    length++; // we did not find anything, so let's re-increment the length
    return -1; 
}

void linkedList::printDetailed() {
    cout << "LENGTH = " << this->getLength()
        << ", HEAD = " << this->getHead()
        << ", TAIL = " << this->getTail()
        << endl;

    int i = 0;
    node* temp = head;

    while (temp != nullptr) {
        if (i % 8 != 0) {
            cout << " -> ";
        }

        if ((i > 0) && (i % 8 == 0)) {
            cout << endl;
        }

        cout << temp->data;
        temp = temp->next;
        i++;
    }
    cout << endl;
}

void linkedList::print() {
    node* temp = head;
    cout << "[";

    while (temp != nullptr) {
        if (temp != head) {
            cout << ", ";
        }

        cout << temp->data;
        temp = temp->next;
    }
    cout << "]" << endl;
}

int linkedList::getHead() {
    if (head != nullptr) return head->data;
    else return -1;
};

int linkedList::getTail() {
    if (tail != nullptr) return tail->data;
    else return -1;
};

int linkedList::getLength() { return length; }
