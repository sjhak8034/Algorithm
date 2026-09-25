#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int n;
int profit[100];
int dp[101];

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> profit[i];
    }
    for(int i = 0; i <= n; i++){
        dp[i] = -1;
    }
    dp[0] = 0;

    for(int i = 0; i <n; i++){
        int length = i+1;
        int value = profit[i];
        for(int j = 1; j <= n; j++){
            if(length > j || dp[j-length] == -1){
                continue;
            }
            dp[j] = max(dp[j],dp[j-length] + value);
        }
    }

    cout<<dp[n];
    

    return 0;
}
