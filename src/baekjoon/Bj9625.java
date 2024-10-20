package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Bj9625 {
    static long answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        List<List<Long>> dp = new LinkedList<>();

        for(int i = 0; i <= 45; i++) {
            dp.add(new LinkedList<>());
        }

        dp.set(0, Arrays.asList(1L, 0L));
        for(int i = 1; i <= K; i++) {
            Long A = dp.get(i-1).get(0);
            Long B = dp.get(i-1).get(1);

            dp.set(i, Arrays.asList(B, A+B));
        }

        System.out.println(dp.get(K).get(0) + " " + dp.get(K).get(1));
    }
}
