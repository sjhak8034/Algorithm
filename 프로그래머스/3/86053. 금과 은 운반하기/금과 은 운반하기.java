class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = 0L;
        answer = 4*(long)Math.pow(10,14);
        long start = 0L;
        long end = 4*(long)Math.pow(10,14);
        long mid;
        while(end >= start){
            mid = (end + start)/2;
            long maxG = 0L;
            long maxS = 0L;
            long minG = 0L;
            long minS = 0L;
        
            for(int i = 0; i < g.length; i++){
                long num = mid / t[i];
                long tempMaxG = (g[i]>(num/2 + num%2)*w[i] ? (num/2 + num%2)*w[i] : g[i]);
                maxG += tempMaxG;
                minS += (s[i]> (num/2 + num%2)*w[i] - tempMaxG ? (num/2 + num%2)*w[i] -tempMaxG : s[i]);
                long tempMaxS = (s[i]>(num/2 + num%2)*w[i] ? (num/2 + num%2)*w[i] : s[i]);
                maxS += tempMaxS;
                minG += (g[i]> (num/2 + num%2)*w[i] - tempMaxS ? (num/2 + num%2)*w[i] -tempMaxS : g[i]);
                
                // if (maxG > a){
                //     minS += (s[i]> (num/2 + num%2)*w[i] - tempMaxG + maxG - a ? (num/2 + num%2)*w[i] -tempMaxG + maxG - a: s[i]);
                // }
                // else{
                //     minS += (s[i]> (num/2 + num%2)*w[i] - tempMaxG ? (num/2 + num%2)*w[i] -tempMaxG : s[i]);
                // }
                // if (maxS > b){
                //     minS += (s[i]> (num/2 + num%2)*w[i] - tempMaxG + maxS - b ? (num/2 + num%2)*w[i] -tempMaxG + maxS - b : s[i]);
                // }
                // else{
                //     minG += (g[i]> (num/2 + num%2)*w[i] - tempMaxS ? (num/2 + num%2)*w[i] -tempMaxS : g[i]);
                // }
               
            }
           
            if ( a <= maxG && b <= maxS  && maxG+minS >=a+b && maxS+minG >=a+b){
                    end = mid -1;
                    answer = Math.min(mid, answer);
                }
            else{
                start = mid + 1;
            }
            }
            return answer;    
        }
}