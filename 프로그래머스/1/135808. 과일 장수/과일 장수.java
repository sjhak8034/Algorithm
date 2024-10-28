import java.util.Arrays;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int [] sortedScore = Arrays.stream(score).sorted().toArray();
        int count = score.length;
        
        while (count >=m){
            
            answer += sortedScore[count-m]*m;
            
            count -=m;
        }
        
        return answer;
    }
}