import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int max = Arrays.stream(citations).max().getAsInt();
        int[] arr = new int[max+1];
        for(int e : citations){
            for(int i = 0; i < max+1; i++){
                if(e >= i){
                    arr[i] +=1;
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] >= i){
                answer = i;
            }           
        }
        
        return answer;
    }
}