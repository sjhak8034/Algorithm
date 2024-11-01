import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] divisors = new int[number];
        int count = 0;
        for(int i = 1; i <= number; i++){
            int limitNum = i;
            count = 0;
            for(int j = 1; j<=limitNum ; j++){
                if (i%j == 0){
                    if( i/j-1 >= j){
                        count +=2;
                    }
                    else{
                        count+=1;
                    }
                    limitNum = i/j-1;
                }
                
            }
            divisors[i-1] = count;
        }
        answer = Arrays.stream(divisors).map(e -> e > limit ? power : e).sum();
    
        return answer;
    }
}