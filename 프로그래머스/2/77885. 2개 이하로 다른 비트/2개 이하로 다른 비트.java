import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int j = 0;
        for(long number : numbers){
            String binaryString = Long.toBinaryString(number);
            int count = 0;
            for(int i = binaryString.length()-1; i >= 0 ; i--){
                if(binaryString.charAt(i) != '1'){
                    break;
                }
                count ++;
            }
            
            if(count <= 1){
                answer[j] = number+1;
            }else{
                answer[j] = number + (long)Math.pow(2L,(long)count-1);
            }
            j++;
        }
        
        
        return answer;
    }
}