package baekjoon;

import java.util.Scanner;

public class Bj1268 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] students = new int[N+1][5];
        boolean[][] same = new boolean[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < 5; j++) {
                students[i][j] = sc.nextInt();
            }
        }

        for(int grade = 0; grade < 5; grade++) {
            for(int i = 1; i <= N; i++) {
                for(int j = i+1; j <= N; j++) {
                    if(i == j) {
                        continue;
                    }

                    if(students[i][grade] == students[j][grade]) {
                        same[i][j] = true;
                        same[j][i] = true;
                    }
                }
            }
        }

        int maxValue = 0;
        int answer = 1;

        for(int i = 1; i <= N; i++) {
            int cnt = 0;
            for(int j = 1; j <= N; j++) {
                if(i == j) {
                    continue;
                }
                if(same[i][j]) {
                    cnt++;
                }
            }
            if(cnt > maxValue) {
                maxValue = cnt;
                answer = i;
            }
        }

        System.out.println(answer);

    }
}
