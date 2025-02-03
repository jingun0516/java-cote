package baekjoon.needcheck;

import java.util.Arrays;
import java.util.Scanner;

public class Bj17070 {
    static int N;
    static int[][] maps;
    static int[][][] dp;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        maps = new int[N][N];
        dp = new int[N][N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maps[i][j] = sc.nextInt();
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(dfs(0, 1, 0));
    }

    public static int dfs(int y, int x, int direction) {
        if(y >= N || x >= N || maps[y][x] == 1) {
            return 0;
        }

        if(y == N - 1 && x == N - 1) {
            return 1;
        }

        if(dp[y][x][direction] != -1) {     // 이미 방문했을 경우
            return dp[y][x][direction];
        }

        int count = 0;

        // 가로 방향 (오른쪽으로 이동 가능)
        if (direction != 1 && x + 1 < N && maps[y][x + 1] == 0) {
            count += dfs(y, x + 1, 0);
        }

        // 세로 방향 (아래로 이동 가능)
        if (direction != 0 && y + 1 < N && maps[y + 1][x] == 0) {
            count += dfs(y + 1, x, 1);
        }

        // 대각선 방향 (오른쪽 아래로 이동 가능)
        if (y + 1 < N && x + 1 < N && maps[y][x + 1] == 0 && maps[y + 1][x] == 0 && maps[y + 1][x + 1] == 0) {
            count += dfs(y + 1, x + 1, 2);
        }

        return dp[y][x][direction] = count; // 결과 저장 후 반환
    }
}
