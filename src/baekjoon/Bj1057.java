package baekjoon;

import java.util.Scanner;

public class Bj1057 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        int cnt = 1;
        while(true) {
            if((A + 1) / 2 == (B + 1) / 2) {
                System.out.println(cnt);
                break;
            }

            A = (A + 1) / 2;
            B = (B + 1) / 2;
            cnt++;
        }
    }
}
