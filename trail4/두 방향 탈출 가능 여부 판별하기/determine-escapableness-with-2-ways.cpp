#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int n, m;
int grid[100][100];
int visited[100][100];
bool isSuccess = false;

bool isInbound(int x, int y){
    if(x >= m || x < 0){
        return false;
    }
    if(y >= n || y < 0){
        return false;
    }
    return true;
}

void go(int x, int y){
    
    if(x == m-1 && y == n-1){
        isSuccess = true;
        cout << 1;
        return;
    }
    int dx[4] = {1,0};
    int dy[4] = {0,1};

    for(int i = 0; i < 2; i++){
        
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(!isInbound(nx,ny) || visited[ny][nx] == 1 || grid[ny][nx] == 0){
            continue;
        }
        visited[ny][nx] = 1;
      
        go(nx,ny);
    }
}

int main() {
    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> grid[i][j];
        }
    }
    int start = 0;
    go(0,0);
    if(!isSuccess){
        cout << 0;
    }
    

    // Please write your code here.

    return 0;
}
