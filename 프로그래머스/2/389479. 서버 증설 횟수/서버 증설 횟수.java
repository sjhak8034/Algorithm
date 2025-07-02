import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        // m: 서버당 수용가능 수
        // n: 서버 가동시간
        // server[k]를 생성
        // for 문으로 i ++;로 돌며
        // server[i%k] 를 초기화 
        // players[i] 와 이전 서버대수 총 갯수 비교
        // sever[i/k] 에 부족한 서버를 채움
        // answer ++;
        
        int[] server = new int[k];
        for(int i = 0; i < players.length; i ++){
            server[i%k] = 0;
            int servers = 0;
            for(int j : server){
                servers += j;
            }
            
            int acceptablePlayers =  (servers + 1) * m - 1;
            if(players[i] > acceptablePlayers){
                
                int plusServer = (players[i] - acceptablePlayers) % m > 0 ?  (players[i] - acceptablePlayers) / m + 1 :  (players[i] - acceptablePlayers)/m;
                server[i%k] = plusServer;   
                answer += plusServer;
            }
            
        }
        return answer;
    }
}