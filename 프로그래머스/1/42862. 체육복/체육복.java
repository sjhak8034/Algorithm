import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        int[] array = new int[n+1];
         Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int e: lost){
            array[e] = 1;
        }
        for (int i = 0; i < reserve.length; i++){
            int e = reserve[i];
            if (array[e] == 1){
                array[e] = 0;
                reserve[i] = -1;
                answer +=1;
                }
        }
        
        for (int e : reserve){
                
                if (n>e-1 && e-1 > 0 ){
                  if (array[e-1] == 1){
                    array[e-1] = 0;
                    answer +=1;
                      continue;
                  
                } 
                }
                if ( 0 <e+01 &&e+01 <= n ){
                if (array[e+1] == 1){
                     array[e+1] = 0;
                    answer +=1;
                }
                  
            }
            }
       
        return answer;
    }
}