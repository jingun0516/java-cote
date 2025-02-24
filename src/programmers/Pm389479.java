package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Pm389479 {
    public static int solution(int[] players, int m, int k) {
        int answer = 0;

        int capacity = m;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for(int i = 0; i < players.length; i++) {
            int num = players[i];

            if(!pq.isEmpty()) {
                int time = pq.peek()[0];
                int cnt = pq.peek()[1];
                if(i >= time + k) {
                    pq.poll();
                    capacity -= cnt * m;
                }
            }

            if(num >= capacity) {
                int need = (num - capacity) / m + 1;
                capacity += need * m;
                pq.offer(new int[]{i, need});
                answer += need;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] players = new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m = 3;
        int k = 5;

        System.out.println(solution(players, m, k));
    }
}
