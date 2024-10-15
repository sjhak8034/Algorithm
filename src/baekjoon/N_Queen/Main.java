package N_Queen;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Main main = new Main();
        int ans = main.findNextQueen(N, new ArrayList<>(), new ArrayList<>(), 0, new ArrayList<>(8),
                0);
        System.out.println(ans);


    }

    // N: 체스판의 N*N크기   pluses, minuses: 퀸의 대각선 겹침 판단
    // depth: 퀸의 말의 갯수   previousQueens: 이전이 뒀던 퀸의 좌표
    // resultCases: 정답의 갯수 저장
    public Integer findNextQueen(int N, ArrayList<Integer> pluses, ArrayList<Integer> minuses, int depth
            , ArrayList<Integer> previousQueens, int resultCases) {
        int next = resultCases;

        for (int i = 0; i < N; i++) {
            int plus = i + depth;
            int minus = i - depth;

            if (previousQueens.contains(i)) {
                continue;
            }
            if (pluses.contains(plus)) {
                continue;
            }
            if (minuses.contains(minus)) {
                continue;
            }
            if (depth == (N-1)) {
                resultCases +=1;
                return resultCases;
            }
            pluses.add(plus);
            minuses.add(minus);
            previousQueens.add(i);
            depth++;
            next += findNextQueen(N, pluses, minuses, depth, previousQueens, resultCases);
            depth --;
            pluses.remove(Integer.valueOf(plus));
            minuses.remove(Integer.valueOf(minus));
            previousQueens.remove(depth);
        }
        return next;
    }


}








