package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bj30802 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Integer> tshirts = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            tshirts.add(sc.nextInt());
        }

        int T = sc.nextInt();
        int P = sc.nextInt();

        int tNum = 0;
        for (int tshirt : tshirts) {
            if (tshirt > 0) {
                tNum += (tshirt - 1) / T + 1;
            }
        }

        System.out.println(tNum);
        System.out.print(N / P + " " + N % P);
    }
}
