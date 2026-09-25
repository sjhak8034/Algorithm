#include <iostream>

using namespace std;

int n, m;
int A[100];
int dp[10001];
int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> A[i];
    }
    dp[0] = 1;
    for(int i = 0; i <= n-1; i++){
        for(int j = m; j >=0; j-- ){
            if(A[i] > j){
                continue;
            }
            dp[j] = max(dp[j],dp[j-A[i]]);
        }
    }

    if(dp[m] == 1){
        cout<< "Yes";
    } else{
        cout<< "No";
    }

    return 0;
}
