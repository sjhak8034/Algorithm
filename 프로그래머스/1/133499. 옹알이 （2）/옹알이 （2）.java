import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        
        for(String trialWord : babbling){
            int index = 0;
            String tempword1 = "";
            while(index != trialWord.length()){
                int tempIndex = index;
                String tempword2 = tempword1;
                for(String word : words){
                    if(index+word.length()>trialWord.length() ){
                        continue;
                    }
                    if (trialWord.substring(index,index+word.length()).contains(word)){
                        tempword1 = word;
                        index += word.length();
                         break;
                        }
                
                }
                if(tempword1.equals(tempword2)){
                    break;
                }
                if(index == trialWord.length()){
                    answer +=1;
                }
                if(index == tempIndex) {
                    break;
                }
            }
        }
        return answer;
    }
}