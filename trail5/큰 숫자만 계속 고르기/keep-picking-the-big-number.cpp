#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[100000];
priority_queue<int> pq;

int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        pq.push(arr[i]);

    }

    for(int i = 0; i < m; i++){
        int num = pq.top();
        pq.pop();
        pq.push(num-1);
    }

    cout << pq.top();

    
    return 0;
}
