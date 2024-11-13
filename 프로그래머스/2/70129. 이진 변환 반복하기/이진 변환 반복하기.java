import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int sizeDiff = 10;
        int[] change;
        String[] temp = s.split("");
        change = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
       
        
        while (change.length != 1){
            int size1 = change.length;
            
            change = Arrays.stream(change).filter(x -> x!=0).toArray();
            int size2 = change.length;
            sizeDiff = size1 - size2;
            int sum = Arrays.stream(change).sum();
            change = Arrays.stream(Integer.toBinaryString(sum).split("")).mapToInt(Integer::parseInt).toArray();         
            
            
            answer[1] += sizeDiff;
            answer[0] +=1;
        }
        
        return answer;
    }
}