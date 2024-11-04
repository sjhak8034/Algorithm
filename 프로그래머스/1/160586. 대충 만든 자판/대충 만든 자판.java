import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] memory = new int[26];
        int count = 0;
        for(String e : targets){
            
            for(char r : e.toCharArray()){
                int minValue = Integer.MAX_VALUE;
                if (memory[(int)r - (int)'A'] == Integer.MAX_VALUE){
                    answer[count] = -1;
                    break;
                }
                if (memory[(int)r - (int)'A'] != 0){
                    answer[count] += memory[(int)r - (int)'A'];
                    continue;
                }
                for(String t : keymap){
                    int tempMinValue = 0;
                    for(char y : t.toCharArray()){
                        tempMinValue++;
                        if (y == r){
                            if(minValue>tempMinValue){
                                minValue = tempMinValue;
                            }
                            break;
                        }
                    }
                    memory[(int)r - (int)'A'] = minValue;
                    
                }
                if (minValue == Integer.MAX_VALUE){
                    answer[count] = -1;
                    break;
                }else{
                    answer[count] += minValue;
                }
                
            }
            count ++;
        }
        return answer;
    }
}