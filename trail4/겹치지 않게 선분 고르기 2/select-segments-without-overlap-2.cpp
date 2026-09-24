#include <iostream>

using namespace std;

int n;
int x1[1000];
int x2[1000];

pair<int,int> line[1001];

int dp[1001];

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> x1[i] >> x2[i];
        if(line[x2[i]].second != x2[i]){
            line[x2[i]] = make_pair(x1[i],x2[i]);
        }else{
            if(line[x2[i]].first < x1[i]){
                line[x2[i]] = make_pair(x1[i],x2[i]);
            }
        }
    }

    for(int i = 1; i <= 1000; i ++){

        if(line[i].second == i){
            dp[i] = max(dp[line[i].first-1] + 1,dp[i-1]);
        } else{
            dp[i] = dp[i-1];
        }
    }

    cout << dp[1000];
    return 0;
}
