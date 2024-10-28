class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int bottle = 0;
        bottle = n;
        while(bottle >= a){
            answer += b*(bottle/a);
            bottle = b*(bottle/a) + bottle % a; 
        }
        
        return answer;
    }
}