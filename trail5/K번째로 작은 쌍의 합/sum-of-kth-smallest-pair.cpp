#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int n, m, k;
int arr1[100000];
int arr2[100000];
priority_queue<int> pq1;
priority_queue<int> pq2;

int main() {
    cin >> n >> m >> k;

    for (int i = 0; i < n; i++) {
        cin >> arr1[i];
    }

    for (int i = 0; i < m; i++) {
        cin >> arr2[i];
    }

    for(int i = 0; i < n; i++){
        if(pq2.size() == k){
            if(arr1[i] > pq2.top()){
                continue;
            }
        }
        for(int j = 0; j < m; j++){
            if(pq2.size() == k){
                if(arr2[j] > pq2.top()){
                    continue;
                }
                if(arr1[i]+arr2[j] > pq2.top()){
                    continue;
                }
                pq2.pop();
                pq2.push(arr1[i]+arr2[j]);
                
            } else{
                pq2.push(arr1[i]+arr2[j]);
            }
            
            
        } 
    }

    for(int i = 0; i < k; i++){
        pq1.push(-pq2.top());
    }

    for(int i = 0; i < k-1; i++){
        pq1.pop();
    }

    cout << -pq1.top();

    

    return 0;
}
