import java.util.Map;
import java.util.HashMap;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        Map<Character,Integer>map = new HashMap<>();
        answer = new int[s.length()];
        
        for (int i = 0; i<s.length();i++){
            char word = s.charAt(i);
            if (map.containsKey(word)){
                answer[i] = i-map.get(word);
            }
            else{
                answer[i] = -1;
            }
            map.put(word,i);
            
        }
        
        return answer;
    }
}