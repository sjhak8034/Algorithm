import java. util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int size = nums.length * (nums.length-1) * (nums.length-2)/6;
        int[] candidates = new int[size];
        int index = 0;
        for(int i = 0 ; i < nums.length-2; i++){
            for(int j = i+1 ; j < nums.length-1; j++){
                for(int k = j+1 ; k < nums.length; k++){
                    candidates[index] = nums[i] + nums[j] + nums[k];   
                    index ++;
                }
            }
        }
        int count = 2;
        int max = Arrays.stream(candidates).max().getAsInt();
    
        while(count <= max){
            for(int i = 0; i < candidates.length ; i++){
                if (candidates[i] % count == 0 && candidates[i] != 0 && candidates[i] == count){
                    answer += 1;
                    candidates[i] = 0;
                }
                else if(candidates[i] % count == 0 && candidates[i] != 0 && candidates[i] != count){
                    candidates[i] = 0;
                }
            }
            count ++;
        }
        return answer;
    }
}