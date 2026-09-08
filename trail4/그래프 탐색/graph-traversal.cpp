#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int n, m;

vector<int> visited;
vector<vector<int>> edges;
int answer = 0;

void dfs(int now) {
    visited[now] = 1;
    for (int next : edges[now]) {
        if (!visited[next]) {
            answer++;              // 새로 방문할 때마다 1 증가
            dfs(next);
        }
    }
}

int main() {
    cin >> n >> m;
    visited.assign(n + 1, 0);
    edges.assign(n + 1, {});

    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        edges[a].push_back(b);
        edges[b].push_back(a);
    }

    dfs(1);                        // 1번에서 한 번만
    cout << answer;
    return 0;
}