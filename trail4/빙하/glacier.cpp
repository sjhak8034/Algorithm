#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int N, M;
int a[200][200];
int melt_grid[200][200];
int visited[200][200];
int melted = -1;
int ans1=0;
int ans2=0;
int dx[4] = {0,1,0,-1};
int dy[4] = {1,0,-1,0};

bool isInbound(int y, int x){
    if(y >= N || y < 0){
        return false;
    }
    if(x >= M || x < 0){
        return false;
    }
    return true;
}


void bfs(){
    queue<pair<int,int>> q;
    q.push(make_pair(0,0));
    memset(visited,0,sizeof(visited));
    visited[0][0] = 1;
    while(!q.empty()){
       
        int y,x;
        tie(y,x) = q.front();
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
            if(a[ny][nx] == 1){
                visited[ny][nx] = 1;
                if( a[ny][nx] == 1){
                    melt_grid[ny][nx] = 1;
                    melted++;
                }
                continue;
            }
            visited[ny][nx] = 1;
            q.push(make_pair(ny,nx));
        }
         
    }
}

void next(){
    if(melted == 0){
        ans1 --;
        return;
    }
   
    ans1 ++;
    ans2 = melted;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            if(melt_grid[i][j] == 1){
                a[i][j] = 0;
            }
        }
    }
    memset(melt_grid, 0, sizeof(melt_grid)); 
    melted = 0;

    bfs();
    next();

}

int main() {
    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> a[i][j];
        }
    }

    next();

    cout << ans1 <<" " << ans2;

    // Please write your code here.

    return 0;
}
