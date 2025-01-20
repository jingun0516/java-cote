package baekjoon;

import java.util.Scanner;

public class Bj2740 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] A = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                A[i][j] = sc.nextInt();
            }
        }

        M = sc.nextInt();
        int K = sc.nextInt();
        int[][] B = new int[M][K];
        for(int i = 0; i < M; i++){
            for(int j = 0; j < K; j++){
                B[i][j] = sc.nextInt();
            }
        }

        int[][] answer = new int[N][K];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < K; j++){
                answer[i][j] = calculate(M, i, j, A, B);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < K; j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int calculate(int M, int y, int x, int[][] A, int[][] B){
        int value = 0;

        for(int i = 0; i < M; i++) {
            value += A[y][i] * B[i][x];
        }

        return value;
    }
}
