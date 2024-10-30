import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Queue<String> newCards1 = new LinkedList<>();
        Queue<String> newCards2 = new LinkedList<>();
        for(String e : cards1){
            newCards1.offer(e);
        }
        for(String e : cards2){
            newCards2.offer(e);
        }
        int check = 0 ;
        for(String e : goal){
            
            if (e.equals(newCards1.peek())){
                check += 1;
                newCards1.poll();
            }
            if (e.equals(newCards2.peek())){
                check += 1;
                newCards2.poll();
            }
        }
        if (check == goal.length){
            answer = "Yes";
        } 
        else{
            answer = "No";
        }
        return answer;
    }
}