#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int n;
int grid[10][10];
int chosen[20];
int visited_col[20];
int ans = 0;
void choose(int depth,int current){
    if (depth == n){
        ans = max(ans, current);
    }

    for(int i = 0; i < n; i++){
        if(visited_col[i] == 1){
            continue;
        }
        visited_col[i] = 1;
        int temp = current;
        current = min(current, grid[depth][i]);
        choose(depth+1,current);
        current = temp;
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
    choose(0,100000);
    cout << ans;
    // Please write your code here.

    return 0;
}
