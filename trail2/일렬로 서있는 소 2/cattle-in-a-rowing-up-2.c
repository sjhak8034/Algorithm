#include <stdio.h>
#define MAXN 100
int cow[MAXN];

void dfs(int depth, int n, int lastIndex, int* answer){

    if(depth == 3){
        (*answer) ++;
    }
    int lastValue = 0;
    if(lastIndex == -1){
        lastValue = 0;
    } else{
        lastValue = cow[lastIndex];
    }
    for(int i = lastIndex + 1; i < n; i++){
        if(cow[i] >= lastValue){
  
            dfs(depth+1, n, i, answer);
        }
    }
}

int main() {
    // Please write your code here.
    int n;
    scanf("%d", &n);
    for(int i = 0; i < n; i++){
        scanf("%d", &cow[i]);
    }
    int answer;
    dfs(0,n,-1,&answer);
    printf("%d" ,answer);
    return 0;
}