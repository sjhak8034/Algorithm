#include <iostream>

using namespace std;

int n, m;
int e[100], t[100];
int dp[10001];
int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> e[i] >> t[i];
    }
    for(int i = 1; i <=10000;i++){
        dp[i] = -1;
    }
    for(int i = 0; i < n; i++){
        for(int j = 10000; j >=0; j--){
            if(t[i] > j || dp[j-t[i]] == -1){
                continue;
            }
            dp[j] = max(dp[j],dp[j-t[i]] + e[i]);
        }
    }

    

    for(int i = 0; i <= 10000; i++){
        if(dp[i] >= m){
            cout << i;
            return 0;
        }
    }

    cout << -1;

    

    return 0;
}
