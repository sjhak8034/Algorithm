#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int N, r, c, d;
int grid[50][50];
int visited[50][50];
int next_dir;

bool isInbound(int y, int x){
    if(y >= N || y <0){
        return false;
    }
    if(x >= N || x <0){
        return false;
    }
    return true;
}

void bfs(int y, int x, int f_y, int f_x){
    queue<pair<int,int>> q;
    q.push(make_pair(y,x));
    int visited2[50][50]= {};
    visited2[y][x] = 1;

    int dx[4] = {-1,0,1,0};
    int dy[4] = {0,1,0,-1};

    int dr[4] = {3,2,1,0};

    while(!q.empty()){
        int y,x;
        tie(y,x) =q.front();
        q.pop();

        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(!isInbound(ny,nx) || visited2[ny][nx] == 1 || grid[ny][nx] == 1){
                continue;
            }
            visited2[ny][nx] = 1;
            if(ny == f_y && nx == f_x){
                next_dir = dr[i];
                return;
            }
            q.push(make_pair(ny,nx));
        }
    }
}

pair<int,int> search_new(int y, int x){
    int o_y = y, o_x = x;
    static int dist[50][50];
    for(int i=0;i<N;i++) for(int j=0;j<N;j++) dist[i][j] = -1;

    queue<pair<int,int>> q;
    q.push({y,x}); dist[y][x] = 0;
    int dy[4]={-1,0,1,0}, dx[4]={0,-1,0,1};
    while(!q.empty()){
        int cy,cx; tie(cy,cx) = q.front(); q.pop();
        for(int i=0;i<4;i++){
            int ny=cy+dy[i], nx=cx+dx[i];
            if(!isInbound(ny,nx) || grid[ny][nx]==1 || dist[ny][nx]!=-1) continue;
            dist[ny][nx] = dist[cy][cx]+1;
            q.push({ny,nx});
        }
    }

    int best=-1, by=-1, bx=-1;
    for(int i=0;i<N;i++) for(int j=0;j<N;j++){
        if(grid[i][j]==1 || visited[i][j]==1 || dist[i][j]<=0) continue;
        if(best==-1 || dist[i][j]<best){ best=dist[i][j]; by=i; bx=j; }
    }
    if(by==-1) return {-1,-1};
    bfs(o_y, o_x, by, bx);
    return {by, bx};
}

int main() {
    
    cin >> N >> r >> c >> d;


    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> grid[i][j];
        }
    }

    int dr[4] = {0,-1,1,2};
    int dx[4] = {0,1,0,-1};
    int dy[4] = {-1,0,1,0};

    int y = r-1;
    int x = c-1;

    int current_dir;
    if(d == 1){
        current_dir = 0;
    } 
    if(d == 2){
        current_dir = 2;
    } 
    if(d == 3){
        current_dir = 3;
    } 
    if(d == 4){
        current_dir = 1;
    } 

    visited[y][x] = 1;
 

    while(true){
 
       
        cout << y+1 << " " << x+1 << "\n";
        int nx = -1;
        int ny = -1;

        int dr_idx = 0;
        // 방향 회전
       
        while(!isInbound(ny,nx) || grid[ny][nx] == 1 || visited[ny][nx] == 1){
            // 갈곳이 없는 경우
            if(dr_idx == 4){
                tie(ny,nx) = search_new(y,x);
                if(ny == -1){
                    return 0;
                }
                break;
            }
        
            next_dir = (current_dir + dr[dr_idx] + 4) % 4; 
            ny = y + dy[next_dir];
            nx = x + dx[next_dir];
            

            dr_idx ++;
        }
        current_dir = next_dir;
        x = nx;
        y = ny;

        visited[y][x] = 1;

        
    }    

    return 0;
}