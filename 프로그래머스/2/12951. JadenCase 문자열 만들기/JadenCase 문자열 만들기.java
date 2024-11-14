import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        s = s + "e";
        String[] arr = s.split(" ");
        
        for(String e : arr){
            if (e.equals("")){
                answer.append(" ");
                continue;
            }
            String word = e.toLowerCase();
            answer.append(Character.valueOf(word.charAt(0)).toString().toUpperCase() + word.substring(1)+ " "); 
        }
        answer = new StringBuilder(answer.substring(0, answer.length() - 2));
        return answer.toString();
        
    }
}