class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(char e : s.toCharArray()){
            if (e == ' '){
                answer += ' ';
            }
            else{
                int newChar = e+n;
                if (e <='Z'){
                    if (newChar > (int)'Z'){
                    newChar = (e+n-'Z'-1) + 'A';
                    }
                    answer += (char)(newChar);
                }
                if (e <='z'&& e >= 'a'){
                    if (newChar > (int)'z'){
                    newChar = (e+n-'z'-1) + 'a';
                    }
                    answer += (char)(newChar);
                    
                }
            }
        }
        return answer;
    }
}