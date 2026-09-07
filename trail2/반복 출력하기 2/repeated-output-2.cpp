#include <bits/stdc++.h>
using namespace std;

int N;

int printRepeat(int N, int count){
    if (N == count){
        return 0;
    }
    cout<< "HelloWorld";
    cout<< "\n";
    count +=1;
    printRepeat(N,count);
    return 0;
}

int main() {
    cin >> N;

    printRepeat(N,0);
    

    return 0;
}