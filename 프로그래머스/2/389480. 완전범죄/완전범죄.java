import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        final int INF = Integer.MAX_VALUE / 2;

        // B 쪽 배열 크기를 불필요하게 크게 만들지 않도록 최댓값 한 번 더 절삭
        int maxPossibleB = 3 * info.length;          // b_i ≤ 3
        int M = Math.min(m, maxPossibleB + 1);        // 실제 쓸 dp 길이

        int[] dp = new int[M];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int[] item : info) {
            int aTrace = item[0];
            int bTrace = item[1];

            int[] next = new int[M];
            Arrays.fill(next, INF);

            for (int b = 0; b < M; b++) {
                if (dp[b] == INF) continue;

                // ① A가 훔친다
                int newA = dp[b] + aTrace;
                if (newA < n) {
                    next[b] = Math.min(next[b], newA);
                }

                // ② B가 훔친다
                int newB = b + bTrace;
                if (newB < M) {
                    next[newB] = Math.min(next[newB], dp[b]);
                }
            }
            dp = next;
        }

        int ans = INF;
        for (int b = 0; b < M && b < m; b++) {
            ans = Math.min(ans, dp[b]);
        }
        return (ans == INF) ? -1 : ans;
    }
}