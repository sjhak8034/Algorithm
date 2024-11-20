import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> mapClothes = new HashMap<>();
        for(String[] e : clothes){
            mapClothes.put(e[1], mapClothes.getOrDefault(e[1],0) + 1);
        }
        for(Map.Entry<String, Integer> entry : mapClothes.entrySet()){
            answer *= entry.getValue()+1;
        }
        answer -= 1;
        return answer;
    }
}