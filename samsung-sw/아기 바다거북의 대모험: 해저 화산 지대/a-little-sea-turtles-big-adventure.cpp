#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int N; // grid 크기
int M; // 거북이 수
int K; // 해저 화산 수
int grid[20][20]; // 장애물 위치
int visited[20][20];
int v_grid[20][20][2]; // 화산 압력 , 열 상태
int volcanoes[10][4]; // 화산 위치 y,x,최대 압력
int is_vlocano_bomb[10];
int turtles[10][3]; // 거북이 위치 y,x,exist

int ans[10];

int dy[4] = {0, 1, 0, -1};
int dx[4] = {1, 0, -1, 0};

bool isInbound(int y, int x){
    if(y>=N || y < 0){
        return false;
    }
    if(x>=N || x < 0){
        return false;
    }
    return true;

}

void refresh(int turn){
    // volcano status
    for(int volcano = 0; volcano < K; volcano++){
        int y,x,P;
        y = volcanoes[volcano][0];
        x = volcanoes[volcano][1];
        P = volcanoes[volcano][2];
        if(v_grid[y][x][0] + v_grid[y][x][1] >= P){
            v_grid[y][x][0] = 0;
        }
    }
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            v_grid[i][j][1] = 0;
        }
    }



    // finish turtle check
    for(int i = 0; i < M; i++){
        if(turtles[i][2] == 0){
            continue;
        }
    
        int y = turtles[i][0];
        int x = turtles[i][1];
        if(grid[y][x] == 3){
            turtles[i][2] = 0;
        }
        if(y == x && y == N-1){
            grid[y][x] = 0;
            turtles[i][2] = 0;
            ans[i] = turn; 
        }
     
    }
}

// simulation
void volcano_active(int volcano){
    int y = volcanoes[volcano][0];
    int x = volcanoes[volcano][1];
    int P = volcanoes[volcano][2];
    int pressure     = v_grid[y][x][0];
    int outside_fire = v_grid[y][x][1];

    if(is_vlocano_bomb[volcano] == 1) return;
    if(pressure + outside_fire < P) return;

    is_vlocano_bomb[volcano] = 1;      // ③ 분출 표시
    v_grid[y][x][1] += P;              // ② 자기 칸에 임계치만큼

    for(int i = 0; i < 4; i++){
        int heat = P / 2;              // ① 방향마다 리셋
        int ny = y + dy[i], nx = x + dx[i];
        while(heat > 0 && isInbound(ny,nx) && grid[ny][nx] != 1){
            v_grid[ny][nx][1] += heat;
            heat /= 2;
            ny += dy[i];
            nx += dx[i];
        }
    }
}

// bfs
void find_way(int turtle){
    int cy = turtles[turtle][0], cx = turtles[turtle][1];

    static int dist[20][20];
    for(int i=0;i<N;i++) for(int j=0;j<N;j++) dist[i][j] = -1;

    queue<pair<int,int>> q;
    q.push({N-1, N-1});
    dist[N-1][N-1] = 0;
    while(!q.empty()){
        int y, x;
        tie(y, x) = q.front(); 
        q.pop();
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i], nx = x + dx[i];
            if(!isInbound(ny,nx) || dist[ny][nx] != -1) continue;
            // 산호초(1) / 다른 거북이(2) / 화석(3) 은 통과 불가.
            // 단, 자기 자신의 칸은 예외
            if(grid[ny][nx] != 0 && !(ny==cy && nx==cx)) continue;
            dist[ny][nx] = dist[y][x] + 1;
            q.push({ny, nx});
        }
    }

    if(dist[cy][cx] == -1) return;          // 경로 없음 → 제자리

    for(int i = 0; i < 4; i++){             // 우, 하, 좌, 상
        int ny = cy + dy[i], nx = cx + dx[i];
        if(!isInbound(ny,nx)) continue;
        if(dist[ny][nx] == dist[cy][cx] - 1){
            turtles[turtle][0] = ny;
            turtles[turtle][1] = nx;
            return;
        }
    }
}

int main() {
    cin>> N >> M >> K;
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            cin >> grid[i][j];
        }
    }
    for(int i = 0; i < M; i++){
        int y, x;
        cin >> y >> x;
        turtles[i][0] = y; 
        turtles[i][1] = x;
        turtles[i][2] = 1;
        grid[y][x] = 2;
    }
    for(int i = 0; i < K; i++){
        int y, x;
        int P;
        cin >> y >> x >> P;
        volcanoes[i][0]  = y;
        volcanoes[i][1]  = x;
        volcanoes[i][2]  = P; 
    }

    for(int i = 0; i < M; i++){
        ans[i] = -1;
    }
    
    for(int turn = 1; turn <= 100; turn++){

        for(int turtle = 0; turtle < M; turtle++){
            if(turtles[turtle][2] == 0) continue;
            find_way(turtle);

            // 이 거북이의 이동을 즉시 반영
            for(int i = 0; i < N; i++)
                for(int j = 0; j < N; j++)
                    if(grid[i][j] == 2) grid[i][j] = 0;
            for(int s = 0; s < M; s++){
                if(turtles[s][2] == 0) continue;
                grid[turtles[s][0]][turtles[s][1]] = 2;
            }
        }
        for(int volcano = 0; volcano < K; volcano ++){
            int y, x;
            y = volcanoes[volcano][0];
            x = volcanoes[volcano][1];
            v_grid[y][x][0] += 10;
        }
        memset(is_vlocano_bomb, 0, sizeof(is_vlocano_bomb));
        for(int i = 0; i < K; i++ ){
            for(int volcano = 0; volcano < K; volcano ++){
                volcano_active(volcano);
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == j && j == N-1){
                    continue;
                }
                if(grid[i][j] == 2){
                   if(v_grid[i][j][1] >= 20){     
                        grid[i][j] = 3;
                    }
                }
            }
        }


        refresh(turn);
    }

    for(int i = 0; i < M; i++){
        cout << ans[i] << "\n";
    }
    return 0;
}