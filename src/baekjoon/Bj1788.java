package baekjoon;

import java.util.Scanner;

public class Bj1788 {
    static long answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] dp = new long[1000001];
        boolean isMinus = false;
        dp[0] = 0;
        dp[1] = 1;

        if(N == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }

        if(N < 0) {
            N *= -1;
            isMinus = true;
        }

        for(int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 2] % 1000000000L + dp[i - 1] % 1000000000L) % 1000000000L;
        }
        if(isMinus && (N % 2 == 0)) {
            dp[N] *= -1;
        }

        answer = dp[N];

        if(answer < 0) {
            System.out.println(-1);
        } else if(answer > 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        System.out.println(Math.abs(answer));
    }
}
