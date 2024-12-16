import java.util.*;
class Solution {
    int min = 10000000;
    public int solution(int x, int y, int n) {
        
        if(x==y) return 0;
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(new int[]{x,0});
        visited.add(x);
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int now = current[0];
            int count = current[1];
            
            int[] nextValues = {now*3, now*2, now+n};
            for(int next : nextValues){
                if(next ==y){
                    return count+1;
                }
                if(next < y && !visited.contains(next)){
                    queue.add(new int[]{next,count+1});
                    visited.add(next);
                }
            }
        }
        
        
        return -1;
    }
    
    
    
}
