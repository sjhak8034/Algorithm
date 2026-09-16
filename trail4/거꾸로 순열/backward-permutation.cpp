#include <iostream>

using namespace std;

int n;
int visited[20];
int chosen[20];

void choose(int depth){
    if(depth == n){
        for(int i = 0; i < n; i++){
            cout << chosen[i] << " ";
        }
        cout << "\n";
    }
    for(int i = n; i >= 1; i--){
        if(visited[i] == 1){
            continue;
        }
        chosen[depth] = i;
        visited[i] = 1;
        choose(depth+1);
        visited[i] = 0;
    }
}

int main() {
    cin >> n;

    choose(0);

    return 0;
}
