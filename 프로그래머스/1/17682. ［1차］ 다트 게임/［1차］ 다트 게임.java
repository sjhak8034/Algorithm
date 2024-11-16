import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        List<Integer> score = new ArrayList<>();
        int count = 0;
        for(char e : dartResult.toCharArray()){
            int size = score.size()-1;
            if (Character.isDigit(e)){
                if (e == '1'){
                    if (dartResult.charAt(count+1) == '0'){
                        score.add(10);
                        count ++;
                        continue;
                    }
                }
                else if (e == '0'){
                    if (count == 0){
                        score.add(Integer.parseInt(e+""));
                        count ++;
                        continue;
                    }
                    if (dartResult.charAt(count-1) == '1'){
                        count ++;
                        continue;
                    }
                }
                score.add(Integer.parseInt(e+""));
                
                
            }
            else if(e == 'S'){
                score.set(size,score.get(size));
            }
            else if(e == 'D'){
              
                score.set(size,(int)Math.pow(score.get(size),2));
            }
            else if(e == 'T'){
            
                score.set(size,(int)Math.pow(score.get(size),3));
            }
            else if(e == '#'){
                score.set(size,score.get(size)*-1);
            }
            else if(e == '*'){
                if(size == 0){
                    score.set(size,score.get(size)*2);
                    count ++;
                    continue;
                }
                for(int i = size-1; i <= size; i++){
                    score.set(i,score.get(i)*2);
                }
            }
            count ++;
        }
        answer = score.stream().mapToInt(Integer::intValue).sum();
        return answer;
    }
}