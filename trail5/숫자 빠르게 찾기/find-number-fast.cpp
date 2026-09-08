#include <iostream>

using namespace std;

int n, m;
int arr[100000];

int bisect_lower(int* arr,int low, int high, int target,int n){
    
    
    while(low <= high){
        int mid = (low+high)/2; 
        
        if (arr[mid] == target){
            return mid + 1;
        }

        if(arr[mid] < target){
            low = mid + 1;
        } else{
            high = mid-1;
        }
    }

    return -1;
}

int main() {
    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    for (int i = 0; i < m; i++) {
        int x;
        cin >> x;
        int answer = bisect_lower(arr,0,n,x,n);
        cout << (answer) << "\n";
    }

    

    return 0;
}
