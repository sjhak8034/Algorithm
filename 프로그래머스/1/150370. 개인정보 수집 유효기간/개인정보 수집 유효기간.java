import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
      
        List<Integer> result = new ArrayList<>();
        Map<String,Integer> termMap = new HashMap<>();
        for(String e : terms){
            termMap.put(e.split(" ")[0],Integer.parseInt(e.split(" ")[1]));
        }
        int todayYear = Integer.parseInt(today.split("\\.")[0]);
        int todayMonth = Integer.parseInt(today.split("\\.")[1]);
        int todayDay = Integer.parseInt(today.split("\\.")[2]);
        int i = 0;
        for(String e : privacies){
            String date = e.split(" ")[0];
            String contract = e.split(" ")[1];
            int dueYear = Integer.parseInt(date.split("\\.")[0]);
            int dueMonth = Integer.parseInt(date.split("\\.")[1]) + termMap.get(contract) ;
            int dueDay = Integer.parseInt(date.split("\\.")[2])-1;
            if(dueDay == 0){
                dueDay = 28;
                dueMonth--;
            }
            while(dueMonth >12){
                dueMonth -= 12;
                dueYear += 1;
            }
            
           
            if (todayYear > dueYear){

                result.add(i+1);
            }
            else if (todayYear == dueYear && todayMonth > dueMonth ){

                result.add(i+1);
            }
            else if (todayYear == dueYear && todayMonth == dueMonth &&  todayDay > dueDay){

                result.add(i+1);
            }
            i++;
        }

        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}