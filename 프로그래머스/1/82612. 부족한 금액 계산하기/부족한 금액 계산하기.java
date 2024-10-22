class Solution {
    public long solution(int price, int money, int count) {
        long answer ;
        long amount = 0;
        for(int i = 1; i<=count; i++){
            amount +=(long) price * i;
        }
        if (money > amount){
            answer = 0;
        }
        else{
            answer = amount - money;
        }
        return answer;
    }
}