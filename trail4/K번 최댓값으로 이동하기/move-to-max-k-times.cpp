#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int n, k;
int grid[100][100];
int r, c;
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

int main() {
    cin >> n >> k;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> grid[i][j];
        }
    }

    cin >> r >> c;
    
    int basis = grid[r-1][c-1];

    queue<pair<int,int>> q;
    
    pair<int,int> max_pair;
    max_pair = {r-1,c-1};
    int max_value = 0;
    visited[r-1][c-1] = 1;
    
    q.push(pair<int,int> {r-1,c-1});

    for(int j = 0; j < k; j++){
        max_value = 0;
        while(!q.empty()){
            int y = q.front().first;
            int x = q.front().second;
            
    
            q.pop();
 
            int dx[4] = {0,1,0,-1};
            int dy[4] = {1,0,-1,0};
 
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(!isInbound(ny,nx) || visited[ny][nx] == 1 || grid[ny][nx] >= basis){
                    continue;
                }
                visited[ny][nx] = 1;

                int value = grid[ny][nx];
                if(value > max_value){
                    max_value = value;
                    max_pair = pair<int,int> {ny,nx};
                } else if(value == max_value){
                    if(ny < max_pair.first){
                        max_pair = pair<int,int> {ny,nx};
                    } else if(ny == max_pair.first){
                        if(nx < max_pair.second){
                            max_pair = pair<int,int> {ny,nx};
                        }
                    }
                }
                q.push(pair<int,int> {ny,nx});
                
            }
        }
        
        q.push(max_pair);
        basis = max_value;
        memset(visited, 0, sizeof(visited));

    }
    
    cout << max_pair.first + 1 << " " << max_pair.second + 1;
    

    return 0;
}
