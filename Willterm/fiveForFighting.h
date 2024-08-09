#include <iostream>
#include <string>
using namespace std; 

template <typename T>
void fiveForFighting(T value) {
    cout << "If I'm given " 
    << value
    << ", then it's five times the fun to get ";

    T fiveTimesValue = value;
    for (int i = 0; i < 4; i++) {
        fiveTimesValue += value;
    }
    cout << fiveTimesValue << endl;
}

