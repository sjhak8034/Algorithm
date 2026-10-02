#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int N, K;
vector<long long> positions;


int main() {
    cin >> N >> K;

    positions.resize(N);
    long long min_pos = INT_MAX;
    long long max_pos = 0;
    for (int i = 0; i < N; i++) {
        cin >> positions[i];
        min_pos = min(min_pos,positions[i]);
        max_pos = max(max_pos,positions[i]);
    }
    sort(positions.begin(), positions.end());// 오름차순
    int ans = 0;


    long long max_length = (max_pos - min_pos + 1)/ K + ((max_pos - min_pos + 1) % K > 0 ? 1 : 0) ;
    
    int hi = max_length;
    int lo = 1;
    
    while(lo < hi){
        int mid = (hi + lo)/2;
        int use = 0;
        int ok = 0;
        for(int j = 0; j < N; j++){
            if(positions[j] > ok){
                ok = positions[j] + mid - 1;
                use += 1;
            }
        }

        if(use <= K){
            hi = mid;
        } else{
            lo = mid+1;
        }

    }
    ans = lo;
    cout << ans;

    return 0;
}
