import java.util.ArrayList;
class Solution {
    public long solution(long n) {
        ArrayList<Integer> num = new ArrayList<>();
        while (n != 0){
            num.add((int)(n%10));
            n = n/10;
        }
        for (int i = 0; i<num.size(); i++){
            for (int j = i; j<num.size(); j++){
                if (num.get(i) < num.get(j)){
                    int temp = num.get(i);
                    num.set(i,num.get(j));
                    num.set(j,temp);
                }
            }
        }
        long count = 1;
        for (int i = 0; i<num.size(); i++){
            n += count * num.get(num.size()-i-1);
            count = count *10;
        }
        return n;
    }
    
}