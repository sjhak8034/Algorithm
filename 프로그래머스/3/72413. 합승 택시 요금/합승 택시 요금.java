import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

    class Solution {
        public int solution(int n, int s, int a, int b, int[][] fares) {
            List<Vertex>[] vertexList = new ArrayList [n + 1];
            for(int i = 1; i < n+1; i++) {
                vertexList[i] = new ArrayList ();
            }

            for(int i = 0; i < fares.length; i++){
                int start = fares[i][0];
                int end = fares[i][1];
                int cost = fares[i][2];
                vertexList[start].add(new Vertex(end,cost));
                vertexList[end].add(new Vertex(start,cost));
            }

            int[] together = findRoute(s,vertexList,Integer.MAX_VALUE,a,b);
            int minValue = together[a] + together[b];
            for(int i = 1; i < n+1; i++) {
                if(i == s) continue;
                int[] alone = findRoute(i,vertexList,minValue,a,b);
                minValue = Math.min(alone[a] + alone[b] + together[i],minValue);
            }

            return minValue;
        }

        public int[] findRoute(int selectedNode,List<Vertex>[] vertexList, int minValue, int a, int b) {
            PriorityQueue<Vertex> pq = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
            int [] distances = new int[vertexList.length];
            Arrays.fill(distances, Integer.MAX_VALUE);
            pq.add(new Vertex(selectedNode,0));
            distances[selectedNode] = 0;

            while (!pq.isEmpty()) {
                Vertex selectedVertex = pq.poll();
                
                if(selectedVertex.cost > distances[selectedVertex.index]) continue;
                for(Vertex e : vertexList[selectedVertex.index]){
                    int currentDistance = distances[e.index];
                    int newDistance = selectedVertex.cost + e.cost;
                    if (currentDistance > newDistance) {
                        distances[e.index] = newDistance;
                        pq.add(new Vertex(e.index,newDistance));
                    }
                }

            }
            return distances;


        }
        class Vertex{
            int index;
            int cost;

            public Vertex(int index, int cost) {
                this.index = index;
                this.cost = cost;
            }

        }
    }