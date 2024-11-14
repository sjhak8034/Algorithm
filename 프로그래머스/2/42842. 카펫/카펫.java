class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer;
        int sum = brown + yellow;
        int limit = sum;
        int min = 0;
        for(int i = 1; i <= sum; i++){
            if (limit <= i-1){
                break;
            } 
            if(sum%i == 0){
                if(brown == i*2 + sum/i*2 - 4){
                    min = i;
                    break;
                }
            }
        }
        
        answer = new int[] {Math.max(sum/min,min),Math.min(sum/min,min)};
        return answer;
    }
}