import java.util.*;
class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer =0 ;
         List<Integer> keys = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            keys.add(i);
        }

        List<List<Integer>> results = new ArrayList<>();
        combine(keys, 5, 0, new ArrayList<>(), results); // 고정된 5개

        for (List<Integer> candidate : results) {
            boolean valid = true;
            for (int i = 0; i < q.length; i++) {
                int[] trial = q[i];
                int count = 0;
                for (int num : trial) {
                    if (candidate.contains(num)) {
                        count++;
                    }
                }
                if (count != ans[i]) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                answer++;
            }
        }

        return answer;
    }

    static void combine(List<Integer> keys, int n, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < keys.size(); i++) {
            current.add(keys.get(i));
            combine(keys, n, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
    }
