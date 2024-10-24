class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int MaxMax = 0;
        int MinMax = 0;
        for(int[] e : sizes){
            int maxSide = Math.max(e[0],e[1]);
            int minSide = Math.min(e[0],e[1]);
            if(maxSide > MaxMax){
                MaxMax = maxSide;
            }
            if(minSide > MinMax){
                MinMax = minSide;
            }
        }
        answer = MinMax * MaxMax;
        return answer;
    }
}