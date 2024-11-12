import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String,Set<String>>reportNameMap = new HashMap<>();
        Map<String,Integer>reportScoreMap = new HashMap<>();
        for(String e : id_list){
            reportNameMap.put(e,new HashSet<String>());
            reportScoreMap.put(e,0);
        }
        
        for(String e: report){
            String[] arrayOfReport = e.split(" ");
            Set<String>set = reportNameMap.get(arrayOfReport[0]);
            boolean result = set.add(arrayOfReport[1]);
            if (result){
                reportScoreMap.put(arrayOfReport[1],reportScoreMap.get(arrayOfReport[1])+1);
            }
        }
         
        for(int i = 0 ; i < id_list.length; i++){
            Set<String>set = reportNameMap.get(id_list[i]);
            for(String e : set){
                if (reportScoreMap.get(e) >= k){
                    answer[i] +=1;
                }
            }
        }
       
        return answer;
    }
}