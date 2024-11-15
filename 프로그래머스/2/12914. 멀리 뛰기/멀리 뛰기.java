class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] cases = new long[n+2];
        cases[1] = 1;
        cases[2] = 2;
        
        for(int i = 3; i < n+1; i++ ){
            cases[i] = cases[i-2] + cases[i-1];
            cases[i] %= 1234567;
        }
        return cases[n];
    }
    
}