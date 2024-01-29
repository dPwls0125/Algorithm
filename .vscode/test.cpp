#include <stdio.h>
#include <iostream>
#include <algorithm>
#include <typeinfo>
using namespace std;

int main(void)
{
    auto a = 10;
    int b = 1;
    double c = 0.1;
    cout << typeid(a).name() << "\n";
    cout << typeid(b).name() << "\n";
    cout << typeid(c).name();
}