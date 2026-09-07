#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int n;
int A[100];

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> A[i];
    }
    int answer = 100000000;
    for (int i = 0; i < n; i++){
        int sum = 0;
        for (int j = 0; j < n; j++){
           sum += abs(i - j) * A[j];
        }
        answer = min(answer,sum);

    }
    cout << answer;
    return 0;
}