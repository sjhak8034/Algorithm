#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int n;
int arr[100];



int main() {
    cin >> n;
    int sum = 0;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        sum += arr[i];
    }
   
    vector<int> dp(sum+1,-1);
    dp[0] = 0;

    for(int i= 0; i < n; i++){
        vector<int> nd = dp;
        int a = arr[i];
        for(int d = 0; d <= sum; d++){
            if (dp[d] < 0) continue;
            if (d + a <= sum) nd[d + a] = max(nd[d + a], dp[d]);                    // 큰 쪽에
            nd[abs(d - a)] = max(nd[abs(d - a)], dp[d] + min(d, a));               // 작은 쪽에
        }
        dp = nd;
    }

    cout << dp[0];

  

    
    

    return 0;
}
