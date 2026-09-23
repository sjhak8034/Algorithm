#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int N;
int dp[46];

int fibonachi(int idx){
    
    if(dp[idx] != 0){
        return dp[idx];
    }

    dp[idx] = fibonachi(idx-1) + fibonachi(idx-2);
    

    return dp[idx];
}

int main() {
    cin >> N;
    
    dp[1] = 1;
    dp[2] = 1;

    int ans = fibonachi(N);

    cout << ans;

    return 0;
}
