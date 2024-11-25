import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        List<int[]> dungeonsList = new ArrayList<>(Arrays.asList(dungeons));
        Queue<int[]> queue = new LinkedList<>(dungeonsList);
        int answer = simulation(0, queue, k, 0 );
        return answer;
    }

     private int simulation(int cases, Queue<int[]> dungeons, int fatigue, int max) {
        int  next = 0;
        int size = dungeons.size();
        if (size == 0) {
            return cases;
        }
        for(int i = 0; i < size; i++) {
            int[] now = dungeons.poll();
            if(fatigue >= now[0]){
                fatigue -= now[1];
                cases += 1;
                next = simulation(cases, dungeons, fatigue, max);
                fatigue += now[1];
                cases -= 1;
            } else {
                next = simulation(cases, dungeons, fatigue, max);
            }

            max = Math.max(max, next);

            dungeons.offer(now);

        }
        return max;
    }
}

