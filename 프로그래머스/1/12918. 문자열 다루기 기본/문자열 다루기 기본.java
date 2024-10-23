class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if (s.length() != 4 && s.length() != 6){
            return false;
        }
        
        for (int i = 0; i<s.length(); i ++){
            if ( Character.valueOf('0')   <= s.charAt(i) &&  s.charAt(i) <= Character.valueOf('9')  ){
                continue;
            }
            else{
                
                answer =  false;
                break;
            }
        
        }
        return answer;
    }
}