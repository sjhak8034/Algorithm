import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer,Integer[]> map = new HashMap<>();
        for(String record : records){
            String[] splitRecord = record.split(" ");
            String[] splitTime = splitRecord[0].split(":");
            int car = Integer.parseInt(splitRecord[1]);
            int time = Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
            if(splitRecord[2].equals("IN")){
                map.put(car,new Integer[]{map.getOrDefault(car,new Integer[]{0,0})[0] - time, map.getOrDefault(car,new Integer[]{0,0})[1] -1});
            }
            else if(splitRecord[2].equals("OUT")){
                map.put(car,new Integer[]{map.getOrDefault(car,new Integer[]{0,0})[0] + time, map.getOrDefault(car,new Integer[]{0,0})[1] +1});
            }
        }
        for(Map.Entry<Integer,Integer[]> entry : map.entrySet()){
            if(entry.getValue()[1] < 0){
                entry.setValue(new Integer[]{entry.getValue()[0] + 60*24 -1 , entry.getValue()[1] + 1});
            }
        }
        Map<Integer,Integer[]> sortedMap = new TreeMap<>(map);
        int[] answer = new int[map.size()];
        int index = 0;
        for(Map.Entry<Integer,Integer[]> entry : sortedMap.entrySet()){
            int time = entry.getValue()[0];
            time -= fees[0];
            answer[index] += fees[1];
            while (time > 0){
                time -= fees[2];
                answer[index] += fees[3];
            }
            index++;
        }
        return answer;
    }
}