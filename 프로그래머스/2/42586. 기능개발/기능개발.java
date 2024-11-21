import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> listAns = new ArrayList<>();
        List<Integer> convert = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> speedsQ = new LinkedList<>();
        for(int e : progresses){
            queue.offer(e);
        }
        for(int e : speeds){
            speedsQ.offer(e);
        }
        int day = 0;
        while(queue.size() != 0){
            day +=1; 
            while(queue.size() != 0){
                int target = queue.peek();
                int speed = speedsQ.peek();
                target += day * speed;
                if(target >= 100){
                    listAns.add(day);
                    queue.poll();
                    speedsQ.poll();
                }
                else{
                    break;
                }
            }
            
        }
        
        for(int i = 0; i < listAns.size(); i++){
            int element = 1;
            
            if(i +1 >= listAns.size()){
                convert.add(1);
                    break;
                }
        
            int j = i;
            while(listAns.get(j) == listAns.get(j+1)){
                element +=1;
                j++;
                if(j+1 >= listAns.size()){
                    break;
                }
                
            }
            i = j;
            convert.add(element);
        }
        int[] answer = new int[convert.size()];
        for(int i =0; i<convert.size(); i++){
            answer[i] = convert.get(i);            
        }
        return answer;
    }
}