#include <bits/stdc++.h>

using namespace std;

int N, T;
vector<vector<int>> grid;
int dist1[1000][1000]; // 0,0 ~ i,j 까지
int dist2[1000][1000];  // n-1,n-1 ~ i,j까지
int dist3[1000][1000];  // i,j ~ T만큼 갔을때 최대

void dfs(int o_y, int o_x,int y, int x, int depth, int current){
    if (depth == T){
        dist3[o_y][o_x] = max(dist3[o_y][o_x], current);
        return;
    }

    int dx[2] = {0,1};
    int dy[2] = {1,0};
    
    for(int i = 0; i < 2; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny > N-1 || nx > N-1){
            continue;
        }
        dfs(o_y,o_x,ny,nx,depth+1,current+grid[ny][nx]);
    }

}

int main() {
    cin.tie(nullptr);

    cin >> N >> T;

    grid.resize(N, vector<int>(N));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> grid[i][j];
            dist1[i][j] = -100000000;
            dist2[i][j] = -100000000;
            dist3[i][j] = -100000000;
        }
    }
    dist1[0][0] = grid[0][0];
    for(int i =0; i < N; i++){
        for(int j =0; j < N; j++){
            if(i != 0){
                dist1[i][j] = max(dist1[i][j], dist1[i-1][j] + grid[i][j]);
            }
            if(j != 0){
                dist1[i][j] = max(dist1[i][j], dist1[i][j-1] + grid[i][j]);
            }
        }
    }
    dist2[N-1][N-1] = grid[N-1][N-1];
    for(int i =N-1; i >= 0; i--){
        for(int j =N-1; j >= 0; j--){
            if(i != N-1){
                dist2[i][j] = max(dist2[i][j], dist2[i+1][j] + grid[i][j]);
            }
            if(j != N-1){
                dist2[i][j] = max(dist2[i][j], dist2[i][j+1] + grid[i][j]);
            }
        }
    }
    int current = 0;
    for(int i =0; i < N; i++){
        for(int j =0; j < N; j++){
            dfs(i,j,i,j,0,grid[i][j]);
        }
    }

   
    int ans = -INT_MAX;
    for(int i =0; i < N; i++){
        for(int j =0; j < N; j++){
            if(dist3[i][j] == -100000000 ){
                 ans = max(ans, dist1[i][j] + dist2[i][j] - grid[i][j]);
            } else{
                ans = max(ans, dist1[i][j] + dist2[i][j] + dist3[i][j] - grid[i][j]);
            }
            
        }
    }

    cout << ans;

    return 0;
}
