import java.util.*;

class Solution {
    public int solution(int[] info, int[][] edges) {
        Tree tree = new Tree(info, edges);

        return tree.max();
    }

    public static class Tree{
        int[][] index;
        int size;
        public Tree(int[] info, int[][] edges){
            this.index = new int[10][2];
            this.size = info.length;
            build(info, edges);
        }

        public void build(int[] info, int[][] edges) {
            this.index[0][0] = 0;
            this.index[0][1] = info[0];
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            boolean[] visited = new boolean[info.length];
            visited[0] = true;
            while (!q.isEmpty()) {
                int current = q.poll();

                reSize(current);


                for (int[] edge : edges) {

                    if (Arrays.equals(this.index[current * 2 + 1], new int[]{0, 0})) {
                        if (edge[0] == index[current][0]) {
                            if (visited[edge[1]]) {
                                continue;
                            }
                            visited[edge[1]] = true;
                            q.add(current*2 + 1);
                            this.index[current * 2 + 1][0] = edge[1];
                            this.index[current * 2 + 1][1] = info[edge[1]];
                        } else if(edge[1] == index[current][0]) {
                            if (visited[edge[0]]) {
                                continue;
                            }
                            visited[edge[1]] = true;
                            q.add(current*2 + 1);
                            this.index[current * 2 + 1][0] = edge[0];
                            this.index[current * 2 + 1][1] = info[edge[0]];
                        }

                    } else {
                        if (edge[0] == index[current][0]) {
                            if (visited[edge[1]]) {
                                continue;
                            }
                            visited[edge[1]] = true;
                            q.add(current*2 + 2);
                            this.index[current * 2 + 2][0] = edge[1];
                            this.index[current * 2 + 2][1] = info[edge[1]];
                        } else if(edge[1] == index[current][0]) {
                            if (visited[edge[0]]) {
                                continue;
                            }
                            visited[edge[1]] = true;
                            q.add(current*2 + 2);
                            this.index[current * 2 + 2][0] = edge[0];
                            this.index[current * 2 + 2][1] = info[edge[0]];

                        }

                    }
                }
            }
        }

        private int max(){
            List<Integer> canVisit = new ArrayList<>();
            canVisit.add(0);
            return dfs(0,0,canVisit, 0);
        }
          private int dfs(int sheep, int wolf, List<Integer> canVisit, int max) {
            // 기저 조건: 늑대 수가 양 이상이면 종료
            if (sheep <= wolf && sheep != 0) {
                return Math.max(max, sheep);
            }

            int currentMax = Math.max(max, sheep);

            for (int node : canVisit) {
                List<Integer> nextCanVisit = new ArrayList<>(canVisit);
                nextCanVisit.remove(Integer.valueOf(node));  // 현재 노드 제거

                // 자식 노드 추가 (왼쪽, 오른쪽 자식)
                int left = 2 * node + 1;
                int right = 2 * node + 2;
                if (!Arrays.equals(index[left], new int[]{0, 0})) {
                    nextCanVisit.add(left);
                }
                if (!Arrays.equals(index[right], new int[]{0, 0})) {
                    nextCanVisit.add(right);
                }

                // 현재 노드가 양인지 늑대인지에 따라 다음 상태 분기
                int nextSheep = sheep;
                int nextWolf = wolf;
                if (index[node][1] == 0) nextSheep++;
                else nextWolf++;

                int result = dfs(nextSheep, nextWolf, nextCanVisit, currentMax);
                currentMax = Math.max(currentMax, result);
            }

            return currentMax;
        }


        private void reSize(int current) {
            if(current*2 +2 >= index.length){
                int[][] temp = index.clone();
                index = new int[(current*2 +1)*2][2];
                for(int i = 0; i < temp.length; i++){
                    index[i][0] = temp[i][0];
                    index[i][1] = temp[i][1];
                }
            }
        }


    }

}