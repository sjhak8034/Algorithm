import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr) {
        int size = 0;
        if (arr.length-1 == 0){
            size = 1;
        }else{
       
            size = arr.length-1;
        }
        int[] answer = new int[size];
       
        int min = Arrays.stream(arr).min().getAsInt();
        int j = 0;
        for (int i = 0; i < arr.length; i++){
            
            if (arr[i] != min){
                answer[j] = arr[i];
            }
            else{
                j --;
            }
            j++;
            
        }
        if (arr.length-1 == 0){
            answer[0] = -1;
        }
    
        return answer;
    }
}