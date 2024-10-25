import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> tempAnswer = new HashSet<>();
        
        for(int i = 0; i<numbers.length;i++){
            for(int j = i+1; j<numbers.length; j++){
            tempAnswer.add(numbers[i] + numbers[j]);
            }
            
        }
        int[] answer = new int[tempAnswer.size()];
        int count = 0;
        for(int e: tempAnswer){
            answer[count] = e;
            count ++;
        }
        Arrays.sort(answer);
        return answer;
    }
}