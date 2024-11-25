import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        return simulation(0, k, dungeons, new boolean[dungeons.length]);
    }

    private int simulation(int cases, int fatigue, int[][] dungeons, boolean[] visited) {
        int max = cases;
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && fatigue >= dungeons[i][0]) {  // 방문하지 않았고 최소 필요 피로도를 만족하면 탐험
                visited[i] = true;  // 방문 표시
                max = Math.max(max, simulation(cases + 1, fatigue - dungeons[i][1], dungeons, visited));
                visited[i] = false;  // 상태 복원
            }
        }
        
        return max;
    }
}

