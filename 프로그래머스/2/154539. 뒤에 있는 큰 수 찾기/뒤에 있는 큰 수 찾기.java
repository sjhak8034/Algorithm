import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = numbers.length -1; i >= 0; i-- ){
            boolean isBig = false;
            while(!stack.isEmpty()){
                int now = stack.peek();
                if(now > numbers[i]){
                    answer[i] = now;
                    isBig = true;
                    stack.push(numbers[i]);
                    break;
                }
                stack.pop();
            }
            if(!isBig){
                answer[i] = -1;
                stack.push(numbers[i]);
            }
        }
        return answer;
    }
}