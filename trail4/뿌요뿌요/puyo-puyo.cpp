#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int n;
int grid[100][100];
int max_value = -1;
int num_k = 0;
int current_value = 0;
int visited[100][100];

bool isInbound(int y, int x){
    if(y >= n || y < 0){
        return false;
    }
    if(x >= n || x < 0){
        return false;
    }
    return true;
}

void sim(int y, int x, int k){
    current_value++;
    int dx[4] = {-1,0,1,0};
    int dy[4] = {0,1,0,-1};
    for(int i = 0; i < 4; i ++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(!isInbound(ny,nx) || visited[ny][nx] == 1 || grid[ny][nx] != k){
            continue;
        }
        visited[ny][nx] = 1;
        sim(ny,nx,k);
    }
}

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> grid[i][j];
        }
    }

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            int k = grid[i][j];
            if(visited[i][j] == 1){
                continue;
            }
            visited[i][j] = 1;
            current_value = 0;
            sim(i,j,grid[i][j]);
            if(current_value >= 4){
                num_k ++;
            }
            max_value = max(max_value,current_value);
        }
    }

    cout <<  num_k << " " << max_value;

    // Please write your code here.

    return 0;
}
