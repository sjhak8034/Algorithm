import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        Map<Integer,Integer>LCM = new HashMap<>();
        
        for(int e: arr){
            int now = e;
            Map<Integer,Integer>currentMap = new HashMap<>();
            while(now != 1){
                
                int count = 2;
                while(now%count != 0){
                    count ++;
                }
                now/= count;
                currentMap.put(count,currentMap.getOrDefault(count, 0)+1);
            }
            for(Map.Entry<Integer, Integer> entry : currentMap.entrySet()){
                if (entry.getValue()>LCM.getOrDefault(entry.getKey(),0)){
                    LCM.put(entry.getKey(),entry.getValue());
                }
            }
        }
        for(Map.Entry<Integer, Integer> entry : LCM.entrySet()){
                for(int i = 0; i < entry.getValue(); i++){
                    answer *= entry.getKey();
                }
            }
        return answer;
    }
}