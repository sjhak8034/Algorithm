import java.util.*;
import java.util.*;

public class Solution {
    public int[] solution(int[] nodes, int[][] edges) {
        // 아직 방문하지 않은 노드 리스트
        Set<Integer> unvisited = new HashSet<>();
        for (int value : nodes) {
            unvisited.add(value);
        }

        // 간선 정보를 그래프로 변환 (인접 리스트)
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int value : nodes) {
            adjacencyList.put(value, new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);  // 양방향 그래프
        }

        List<TreeV2> forest = new ArrayList<>();
        int[] answer = {0, 0};
        makeForest(unvisited, adjacencyList, forest);

        for (TreeV2 tree : forest) {

            tree.isEvenOddOrReverse(answer);
        }

        return answer;
    }

    // forest 생성
    static void makeForest(Set<Integer> unvisited, Map<Integer, List<Integer>> adjacencyList, List<TreeV2> forest) {
        while (!unvisited.isEmpty()) {
            Integer startValue = unvisited.iterator().next();
            TreeV2 tree = new TreeV2();
            Map<Integer, NodeV2> nodeMap = new HashMap<>();  // 값에 해당하는 노드를 추적

            // 시작 노드 생성
            NodeV2 startNode = new NodeV2(startValue);
            nodeMap.put(startValue, startNode);
            tree.addNode(startNode);

            // DFS로 트리 구축
            dfs(startValue, unvisited, adjacencyList, tree, nodeMap);

            forest.add(tree);
        }
    }

    // 트리 생성
    static void dfs(int currentValue, Set<Integer> unvisited,
                    Map<Integer, List<Integer>> adjacencyList,
                    TreeV2 tree, Map<Integer, NodeV2> nodeMap) {

        // 현재 노드를 방문 처리
        unvisited.remove(currentValue);
        NodeV2 currentNode = nodeMap.get(currentValue);

        // 인접한 노드들을 탐색
        for (int neighborValue : adjacencyList.get(currentValue)) {
            // 이미 방문한 노드는 건너뛰기
            if (!unvisited.contains(neighborValue)) {
                continue;
            }

            // 새 이웃 노드 생성 및 연결
            NodeV2 neighborNode = new NodeV2(neighborValue);
            nodeMap.put(neighborValue, neighborNode);
            tree.addNode(neighborNode);

            // 양방향 연결
            currentNode.addNeighbor(neighborNode);
            neighborNode.addNeighbor(currentNode);

            // 재귀적으로 이웃 노드 탐색
            dfs(neighborValue, unvisited, adjacencyList, tree, nodeMap);
        }
    }


}
// 트리를 굳이 만들지 않고 되는지 안되는지만 판별하면 된다!
class NodeV2 {
    int value;
    List<NodeV2> neighbors;

    public NodeV2(int value) {
        this.value = value;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(NodeV2 neighbor) {
        if (!neighbors.contains(neighbor)) {
            neighbors.add(neighbor);
        }
    }

}

class TreeV2 {
    List<NodeV2> nodes = new ArrayList<>();

    public void addNode(NodeV2 node) {
        nodes.add(node);
    }

    public void isEvenOddOrReverse(int[] answer) {
        // 부모노드 고려x 연결된 node갯수로만 판별
        int evenOddCount = 0;
        int ReverseOddEvenCount = 0;
        for (NodeV2 node : nodes) {
            boolean isEven = node.value % 2 == 0;
            boolean hasEvenLink = node.neighbors.size() % 2 == 0;
            if(isEven && hasEvenLink || !isEven && !hasEvenLink) {
                evenOddCount++;
            } else {
                ReverseOddEvenCount++;
            }
            if(evenOddCount >= 2 && ReverseOddEvenCount >= 2) {
                return;
            }
        }
        if(evenOddCount == 1){
            answer[0] = answer[0] + 1;
        }
        if(ReverseOddEvenCount == 1){
            answer[1] = answer[1] + 1;
        }
    }

}

