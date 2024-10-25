import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int count = 0;
        for (int[]e : commands){
        
            int[] slicedArray = Arrays.copyOfRange(array,e[0]-1,e[1]);
            Arrays.sort(slicedArray);
            answer[count] = slicedArray[e[2]-1];     
            count ++;
        }
        return answer;
    }
}