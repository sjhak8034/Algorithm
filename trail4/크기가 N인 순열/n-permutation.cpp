#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int n;
int chosen[100];
bool used[20];

void choose(int depth){
    if (depth == n){
        for (int i = 0; i < n; i++){
            cout << chosen[i] << " ";
        }
        cout << "\n";
        return;
    }

    for (int i = 1; i <= n; i++) {
        if (used[i]) continue;
        used[i] = true;
        chosen[depth] = i;       // 값이 필요하면 A[i]
        choose(depth + 1);
        used[i] = false;
    }
    
   
}

int main() {
    cin >> n;
    
    choose(0);
    

    return 0;
}
