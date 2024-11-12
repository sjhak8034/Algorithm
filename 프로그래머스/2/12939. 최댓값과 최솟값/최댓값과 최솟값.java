import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        int[] arrayS = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[]sorted = Arrays.stream(arrayS).sorted().toArray();
        answer += sorted[0] + " " + sorted[sorted.length-1];
        return answer;
    }
}