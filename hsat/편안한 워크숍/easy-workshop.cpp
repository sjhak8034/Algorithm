#include <iostream>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int N, K;
vector<vector<int>> grid;
long long dp[100][100][101];

bool isInbound(int y, int x){
    if(y >= N || y < 0){
        return false;
    }
    if(x >= N || x < 0){
        return false;
    }
    return true;
}

int main() {
    cin >> N >> K;

    grid.resize(N, vector<int>(N));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> grid[i][j];
        }
    }
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            for(int p = 2; p <= K; p++){
                dp[i][j][p] = INT_MAX;
               
            }
        }
    }

    int dx[4] = {0,1,0,-1};
    int dy[4] = {1,0,-1,0};
    for(int i = 2; i <=K; i++){
        for(int y = 0; y <N; y++){
            for(int x = 0; x < N; x++){
                for(int dir = 0; dir < 4; dir++){
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if(!isInbound(ny,nx)|| grid[ny][nx] <= grid[y][x]){
                        continue;
                    }
                    long long dif = max<long long>(dp[ny][nx][i-1], grid[ny][nx]-grid[y][x]);
                    dp[y][x][i] = min(dp[y][x][i],dif); 
                }
                // cout<<dp[y][x][i] << " " << y << x << i << "\n";
            }
        }
    }
    long long answer = INT_MAX;
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            answer = min(answer,dp[i][j][K]);
        }
    }
    if( answer == INT_MAX){
        cout << -1;
        return 0;
    }
    cout << answer;

  
    return 0;
}
