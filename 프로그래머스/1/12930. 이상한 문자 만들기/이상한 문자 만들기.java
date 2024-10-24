class Solution {
    public String solution(String s) {
        String answer = "";
        int i = 0;
        for(char e : s.toCharArray()){
            if (e == ' ')
            {
                answer += e;
                i = 0;
                continue;
            }
            
            if ((i)%2 == 0){
                answer += Character.toUpperCase(e);
            }
            else{
                answer+=Character.toLowerCase(e);
            }
            
            
            i++;
        }
        return answer;
    }
}