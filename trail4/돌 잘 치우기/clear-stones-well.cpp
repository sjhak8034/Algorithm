#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int n, k, m;
int grid[100][100];
int r[10000], c[10000];
int ans = 0;
int visited[100][100];
int eliminated[100][100];

bool isInbound(int y, int x){
    if(y >= n || y < 0){
        return false;
    }
    if(x >= n || x < 0){
        return false;
    }
    return true;
}

void bfs(){
    int temp_ans = 0;
    memset(visited,0,sizeof(visited));
    queue<pair<int,int>> q;

    for (int i = 0; i < k; i++) {
        visited[r[i]][c[i]] = 1;
        q.push(make_pair(r[i],c[i]));
    }
    while(!q.empty()){
        temp_ans ++;
        int dx[4] = {0,1,0,-1};
        int dy[4] = {1,0,-1,0};
        int x,y;
        tie(x,y) = q.front();
        q.pop();
  
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!isInbound(ny,nx) || visited[ny][nx] == 1 || (grid[ny][nx] == 1 && eliminated[ny][nx] == 0)){
                continue;
            }
            visited[ny][nx] = 1;
            q.push(make_pair(ny,nx));
        }
    }
    ans = max(temp_ans,ans);
}

void choose(int depth, int idx){
    
    if(depth == m){
        bfs();
        return;
    }

    if(idx == n*n-1){
        return;
    }
    

    choose(depth, idx+1);
    int y = idx/n;
    int x = idx%n;
    if(grid[y][x] == 0){
        return;
    }

    eliminated[y][x] = 1;
    choose(depth+1,idx+1);
    eliminated[y][x] = 0;

}

int main() {
    cin >> n >> k >> m;

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++) cin >> grid[i][j];

    for (int i = 0; i < k; i++) {
        cin >> r[i] >> c[i];
        r[i]--;
        c[i]--;
    }
    
    choose(0,0);
            
            
 
    cout << ans;
    return 0;
}
