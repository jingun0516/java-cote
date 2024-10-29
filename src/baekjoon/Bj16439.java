package baekjoon;

import java.util.Scanner;

public class Bj16439 {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] chicken = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                chicken[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < M - 2; i++) {
            for(int j = i + 1; j < M - 1; j++) {
                for(int k = j + 1; k < M; k++) {
                    int sum = 0;
                    for(int n = 0; n < N; n++) {
                        sum += Math.max(Math.max(chicken[n][i], chicken[n][j]), chicken[n][k]);
                    }
                    answer = Math.max(sum, answer);
                }
            }
        }

        System.out.println(answer);
    }
}
