#include <bits/stdc++.h>

using namespace std;

int N, T;
vector<vector<int>> grid;
int dist1[1000][1000]; // 0,0 ~ i,j 까지
int dist2[1000][1000];  // n-1,n-1 ~ i,j까지
int dist3[1000][1000];  // i,j ~ T만큼 갔을때 최대
int L[2][1000][1000];

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
    for (int i = 0; i < N; i++)
    for (int j = 0; j < N; j++) L[0][i][j] = grid[i][j];

    int maxT = min(T, 2 * N - 2), cur = 0;
    for (int t = 1; t <= maxT; t++) {
        int nx = cur ^ 1;
        for (int i = N - 1; i >= 0; i--)
            for (int j = N - 1; j >= 0; j--) {
                if ((N - 1 - i) + (N - 1 - j) < t) continue;   // t번 이동이 불가능한 칸
                int best = INT_MIN;
                if (i + 1 < N) best = max(best, L[cur][i + 1][j]);
                if (j + 1 < N) best = max(best, L[cur][i][j + 1]);
                L[nx][i][j] = grid[i][j] + best;
            }
        cur = nx;
    }

    int ans = -INT_MAX;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++) {
            bool can = ((N - 1 - i) + (N - 1 - j) >= T);       // T번 이동 가능한가
            int v = dist1[i][j] + dist2[i][j] - grid[i][j];
            if (can) v += L[cur][i][j];
            ans = max(ans, v);
        }


    cout << ans;

    return 0;
}
