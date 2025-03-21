package baekjoon;

import java.util.Scanner;

public class Bj28075 {
    static int answer = 0;
    static int N;
    static int M;
    static int[][] work;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        work = new int[2][3];

        // [0][j] 수집 임무
        // [1][j] 감시 임무
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 3; j++) {
                work[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 3; j++) {
                dfs(1, i, j, work[i][j]);
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int cnt, int y, int x, int score) {
        if(cnt >= N) {
            if(score >= M) {
                answer++;
            }
            return;
        }

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 3; j++) {
                if(x == j) {
                    dfs(cnt + 1, i, j, score + work[i][j] / 2);
                } else {
                    dfs(cnt + 1, i, j, score + work[i][j]);
                }
            }
        }
    }
}
