import java.util.Arrays;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] temp = new int [k];
        for(int i = 0; i < k; i++){
            temp[i] = -1;
        }
        int min = 0;
        
        int tempMinIndex = 0;
        for(int i = 0; i< score.length; i++){
            int tempMin = 999999;
            if (score[i] >= min){
               for(int j = 0; j<k; j++){
                   if (temp[j] < tempMin){
                       tempMin = temp[j];
                       tempMinIndex = j;
                   }                                   
               }
                temp[tempMinIndex] = score[i];
                min = Arrays.stream(temp).min().getAsInt();
            }
        
            answer[i] = Arrays.stream(temp).filter(e -> e != -1).min().getAsInt();
            
        }
        return answer;
    }
}