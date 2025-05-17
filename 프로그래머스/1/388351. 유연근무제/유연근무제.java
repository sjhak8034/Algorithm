import java.util.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;
        int days = timelogs[0].length;
        int worker = 0;
        for(int[]timelog : timelogs){
            int schedule = schedules[worker];
            for(int i = 0; i < days; i++){
                if((i + startday)%7 == 0 || (i + startday)%7 == 6){
                    continue;
                }
                int hour = (timelog[i]-10)/100;
                int minute = (timelog[i]-10)%100;
                if (minute >= 60){
                    minute -= 40;
                }
                int newTime = hour * 100 + minute;
                if(newTime > schedule){
                    answer --;
                    break;
                }
            }
            worker +=1;
        }
        
        return answer;
    }
}