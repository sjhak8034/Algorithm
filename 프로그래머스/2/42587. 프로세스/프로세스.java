import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queueP = new LinkedList<>();
        Queue<Integer> queueL = new LinkedList<>();
        int index = 0;
      
        for(int e : priorities){
            queueP.offer(e);
            if(index == location){
                queueL.offer(1);
            }
            else{
                queueL.offer(0);
            }
            index ++;
            
        }
        int out = 0;
        while(out != 1){
            int target = queueP.poll();
            out = queueL.poll();
            int max = Arrays.stream(priorities).max().getAsInt();
            if(target == max){
                for(int i = 0; i < priorities.length; i++){
                    if(priorities[i] == target){
                        priorities[i] = 0;
                        break;
                    }
                }
                answer +=1;
            }
            else{
                queueP.offer(target);
                queueL.offer(out);
                out = 0;
            }
        }
        return answer;
    }
}