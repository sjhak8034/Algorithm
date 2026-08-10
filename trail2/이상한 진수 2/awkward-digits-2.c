#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define MAX(a,b)((a) > (b) ? (a) : (b));
int main() {
    char* word = malloc(11*sizeof(char));
    scanf("%s", word);
    int len = strlen(word);
    int change = 0;
    
    int digit = 1;
    int sum = 0;
    int answer = 0;
    for(int i = len-1; i >= 0; i --){
        if(word[i] == '1'){
            sum += digit;
        }
        digit *= 2;
    }
    int temp = sum;
    digit = 1;

    for(int i = len-1; i >= 0; i--){
        if(word[i] == '0'){
            sum += digit;
        } else{
            sum -= digit;
        }
        digit *= 2;
        answer = MAX(answer, sum);
        sum = temp;
    }
 
    printf("%d", answer);
    return 0;
}