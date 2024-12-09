package baekjoon;

import java.util.*;

public class Bj17484 {
    static int answer = 700;
    static int[] dx = {-1, 0, 1};

    static void dfs(int[][] earth, int x, int y, int cnt, int direction, int N, int M) {
        if(y >= N - 1) {
            answer = Math.min(answer, cnt);
            return;
        }

        for(int i = 0; i < 3; i++) {
            if(direction == dx[i]) {
                continue;
            }

            int nx = x + dx[i];
            if(nx < 0 || nx >= M) {
                continue;
            }
            int newCnt = cnt + earth[y + 1][nx];
            dfs(earth, nx, y + 1, newCnt, dx[i], N, M);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] earth = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                earth[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < M; i++) {
            dfs(earth, i, -1, 0, -2, N, M);
        }

        System.out.println(answer);


    }
}

