#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int n;
int x[200000];
priority_queue<int> pq;

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> x[i];
    }

    for(int i = 0; i < n; i++){
        if(x[i] == 0){
            if(pq.empty()){
                cout << 0;
            } else{
                cout<<-pq.top();
                pq.pop();
            }
            cout << "\n";
            
        }else{
            pq.push(-x[i]);
        }
    }

    return 0;
}
