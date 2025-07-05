import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int endIndex = n-1;
        
        int delivery = 0;
        int pickup = 0;
        // 끝이 0이 될때까지 반복
        while(endIndex >= 0){
            // delivery와 pickup 모두 0인경우 endIndex 감소
            while(deliveries[endIndex] ==0 && pickups[endIndex]==0){
                endIndex -= 1;
                if(endIndex == -1){
                    break;
                }
            }
            if(endIndex == -1){
                    break;
                }
            // 배달 물품을 채움
            delivery = cap;
            // 끝거리까지 이동
            answer += (endIndex + 1)*2;
            // 이동하며 끝에서부터 배달함
            int deliveryPoint = endIndex;
            while (delivery != 0){
                if(delivery <= deliveries[deliveryPoint]){
                    deliveries[deliveryPoint] -= delivery;
                    break;
                }
                else{
                    delivery -= deliveries[deliveryPoint];
                    deliveries[deliveryPoint] = 0;
                }
                deliveryPoint --;
                if(deliveryPoint == -1){
                    break;
                }
            }
            pickup = cap;
            int pickupPoint = endIndex;
            // 끝에서부터 수거함
            while (pickup != 0 ){
               if(pickup <= pickups[pickupPoint]){
                    pickups[pickupPoint] -= pickup;
                   break;
                }
                else{
                    pickup -= pickups[pickupPoint];
                    pickups[pickupPoint] = 0;
                } 
                pickupPoint--;
                if(pickupPoint == -1){
                    break;
                }
            }
            
            
            
        }
        
        return answer;
    }
}