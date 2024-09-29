package baekjoon;

import java.util.Scanner;

public class Bj10164 {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[][] dp = new int[16][16];
        dp[0][0] = 1;

        for(int i = 0; i <= 15; i++) {
            for(int j = 0; j <= 15; j++) {
                if(i > 0) dp[i][j] += dp[i-1][j];
                if(j > 0) dp[i][j] += dp[i][j-1];
            }
        }

        if(K != 0) {
            K--;
            int row = (int) (K / M);
            int col = K % M;

            int xLen1 = col;
            int yLen1 = row;

            int xLen2 = N-row - 1;
            int yLen2 = M-col - 1;

            answer = dp[yLen1][xLen1] * dp[yLen2][xLen2];
            System.out.println(answer);

            return;
        }

        answer = dp[N - 1][M - 1];
        System.out.println(answer);
    }
}
