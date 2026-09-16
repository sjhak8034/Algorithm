#include <iostream>

using namespace std;

int n;
int A[10][10];
int ans = 1000000;
int visited[11];

void go(int depth, int current, int sum){
    if(depth == n){
        if(A[current][0] == 0){
            return;
        }
        sum += A[current][0];
        ans = min(ans,sum);
        return;
    }

    for(int i = 0; i < n; i ++){
        if(visited[i] == 1 || A[current][i] == 0){
            continue;
        }
        visited[i] = 1;
        go(depth+1, i, sum + A[current][i]);
        visited[i] = 0;
    }
}

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> A[i][j];
        }
    }

    visited[0] = 1;
    go(1,0,0); 
        
  
    
    cout<< ans;
    

    return 0;
}
