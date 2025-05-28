import java.util.*;
import java.util.stream.Collectors;
public class Solution {
    class Node {
        int value;
        int[] point;
        Node parent;
        Node left;
        Node right;
        public Node(int value, Node parent, int[] point) {
            this.value = value;
            this.parent = parent;
            this.point = point;
        }
    }
    class Tree{
        Node root;

        public Tree(List<int[]> nodeinfoList) {
            int[]nodeinfo = nodeinfoList.remove(0);
            int[]point = new int[2];
            point[0] = nodeinfo[0];
            point[1] = nodeinfo[1];
            this.root = new Node(nodeinfo[2], null, point);
            makeTree(nodeinfoList, this.root);
        }
        private void makeTree(List<int[]> nodeinfoList, Node node) {
            List<int[]> leftNodeInfoList = nodeinfoList.stream()
                    .filter(array -> array[0] < node.point[0])
                    .collect(Collectors.toList());
            List<int[]> rightNodeInfoList = (nodeinfoList.stream()
                    .filter(array -> array[0] > node.point[0])
                    .collect(Collectors.toList()));
            Comparator<int[]> comparator = Comparator.comparingInt((int[] array) -> array[1]).reversed();
            leftNodeInfoList.sort(comparator);
            rightNodeInfoList.sort(comparator);

            if(!leftNodeInfoList.isEmpty()){
                int[]leftInfo = leftNodeInfoList.remove(0);
                int[]leftPoint = new int[2];
                leftPoint[0] = leftInfo[0];
                leftPoint[1] = leftInfo[1];
                node.left = new Node(leftInfo[2], node, leftPoint);
            }
            if(!rightNodeInfoList.isEmpty()){
                int[]rightInfo = rightNodeInfoList.remove(0);
                int[]rightPoint = new int[2];
                rightPoint[0] = rightInfo[0];
                rightPoint[1] = rightInfo[1];
                node.right = new Node(rightInfo[2], node, rightPoint);
            }

            if(node.left != null){
                makeTree(leftNodeInfoList,node.left);
            }
            if(node.right != null){
                makeTree(rightNodeInfoList,node.right);
            }
        }

        public void preorderTraversal(List<Integer> result, Node node) {
            result.add(node.value);
            if(node.left != null){
                preorderTraversal(result, node.left);
            }
            if(node.right != null){
                preorderTraversal(result, node.right);
            }
        }

        public  void postorderTraversal(List<Integer> result, Node node) {
            if(node.left != null){
                postorderTraversal(result, node.left);
            }
            if(node.right != null){
                postorderTraversal(result, node.right);
            }
            result.add(node.value);

        }

    }

    public int[][] solution(int[][] nodeinfo) {
        List<int[]> nodeinfoList = new ArrayList<>();
        for( int i = 0; i < nodeinfo.length; i++ ) {
            nodeinfoList.add(new int[]{nodeinfo[i][0], nodeinfo[i][1], i+1});
        }
        Comparator<int[]> comparator = Comparator.comparingInt((int[] array) -> array[1]).reversed();
        nodeinfoList.sort(comparator);
        Tree tree = new Tree(nodeinfoList);
        List<Integer> preorderTravelResult = new ArrayList<>();
        List<Integer> postorderTravelResult = new ArrayList<>();
        tree.preorderTraversal(preorderTravelResult, tree.root);
        tree.postorderTraversal(postorderTravelResult, tree.root);
        int[][] answer = new int[2][preorderTravelResult.size()];
        for(int i = 0; i < preorderTravelResult.size(); i++){
            answer[0][i] = preorderTravelResult.get(i);
            answer[1][i] = postorderTravelResult.get(i);
        }
        return answer ;
    }
}