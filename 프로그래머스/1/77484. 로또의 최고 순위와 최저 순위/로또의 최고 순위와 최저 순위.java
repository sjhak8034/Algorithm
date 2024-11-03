import java.util.*;

import java.util.stream.Collectors;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int max = 7;
        int min = 7;
        List<Integer> list = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        for(int e : lottos){
            if (e == 0){
                max -=1;
                
            }
            else if (list.contains(e)){
        
                max-=1;
                min-=1;
                    
            }
        }
        if (max > 6){
            max = 6;
        }
        if (min > 6){
            min = 6;
        }
        int[] answer = {max,min};
        
        return answer;
    }
}