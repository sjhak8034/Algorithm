#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int N, M;
int grid[50][50];
int c_grid[50][50];
int safety_nums[101];
int visited[50][50];


bool isInbound(int y,int x){
    if(y >= N || y < 0){
        return false;
    }
    if(x >= M || x < 0){
        return false;
    }
    return true;
}

void dfs(int y,int x, int k){
    int dx[4] = {0,1,0,-1};
    int dy[4] = {1,0,-1,0};
   
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(!isInbound(ny,nx) || visited[ny][nx] == 1 || c_grid[ny][nx] == 0){
            continue;
        }
        
        visited[ny][nx] = 1;
        dfs(ny,nx,k);
    }
}


int main() {
    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> grid[i][j];
        }
    }

    for(int k = 1; k < 101; k++){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(grid[i][j] <= k){
                    c_grid[i][j] = 0;
                } else{
                    c_grid[i][j] = 1;
                }
            }
        }
        memset(visited, 0, sizeof(visited));
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visited[i][j] == 1 || c_grid[i][j] == 0){
                    continue;
                } 
                safety_nums[k] ++;
                dfs(i,j,k);
            }
        }
    }
    int max_k = 0;
    int max_value = -1;
    for(int i = 1; i < 101; i++){
        if(safety_nums[i] > max_value){
            max_k = i;
            max_value = safety_nums[i];
        }
    }
    cout << max_k << " " << max_value;
    // Please write your code here.

    return 0;
}
