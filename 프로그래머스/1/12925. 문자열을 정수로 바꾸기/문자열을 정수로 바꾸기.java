class Solution {
    public int solution(String s) {
        int answer = 0;
        double  count = 1;
        int sign = 1;
        int size = s.length();
        for (int i = 0; i<s.length(); i++){
            char n = s.charAt(i);
            if (n == '+'){
                sign = 1;
                
            }
            else if (n =='-'){
                sign = -1;
                
            }
            else{
                count =  Math.pow(10,(size - i-1));
                answer += sign * ((int)n - (int)'0') * count;
                
            }
        }
        return answer;
    }
}