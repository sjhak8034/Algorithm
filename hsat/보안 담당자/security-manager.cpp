#include <iostream>
#include <string>
#include <bits/stdc++.h>

using namespace std;

int N;
string records;
int dp[5001];


int main() {
    cin >> N;
    cin >> records;

    if(records.size()%2 == 1){
        cout << "No";
        return 0;
    }
    
    int questionNum = 0;
    memset(dp, 0, sizeof(dp));
    for(int i = 1; i <= N; i++){
        dp[i] = dp[i-1];
        dp[i] += (records[i-1] == '(' ? 1 : 0);
        dp[i] += (records[i-1] == ')' ? -1 : 0);
        questionNum +=  (records[i-1] == '?' ? 1 : 0);
    
    }
  
    int inNum = (questionNum-dp[N])/2;
    int outNum = (questionNum-dp[N])/2 + dp[N];

    
    
    for(int i = 1; i <=N; i++){
        dp[i] = dp[i-1];
        if(records[i-1] == '?' && inNum != 0){
           
            dp[i] ++;
            inNum--;
        } else if(records[i-1] == '?' && inNum == 0){
        
            dp[i] --;
        } else{
            dp[i] += records[i-1] == '(' ? 1 : 0;
            dp[i] += records[i-1] == ')' ? -1 : 0;
        }
       
        if(dp[i] < 0){
            cout << "No";
            return 0;
        }
    }
    if(dp[N] != 0){
        cout << "No";
        return 0;
    }
    cout << "Yes";



    // for(int i = N-1; i >= 0; i--){
    //     if(dp[i] < 0 && records[i] == '?'){
    //         int k = dp[i];
    //         while(k != 0){
    //             if(records[i] == '?'){
    //                 records[i]
    //             }

    //             i--;
    //             k++;
    //         }
    //     }
    // }

    return 0;
}
