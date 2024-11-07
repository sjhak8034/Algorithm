import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String,Integer> map = new HashMap<>();
        int score = 0;
        for(String e : players){
            map.put(e,score);
            score++;
        }
      
        for(String e : callings){   
            int targetIndex = map.get(e);
            map.put(e,targetIndex-1);
            map.put(players[targetIndex-1],targetIndex);
            players[targetIndex] = players[targetIndex-1];
            players[targetIndex-1] = e;
            
        }
        
        
        return players;
    }
}