package baekjoon;

import java.util.*;

public class Bj2670 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        double[] nums = new double[N];

        for(int i = 0; i < N; i++) {
            nums[i] = sc.nextDouble();
        }

        double value = 1;
        double maxV = nums[0];

        for(int i = 0; i < N; i++) {
            value = Math.max(nums[i], value * nums[i]);

            maxV = Math.max(maxV, value);
        }

        System.out.printf("%.3f%n", maxV);
    }
}
