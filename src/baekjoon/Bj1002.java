package baekjoon;

import java.util.Scanner;

public class Bj1002 {
    static long answer = Long.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            double distance = Math.sqrt((x1-x2) * (x1-x2) + (y1-y2) * (y1-y2)); // 두 원사이의 거리

            double rr = r1 + r2;    // 두 반지름의 합

            if(x1 == x2 && y1 == y2) {      // 중심이 같을 경우
                if(r1 == r2) {
                    System.out.println(-1);
                } else {
                    System.out.println(0);
                }
                continue;
            }

            int absR = Math.abs(r1 - r2);

            if(rr == distance || absR == distance) {        // 내접 / 외접
                System.out.println(1);
            } else if(rr < distance || absR > distance) {     // 만나지 않을 경우
                System.out.println(0);
            } else {
                System.out.println(2);
            }
        }

    }
}
