class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 0; i < n ; i++ ){
            answer +=1;
            int temp = answer;
            boolean check = false;
            while(temp >0){
                if (temp % 10 == 3 ){
                        check = true;
                }
                temp /=10;
            }
            while(answer %3 == 0 || check){
                answer +=1;
                temp = answer;
                check = false;
                while(temp >0){
                if (temp % 10 == 3 ){
                    check = true;
                }
                temp/= 10;   
            }
            }
        }
        return answer;
    }
}