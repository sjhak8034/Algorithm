import java.util.*;
class Solution {
    public int solution(String word) {
        int answer = 0;
        char[] order = {'A','E','I','O','U'};
        Map<Character, Character> map = new HashMap<>();
        map.put('A', 'E');
        map.put('E', 'I');
        map.put('I', 'O');
        map.put('O', 'U');
        StringBuilder stringbuilder = new StringBuilder();
        while(true){
            if(stringbuilder.length() < order.length){
                stringbuilder.append(order[0]);
            }
            else if(stringbuilder.length() == order.length && stringbuilder.charAt(order.length-1) == order[order.length-1]){
                for(int i = 0; i < order.length; i++){
                    if(stringbuilder.charAt(order.length - i -1) == order[order.length-1]){
                       stringbuilder.deleteCharAt(order.length - i -1);
                    }
                    else{
                        stringbuilder.replace(order.length - i -1, order.length - i,
                                String.valueOf(Character.toChars(map.get(stringbuilder.charAt(order.length - i -1)))));
                        break;
                    }
                }
            }
            else{
                stringbuilder.replace(order.length-1, order.length, String.valueOf(Character.toChars(map.get(stringbuilder.charAt(order.length-1)))));
            }
            answer ++;
            if(stringbuilder.toString().equals(word)){
                break;
            }
        }
        return answer;
    }
}