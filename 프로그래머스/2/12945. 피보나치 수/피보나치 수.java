import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> F = new ArrayList<>();
        F.add(0);
        F.add(1);
        for(int i = 2; i <= n; i++){
            F.add((F.get(i-2) + F.get(i-1))%1234567);
        }
        answer = F.get(n);
        return answer;
    }
}