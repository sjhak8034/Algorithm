#include <iostream>

using namespace std;

int n;
int dp[1001];

int main() {
    cin >> n;
    dp[0] = 1;
    int nums[3] = {1,2,5};
    for(int i =1; i <= n; i++){
        for(int j = 0; j < 3; j++){
            if(nums[j] > i){
                continue;
            }
            dp[i] += dp[i-nums[j]];
            dp[i] %= 10007;
            
        }
    }

    cout << dp[n];

    return 0;
}
