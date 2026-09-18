#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int n;
int grid[25][25];
int village_nums = 0;
int visited[25][25];
vector<int> villange_peoples;

bool isInbound(int y,int x){
    if(y >= n || y < 0){
        return false;
    }
    if(x >= n || x < 0){
        return false;
    }
    return true;
}

void dfs(int y,int x){
    villange_peoples[villange_peoples.size()-1] ++;
    int dx[4] = {0,1,0,-1};
    int dy[4] = {1,0,-1,0};
   
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(!isInbound(ny,nx) || visited[ny][nx] == 1 || grid[ny][nx] == 0){
            continue;
        }
        
        visited[ny][nx] = 1;
        dfs(ny,nx);
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
            if(visited[i][j] == 1 || grid[i][j] == 0){
                continue;
            }
            villange_peoples.push_back(0);
            visited[i][j] = 1;
            dfs(i,j);
            village_nums ++;
        }
    }
    cout << village_nums;
    cout << "\n";
    sort(villange_peoples.begin(), villange_peoples.end());
    for(int i = 0; i < village_nums; i++){
        cout << villange_peoples[i];
        cout << "\n";
    }

    // Please write your code here.

    return 0;
}
