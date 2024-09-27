package baekjoon;

import java.util.*;

public class Bj14241 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++) {
            pq.add(sc.nextInt());
        }

        int answer = 0;

        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + b);
            answer += a * b;
        }

        System.out.println(answer);
    }
}

