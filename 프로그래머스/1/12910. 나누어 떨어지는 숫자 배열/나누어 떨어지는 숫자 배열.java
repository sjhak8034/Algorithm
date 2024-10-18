import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        List<Integer>tempAnswer = new ArrayList<>();
        for (int e: arr){
            if (e%divisor == 0){
                tempAnswer.add(e);
            }
        }
        int size = tempAnswer.size();
        int[] answer = new int[size];
        if (size == 0){
            answer = new int[]{-1};
            return answer;
        }
        for (int i = 0; i < size; i++ ){
            for (int j = 0; j<size-1; j++){
                
                if (tempAnswer.get(j) > tempAnswer.get(j+1)){
                    int temp = tempAnswer.get(j);
                    tempAnswer.set(j, tempAnswer.get(j+1));
                     tempAnswer.set(j+1, temp);
                }
            }
        }
        for (int i = 0; i< size; i++){
            answer[i] = tempAnswer.get(i);
        }
        
        return answer;
    }
}