#include <iostream>

using namespace std;

int n, m;
int A[100];
int dp[10001];
int MAX_VALUE = 1000000;
int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> A[i];
    }
    for(int i = 1; i <=m; i++){
        dp[i] = MAX_VALUE;
    }
    dp[0] = 0;
    for(int i = 0; i < n; i++){
        for(int j = m; j >= 0; j--){
            if(j >= A[i]){
                if(dp[j-A[i]] == MAX_VALUE){
                    continue;
                }
                dp[j] = min(dp[j], dp[j-A[i]] + 1);
            }
        }
    }

    if(dp[m] == MAX_VALUE){
        cout << -1;
        return 0;
    }

    cout << dp[m];

    return 0;
}
