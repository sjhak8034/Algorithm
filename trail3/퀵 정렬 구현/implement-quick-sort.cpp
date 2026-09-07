#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int n;
int arr[100000];

void swap(int* arr, int a, int b){
    int temp = 0;
    temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}

int partician(int*arr, int high,int low){
    int i = low-1;
    int pivot = 0;
    if (high - low + 1 <= 3){
        pivot = high;
    } else{
        int mid = (high - low)/2;
        pivot = max(min(high,low), min(max(high,low), mid));
    }
    swap(arr,pivot,high);
    for (int j = i+1; j<high; j++){
        if (arr[j] < arr[high]){
            i++;
            swap(arr,i,j);
        }
    }
    swap(arr,i+1,high);

    return i+1;
}

void quicksort(int* arr, int high, int low){
    if (low< high){
        int pos = partician(arr, high, low);

        quicksort(arr, pos-1, low);
        quicksort(arr, high, pos+1);
    }
}


int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    quicksort(arr,n-1,0);
    for (int i = 0; i < n; i++){
        cout << arr[i] <<" ";
    }
    return 0;
}
