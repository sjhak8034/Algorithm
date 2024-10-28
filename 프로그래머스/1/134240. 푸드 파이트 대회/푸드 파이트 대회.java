class Solution {
    public String solution(int[] food) {
        String answer = "";
        String reverse = "";
        int count = 0;
        for(int i = 1; i<food.length; i++){
            count = food[i];
            while(count/2 > 0){
                answer += i;
                reverse += i;
                count -= 2;
            }
        }
        for(int i = 0; i<food[0]; i++)
        {
            answer += "0";
        }
        reverse = new StringBuilder(reverse).reverse().toString();
        answer += reverse;
        return answer;
    }
}