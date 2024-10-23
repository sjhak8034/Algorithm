class Solution {
    public int solution(int n) {
        int answer = 0;
        String n3 = Integer.toString(n,3);
        String temp = "";
        for(int i = n3.length()-1; 0<=i;i --){
            temp += n3.charAt(i);
        }
        answer = Integer.parseInt(temp,3);
        
        return answer;
    }
}