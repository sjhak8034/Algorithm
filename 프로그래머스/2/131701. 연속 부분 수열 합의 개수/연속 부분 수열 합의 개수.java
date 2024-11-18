import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int j = 1; j <= elements.length; j++){
            for(int i = 0; i < elements.length; i ++){
                int sum = 0;
                for(int k = 0; k < j; k++){
                    int index = i+k;
                    if (index >= elements.length){
                        index -= elements.length;
                    }
                    sum += elements[index];
                }
                boolean flag = set.add(sum);
                if (flag){
                    answer +=1;
                }
            }
        }
        return answer;
    }
}