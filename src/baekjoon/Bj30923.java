package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bj30923 {
    static long answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long sum = 0;

        List<Integer> printer = new ArrayList<>();
        for(int i = 0; i < N; i++){
            printer.add(sc.nextInt());
            sum += printer.get(i);
        }

        answer += N * 2 + sum * 2;    // 위아래 + 앞뒤

        answer += printer.get(0) + printer.get(N-1);    // 양옆

        for(int i = 0; i < N-1; i++) {
            int sub = Math.abs(printer.get(i) - printer.get(i + 1));
            answer += sub;
        }

        System.out.println(answer);

    }
}
