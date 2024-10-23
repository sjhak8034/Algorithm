class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int size1 = arr1.length;
        int size2 = arr1[0].length;
        int[][] answer = new int[size1][size2];
        for (int i = 0; i<size1; i++){
            for(int j = 0; j < size2; j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
    
        return answer;
    }
}