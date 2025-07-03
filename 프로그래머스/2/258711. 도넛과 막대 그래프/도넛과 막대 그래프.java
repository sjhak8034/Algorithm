import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
            // 먼저 추가된 정점이 뭔지 찾음
            int[] answer = new int[4];
            int newOne = edges[0][0];
            List<Integer> startList = new ArrayList<>();
            Map<Integer, List<Integer>> mapOut = new HashMap<>();
            Map<Integer, List<Integer>> mapIn = new HashMap<>();
            for (int[] edge : edges) {
                mapOut.putIfAbsent(edge[0], new ArrayList<Integer>());
                mapOut.putIfAbsent(edge[1], new ArrayList<Integer>());
                mapOut.get(edge[0]).add(edge[1]);
                mapIn.putIfAbsent(edge[1], new ArrayList<Integer>());
                mapIn.putIfAbsent(edge[0], new ArrayList<Integer>());
                mapIn.get(edge[1]).add(edge[0]);
            }

            for (Map.Entry<Integer, List<Integer>> entry : mapIn.entrySet()) {

                if (entry.getValue().isEmpty()) {

                    if (mapOut.get(entry.getKey()).size() >= 2) {
                        newOne = entry.getKey();
                    }


                }
            }
            // 추가된 정점기준으로 스타트 찾음
            startList.addAll(mapOut.get(newOne));
            answer[0] = newOne;
            for (int start : startList) {
                int result = propagation(mapOut, start);
                answer[result]++;
            }

            // 간선을 막힐때 까지 따라간다 (재귀 dfs)
            // 정점에 방문 횟수 저장 2번 방문 갯수 저장 0 -> 막대 1 -> 도넛 2 -> 8
            // visit한 간선은 저장
            // 간선이 막히고 결과를 저장


            return answer;
        }

        // startNode 에서 stack에 mapOut 리스트를 넣고 순회
        // startNode는 stack에 다시 추가하지않음
        // for문을 돌면서 원점으로 돌아오지않고 종료시 1, for문을 돌며 원점에 돌아올 시 0, for 문을 돌며 out 이 2개면 2를 출력
        public int propagation(Map<Integer, List<Integer>> mapOut, int startNode) {
            Stack<Integer> stack = new Stack<>();
            stack.add(startNode);
            while (!stack.isEmpty()) {
                int now = stack.pop();
                List<Integer> list = mapOut.get(now);
                if (list.size() == 2) {
                    return 3;
                }

                for (Integer next : list) {
                    if (next == startNode) {
                        return 1;
                    }
                    stack.add(next);
                }

            }
            return 2;
        }
    
}