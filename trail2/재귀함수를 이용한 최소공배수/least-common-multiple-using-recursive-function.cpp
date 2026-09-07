#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int n;
int arr[10];

long long gcd_(long long a, long long b) {
    return b ? gcd_(b, a % b) : a;
}

long long lcm_(long long a, long long b) {
    return a / gcd_(a, b) * b;
}

void lcm_all(int* arr, int n, int idx, int* result){
    if (n == idx){
        return;
    }
    *result = lcm_(*result,arr[idx]);
    lcm_all(arr,n,idx + 1, result);
    return;
}

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int result = 1;
    lcm_all(arr,n,0,&result);
    cout<< result;

    return 0;
}