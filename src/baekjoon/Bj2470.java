package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bj2470 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Long> numbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numbers.add(sc.nextLong());
        }

        Collections.sort(numbers);

        int left = 0;
        int right = N - 1;
        long minSum = Long.MAX_VALUE;
        long ans1 = 0, ans2 = 0;

        while (left < right) {
            long sum = numbers.get(left) + numbers.get(right);

            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                ans1 = numbers.get(left);
                ans2 = numbers.get(right);
            }

            if (sum < 0) left++;
            else right--;
        }

        System.out.println(ans1 + " " + ans2);
    }
}
