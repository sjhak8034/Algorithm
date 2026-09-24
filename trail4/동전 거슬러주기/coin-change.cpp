#include <iostream>

using namespace std;

int N, M;
int coin[100];
int dp[10001];
int MAX_VALUE = 100000000;
int main() {
    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        cin >> coin[i];
    }
    for(int i = 1; i < 10001; i++){
        dp[i] = MAX_VALUE;
    }
    for (int i = 1; i <= M; i++){
        for(int j = 0; j < N; j++){
            if(coin[j] > i){
                continue;
            }
            dp[i] = min(dp[i-coin[j]] + 1,dp[i]); 
        }
    }
    if(dp[M] == MAX_VALUE){
        cout << -1;
        return 0;
    }
    cout << dp[M];
    return 0;
}
