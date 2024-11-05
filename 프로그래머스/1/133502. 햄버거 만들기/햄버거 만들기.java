import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> arrayList = new ArrayList<>();
        for(int e : ingredient){
            arrayList.add(e);
        }

        int change = 1;
        while(change !=0){
            change = 0;
            
            for(int i = 0; i< arrayList.size(); i++){
                if (i+3 > arrayList.size() -1){
                        break;
                    }
                if(arrayList.get(i) == 1){
                    
                    if(arrayList.get(i) == 1 && arrayList.get(i+1) == 2 && arrayList.get(i+2) == 3&& arrayList.get(i+3) == 1)                       {
                        arrayList.remove(i);
                        arrayList.remove(i);
                        arrayList.remove(i);
                        arrayList.remove(i);
                            answer+=1;
                        change = 1;
                        if(i-4 >= -1) i -= 4;
                else i = -1;
                    }
                    
                }
            }
            
      
        }
        return answer;
    }
}