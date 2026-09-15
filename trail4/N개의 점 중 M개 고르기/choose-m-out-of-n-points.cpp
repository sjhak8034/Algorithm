#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int n, m;
int x[20], y[20];
vector<int> chosen_points;
int ans = 10000000;
int cal(int x1, int x2, int y1, int y2){
    return (x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2);
}

void choose(int depth, int max_dist, int idx){
   
    if (depth == m){
        ans = min(ans, max_dist);
        return;
    }

    if(idx == n){
        return;
    }
    choose(depth, max_dist, idx+1);

    chosen_points.push_back(idx);
    for(int point : chosen_points){
        max_dist = max(max_dist, cal(x[point],x[idx],y[point],y[idx]));
    }
    
    choose(depth+1, max_dist, idx+1);
    chosen_points.pop_back();
}

int main() {
    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        cin >> x[i] >> y[i];
    }
    choose(0,0,0);
    cout<<ans;
    return 0;
}
