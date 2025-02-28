package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Bj2232 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] trap = new int[n];
        boolean[] check = new boolean[n];
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            trap[i] = sc.nextInt();
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for(int i = 0; i < n; i++) {
            pq.offer(new int[]{trap[i], i});
        }

        PriorityQueue<Integer> ans = new PriorityQueue<>();

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int val = cur[0];
            int index = cur[1];

            if(check[index]) {
                continue;
            }

            check[index] = true;
            cnt++;

            ans.offer(index + 1);

            for(int i = index + 1; i < n; i++) {
                if(check[i]) {
                    break;
                }
                if(trap[i] < val) {
                    check[i] = true;
                    cnt++;
                    val = trap[i];
                } else {
                    break;
                }
            }

            val = cur[0];
            for(int i = index - 1; i >= 0; i--) {
                if(check[i]) {
                    break;
                }
                if(trap[i] < val) {
                    check[i] = true;
                    cnt++;
                    val = trap[i];
                } else {
                    break;
                }
            }

            if(cnt >= n) {
                break;
            }
        }

        while(!ans.isEmpty()) {
            System.out.println(ans.poll());
        }
    }
}
