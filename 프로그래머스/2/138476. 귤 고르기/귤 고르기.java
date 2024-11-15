import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer>numbers = new HashMap<>();
        for(int e: tangerine){
            numbers.put(e,numbers.getOrDefault(e,0)+1);
        }
         Integer[] numberList = new Integer[numbers.size()];
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : numbers.entrySet()){
            numberList[count] = entry.getValue();
            count+=1;
        }
        Arrays.sort(numberList, Collections.reverseOrder());
        count = 0;
        for(int e : numberList){
            answer +=1;
            count += e;
            if(count >= k){
                break;
            }
        }
        return answer;
    }
}