import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int[] leftUnique = new int[topping.length];
    int[] rightUnique = new int[topping.length];
    
    Set<Integer> leftSet = new HashSet<>();
    Set<Integer> rightSet = new HashSet<>();

    // 왼쪽에서 오른쪽으로 고유 토핑 개수 계산
    for (int i = 0; i < topping.length; i++) {
        leftSet.add(topping[i]);
        leftUnique[i] = leftSet.size();
    }

    // 오른쪽에서 왼쪽으로 고유 토핑 개수 계산
    for (int i = topping.length - 1; i >= 0; i--) {
        rightSet.add(topping[i]);
        rightUnique[i] = rightSet.size();
    }

    // 왼쪽과 오른쪽의 고유 토핑 개수를 비교하여 조건 만족 개수 계산
    int answer = 0;
    for (int i = 0; i < topping.length - 1; i++) {
        if (leftUnique[i] == rightUnique[i + 1]) {
            answer++;
        }
    }

    return answer;
    }
}