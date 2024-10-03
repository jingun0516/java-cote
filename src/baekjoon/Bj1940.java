package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bj1940 {
    static long answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer> armor = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            armor.add(sc.nextInt());
        }
        Collections.sort(armor);

        int start = 0;
        int end = armor.size()-1;

        while (start < end) {
            int left = armor.get(start);
            int right = armor.get(end);

            int num = left + right;

            if (num == M) {
                answer++;
                start++;
                end--;
            } else if (num > M) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(answer);
    }
}
