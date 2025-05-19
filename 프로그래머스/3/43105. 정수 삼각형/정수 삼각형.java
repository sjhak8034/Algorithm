
class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        Integer[][] memo = new Integer[n][n];

        return findMaxPath(triangle, 0, 0, memo);
    }

    private int findMaxPath(int[][] triangle, int row, int col, Integer[][] memo) {

        if (row == triangle.length) {
            return 0;
        }

        // 이미 계산된 경우 메모에서 가져옴
        if (memo[row][col] != null) {
            return memo[row][col];
        }

        // 현재 위치의 값
        int currentValue = triangle[row][col];

        // 왼쪽 오른쪽 선택
        int leftPath = findMaxPath(triangle, row + 1, col, memo);
        int rightPath = findMaxPath(triangle, row + 1, col + 1, memo);

        // 좌측과 우측중 큰 값을 저장
        memo[row][col] = currentValue + Math.max(leftPath, rightPath);
        return memo[row][col];
    }
}