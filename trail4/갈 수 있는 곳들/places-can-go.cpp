#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int n, k;
int grid[100][100];
int r[10000], c[10000];
int visited[100][100];
int ans = 0;

bool isInbound(int y, int x){
    if(y >= n || y < 0){
        return false;
    }
    if(x >= n || x < 0){
        return false;
    }
    return true;
}




int main() {
    cin >> n >> k;

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++) cin >> grid[i][j];

    for (int i = 0; i < k; i++) cin >> r[i] >> c[i];
    queue<pair<int,int>> q;
    for(int i = 0; i < k; i++){
        int y = r[i] - 1;
        int x = c[i] - 1;
        visited[y][x] = 1;
        q.push(pair<int,int> {y,x});
        
        
    }

    while(!q.empty()){
        
        int dx[4] = {0,1,0,-1}; 
        int dy[4] = {1,0,-1,0}; 
        pair<int,int> now = q.front();
        q.pop();
        int x = now.second;
        int y = now.first;
        
        ans ++;
        for(int i  = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!isInbound(ny,nx) || visited[ny][nx] == 1 || grid[ny][nx] == 1){
                continue;
            }
            visited[ny][nx] = 1;
            q.push(pair<int,int> {ny,nx});
        }
    }
    cout << ans;
    

    return 0;
}
