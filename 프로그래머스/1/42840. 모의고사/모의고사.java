import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1,e2) -> {if (e1[1] == e2[1]){return e1[0] - e2[0];}return e2[1]-e1[1];});
        int[] person1_result = {1,0};
        int[] person2_result = {2,0};
        int[] person3_result = {3,0};
        for(int i = 0; i<answers.length; i++ ){
            if (person1[i%person1.length] == answers[i]){
                person1_result[1] += 1;
            }
            if (person2[i%person2.length] == answers[i]){
                person2_result[1] += 1;
            }
            if (person3[i%person3.length] == answers[i]){
                person3_result[1] += 1;
            }
        }
   
        pq.offer(person1_result);
        pq.offer(person2_result);
        pq.offer(person3_result);
       
        ArrayList<Integer> tempanswer = new ArrayList<>();
        int maxNum = pq.peek()[1]; 
        
        for(int i = 0; i<3; i++){
            if (pq.peek()[1] == maxNum){
                tempanswer.add(pq.poll()[0]);
            }
            
        }
        int[] answer = new int[tempanswer.size()];
        for(int i =0; i<tempanswer.size(); i++ ){
            answer[i] = tempanswer.get(i);
        }
    
        return answer;
    }
}