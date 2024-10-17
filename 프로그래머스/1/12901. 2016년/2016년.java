import java.util.HashMap;
import java.util.Map;
class Solution {
    public String solution(int a, int b) {
        String answer = "";
        Map<Integer,Integer> calendar = new HashMap<>();
        calendar.put(1, 31);
        calendar.put(2, 29);
        calendar.put(3, 31);
        calendar.put(4, 30);
        calendar.put(5, 31);
        calendar.put(6, 30);
        calendar.put(7, 31);
        calendar.put(8, 31);
        calendar.put(9, 30);
        calendar.put(10, 31);
        calendar.put(11, 30);
        calendar.put(12, 31);
        
        int days = -1;
        
        for (int i = 1; i<a; i++){
            days += calendar.get(i);
            
        }
        days += b;
        days = days%7;
        switch(days){
            case  0:
                answer = "FRI";
                break;
            case  1:
                answer = "SAT";
                break;
            case  2:
                answer = "SUN";
                break;
            case  3:
                answer = "MON";
                break;
            case  4:
                answer = "TUE";
                break;
            case  5:
                answer = "WED";
                break;
            case  6:
                answer = "THU";
                break;
                
        }
        
        return answer;
    }
}