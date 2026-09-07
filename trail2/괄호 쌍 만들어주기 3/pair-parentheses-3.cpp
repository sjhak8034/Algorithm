#include <iostream>
#include <string>

using namespace std;

string A;

int main() {
    cin >> A;
    int answer = 0;
    for(int i = 0; i < A.length(); i++){
        if (A[i] == '('){
            for(int j = i+1; j < A.length(); j++){
                if(A[j] == ')'){
                   answer ++; 
                }
            }
        }
    }
    cout <<answer;
 
    return 0;
}