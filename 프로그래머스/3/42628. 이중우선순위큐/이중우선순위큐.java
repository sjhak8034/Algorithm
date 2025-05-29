import java.util.*;

public class Solution {
   public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> countMap = new HashMap<>();

        for (String op : operations) {
            String[] parts = op.split(" ");
            String cmd = parts[0];
            int num = Integer.parseInt(parts[1]);

            if (cmd.equals("I")) {
                minHeap.add(num);
                maxHeap.add(num);
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            } else if (cmd.equals("D")) {
                if (num == 1) {
                    remove(maxHeap, countMap);
                } else {
                    remove(minHeap, countMap);
                }
            }
        }

        int max = findValue(maxHeap, countMap);
        int min = findValue(minHeap, countMap);


        return new int[]{max, min};
    }

    private int remove(PriorityQueue<Integer> heap, Map<Integer, Integer> map) {
        while (!heap.isEmpty()) {
            int value = heap.poll();
            if (map.getOrDefault(value, 0) > 0) {
                map.put(value, map.get(value) - 1);
                return value;
            }
        }
        return 0;
    }
    private int findValue(PriorityQueue<Integer> heap,Map<Integer, Integer> map) {
        while (!heap.isEmpty()) {
            int value = heap.poll();
            if (map.getOrDefault(value, 0) > 0) {
                return value;
            }
        }
        return 0;
    }
}