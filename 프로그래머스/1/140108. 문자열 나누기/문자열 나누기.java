class Solution {
    public int solution(String s) {
        int answer = 1;
        int startIndex = 0;
        while(startIndex < s.length()){
            int countSame = 0;
            int countDifferent = 0;
            char x = s.charAt(startIndex);
            for ( int i = startIndex; i < s.length(); i ++){
                
                startIndex = i+1;
                if (x == s.charAt(i)){
                    countSame ++;
                }
                else{
                    countDifferent++;
                }
                if (countSame == countDifferent ){
                    if (i != s.length() -1){
                        answer +=1;
                    }
                    
                    break;
                }
            }
        }
        return answer;
    }
}