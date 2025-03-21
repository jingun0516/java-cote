package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bj20949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Monitor> monitors = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            int W = sc.nextInt();
            int H = sc.nextInt();

            monitors.add(new Monitor(i + 1, W, H));
        }

        Collections.sort(monitors);

        for(Monitor m : monitors) {
            System.out.println(m.index);
        }
    }

    public static class Monitor implements Comparable<Monitor> {
        public int index;
        int W;
        int H;
        public int PPI;

        public Monitor(int index, int W, int H) {
            this.index = index;
            this.W = W;
            this.H = H;
            this.PPI = W*W + H*H;
        }

        @Override
        public int compareTo(Monitor o) {
            return Integer.compare(o.PPI, this.PPI); // 내림차순 정렬
        }
    }
}
