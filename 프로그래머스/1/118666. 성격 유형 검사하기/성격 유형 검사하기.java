import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character,Integer> scoreMap = new HashMap<>();
        scoreMap.put('A',0);
        scoreMap.put('N',0);
        scoreMap.put('M',0);
        scoreMap.put('J',0);
        scoreMap.put('C',0);
        scoreMap.put('F',0);
        scoreMap.put('R',0);
        scoreMap.put('T',0);
        for(int i = 0; i< survey.length; i++){
            if(choices[i] <= 3){
                scoreMap.put(survey[i].charAt(0),scoreMap.get(survey[i].charAt(0)) + 4-choices[i]);
            }
            else if( choices[i] >= 5){
                scoreMap.put(survey[i].charAt(1),scoreMap.get(survey[i].charAt(1)) + choices[i] - 4) ;
            }
        }
        if(scoreMap.get('R') >= scoreMap.get('T')){
            answer+='R';
        }
        else{
            answer+='T';
        }
        if(scoreMap.get('C') >= scoreMap.get('F')){
            answer+='C';
        }
        else{
            answer+='F';
        }
        if(scoreMap.get('J') >= scoreMap.get('M')){
            answer+='J';
        }
        else{
            answer+='M';
        }
        if(scoreMap.get('A') >= scoreMap.get('N')){
            answer+='A';
        }
        else{
            answer+='N';
        }
        return answer;
    }
}