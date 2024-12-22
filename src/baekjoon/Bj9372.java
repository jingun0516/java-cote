package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bj9372 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            List<Integer>[] airplanes = new ArrayList[N+1];
            for (int i = 0; i <= N; i++) {
                airplanes[i] = new ArrayList<>();
            }

            for(int i = 0; i < M; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                airplanes[start].add(end);
                airplanes[end].add(start);
            }

            System.out.println(N-1);
        }
    }
}
