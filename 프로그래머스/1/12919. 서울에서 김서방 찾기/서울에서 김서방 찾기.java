class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int count = 0;
        for (String e : seoul){
            if(e.equals("Kim")){
                answer = "김서방은 "+ count+"에 있다";
                return answer ;
            }
            count ++;
        }
        return answer;
    }
}