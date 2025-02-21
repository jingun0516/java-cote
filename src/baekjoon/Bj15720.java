package baekjoon;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Bj15720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();

        PriorityQueue<Integer> burgers = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> side = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> drink = new PriorityQueue<>(Collections.reverseOrder());

        int sum = 0;
        for(int i = 0; i < B; i++) {
            int b = sc.nextInt();
            burgers.add(b);
            sum += b;
        }
        for(int i = 0; i < C; i++) {
            int c = sc.nextInt();
            side.add(c);
            sum += c;
        }
        for(int i = 0; i < D; i++) {
            int d = sc.nextInt();
            drink.add(d);
            sum += d;
        }

        int answer = 0;

        while (!burgers.isEmpty() || !side.isEmpty() || !drink.isEmpty()) {

            if (!burgers.isEmpty() && !side.isEmpty() && !drink.isEmpty()) {
                answer += (burgers.poll() + side.poll() + drink.poll()) * 9 / 10;
            } else {
                if (!burgers.isEmpty()) {
                    answer += burgers.poll();
                }
                if (!side.isEmpty()) {
                    answer += side.poll();
                }
                if (!drink.isEmpty()) {
                    answer += drink.poll();
                }
            }
        }

        System.out.println(sum);
        System.out.println(answer);



    }
}
