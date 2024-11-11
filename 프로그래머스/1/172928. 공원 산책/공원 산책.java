import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int[] now = new int[2];
        int y_size = park.length;
        int x_size = park[0].length();
        List<int[]> disturb = new ArrayList<>();
        for(int i = 0; i < y_size; i++){
            for(int j = 0; j < x_size; j++){
                if (park[i].charAt(j) == ('S')){
                    now = new int[]{i,j};
                }
                if (park[i].charAt(j) == ('X')){
                    disturb.add(new int[]{i,j});
                }
            }
        }
        for(String r : routes){
            String direction = r.split(" ")[0];
            int length = Integer.parseInt(r.split(" ")[1]);
            int[] temp_Now = now.clone();
            for(int i = 0; i < length; i++ ){
                if (direction.equals("E")){
                    temp_Now[1] +=1;
                }
                if (direction.equals("W")){
                    temp_Now[1] -=1;
                }
                if (direction.equals("S")){
                    temp_Now[0] +=1;
                }
                if (direction.equals("N")){
                    temp_Now[0] -=1;
                }
                if (temp_Now[0] < 0 || temp_Now[0] >y_size-1 ){
                    break;
                }
                if (temp_Now[1] < 0 || temp_Now[1] >x_size-1 ){
                    break;
                }
                boolean check = false;
                for(int[] d : disturb){
                    if (Arrays.equals(temp_Now, d)){
                        check = true;
                        break;
                    }
                }
                if (check){
                    break;
                }
                if (i == length-1){
                    now = temp_Now;
                }
            }
        }
        return now;
    }
}