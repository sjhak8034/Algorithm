#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int n, k;
int grid[100][100];
int ans[100][100];
int visited[100][100];

bool isInbound(int y, int x){
    if(y >= n || y <0){
        return false;
    }
    if(x >= n || x <0){
        return false;
    }
    return true;
}

int main() {
    cin >> n >> k;

    queue<tuple<int,int,int>> q;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> grid[i][j];
            if(grid[i][j] == 2){
                q.push(make_tuple(i,j,0));
                visited[i][j] = 1;
                ans[i][j] = 0;
            }
        }
    }
    int dx[4] = {0,1,0,-1};
    int dy[4] = {1,0,-1,0};
    while(!q.empty()){
        int y,x,time;
        tie(y,x,time) = q.front();
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!isInbound(ny,nx)){
                continue;
            } 
            if(visited[ny][nx] == 1){
                continue;
            }
            if(grid[ny][nx] == 1){
                q.push(make_tuple(ny,nx,time+1));
                visited[ny][nx] = 1;
                ans[ny][nx] = time+1;
                grid[ny][nx] = 2;
            } 

        }
        
    }
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(grid[i][j] == 0){
                ans[i][j] = -1;
            }
            if(grid[i][j] == 1){
                ans[i][j] = -2;
            }
        }
    }
    
   
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cout<<ans[i][j] << " ";
        }
        cout << "\n";
    }

    return 0;
}
