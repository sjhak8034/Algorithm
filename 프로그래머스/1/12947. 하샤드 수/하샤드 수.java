import java.util.ArrayList;
import java.util.List;
class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        int test_x = x; 
        List<Integer> digits = new ArrayList<>();
        while (test_x != 0){
            digits.add(test_x%10 );
            test_x = test_x/10;
        }
        int sumDigits = digits.stream().mapToInt(Integer :: intValue ).sum();
        
        if(x%sumDigits == 0){
            answer = true;
        }
        
        
        return answer;
    }
}