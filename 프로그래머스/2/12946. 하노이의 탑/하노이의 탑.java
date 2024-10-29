import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int[][] solution(int n) {
        List<int[]> list = new ArrayList<>();
            miniSolution(n,1,3,list);
            int [][] answer = list.toArray(new int[list.size()][]);
            
            
        return answer;
    }
    public void miniSolution(int n, int start, int end, List<int[]> list) {
            int elsepin = Arrays.stream(new int[] {1,2,3,}).filter(x -> x != start && x != end).findFirst().getAsInt();

            if (n == 2) {
                list.add(new int[]{start, elsepin});
                list.add(new int[]{start, end});
                list.add(new int[]{elsepin, end});
            }
            else{
                miniSolution(n - 1, start, elsepin, list);
                list.add(new int[]{start, end});
                miniSolution(n - 1, elsepin, end, list);


            }



        }
}