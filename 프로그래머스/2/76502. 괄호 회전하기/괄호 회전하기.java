import java.util.*;
class Solution {
    public int solution(String s) {
    
        int answer = 0;
       
        
        for(int i = 0; i < s.length(); i++ ){
            Stack<Character> stack = new Stack<>();
            for(int j = i; j < s.length()+i; j++){
                int index = j;
                if (index >= s.length()){
                    index -= s.length();
                }
                if(s.charAt(index) == '{' ||s.charAt(index) == '(' ||s.charAt(index) == '[' ){
                    stack.push(s.charAt(index));
                }
                if(s.charAt(index) == '}' ||s.charAt(index) == ')' ||s.charAt(index) == ']' ){
                    if(stack.isEmpty()){
                        stack.push(s.charAt(index));
                        break;
                    }
                    char compare = stack.pop();
                    if(-3<compare-s.charAt(index) && compare-s.charAt(index) < 3){
                        continue;
                    }
                    else{
                        stack.push(s.charAt(index));
                        break;
                    }
                }
            }
            if(stack.isEmpty()){
                answer ++;
            }
        }
        return answer;
        
        
    }
}