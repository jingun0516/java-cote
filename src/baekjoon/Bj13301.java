package baekjoon;

import java.util.Scanner;

public class Bj13301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[] dp = new long[81];

        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N] * 4 + dp[N-1] * 2);
    }
}
