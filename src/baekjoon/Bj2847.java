package baekjoon;

import java.util.Scanner;

public class Bj2847 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        int num = numbers[N - 1];

        int answer = 0;
        for (int i = N - 2; i >= 0; i--) {
            if (numbers[i] >= num) {
                int diff = numbers[i] - num + 1;
                answer += diff;
                numbers[i] -= diff;
            }
            num = numbers[i];
        }

        System.out.println(answer);
    }
}
