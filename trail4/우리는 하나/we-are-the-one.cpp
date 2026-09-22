#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int n, k, u, d;
int grid[8][8];
int visited[8][8];
int ans = 0;
vector<int> chosen;

bool isInbound(int y, int x){
    if(y >= n || y < 0){
        return false;
    }
    if(x >= n || x < 0){
        return false;
    }
    return true;
}

bool canGo(int y, int x, int ny, int nx){
    if(abs(grid[y][x] - grid[ny][nx]) >= u && abs(grid[y][x] - grid[ny][nx]) <= d){
        return true;
    }
    return false;
}

void bfs(){
    int temp_ans = 0;
    queue<pair<int,int>> q;

    for(int idx:chosen){
        int x = idx % n;
        int y = idx / n;
        q.push(make_pair(y,x));
        visited[y][x] = 1;
        temp_ans++;
    }

    while(!q.empty()){
        int dx[4] = {0,1,0,-1};
        int dy[4] = {1,0,-1,0};

        int x,y;
        tie(y,x) = q.front();
        q.pop();

        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(!isInbound(ny,nx)){
                continue;
            }
            if(visited[ny][nx] == 1){
                continue;
            }
            if(!canGo(y,x,ny,nx)){
                continue;
            }
            visited[ny][nx] = 1;
            temp_ans++;
            q.push(make_pair(ny,nx));
        }
    }
    ans = max(temp_ans,ans);
    memset(visited,0,sizeof(visited));
}

void choose(int depth, int idx){
    if(depth == k){
        
        bfs();
        return;
    }
    
    if(idx == n*n){
        return;
    }

   

    choose(depth, idx + 1);
    

    chosen.push_back(idx);

    choose(depth+1, idx + 1);

    chosen.pop_back();
}



int main() {
    cin >> n >> k >> u >> d;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> grid[i][j];
        }
    }


    choose(0,0);
    cout<<ans;
    return 0;
}
