#include <bits/stdc++.h>
using namespace std;

const int INF = 1e9;
int n, grid[100][100], memo[100][100];
int L;

int dfs(int y, int x) {
    if (grid[y][x] < L) return INF;               // 못 지나가는 칸
    if (y == n-1 && x == n-1) return grid[y][x];  // 도착
    int &ret = memo[y][x];
    if (ret != -1) return ret;                    // 이미 계산함

    int best = INF;
    if (y + 1 < n) best = min(best, dfs(y+1, x));
    if (x + 1 < n) best = min(best, dfs(y, x+1));
    return ret = (best == INF) ? INF : max(best, grid[y][x]);
}

int main() {
    cin >> n;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            cin >> grid[i][j];

    int ans = INF;
    for (L = 1; L <= 100; L++) {
        memset(memo, -1, sizeof(memo));           // L마다 초기화 필수
        int r = dfs(0, 0);
        if (r != INF) ans = min(ans, r - L);
    }
    cout << ans;
}