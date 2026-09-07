#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int N;
string command[10000];
int num[10000];

int main() {
    cin >> N;
    vector<int> a;
    for (int i = 0; i < N; i++) {
        cin >> command[i];
        
        if (command[i] == "push_back" || command[i] == "get") {
            cin >> num[i];
            if (command[i] == "push_back"){
                a.push_back(num[i]);
            } else{
                cout<<a[num[i]-1]<<"\n";
            }
        } else if(command[i] == "pop_back"){
            a.pop_back();
        }else{
            cout<<a.size()<<"\n";
        }
    }

    // Please write your code here.

    return 0;
}
