package laboratoryBy1dimension;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int M = sc.nextInt();
        ArrayList<Integer> Map = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Map.add(sc.nextInt());

            }
        }
        Main main = new Main();
        int ans = main.makeWall(N,M,Map,0,0,0);
        System.out.println(ans);

    }

    public Integer makeWall(int N, int M, ArrayList<Integer> map, int numWall, int latestWallIndex, int result) {
        numWall++;
        int next = 0;
        if (numWall == 4) {
            int wallNum = 0;
            ArrayList<Integer> infected = new ArrayList<>();
            ArrayList<Integer> people = new ArrayList<>();
            for (int i = 0; i < N*M; i++) {
                if (map.get(i)==1) {
                    wallNum ++;
                }
                if (map.get(i)==2) {
                    infected.add(i);
                }
                if (map.get(i)==0) {
                    people.add(i);
                }

            }
            int tempResult = simulation(N,M,infected,people);

            result = Math.max(result, tempResult);
            return result;
        }
        for (int i = latestWallIndex; i < N * M; i++) {
            int spaceState = map.get(i);
            int xIndex = i % M;
            int yIndex = i / M;
            if (spaceState != 0) {
                continue;
            }
            boolean isOutline = (xIndex == 0 || xIndex == M - 1 || yIndex == 0 || yIndex == N - 1);
            if (isOutline) {
                map.set(i, 1);
            } else {
                boolean isSideWall = (map.get(i + 1) == 1 || map.get(i - 1) == 1 || map.get(i - M) == 1 || map.get(i + M) == 1 || map.get(i - M - 1) == 1 || map.get(i - M + 1) == 1 || map.get(i + M - 1) == 1 || map.get(i + M + 1) == 1);
                boolean isSideInfected = (map.get(i + 1) == 2 || map.get(i - 1) == 2 || map.get(i - M) == 2 || map.get(i + M) == 2 || map.get(i - M - 1) == 2 || map.get(i - M + 1) == 2 || map.get(i + M - 1) == 2 || map.get(i + M + 1) == 2);
                if (isSideWall || isSideInfected) {
                    map.set(i, 1);
                }
            }
            latestWallIndex = i;
            result = makeWall(N, M, map, numWall, latestWallIndex, result);
            map.set(i,0);

        }
        return result;
    }
    public Integer simulation(int N, int M, ArrayList<Integer> infected,ArrayList<Integer> people) {
        int infectedNum = 0;
        ArrayList<Integer> infectedCopy = new ArrayList<>();
        infectedCopy.addAll(infected);

        for (int i = 0; i < M+N; i++) {
            int isChange = 0; // check is change
            for (int infec : infectedCopy) {
                int rightSideIndex = infec + 1;
                int leftSideIndex = infec - 1;
                int upperSideIndex = infec + M;
                int lowerSideIndex = infec - M;
                if (infec % M != 0) {
                    if (people.contains(leftSideIndex)) {
                        infected.add(leftSideIndex);
                        people.remove(Integer.valueOf(leftSideIndex));
                        isChange ++;
                    }

                }
                if (infec % M != M - 1) {
                    if (people.contains(rightSideIndex)) {
                        infected.add(rightSideIndex);
                        people.remove(Integer.valueOf(rightSideIndex));
                        isChange ++;
                    }
                }
                if (infec /M != 0) {
                    if (people.contains(lowerSideIndex)) {
                        infected.add(lowerSideIndex);
                        people.remove(Integer.valueOf(lowerSideIndex));
                        isChange ++;
                    }
                }
                if (infec /M != N - 1) {
                    if (people.contains(upperSideIndex)) {
                        infected.add(upperSideIndex);
                        people.remove(Integer.valueOf(upperSideIndex));
                        isChange ++;
                    }
                }



            }
            if (isChange == 0) {
                break;
            }
            infectedCopy.clear();
            infectedCopy.addAll(infected);
        }
        int peopleNum = people.size();
        return peopleNum;
    }
}
