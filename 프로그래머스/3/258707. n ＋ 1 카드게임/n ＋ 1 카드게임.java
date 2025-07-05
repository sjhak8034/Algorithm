import java.util.*;
import java.util.stream.Collectors;
class Solution {
 public static int solution(int coin, int[] cards) {
        int answer = 0;
        int length = cards.length + 1;
        Map<Integer,Integer> pairRoundMap = new HashMap<>();
        Map<Integer,Integer> cardRoundMap = new HashMap<>();
        // 두번째칸이 pair의 위치. pair가 멀수록 우선권 증가 ( 빨리 제거)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->  b[1] - a[1] );
        // cards를 cardRoundMap에 넣는다
        for(int i = 0; i <cards.length; i++){
            cardRoundMap.put(cards[i], i);
        }
        // cards를 map에 넣는다. (앞 카드의 라운드 - 뒷 카드(페어) 라운드)
        for(int i = 0; i <cards.length; i++){
            int card = cards[i];
            int pair = length - card;
            // 페어 카드가 이미 map을 만든경우 스킵
            int cardPairRound = cardRoundMap.get(pair);
            int isPairRoundExist = pairRoundMap.getOrDefault(cardPairRound,-1);
            if(isPairRoundExist == -1){
                pairRoundMap.put(i,cardPairRound);




                // 큐에 넣을때 최대 갯수 coin
                // map을 만들때 priority queue에 [i,j] 형식으로 넣는다
                // 이미 핸드에 들어오는건 제외
                if(i < cards.length/3){
                    continue;
                }
                int[] cardPairRoundArr = new int[2];
                cardPairRoundArr[0] = i;
                cardPairRoundArr[1] = cardPairRound;
                if(pq.size() == coin + 1){
                    pq.poll();
                }
                pq.add(cardPairRoundArr);
            }
        }
        int myHandPair = 0;
        List<Integer> needPair = new ArrayList<>();
        for(int i = 0; i < cards.length/3; i ++){
            int pairRound = pairRoundMap.getOrDefault(i, -1);
            // 페어 완성
            if(pairRound == -1 ){
                continue;
            } else{
                if(pairRound < cards.length/3){
                    myHandPair += 1;
                    continue;
                }
                // 페어가 충족하지 않을경우
                needPair.add(pairRound);
            }
        }
        pq = pq.stream()
                .sorted((a, b) -> Integer.compare(a[1], b[1]))
                .collect(Collectors.toCollection(() -> new PriorityQueue<>(Comparator.comparingInt(a -> a[1]))));
        int now = cards.length/3  -1;
        while(myHandPair != -1) {
            answer++;
            now += 2;
            // 처음에 손에 가지고 있던 스페어 카드
            if(coin >= 1) {
                for (int i = 0; i < needPair.size(); i++) {
                    int pairRound = needPair.get(i);
                    if (pairRound <= now) {
                        myHandPair += 1;
                        needPair.remove(i);
                        i--;
                        coin--;
                        break;

                    }
                }
            }

            // 아예 없던 페어가 만들어 지는 경우
            // 핸드페어가 부족할때만 시도
            if (coin >= 2 && myHandPair == 0) {
                if (!pq.isEmpty()) {
                    if (pq.peek()[1] <= now) {
                        int[] newHand = pq.poll();
                        coin -= 2;
                        myHandPair += 1;
                    }


                }
            }
            if(now > cards.length - 1){
                break;
            }
            myHandPair --;
        }


        return answer;
    }

}