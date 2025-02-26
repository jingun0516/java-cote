package programmers.needtocheck;

import java.util.Arrays;

public class Pm389480 {
    public static int solution(int[][] info, int n, int m) {
        int len = info.length;
        int[][] dp = new int[len + 1][m + 1]; // DP 테이블

        // DP 테이블 초기화
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][0] = 0; // 시작점 (a = 0, b = 0)

        for (int y = 0; y < len; y++) {
            for (int b = m - 1; b >= 0; b--) { // B 값을 뒤에서부터 탐색
                if (dp[y][b] == Integer.MAX_VALUE) continue;

                int nextA = dp[y][b] + info[y][0];
                int nextB = b + info[y][1];

                if (nextA < n) {
                    dp[y + 1][b] = Math.min(dp[y + 1][b], nextA);
                }
                if (nextB < m) {
                    dp[y + 1][nextB] = Math.min(dp[y + 1][nextB], dp[y][b]);
                }
            }
        }

        // 최소 A 값 찾기
        int answer = Integer.MAX_VALUE;
        for (int b = 0; b < m; b++) {
            answer = Math.min(answer, dp[len][b]);
        }

        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }

    public static void main(String[] args) {
        int[][] info = new int[][]{{3, 3}, {3, 3}};
        int n = 7;
        int m = 1;

        System.out.println(solution(info, n, m));
    }
}
