class Solution {
    public String solution(String s) {
        String answer = "";
        char[] temp = new char[s.length()] ;
        for (int i = 0 ; i<s.length();i++){
            temp[i] = s.charAt(i);
        }
        char tempchar;
        
        for (int i = 0 ; i<s.length();i++){
            for(int j = 0 ; j<s.length()-i-1;j++){
                
                if (temp[j]  <temp[j+1] ){
                    tempchar = temp[j];
                    temp[j] = temp[j+1];
                    temp[j+1] = tempchar;
                }
            }
        }
        for (int i = 0 ; i<s.length();i++){
            answer += temp[i];
        }
        
        return answer;
    }
}