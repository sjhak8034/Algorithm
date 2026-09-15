#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int n, m;
int A[20];

void xor_all(int depth, int idx, int* result, int sum){
    if (depth == m){
        (*result) = max(*result, sum);
        return;
    }
    for(int i = idx; i < n; i++){
        xor_all(depth+1,i+1,result,sum ^ A[i]);
    }
}

int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> A[i];
    }
    int result = 0;
    xor_all(0,0,&result,0);
    cout<<result;

    return 0;
}