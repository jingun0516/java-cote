package baekjoon;

import java.util.Scanner;

public class Bj2702 {
    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int maxV = Math.max(a ,b);
            int minV = Math.min(a ,b);
            System.out.println(lcm(maxV, minV)+ " " + gcd(maxV, minV));
        }
    }
}
