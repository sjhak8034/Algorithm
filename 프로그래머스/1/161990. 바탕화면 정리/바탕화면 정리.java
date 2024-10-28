class Solution {
    public int[] solution(String[] wallpaper) {
        int minx = 999;
        int maxx = 0;
        int miny = 999;
        int maxy = 0;
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                if (wallpaper[i].charAt(j) == '#'){
                    if (minx > j){
                        minx = j;
                    }
                    if (maxx < j){
                        maxx = j;
                    }
                    if (miny > i){
                        miny = i;
                    }
                    if (maxy < i){
                        maxy = i;
                    }
                }
            }
        }
        int[] answer = {miny,minx,maxy+1,maxx+1};
        return answer;
    }
}