package baekjoon;

import java.util.Scanner;

public class Bj2096 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] maps = new int[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                maps[i][j] = sc.nextInt();
            }
        }

        int[][] maxDp = new int[N][3]; // 현재까지 최대 점수
        int[][] minDp = new int[N][3]; // 현재까지 최소 점수

        for(int i = 0; i < 3; i++) {
            maxDp[0][i] = maps[0][i];
            minDp[0][i] = maps[0][i];
        }

        int maxV = 0;
        int minV = Integer.MAX_VALUE;

        for(int i = 1; i < N; i++) {
            maxDp[i][0] = maps[i][0] + Math.max(maxDp[i-1][0], maxDp[i-1][1]);
            maxDp[i][1] = maps[i][1] + Math.max(Math.max(maxDp[i-1][0], maxDp[i-1][1]), maxDp[i-1][2]);
            maxDp[i][2] = maps[i][2] + Math.max(maxDp[i-1][1], maxDp[i-1][2]);

            minDp[i][0] = maps[i][0] + Math.min(minDp[i-1][0], minDp[i-1][1]);
            minDp[i][1] = maps[i][1] + Math.min(Math.min(minDp[i-1][0], minDp[i-1][1]), minDp[i-1][2]);
            minDp[i][2] = maps[i][2] + Math.min(minDp[i-1][1], minDp[i-1][2]);
        }

        for(int i = 0; i < 3; i++) {
            maxV = Math.max(maxV, maxDp[N - 1][i]);
            minV = Math.min(minV, minDp[N - 1][i]);
        }


        System.out.println(maxV + " " + minV);
    }
}
