package baekjoon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Bj5800 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        for(int i = 0; i < K; i++) {
            int N = sc.nextInt();

            ArrayList<Integer> arrayList = new ArrayList<>();

            for(int j = 0; j < N; j++) {
                arrayList.add(sc.nextInt());
            }

            arrayList.sort(Comparator.reverseOrder());

            int largeGap = 0;
            for(int j = 1; j < N; j++) {
                int gap = arrayList.get(j - 1) - arrayList.get(j);
                largeGap = Math.max(largeGap, gap);
            }

            int maxV = arrayList.get(0);
            int minv = arrayList.get(arrayList.size() - 1);

            System.out.println("Class " + (i + 1));
            System.out.println("Max " + maxV + ", Min " + minv + ", Largest Gap " + largeGap);
        }
    }
}
