#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int main() {
    char* word = malloc(11*sizeof(char));
    scanf("%s", word);
    int len = strlen(word);
    int change = 0;
    for(int i = 0; i < len; i++){
        if(word[i] == '0'){
            word[i] = '1';
            change = 1;
            break;
        }
    }
    if(change == 0){
        word[len-1] = '0';
    }
    int answer = 0;
    int digit = 1;
    for(int i = len-1; i >= 0; i --){
        if(word[i] == '1'){
            answer += digit;
        }
        digit *= 2;
    }
    printf("%d", answer);
    return 0;
}