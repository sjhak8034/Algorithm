class Solution {
    public int solution(String s) {
        int answer = 0;
        String tempanswer = "";
        String numWord = "";
        for (int i = 0; i< s.length(); i++){
            if (Character.isDigit(s.charAt(i))){
                tempanswer+=s.charAt(i); 
            }
            else{
                numWord += s.charAt(i);
                switch(numWord)
                {
                    case "zero":
                        tempanswer += '0';
                        numWord = "";
                        break;
                    case "one":
                        tempanswer += '1';
                        numWord = "";
                        break;
                    case "two":
                        tempanswer += '2';
                        numWord = "";
                        break;
                    case "three":
                        tempanswer += '3';
                        numWord = "";
                        break;
                    case "four":
                        tempanswer += '4';
                        numWord = "";
                        break;
                    case "five":
                        tempanswer += '5';
                        numWord = "";
                        break;
                    case "six":
                        tempanswer += '6';
                        numWord = "";
                        break;
                    case "seven":
                        tempanswer += '7';
                        numWord = "";
                        break;
                    case "eight":
                        tempanswer += '8';
                        numWord = "";
                        break;
                    case "nine":
                        tempanswer += '9';
                        numWord = "";
                        break;
                    default:
                        break;
                }
            }
            
        }
        answer = Integer.parseInt(tempanswer);
        return answer;
    }
}