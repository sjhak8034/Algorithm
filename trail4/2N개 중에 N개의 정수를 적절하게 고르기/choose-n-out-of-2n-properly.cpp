#include <iostream>
#include <bits/stdc++.h>
using namespace std;


int n;
int num[20];
int two_n_sum = 0;
int ans = 1000000;

void choose(int depth, int idx,int sum){
    if(depth == n){
        ans = min(ans, abs(two_n_sum - 2*sum));
    }
    if(idx == 2*n-1){
        return;
    }
    choose(depth,idx+1,sum);

    choose(depth+1,idx+1,sum + num[idx]);
}

int main() {
    cin >> n;
    for (int i = 0; i < 2 * n; i++) {
        cin >> num[i];
        two_n_sum += num[i];
    }
    
    choose(0,0,0);

    cout << ans;

    // Please write your code here.

    return 0;
}
