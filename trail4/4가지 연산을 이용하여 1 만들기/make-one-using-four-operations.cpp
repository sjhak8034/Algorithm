#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int N;

queue<pair<int,int>> q;

int visited[2000000];

int main() {
    cin >> N;

    q.push(make_pair(N,0));
   
    while(!q.empty()){
        
        int num,level;
        tie(num,level) = q.front();
        q.pop();
        if(visited[num] == 1){
            continue;
        }
        visited[num] = 1;
        if(num == 1){
            cout << level;
            return 0;
        }
        
        

        q.push(make_pair(num-1,level+1));
        q.push(make_pair(num+1,level+1));
        if(num % 2 == 0){
            q.push(make_pair(num/2,level+1));
        }
        if(num%3 == 0){
            q.push(make_pair(num/3,level+1));
        }

    } 
    

    return 0;
}
