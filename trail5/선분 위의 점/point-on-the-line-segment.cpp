#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int n, m;
int points[100000];
int st[100000], ed[100000];
int anser[100000];

int lower_bound(int target){
    int hi = n;
    int low = 0;
    int mid = 0;
    while(hi > low){
        mid = (hi+low)/2;
        if(points[mid] >= target){
            hi = mid;
        } else{
            low = mid+1;
        }
    }
    return low;
}

int upper_bound(int target){
    int hi = n;
    int low = 0;
    int mid = 0;
    while(hi > low){
        mid = (hi+low)/2;
        if(points[mid] > target){
            hi = mid;
        } else{
            low = mid+1;
        }
    }
    return low;
}

int main() {
    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        cin >> points[i];
    }

    for (int i = 0; i < m; i++) {
        cin >> st[i] >> ed[i];
    }
    sort(points, points+n);
    for(int i = 0; i < m; i++){
        int low = lower_bound(st[i]);
        int high = upper_bound(ed[i]);
  
        cout << high - low;
        cout << "\n";
        
    }
    

    return 0;
}
