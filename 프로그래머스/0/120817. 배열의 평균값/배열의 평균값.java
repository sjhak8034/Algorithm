class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        for (int e : numbers){
            answer += e;
        }
        answer = answer/numbers.length;
        return answer;
    }
}