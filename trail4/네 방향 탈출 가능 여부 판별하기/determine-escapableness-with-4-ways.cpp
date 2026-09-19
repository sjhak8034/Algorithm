#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int dx[4] = {0,1,0,-1};
int dy[4] = {1,0,-1,0};
int visited[101][101];

int n, m;
int a[100][100];
queue<pair<int,int>> q;

bool isInbound(int y, int x){
    if(y >= n || y < 0){
        return false;
    }
    if(x >= m || x < 0){
        return false;
    }
    return true;
}

int main() {
    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }

    q.push({0,0});

    while(!q.empty()){
        pair<int,int> point = q.front();
        q.pop();
        if(point == pair<int,int>{n-1, m-1}){
            cout << 1;
            return 0;
        }

        for(int i = 0; i < 4; i++){
            int nx = point.second + dx[i];
            int ny = point.first + dy[i];
            if(!isInbound(ny,nx) || visited[ny][nx] == 1 || a[ny][nx] == 0){
                continue;
            }
            visited[ny][nx] = 1;
            q.push({ny,nx});
        }
    }
    
    cout << 0;
    // Please write your code here.

    return 0;
}
