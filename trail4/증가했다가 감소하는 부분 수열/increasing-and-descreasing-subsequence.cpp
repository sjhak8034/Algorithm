#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int n;
int sequence[1000];
int up[1000];
int down[1000];

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> sequence[i];
        up[i] = 1;
        down[i] = 1; 
    }

    for(int i = 0; i < n; i++){
        for(int j = 0; j < i; j++){
            if(sequence[i] > sequence[j]){
                up[i] = max(up[i],up[j] + 1);
            }
            
        }
        
    }
    for(int i = n-1; i >= 0; i--){
        for(int j = i+1; j < n; j++){
            if(sequence[i] > sequence[j]){
                down[i] = max(down[i],down[j] + 1);
            }
        }
       
    }
    int ans = 0;
    for(int i = 0; i < n; i++){
        ans = max(up[i] + down[i] - 1, ans);
    }
    
   
    cout<<ans;

    return 0;
}
