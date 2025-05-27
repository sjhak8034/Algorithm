import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 1000000;
        for( int[] wire : wires){
            int[][] newWires = new int[wires.length][2];
            for( int i = 0; i < wires.length; i++){
                if(wires[i] != wire){
                    newWires[i] = wires[i];
                }
            }
            for(int i = 1; i<n + 1; i++){
                nodeMap.put(i, new Node(i));
            }
            Tree tree = new Tree(nodeMap.get(1));
            tree.makeTree(tree.root, newWires, -1);
            tree.getSize(tree.root);
            if(answer > Math.abs(n-2*tree.size)){
                answer = Math.abs(n-2*tree.size);
            }
        }
        return answer;
    }
      class Node{
        int number;
        int value;
        List<Node> children = new ArrayList<Node>();
        Node(int number){
            this.number = number;
        }
        public void addChild(Node child){
            children.add(child);
        }

    }
    class Tree{
        Node root;
        int size;
        public Tree(Node root){
            this.root = root;

        }
        public void getSize(Node node){
            size +=1;
            for(Node child : node.children){
                getSize(child);
            }
        }
        public void makeTree(Node node, int[][] wires, int parent){
            for(int[] wire : wires){
                for( int i : wire){
                    if(wire[0] == node.number || wire[1] == node.number){
                        if(i != node.number && i != parent){
                            node.addChild(nodeMap.get(i));
                            makeTree(nodeMap.get(i), wires, node.number);
                        }
                    }
                }
            }
        }
    }

    public Map<Integer, Node> nodeMap = new HashMap<Integer, Node>();

}