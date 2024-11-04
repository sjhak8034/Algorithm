import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        char[] sortedSkip = skip.toCharArray();
        Character[] charArray = new Character[sortedSkip.length];
            for (int i = 0; i < sortedSkip.length; i++) { charArray[i] = sortedSkip[i];}
        List<Character> list = Arrays.asList(charArray);
        
        for(char e : s.toCharArray()){
            
           for(int i = 0; i < index; i++){
               e+=1;
               if (e> 'z'){
                e -= 26;
            }
               if(list.contains(e)){
                   i --;
                
               }
           }
            
          answer += e ;
          
          
        }
        return answer;
    }
}