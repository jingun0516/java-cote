package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Bj10844 {
    public static long DIV_VALUE = 1000000000;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[][] dp = new long[N + 1][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1] % DIV_VALUE;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % DIV_VALUE;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % DIV_VALUE;
                }
            }
        }

        long answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer = (answer + dp[N][i]) % DIV_VALUE;
        }

        System.out.println(answer);

    }
}
