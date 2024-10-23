
class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int min = Math.min(n,m);
        int max = Math.max(n,m);
        for(int i = 1; i<=min; i++){
            if(n%i == 0 && m%i == 0){
                answer[0] = i;
            }
        }
        int count = max;
        while(true){
            if(count % n == 0 && count % m == 0){
                answer[1] = count;
                break;
            }
           count++;
        }
        return answer;
    }
}