package baekjoon;

import java.util.Scanner;

public class Bj11916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        boolean[] taja = new boolean[4];
        int cnt = 0;
        int score = 0;

        for (int i = 0; i < N; i++) {
            int ball = sc.nextInt();

            switch (ball) {
                case 1:
                    cnt++;
                    break;

                case 2:
                    cnt = 4;
                    break;

                case 3:
                    cnt++;
                    if (taja[3]) {
                        score++;
                        taja[3] = false;
                    }
                    if (taja[2]) {
                        taja[3] = true;
                        taja[2] = false;
                    }
                    if (taja[1]) {
                        taja[2] = true;
                        taja[1] = false;
                    }

                    break;
            }
            if (cnt >= 4) {
                cnt = 0;

                if (taja[1]) {
                    if (taja[2]) {
                        if (taja[3]) {
                            taja[3] = false;
                            score++;
                        }
                        taja[3] = true;
                        taja[2] = false;
                    }
                    taja[2] = true;
                    taja[1] = false;
                }
                taja[1] = true;
            }
        }
        System.out.println(score);
    }
}
