import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> trucks = new LinkedList<>();
        for(int truck : truck_weights){
            trucks.offer(truck);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++){
            queue.offer(0);
        }
        int sum = 0;
        while(!queue.isEmpty()){
            answer ++;
            sum -= queue.poll();
            int target = weight - sum;
            if(!trucks.isEmpty()&&target >= trucks.peek()){
                target = trucks.peek();
                queue.offer(trucks.poll());
            } else if (trucks.isEmpty()) {
                target = 0;
            } else{

                queue.offer(0);
                target = 0;
            }
            sum += target;

        }
        return answer;
    }
}