import java.util.*;
class Solution {
     public int[] solution(String s) {
        int size = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean flag = false;
        StringBuilder number = new StringBuilder();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (c <= 57 && c >= 48) {

                number.append(c);
                flag = true;

            } else {
                if (flag) {
                    temp.add(Integer.parseInt(number.toString()));
                    size++;
                    number = new StringBuilder();
                }
                flag = false;
            }
            if (c == '}') {
                if (size == 0) {
                    continue;
                } else {
                    map.put(size, List.copyOf(temp));
                }

                size = 0;

                temp.clear();
            }

        }
        for (int i = 1; i <= map.size(); i++) {
            List<Integer> tempList = map.get(i);
            for (int j : tempList) {
                if (!list.contains(j)) {
                    list.add(j);
                    break;
                }

            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}