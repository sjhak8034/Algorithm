import java.util.HashSet;
import java.util.Set;
class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        Set<Integer> temp =new HashSet<>();
        for (int i = 0; i<numbers.length; i++){
            temp.add(numbers[i]);
        }
        for (int e: temp){
            answer -= e;
        }
        return answer;
    }
}