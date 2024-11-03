import java.util.*;
import java.util.Collections;
import java.math.BigInteger;
class Solution {
    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];
        
        // 각 숫자의 출현 횟수 계산
        for (char c : X.toCharArray()) countX[c - '0']++;
        for (char c : Y.toCharArray()) countY[c - '0']++;
        
        // 결과 문자열 생성을 위한 StringBuilder
        StringBuilder sb = new StringBuilder(Math.min(X.length(), Y.length()));
        
        // 큰 숫자부터 처리
        for (int i = 9; i >= 0; i--) {
            int count = Math.min(countX[i], countY[i]);
            for (int j = 0; j < count; j++) {
                sb.append(i);
            }
        }
        
        // 결과 처리
        if (sb.length() == 0) return "-1";
        if (sb.charAt(0) == '0') return "0";
        
        return sb.toString();
    }
}