class Solution {
    public long solution(long n) {
        long answer = 0;
        for (long i =0; i<=n; i++){
            if (i*i>n){
                answer = -1;
                break;
            }
            if (i*i == n){
                answer = (i+1)*(i+1);
                break;
            }
        }
        return answer;
    }
}