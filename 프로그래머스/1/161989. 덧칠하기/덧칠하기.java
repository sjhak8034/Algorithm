class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int paint = 0;
        for ( int e : section){
            if(paint < e){
                paint = e  + m-1;
                answer +=1;
            }
            if (paint >= n){
                break;
            }
            
        }
        return answer;
    }
}