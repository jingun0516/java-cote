package baekjoon;

import java.util.Scanner;

public class Bj1652 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        char[][] maps = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                maps[i][j] = str.charAt(j);
            }
        }

        int w = 0;
        int h = 0;

        for (int i = 0; i < N; i++) {        // 가로 방향
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (maps[i][j] != 'X') {
                    cnt++;
                    if (j == N - 1) {
                        if (cnt >= 2) {
                            w++;
                            cnt = 0;
                        }
                    }
                } else {
                    if (cnt >= 2) {
                        w++;
                    }
                    cnt = 0;
                }
            }
        }

        for (int j = 0; j < N; j++) {        // 세로 방향
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (maps[i][j] != 'X') {
                    cnt++;
                    if (i == N - 1) {
                        if (cnt >= 2) {
                            h++;
                            cnt = 0;
                        }
                    }
                } else {
                    if (cnt >= 2) {
                        h++;
                    }
                    cnt = 0;
                }
            }
        }


        System.out.println(w + " " + h);
    }
}
