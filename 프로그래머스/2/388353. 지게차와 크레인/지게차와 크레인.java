import java.util.*;
class Solution {
    public int solution(String[] storage, String[] requests) {
           char out = '0';
        int row = storage.length;
        int col = storage[0].length();
        int answer = row * col;



        Queue<int[]> canReach = new LinkedList<>();

        // 처음 도달가능한 위치를 가장자리로 설정
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == 0 || j == 0 || i == row-1 || j == col-1){
                    canReach.add(new int[]{i,j});
                }

            }
        }
        Queue<int[]> temp = new LinkedList<>();
        for (String request : requests) {
            Queue<int[]> next = new LinkedList<>();
            temp.addAll(canReach);
            if (request.length() == 1){
                while (!canReach.isEmpty()) {
                    int[] target = canReach.poll();
                    char charRequest = request.charAt(0);
                    if(charRequest == (storage[target[0]].charAt(target[1]))){
                        StringBuilder sb = new StringBuilder(storage[target[0]]);
                        sb.setCharAt(target[1],out);
                        storage[target[0]] = sb.toString();
                        answer -= 1;
                    }
                }
            } else {

                for (int i = 0; i < row; i++ ) {
                    for (int j = 0; j < col; j++) {
                        char c = storage[i].charAt(j);
                        if(c == request.charAt(0)){
                            StringBuilder sb = new StringBuilder(storage[i]);
                            sb.setCharAt(j,out);
                            storage[i] = sb.toString();
                            answer -= 1;
                        }
                    }

                }
            }
            canReach.addAll(temp);
            bfs(canReach,row, col,storage, next);
            canReach = next;


        }
        return answer;
    }
    static boolean isAdjacentToZero(String[] storage, int i, int j) {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < storage.length && nj >= 0 && nj < storage[0].length()) {
                if (storage[ni].charAt(nj) == '0') {
                    return true;
                }
            }
        }
        return false;
    }

    // 가장자리부터 차례로 모든 "0" 탐색
    static void bfs(Queue<int[]> canReach, int row, int col, String[] storage, Queue<int[]> next) {
        boolean[][] visited = new boolean[row][col];

        while (!canReach.isEmpty()) {
            int[] target = canReach.poll();

            if (visited[target[0]][target[1]]) {
                continue;
            }
            visited[target[0]][target[1]] = true;

            // 현재 위치가 "0"이 아니면 다음에도 탐색
            if (storage[target[0]].charAt(target[1]) != '0') {
                next.add(target);
                continue;
            }

            int[][] directions = {
                    { -1, 0 }, // north
                    { 1, 0 },  // south
                    { 0, -1 }, // west
                    { 0, 1 }   // east
            };

            for (int[] dir : directions) {
                int newRow = target[0] + dir[0];
                int newCol = target[1] + dir[1];

                boolean isOut = newRow < 0 || newRow >= row || newCol < 0 || newCol >= col;
                if (isOut || visited[newRow][newCol]) {
                    continue;
                }


                if (isAdjacentToZero(storage, newRow, newCol)) {
                    if (storage[newRow].charAt(newCol) == '0') {
                        canReach.add(new int[] { newRow, newCol });
                    } else {
                        next.add(new int[] { newRow, newCol });
                    }
                }
            }
        }
    }
}