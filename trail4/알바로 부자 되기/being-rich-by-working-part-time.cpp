#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int N;
int s[1000], e[1000], p[1000];
int dp[1000];
int main() {
    cin >> N;
    int end_time = 0;
    for (int i = 0; i < N; i++) {
        cin >> s[i] >> e[i] >> p[i];
    }
    for(int i = 0; i < N; i++){
        dp[i] = p[i];
    }
    int ans = 0;
    for(int i = 0; i < N; i++){
        for(int j = 0; j < i; j++){
            if(e[j] >= s[i]){
                continue;
            }
            else{
                dp[i] = max(dp[i],dp[j] + p[i]);
            }
        }
        ans = max(dp[i],ans);
    }

    cout << ans;

    return 0;
}
