#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int N;
char grid[20][20];
unordered_map<int, vector<int>> coin_map;
set<int> coin_set;
vector<int> start;
vector<int> endP;
int MAX_DIST = 10000000;

void choose(int depth, vector<int> prev, int idx, int sum, int* result){
    if(depth == 3){
        sum += abs(prev[0] - endP[0]) + abs(prev[1] - endP[1]);
        *result = min(*result, sum);
        return;
    }
    int size = coin_set.size();
    for(int i = idx; i < size; i++){
        auto it = coin_set.begin();
        advance(it, i); 
        int n = *it;
        int x = coin_map[n][1];
        int y = coin_map[n][0];
        
        choose(depth + 1, coin_map[n], i + 1, sum + abs(y - prev[0]) + abs(x - prev[1]), result);
    }
}

int main() {
    cin >> N;

    for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++) {
            cin >> grid[i][j];
            if (grid[i][j] != '.' && grid[i][j] != 'E' && grid[i][j] != 'S'){
                int num = (grid[i][j] - '0');
                coin_set.insert(num);
                coin_map[num].resize(2);
                coin_map[num][0] = i;
                coin_map[num][1] = j;
            }
            if (grid[i][j] == 'S'){
                start.resize(2);
                start[0] = i;
                start[1] = j;
            }
            if (grid[i][j] == 'E'){
                endP.resize(2);
                endP[0] = i;
                endP[1] = j;
            }
        }
    }
        
    
    int result = MAX_DIST;
    choose(0,start,0,0,&result);
    if(result == MAX_DIST){
        cout << -1;
        return 0;
    }
    cout << result;
    return 0;
}
