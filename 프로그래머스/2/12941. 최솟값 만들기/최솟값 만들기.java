import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        List<Integer> arrayA = new ArrayList<>();
        for (int num : A) {
            arrayA.add(num);
        }
        List<Integer> arrayB = new ArrayList<>();
        for (int num : B) {
            arrayB.add(num);
        }
        Collections.sort(arrayA);
        Collections.sort(arrayB);
        int answer = 0;
        for(int i=0; i<arrayA.size(); i++){
            answer += arrayA.get(i) * arrayB.get(arrayB.size()-1-i);
        }
        return answer;
    }
}