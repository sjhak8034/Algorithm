#include <iostream>

using namespace std;

int n;
int grid[10][10];
int chosen[10];
int visited_row[10];
int visited_col[10];
int ans = 0;

void choose(int depth, int sum){
    if (depth == n){
        ans = max(ans,sum);
    }

    for(int i = 0; i < n; i++){
        
        if (visited_col[i] == 1){
            continue;
        }
        visited_col[i] = 1;
        choose(depth + 1, sum + grid[depth][i]);
        visited_col[i] = 0;
    }
}

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> grid[i][j];
        }
    }
    choose(0,0);

    cout << ans;

    return 0;
}
