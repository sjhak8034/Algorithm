import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder kdigit = new StringBuilder();

        while(n != 0){
            if (n % k !=0 ) {
                kdigit.append((n % k));
            }
            if(n/k == 0 ||n % k == 0 && !(kdigit.length() == 0)){
                kdigit.reverse();

                if(isPrime(Long.parseLong(kdigit.toString()))){
                    answer += 1;
                }
                kdigit.delete(0,kdigit.length());

            }

            n /= k;
        }
        return answer;
    }
    private boolean isPrime(long n){
        long temp = n;
        if (n < 2) return false;
        for(long i = 2; i < temp; i++){
            if(n % i == 0){
                return false;
            }
            temp = n/i + n%i;
        }
        return true;
    }
}