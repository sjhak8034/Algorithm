import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public String[] solution(String[] strings, int n) {
        for(int j = 0; j < strings.length-1; j++){
        for(int i = 0; i < strings.length-1-j; i++){
            if(strings[i].charAt(n) > strings[i+1].charAt(n)){
                String temp = strings[i];
                strings[i] = strings[i+1];
                strings[i+1] = temp;
            }
            else if(strings[i].charAt(n) == strings[i+1].charAt(n)){
                String[] templist = Arrays.copyOfRange(strings,i,i+2);
                  Arrays.sort(templist);
                strings[i] = templist[0];
                strings[i+1] = templist[1];
                }
            }
            
        }
        
       
        return strings;
    }
}