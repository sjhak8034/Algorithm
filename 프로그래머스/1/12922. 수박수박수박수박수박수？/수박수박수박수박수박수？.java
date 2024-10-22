class Solution {
    public String solution(int n) {
        String answer = "";
        String word = "수박";
        int num;
        for (int i = 0; i<n; i++){
            num = i% word.length();
            answer += word.charAt(num);
        }
        return answer;
    }
}