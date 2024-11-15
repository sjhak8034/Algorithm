import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int aOrder = a;
        int bOrder = b;
        while(aOrder != bOrder){
            answer +=1;
            aOrder = aOrder/2 + aOrder%2;
            bOrder = bOrder/2 + bOrder%2;
        }
        
        return answer;
    }
}