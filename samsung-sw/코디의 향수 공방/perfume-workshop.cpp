#include <iostream>
#include <bits/stdc++.h>

using namespace std;

set<int> p_s; // perfym value order set
int perfume_value_num[3001] = {}; // perfume value : 갯수
int perfumes_value_map[1101] = {}; // perfume number : value

int N; 
int Q;

void prepare(){
    cin >> N;
    for(int i = 1; i <= N; i++){
        int v;
        cin >> v;
        perfumes_value_map[i] = v;
        perfume_value_num[v] ++;
        p_s.insert(v);
    }
}

void add(){
    int v;
    cin >> v;
    N++;
    perfumes_value_map[N] = v;
    perfume_value_num[v] ++;
    p_s.insert(v);
}

void discard(){
    int idx;
    cin >> idx; 
    if(perfumes_value_map[idx] != -1){
        int v = perfumes_value_map[idx];
        cout << v << "\n";
        perfume_value_num[v] --;
        perfumes_value_map[idx] = -1;
        
        if(perfume_value_num[v] == 0){
            p_s.erase(v);
        }
    } else{
        cout << -1 << "\n";
    }
 
}
// dp
void blending(){
    int k;
    cin >> k;
    int dp[k+1] = {};

    for(int i = 1; i <= k; i++){
        dp[i] = INT_MAX;
    }

    for(int v : p_s){
        for(int i = 1; i <=k; i++){
            if(v > i || dp[i-v] == INT_MAX){
                continue;
            }

            dp[i] = min(dp[i-v] + 1, dp[i]);

        }
    }
    if(dp[k] == INT_MAX){
        cout << -1 << "\n";
        return;
    }
    cout << dp[k] << "\n";

}
// 누적합
void mix(){
    int k;
    cin >> k;

    // suf[v] = 향도가 v 이상인 향료의 개수
    static long long suf[3002];
    suf[3001] = 0;
    for (int v = 3000; v >= 1; v--)
        suf[v] = suf[v+1] + perfume_value_num[v];

    long long ans = 0;
    for (int v1 : p_s) {
        for (int v2 : p_s) {
            int need = k - v1 - v2;
            long long third;
            if (need <= 1)      third = suf[1];      // 아무 향료나 가능
            else if (need > 3000) third = 0;         // 불가능
            else                third = suf[need];

            ans += (long long)perfume_value_num[v1] * perfume_value_num[v2] * third;
        }
    }
    cout << ans << "\n";
}
int main() {
    cin >> Q;
    int command;

    for(int i = 0; i < 1100; i++){
        perfumes_value_map[i] = -1;
    }

    for(int i = 0; i < Q; i++){
        cin >> command;
        if(command == 1){
            prepare();
        } 
        if(command == 2){
            add();
        } 
        if(command == 3){
            discard();
        } 
        if(command == 4){
            blending();
        } 
        if(command == 5){
            mix();
        } 
    }



    return 0;
}