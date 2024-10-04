package baekjoon;

import java.util.Scanner;

public class Bj1459 {
    static long answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long X = sc.nextInt();
        long Y = sc.nextInt();
        int W = sc.nextInt();
        int S = sc.nextInt();

        long minV = Math.min(X, Y);
        long maxV = Math.max(X, Y);

        if(W * 2 < S) {         // 대각선이 W * 2 보다 클 때
            answer = (X + Y) * W;
        } else if(S < W) {      // 지그재그로 가는 게 쭉 가는 것보다 이득일 때
            if((maxV - minV) % 2 == 0) {    // 짝수라면 지그재그로 끝까지
                answer = S * maxV;
            } else {
                answer = S * (maxV - 1) + W;
            }
        } else {                // 대각선으로 가는 게 이득일 때
            answer = S * minV + W * (maxV - minV);
        }

        System.out.println(answer);
    }
}
