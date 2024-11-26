class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = findnext(numbers.length,-1,numbers,0,target,0);
        return answer;
    }
    
    private int findnext(int n,int now ,int[] numbers, int result, int target,int flag){
        
        if (now != -1){
         result = result + flag * numbers[now] ;   
        }
        if (n-1 == now ){
            if (result == target){
                return 1;
            }
            return 0;
        }
        int temp1 = findnext(n, now+1, numbers, result, target, -1);
        
        int temp2 = findnext(n, now+1, numbers, result, target, 1);
        
        
        
        return (temp1 + temp2);
    }
}